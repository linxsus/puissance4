package puissance4.metier;

import puissance4.modele.ByteTableauJoueur;
import puissance4.modele.Donnee;

/**
 * @author Xavier Gouraud<br>
 *
 *         permet de caluler si on a gagner
 */
public class Gagnee {

	private int hauteur = 0;
	private int colonne;
	private ByteTableauJoueur byteTableauJoueur;

	/**
	 * verifie si le dernier pion jouer dans donnee a fait gagner le dernier joueur.
	 *
	 * @param donnee
	 *            donnee a analyser
	 * @return retourne true si c'est gagner false sinon
	 */
	public boolean isGagnee(Donnee donnee) {

		byteTableauJoueur = donnee.getByteTableauJoueur();
		this.colonne = donnee.getDernierJouer();
		hauteur = donnee.getNbPionColonne(colonne);
		int gagnee = 0;
		byte test;
		test = byteTableauJoueur.getHauteur(hauteur - 1, colonne);
		gagnee += test(test);
		test = byteTableauJoueur.getHorizontal(hauteur - 1, colonne);
		gagnee += test(test);
		test = byteTableauJoueur.getDiagonal1(hauteur - 1, colonne);
		gagnee += test(test);
		test = byteTableauJoueur.getDiagonal2(hauteur - 1, colonne);
		gagnee += test(test);
		if (gagnee > 0) {
			return true;
		}
		return false;
	}

	/**
	 * retourne 1 si il y a 4 pion a la suite dans le byte test fournit en parametre
	 * sinon retourne 0
	 *
	 * @param test
	 *            byte a tester
	 * @return 1 si il y a 4 pion sinon 0
	 */
	private int test(Byte test) {
		int resultat = 0;
		if ((0b1111 & test) == 0b1111) {
			resultat = 1;
		}
		if ((0b11110 & test) == 0b11110) {
			resultat = 1;
		}
		if ((0b111100 & test) == 0b111100) {
			resultat = 1;
		}
		if ((0b1111000 & test) == 0b1111000) {
			resultat = 1;
		}
		return resultat;
	}

}
