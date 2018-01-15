package puissance4.modele;

import puissance4.modele.Donnee;

public class DonneeBase extends Donnee {

	private int idBaseDonnee[] = new int[3];

	public DonneeBase(int[][] temp, int i, int j) {
		super(temp, i, j);
		idBaseDonnee = CalculInitIdBaseDonnee();
	}

	public DonneeBase() {
		super();
	}

	@Override
	public boolean ajoutPion(int colonne) {
		int nbPionColonne = getNbPionColonne(--colonne);
		int indice = nbPionColonne / 2;
		int puissance1 = ((7 * (nbPionColonne % 2)) + colonne);
		int puissance2 = ((7 * (nbPionColonne % 2)) - colonne) + 6;
		// je suis surpris qu'il n'y est pas d'erreur car Mat.pow renvoie un Double
		// TODO essayer d'utiliser ce type de code qui me parait plus rapide
		// powerN(long number, int power){
		// long res = 1;
		// long sq = number;
		// while(power > 0){
		// if(power % 2 == 1){
		// res *= sq;
		// }
		// sq = sq * sq;
		// power /= 2;
		// }
		// return res;
		//
		// apres reflexion vue qu c'est un nombre finit de possibilite un tableau serait
		// surement mieux.
		idBaseDonnee[indice] += (joueur * Math.pow(3, puissance1));
		idBaseDonnee[indice + 3] += (joueur * Math.pow(3, puissance2));
		return super.ajoutPion(colonne + 1);
	}

	@Override
	public boolean enleverPion() {
		int colonne = getDernierJouerPion()[nbPionJouer - 1].getColonne();
		int nbPionColonne = getNbPionColonne(colonne) - 1;
		int indice = nbPionColonne / 2;
		int puissance1 = ((7 * (nbPionColonne % 2)) + colonne);
		int puissance2 = ((7 * (nbPionColonne % 2)) - colonne) + 6;
		// je suis surpris qu'il n'y est pas d'erreur car Mat.pow renvoie un Double
		// TODO verifier que cela n'engendre pas d'erreur
		idBaseDonnee[indice] -= (precedent * Math.pow(3, puissance1));
		idBaseDonnee[indice + 3] -= (precedent * Math.pow(3, puissance2));
		return super.enleverPion();
	}

	public int[] getIdBaseDonnee() {
		int[] resultat = new int[3];
		boolean premiereTranche = true;
		if (idBaseDonnee[2] < idBaseDonnee[5]) {
			premiereTranche = false;
		} else if ((idBaseDonnee[2] == idBaseDonnee[5]) && (idBaseDonnee[1] < idBaseDonnee[4])) {
			premiereTranche = false;
		} else if ((idBaseDonnee[1] == idBaseDonnee[4]) && (idBaseDonnee[0] < idBaseDonnee[3])) {
			premiereTranche = false;
		}

		if (premiereTranche) {
			resultat[0] = idBaseDonnee[0];
			resultat[1] = idBaseDonnee[1];
			resultat[2] = idBaseDonnee[2];
		} else {
			resultat[0] = idBaseDonnee[3];
			resultat[1] = idBaseDonnee[4];
			resultat[2] = idBaseDonnee[5];
		}
		return resultat;
	}

	private int[] CalculInitIdBaseDonnee() {
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
		return resultat;
	}

	@Override
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
