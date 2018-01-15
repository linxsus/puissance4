package puissance4.modele;

/**
 * classe permetant de stocker les donnees du jeux
 *
 * @author Xavier Gouraud
 */

public class Donnee {

	private final int HAUTEUR = 6;
	private final int LARGEUR = 7;
	protected int joueur = 1;
	protected int precedent = 0;
	protected PionJouer[] dernierJouer = new PionJouer[HAUTEUR * LARGEUR];
	protected int nbPionJouer = 0;

	protected int[] nbPionColonne = new int[LARGEUR];

	protected ByteTableauJoueur[] byteTableauJoueur = new ByteTableauJoueur[2];

	/**
	 * creation d'un initial des donnees le jeux est vide le joueur suivant est 1
	 *
	 */
	public Donnee() {
		super();
		init();
	}

	// utile pour les test
	/**
	 * creation d'un objet donnee avec le jeux initialiser par le tableau
	 *
	 * @param tableau
	 *            'tableau du jeux' de preference un tableau 6*7
	 */

	public Donnee(int[][] tableau) {
		super();
		init();
		copyTableau(tableau);
	}

	/**
	 * creation d'un objet donnee avec le jeux initialiser par le tableau et choix
	 * du joueur en cours et du joueur precedent
	 *
	 * @param tableau
	 *            'tableau du jeux' de preference un tableau 6*7
	 * @param dernierJouer
	 *            dernier joueur qui a jouer
	 * @param joueur
	 *            joueur qui va jouer
	 *
	 */
	public Donnee(int[][] tableau, int dernierJouer, int joueur) {
		super();
		init();
		copyTableau(tableau);
		this.dernierJouer[nbPionJouer].setColonne(dernierJouer);
		nbPionJouer++;
		this.joueur = joueur;
		nextJoueur();
	}

	/**
	 * permet de retirer le dernier pion du joueur
	 *
	 * @return si le pion a ete retirer ou pas
	 */
	public boolean enleverPion() {
		boolean resultat = false;
		if (nbPionJouer > 1) {
			nbPionJouer--;
			PionJouer derJouer = dernierJouer[nbPionJouer];
			byteTableauJoueur[0].enleverPion(derJouer.getHauteur(), derJouer.getColonne());
			byteTableauJoueur[1].enleverPion(derJouer.getHauteur(), derJouer.getColonne());
			nbPionColonne[derJouer.getColonne()]--;
			nextJoueur();
			resultat = true;
		}
		return resultat;
	}

	/**
	 * permet d'ajouter un pion du joueur courant dans la colone : colone
	 *
	 *
	 * @param colonne
	 *            int colonne
	 * @return si le pion a ete ajouter ou pas
	 */
	public boolean ajoutPion(int colonne) {
		colonne -= 1;
		if ((colonne >= 0) && (colonne <= (LARGEUR - 1))) { // si la colone est dans le tableau
			int hauteur = nbPionColonne[colonne];
			if (hauteur < 6) {
				byteTableauJoueur[joueur - 1].ajouterPion(hauteur, colonne);
				nextJoueur();
				dernierJouer[nbPionJouer].setColonne(colonne);
				dernierJouer[nbPionJouer].setHauteur(hauteur);
				nbPionJouer++;
				nbPionColonne[colonne]++;
				return true;
			}
		}
		return false; // impossible de rajouter le pion car la colone est pleine
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String message = "";
		for (int i = HAUTEUR - 1; i >= 0; i--) {

			for (int j = 0; j < LARGEUR; j++) {
				int t2 = getTableau(i, j);
				message += "|";
				switch (t2) {
				case 1:
					message += "X";
					break;
				case 2:
					message += "O";
					break;
				default:
					message += " ";
				}
			}
			message += "|" + i + "\n";
		}
		for (int i = 1; i <= LARGEUR; i++) {
			message += " " + i;
		}
		message += "\n";
		if (precedent != 0) {
			message += " le joueur " + precedent + " a jouer sur " + (dernierJouer[nbPionJouer - 1].getColonne() + 1)
					+ "\n";
		}
		return message;
	}

	public int getNbPionJouer() {
		return nbPionJouer;
	}

	public PionJouer[] getDernierJouerPion() {
		return dernierJouer;
	}

	/**
	 * retourne le ByteTableauJoueur du joueur en cours
	 */
	public ByteTableauJoueur getByteTableauJoueur() {
		return byteTableauJoueur[precedent - 1];
	}

	/**
	 * retourne le nb de pion dans la colonne (colonne)
	 *
	 * @param colonne
	 *            int colonne colonne sur la quelle on veux avoir le nb de pion.
	 */
	public int getNbPionColonne(int colonne) {
		return nbPionColonne[colonne];
	}

	/**
	 * retourn la derniere colonne jouer
	 *
	 * @return la derniere colonne jouer
	 */
	public int getDernierJouer() {
		return dernierJouer[nbPionJouer - 1].getColonne();
	}

	/**
	 * retourne le joueur en cours
	 *
	 * @return joueur en cours
	 */
	public int getJoueur() {
		return joueur;
	}

	/**
	 * retourne le joueur qui vien de joueur
	 *
	 * @return le joueur qui vien de joueur
	 */
	public int getPrecedent() {
		return precedent;
	}

	/**
	 * retourn le pion qui est en ligne i colone j 0 pas de pion 1 pion joueur 1 2
	 * pion joueur 2
	 *
	 * @param i
	 *            ligne
	 * @param j
	 *            colone
	 * @return le pion qui est en ligne i colone j
	 */
	public int getTableau(int i, int j) {
		return byteTableauJoueur[0].getPion(i, j) + (byteTableauJoueur[1].getPion(i, j) * 2);
	}

	/**
	 * retourne la hauteur du tableau
	 *
	 * @return la hauteur du tableau
	 */
	public int getHauteur() {
		return HAUTEUR;
	}

	/**
	 * retourne la largeur du tableau
	 *
	 * @return la largeur du tableau
	 */
	public int getLargeur() {
		return LARGEUR;
	}

	/**
	 * retourn sous forme de tableau toute les colones jouable (qui ne sont pas
	 * arriver au max)
	 *
	 * @return le tableau de toute les colones jouable
	 */
	public int[] getColoneJouable() {
		int[] temps = new int[LARGEUR];
		int nbJouable = 0;
		for (int i = 0; i < LARGEUR; i++) {
			if (nbPionColonne[i] < 6) {

				temps[nbJouable] = i;
				nbJouable++;
			}
		}
		int[] coloneJouable = new int[nbJouable];
		for (int i = 0; i < nbJouable; i++) {
			coloneJouable[i] = temps[i] + 1; // +1 pour retomber sur des colones allant de 1 a ...
		}
		return coloneJouable;
	}

	/**
	 * transforme le tableau fournit en parametre au format des donneee
	 *
	 * @param tableau
	 *            tableau de 6*7 representant le jeux
	 */
	private void copyTableau(int[][] tableau) {
		for (int i = 0; i < tableau[0].length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				int res = tableau[j][i];
				if (res > 0) {
					byteTableauJoueur[res - 1].ajouterPion(j, i);
					nbPionColonne[i]++;
				}
			}
		}
	}

	/**
	 * initialisation du tableau dernierJoueur
	 */
	protected void init() {
		for (int i = 0; i < dernierJouer.length; i++) // boucle foreach cacher car dans les boucle foreach on ne peut
														// pas modifier la valeur.
		{
			dernierJouer[i] = new PionJouer();
		}
		for (int i = 0; i < byteTableauJoueur.length; i++) {
			byteTableauJoueur[i] = new ByteTableauJoueur();
		}
	}

	/**
	 * changement de joueur
	 *
	 */
	private void nextJoueur() {
		if (joueur == 1) {
			joueur = 2;
			precedent = 1;
		} else {
			joueur = 1;
			precedent = 2;
		}
	}

	public long getIdBaseDonnee1() {
		int[] resultat = new int[6];
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < getLargeur(); j++) {
					resultat[2 - k] *= 3;
					resultat[2 - k] += getTableau((5 - (2 * k) - i), j);
					resultat[5 - k] *= 3;
					resultat[5 - k] += getTableau((5 - (2 * k) - i), 6 - j);
				}
			}
		}
		return 1L;
	}

	public DonneeBase setDonnee(int[] tabInit) {
		int temp[][] = new int[6][7];
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					temp[(k * 2) + i][j] = tabInit[k] % 3;
					tabInit[k] /= 3;

				}
			}
		}
		return new DonneeBase(temp, 1, 1);
	}

}
