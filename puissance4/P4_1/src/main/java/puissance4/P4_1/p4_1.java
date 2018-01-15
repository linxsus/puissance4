package puissance4.P4_1;

import puissance4.metier.OrdinateurMilieux;
import puissance4.modele.DonneeBase;

public class p4_1 {

	public static void main(String[] args) {
		int temp[][] = { { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		DonneeBase donnee = new DonneeBase(temp, 3, 1);
		OrdinateurMilieux ordi = new OrdinateurMilieux(donnee, true, 50);
		System.out.println(donnee);
		ordi.jouer();
		System.out.println(donnee);
	}
}
