package puissance4.persistant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import puissance4.modele.Donnee;
import puissance4.modele.DonneeBase;

public class DonneeOrdinateurMysql extends DonneeOrdinateur {

	final static Logger logger = Logger.getLogger(DonneeOrdinateurMysql.class);
	private static String url = "jdbc:mysql://localhost/Puissance4?rewriteBatchedStatements=true&autoReconnect=true&useSSL=false";
	private static String login = "Puissance4";
	private static String passwd = "p4C@llans";
	private static Connection cn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private long id = 0;
	// private int resultat = 0;
	// private boolean calculer = false;
	// private DonneeBase donnee = null;
	// private int colonne = -1;
	private int feuille = 0;

	/**
	 * creation de la class avec initialisation
	 *
	 * @param colonne
	 *            int colonne
	 * @param resultat
	 *            int resultat
	 * @param donnee
	 *            Donnee
	 */
	public DonneeOrdinateurMysql(int colonne, int resultat, DonneeBase donnee) {
		super();
		init();
		setDonnee(donnee);
		setColonne(colonne);
		setResultat(resultat);
		// calculer=false;
	}

	/**
	 * creation de la class sans initialisation
	 */
	public DonneeOrdinateurMysql() {
		super();
		init();
		logger.error("creation Mysql");
	}

	public DonneeOrdinateurMysql(Connection cn, Statement st, ResultSet rs) {
		super();
		DonneeOrdinateurMysql.cn = cn;
		DonneeOrdinateurMysql.st = st;
		DonneeOrdinateurMysql.rs = rs;
	}

	@Override
	public String toString() {
		return "DonneeOrdinateur [colonne=" + colonne + ", resultat=" + resultat + ", donnee=" + this.donnee
				+ ", calculer=" + calculer + "]";
	}

	// TODO une lecture en base devrait etre utile.
	/**
	 * retourne si le tableau est calculer
	 *
	 * @return le tableau est calculer
	 */
	@Override
	public boolean isCalculer() {
		return calculer;
	}

	/**
	 * retourne colonne
	 *
	 * @return int colonne
	 */
	@Override
	public int getColonne() {
		return colonne;
	}

	// TODO a tester
	/**
	 * retourne Donnee
	 *
	 * @return Donnee
	 */
	@Override
	public DonneeBase getDonnee() {
		int iddonnee[] = new int[3];
		int dernierJouer = 0;
		int joueur = 0;
		int[][] temp = new int[6][7]; // TODO 6 et 7 en dure
		if (this.donnee != null) {
			return (DonneeBase) this.donnee; // TODO !!attention pas tres propre !!
		} else {
			try {
				String sql = "select * from `puissance4`.`donnee` WHERE `index`='" + id + "';";
				// System.out.println(sql);
				rs = st.executeQuery(sql);
				while (rs.next()) {
					joueur = rs.getInt("joueur");
					dernierJouer = rs.getInt("dernierjouer");
					iddonnee[0] = rs.getInt("iddonnee1");
					iddonnee[1] = rs.getInt("iddonnee2");
					iddonnee[2] = rs.getInt("iddonnee3");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				try { // Etape 6 : lib�rer ressources de la m�moire.
					cn.close();
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			for (int k = 0; k < 3; k++) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < temp[0].length; j++) {
						temp[(k * 2) + i][j] = iddonnee[k] % 3;
						iddonnee[k] /= 3;

					}
				}
			}
		}

		DonneeBase resultat = new DonneeBase(temp, dernierJouer, joueur);
		return resultat;
	}

	/**
	 * retourne Resultat
	 *
	 * @return int resultat
	 */
	@Override
	public int getResultat() {
		return resultat;
	}

	public int getFeuille() {
		return feuille;
	}

	/**
	 * affectation du boolean calculer
	 *
	 * @param calculer
	 *            boolean calculer
	 */
	@Override
	public void setCalculer(boolean calculer) { // TODO a quoi sert l'argument voire dans le parent mais sinon l'enlever
		this.calculer = calculer;
		if (calculer) {
			// enregistrer donnee
			// mettre donnee a null; on verra ce qui ce passe.
			int[] iddonnee = ((DonneeBase) donnee).getIdBaseDonnee();
			String sql;
			try {
				// TODO rajouter le calculer
				sql = "INSERT INTO `puissance4`.`donnee` (`iddonnee1`, `iddonnee2`, `iddonnee3`, `dernierJouer`, `joueur`, `precedent`, `colonne`, `resultat`, `feuille`,`calculer`) VALUES ('"
						+ iddonnee[0] + "', '" + iddonnee[1] + "', '" + iddonnee[2] + "', '"
						+ this.donnee.getDernierJouer() + "', '" + this.donnee.getJoueur() + "', '"
						+ this.donnee.getPrecedent() + "', '" + colonne + "', '" + resultat + "','" + feuille
						+ "','1')";
				st.executeUpdate(sql);
				sql = "select LAST_INSERT_ID();";// dernier inserer
				rs = st.executeQuery(sql);
				while (rs.next()) {
					id = rs.getLong("LAST_INSERT_ID()"); // on transforme le resultat en int
					// System.out.println(id);
				}
			} catch (SQLException e) {
				logger.error("erreur sql ", e);

			}
		}

	}

	/**
	 * affectation de colonne
	 *
	 * @param colonne
	 *            int colonne
	 */
	@Override
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	/**
	 * affectation de donnee
	 *
	 * @param donnee
	 *            Donnee
	 */
	@Override
	public void setDonnee(Donnee donnee) {

		/*
		 * si il est dans la base je charge les donnees sinon je le met en memoire
		 */

		int idBaseDonnee[] = ((DonneeBase) donnee).getIdBaseDonnee();
		id = 0;
		try {
			String sql = "select * from `puissance4`.`donnee` WHERE `iddonnee1`='" + idBaseDonnee[0]
					+ "' and `iddonnee2`='" + idBaseDonnee[1] + "' and `iddonnee3`='" + idBaseDonnee[2] + "';";
			// System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getLong("index");
				resultat = rs.getInt("resultat");
				calculer = (rs.getInt("calculer") == 1) ? true : false; // TODO remetre une colonne calculer
				colonne = rs.getInt("colonne");
				feuille = rs.getInt("feuille");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// lib�rer ressources de la m�moire.
				cn.close();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (id == 0) {
			this.donnee = donnee;
		}

	}

	/**
	 * affectation de resultat
	 *
	 * @param resultat
	 *            int resultat
	 */
	@Override
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	@Override
	public void setFeuille(int feuille) {
		this.feuille = feuille;
	}

	/**
	 * creation de la connexion a la base de donnee
	 */
	private static void init() {
		if (cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");// Etape 1 : Chargement du driver
				cn = DriverManager.getConnection(url, login, passwd); // Etape 2 : r�cup�ration de la connexion
				st = cn.createStatement();// Etape 3 : Cr�ation d'un statement
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					cn.close();// lib�rer ressources de la m�moire.
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * retourne la DonneeBase de l'id mis en parametre
	 *
	 * @param idTemp
	 *            id dans la base de donnee du tableau a recuperer.
	 * @return l'object de type DonneeBase dont l'id en base de donnee a ete passser
	 *         en parametre
	 */

	public DonneeBase getLastDonnee(int idTemp) {
		if (idTemp != 1) {
			id = idTemp;
		} else {
			try {
				String sql = "select max(`index`) `index` from `puissance4`.`donnee`;";
				// System.out.println(sql);
				rs = st.executeQuery(sql);
				while (rs.next()) {
					id = rs.getLong("index");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					// Etape 6 : lib�rer ressources de la m�moire.
					cn.close();
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		System.out.println(id); // n'est la que pour les test
		return getDonnee();
	}
}