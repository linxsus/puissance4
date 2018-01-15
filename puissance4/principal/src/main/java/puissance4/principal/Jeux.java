package puissance4.principal;

import java.util.Scanner;

import puissance4.metier.Gagnee;
import puissance4.metier.Ordinateur;
import puissance4.modele.Donnee;

public class Jeux {

	static private Scanner sc;

	public static void main(String[] args) {
		Donnee donnee = new Donnee();
		Gagnee gagnee = new Gagnee();
		Ordinateur ordi = new Ordinateur(donnee, false, 10);
		boolean gg = false;

		sc = new Scanner(System.in);

		int colone;
		for (int i = 0; (i < (7 * 6)) && !gg; i++) {
			if (donnee.getJoueur() == 1) {
				System.out.println(donnee);
				do {
					colone = choisirColone(sc);
				} while (!donnee.ajoutPion(colone));
				gg = gagnee.isGagnee(donnee);
			} else {
				int aJouer = ordi.jouer();
				donnee.ajoutPion(aJouer);
				gg = gagnee.isGagnee(donnee);
			}
		}
		if (gg) {
			System.out.println("gagner\n" + donnee);
		} else {
			System.out.println("egalitee\n" + donnee);
		}
	}

	private static int choisirColone(Scanner sc) {
		int str;
		System.out.println("Veuillez saisir un nombre :");
		str = sc.nextInt();
		return str;
	}
}
