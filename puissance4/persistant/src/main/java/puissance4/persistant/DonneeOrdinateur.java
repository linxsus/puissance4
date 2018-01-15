package puissance4.persistant;

import puissance4.modele.Donnee;

/**
 * @author Xavier Gouraud
 *
 */
public class DonneeOrdinateur {

	protected int colonne;
	protected int resultat;
	protected Donnee donnee;
	protected boolean calculer;

	/**
	 * retourne si le tableau est calculer
	 *
	 * @return boolean
	 */
	public boolean isCalculer() {
		return calculer;
	}

	/**
	 * affectation du boolean calculer
	 *
	 * @param caluler
	 *            boolean
	 */
	public void setCalculer(boolean caluler) {
		this.calculer = caluler;
	}

	@Override
	public String toString() {
		return "DonneeOrdinateur [colonne=" + colonne + ", resultat=" + resultat + ", donnee=" + donnee + ", calculer="
				+ calculer + "]";
	}

	/**
	 * retourne colonne
	 *
	 * @return int
	 */
	public int getColonne() {
		return colonne;
	}

	/**
	 * affectation de colonne
	 *
	 * @param colonne
	 *            int
	 */
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}

	/**
	 * retourne Resultat
	 *
	 * @return int
	 */
	public int getResultat() {
		return resultat;
	}

	/**
	 * affectation de resultat
	 *
	 * @param resultat
	 *            int
	 */
	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	/**
	 * retourne Donnee
	 *
	 * @return Donnee
	 */
	public Donnee getDonnee() {
		return donnee;
	}

	/**
	 * affectation de donnee
	 *
	 * @param donnee
	 *            Donnee
	 */
	public void setDonnee(Donnee donnee) {
		this.donnee = donnee;
	}

	/**
	 * creation de la class avec initialisation
	 *
	 * @param colonne
	 *            int
	 * @param resultat
	 *            int
	 * @param donnee
	 *            int
	 */
	public DonneeOrdinateur(int colonne, int resultat, Donnee donnee) {
		super();
		this.donnee = donnee;
		this.colonne = colonne;
		this.resultat = resultat;
		calculer = false;
	}

	/**
	 * creation de la class sans initialisation
	 */
	public DonneeOrdinateur() {
		super();
	}

	public void setFeuille(int i) {
	}
}
