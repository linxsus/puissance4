package puissance4.metier;

import puissance4.modele.Donnee;
import puissance4.modele.DonneeBase;
import puissance4.modele.PionJouer;
import puissance4.persistant.DonneeOrdinateur;

/**
 * class pour le calcul du toujour gagner si on commance au milieux.
 * modification des fonctions calculPoids et calculResultat pour ne prendre en
 * compt que le chemin ou on gagne systematiquement.
 *
 * @author Xavier Gouraud
 *
 */
public class OrdinateurMilieux extends Ordinateur {

	/**
	 * creation de la class avec comme DonneeBase donnee
	 *
	 * @param donnee
	 *            DonneeBase
	 */
	public OrdinateurMilieux(DonneeBase donnee) {
		super(donnee);
	}

	/**
	 * creation de la class avec comme DonneeBase donnee et mettre le boolean a true
	 * pour utiliser mysql.
	 *
	 * @param donnee
	 *            DonneeBase
	 * @param mysql
	 *            boolean
	 * @param tourMax
	 *            int
	 */
	public OrdinateurMilieux(DonneeBase donnee, boolean mysql, int tourMax) {
		super(donnee, mysql, tourMax);
	}

	/**
	 * calcul le tableau des poids
	 *
	 * @param donnee
	 *            donnee a annalyser
	 * @param nbTour
	 *            nb de tour restant a effectuer
	 * @return le tableau des poids calculer
	 */
	@Override
	protected DonneeOrdinateur[] calculPoids(Donnee donnee, int nbTour) {
		// init des variable pour le calcul
		int[] coloneJouable = donnee.getColoneJouable();
		// init du resulta (mise a 0 de tous les champs)
		DonneeOrdinateur[] resultat = initDonneeOrdinateur(coloneJouable.length);

		// affichage pour un suivit lors de l'execution
		if ((nbTour > 31)) {
			System.out.println(nbTour);
			System.out.println(donnee);
			PionJouer[] pionJouer = donnee.getDernierJouerPion();
			int nbPionJouer = donnee.getNbPionJouer();
			for (int i = 5; i < nbPionJouer; i++) {
				System.out.print((pionJouer[i].getColonne() + 1) + " ");
			}
			System.out.println(" ");

		}

		// calcul si on peut gagner a un endroie.
		if (nbTour > 0) { // si on est pas au max de tour
			nbTour--;
			for (int i = 0; i < coloneJouable.length; i++) { // pour chaque possibiliter restante.
				// tempDonnee = new Donnee(donnee); // je copy l'object donnee
				donnee.ajoutPion(coloneJouable[i]); // j'ajoute un pion
				resultat[i].setDonnee(donnee); // je sauvegarde l'object donnee
				if (!resultat[i].isCalculer()) {
					if (gagnee.isGagnee(donnee)) { // si gagne
						resultat[i].setColonne(coloneJouable[i]); // je reseigne le tableau
						resultat[i].setResultat(1);
						resultat[i].setFeuille(1); // en cours
						resultat[i].setCalculer(true);// on inscrit que le calcul est terminer pour la donneeOrdinateur
						donnee.enleverPion();
						return resultat; // et je termine la boucle

					} else { // pour chaque object sauvegarder
						// Donnee temporaire = resultat[i].getDonnee();// on recharge les donnee

						DonneeOrdinateur[] temps = calculPoids(donnee, nbTour); // on calcul les poids pour un
																				// niveau superieur

						if (temps.length == 0) {
							resultat[i].setResultat(-1);
							resultat[i].setFeuille(1);
						} else {
							resultat[i].setResultat(calculResultat(temps)); // on calcul le poid total du
																			// niveau
							// superieur
						}
						resultat[i].setColonne(coloneJouable[i]);// on sauvegarde la colone
						resultat[i].setCalculer(true); // on inscrit que le calcul est terminer pour la
														// donneeOrdinateur en cours
						if (resultat[i].getResultat() == 1) { // si (on gagne forcement si on joue la)
							resultat[i].setCalculer(true);// on inscrit que le calcul est terminer pour la
															// donneeOrdinateur
							donnee.enleverPion();
							return resultat; // on quite la boucle
						}
					}
				} else {
					if (resultat[i].getResultat() == 1) { // si (on gagne forcement si on joue la)
						donnee.enleverPion();
						return resultat; // on quite la boucle
					}
				}
				donnee.enleverPion();
			}
		}
		return resultat;
	}

	/**
	 * calcul le resultat d'un tableau si peut importe ou je jour je perd alors il
	 * gagne sinon il perd.
	 *
	 * @param tabResultat
	 *            tableau de DonneeOrdinateur[] a calculer
	 * @return le resultat du tableau
	 */
	@Override
	protected int calculResultat(DonneeOrdinateur[] tabResultat) {
		int resultat = -1;
		int total = 0;
		for (int i = 0; i < tabResultat.length; i++) // pour toutes les valeur du tableau
		{
			total += tabResultat[i].getResultat(); // je les aditionnes
		}
		total /= tabResultat.length; // je le divise par le nb d'element du tableau.
		if (total == -1) {
			resultat = 1;
		}
		return resultat;
	}

}
