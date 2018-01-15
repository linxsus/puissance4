package org.main;

import java.util.Scanner;

import org.P4Metier.Gagnee;
import org.P4Metier.Factory.Factory;
import org.P4Metier.id.GestIdDonneeLong;
import org.P4Metier.ordi.OrdinateurArbre;

public class MainArbre {

	static private Scanner sc;

	public static void main(String[] args) {
		Factory factory = new Factory(false, true, true, true);
		GestIdDonneeLong donnee = (GestIdDonneeLong) factory.getGestIDDonnee();
		Gagnee gagnee = factory.getGagnee();
		OrdinateurArbre ordi = (OrdinateurArbre) factory.getOrdinateur(donnee);
		ordi.setTourMax(5);
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
