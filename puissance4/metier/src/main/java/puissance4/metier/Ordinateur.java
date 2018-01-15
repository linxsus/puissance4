package puissance4.metier;

import java.util.Random;

import puissance4.modele.Donnee;
import puissance4.persistant.DonneeOrdinateur;
import puissance4.persistant.DonneeOrdinateurMysql;

/**
 * @author Xavier Gouraud
 *
 *         classe pour calculer le pion a jouer pour gagner
 *
 */
public class Ordinateur {
	private Donnee donnee;
	private boolean mysql = false;
	private int tourMax = 4;
	protected Gagnee gagnee = new Gagnee();

	/**
	 * creation de la class avec comme donnee donnee
	 *
	 * @param donnee
	 *            Donnee
	 */
	public Ordinateur(Donnee donnee) {
		super();
		this.donnee = donnee;
	}

	/**
	 * creation de la class avec comme donnee donnee et mettre le boolean a true
	 * pour utiliser mysql.
	 *
	 * @param donnee
	 *            Donnee
	 * @param mysql
	 *            boolean
	 * @param tourMax
	 *            int
	 */
	public Ordinateur(Donnee donnee, boolean mysql, int tourMax) {
		super();
		this.donnee = donnee;
		this.mysql = mysql;
		this.tourMax = tourMax;
	}

	/**
	 * retourn la colone a jouer pour les donnee donnee !!! reinitialise les donnee
	 * lors de la creation !!!
	 *
	 * @param donnee
	 *            Donnee
	 * @return colone a jouer pour les donnee donnee
	 */
	public int jouer(Donnee donnee) {
		this.donnee = donnee; // reinitialise donnee
		return jouer();
	};

	/**
	 * retourne la colone a jouer
	 *
	 * @return colone a jouer
	 */
	public int jouer() {
		int resultat = 0;
		DonneeOrdinateur[] temp = calculPoids(donnee, tourMax); // calcul du tableau des poids le 2eme argument est la
		// profondeur de l'arbre
		resultat = meilleurChoix(temp); // recuperation du meilleur choix possible
		if (resultat == 0) // la je suis pas sure qu'il n'y a pas une erreur
		{
			resultat = auHazard();
			System.out.println("possible erreur");
		}
		return resultat;
	}

	/**
	 * calcul une colone au hasard dans les choix possible
	 *
	 * @return colone au hasard dans les choix possible
	 */
	private int auHazard() {
		int[] coloneJouable = donnee.getColoneJouable();
		Random rnd = new Random();
		return coloneJouable[rnd.nextInt(coloneJouable.length)]; // une colone hasard dans le tableau coloneJouable
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
	protected DonneeOrdinateur[] calculPoids(Donnee donnee, int nbTour) {
		// init des variable pour le calcul
		int[] coloneJouable = donnee.getColoneJouable();
		// init du resulta (mise a 0 de tous les champs)
		DonneeOrdinateur[] resultat = initDonneeOrdinateur(coloneJouable.length);

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
						resultat[i].setResultat(1000);
						resultat[i].setFeuille(1); // en cours
						resultat[i].setCalculer(true);// on inscrit que le calcul est terminer pour la donneeOrdinateur
						donnee.enleverPion();
						return resultat; // et je termine la boucle

					} else { // pour chaque object sauvegarder
						// Donnee temporaire = resultat[i].getDonnee();// on recharge les donnee

						DonneeOrdinateur[] temps = calculPoids(donnee, nbTour); // on calcul les poids pour un
																				// niveau superieur

						if (temps.length == 0) {
							resultat[i].setFeuille(1);
						} else {
							resultat[i].setResultat(0 - calculResultat(temps)); // on calcul le poid total du niveau
																				// superieur et on inverse le signe car
																				// joueur oposer
						}
						resultat[i].setColonne(coloneJouable[i]);// on sauvegarde la colone
						resultat[i].setCalculer(true); // on inscrit que le calcul est terminer pour la
														// donneeOrdinateur en cours

					}
				}
				donnee.enleverPion();
			}
		}
		return resultat;
	}

	@Override
	public String toString() {
		return "Ordinateur [donneeS=" + donnee + "]";
	}

	/**
	 * calcul le meilleur choix dans le tableau tabResultat
	 *
	 * @param tabResultat
	 *            tableau de forme DonneeOrdinateur
	 * @return le meilleur choix dans le tableau tabResultat
	 */
	protected int meilleurChoix(DonneeOrdinateur[] tabResultat) {
		DonneeOrdinateur resultat = new DonneeOrdinateur(0, -1000, null); // TODO a modifier car pas tres prope
		// String message="";
		for (int i = 0; i < tabResultat.length; i++) // pour chaque element du tableau
		{// message+=tabResultat[i].getResultat()+" ";
			if (tabResultat[i].getResultat() > resultat.getResultat()) { // si la valeur est meilleur que la precedente
				resultat = tabResultat[i]; // on enregistre la valeur
			}
		}
		// System.out.println(message);
		return resultat.getColonne(); // on retourne le meilleur choix dans le tableau tabResultat
	}

	/**
	 * calcul le resultat d'un tableau (somme des poids du tableau/nb d'element du
	 * tableau)
	 *
	 * @param tabResultat
	 *            tableau de DonneeOrdinateur[] a calculer
	 * @return le resultat du tableau
	 */
	protected int calculResultat(DonneeOrdinateur[] tabResultat) {
		int resultat = 0;
		for (int i = 0; i < tabResultat.length; i++) // pour toutes les valeur du tableau
		{
			resultat += tabResultat[i].getResultat(); // je les aditionnes
		}
		resultat = resultat / tabResultat.length; // je le divise par le nb d'element du tableau.
		return resultat;
	}

	/**
	 * initialise un tableau de la taille (taille) fournit en parametre le tableau
	 * est de type DonneeOrdinateurMysql si mysql a ete mis a true sinon de type
	 * DonneeOrdinateur
	 *
	 * @param taille
	 *            int corespond a la taille du tableau a initialiser
	 * @return le tableau cree
	 */
	protected DonneeOrdinateur[] initDonneeOrdinateur(int taille) {
		DonneeOrdinateur[] resultat = new DonneeOrdinateur[taille];
		if (mysql) {
			for (int i = 0; i < taille; i++) {
				resultat[i] = new DonneeOrdinateurMysql();
			}
		} else {
			for (int i = 0; i < taille; i++) {
				resultat[i] = new DonneeOrdinateur();
			}
		}
		return resultat;
	}
};
