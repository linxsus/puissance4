package puissance4.modele;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class DonneeTest {

	@Test
	final void testDonnee() {
		Donnee donnee = new Donnee();
		assertTrue(donnee.getTableau(0, 0) == 0, "test du tableau pour la creation d'un tableau vide");
		// assertTrue(donnee.getDernierJouer() == 0, "test de dernier joueur pour la
		// creation d'un tableau vide");
		assertTrue(donnee.getPrecedent() == 0, "test de dernier jouer pour la creation d'un tableau vide");
		assertTrue(donnee.getJoueur() == 1, "test joueur pour la creation d'un tableau vide");
	}

	/*
	 * @Test final void testDonneeDonnee() { int temp[][] = { { 1, 2, 2, 1, 2, 2, 2
	 * }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 }, { 0, 0, 0, 0, 0, 0, 1 },
	 * { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } }; Donnee temps = new
	 * Donnee(temp, 5, 2); Donnee donnee = new Donnee(temps);
	 * assertTrue(donnee.getTableau(2, 3) == 1,
	 * "test du tableau pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)"
	 * ); assertTrue(donnee.getDernierJouer() == 5,
	 * "test de dernier joueur pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)"
	 * ); assertTrue(donnee.getPrecedent() == 0,
	 * "test de dernier jouer pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)"
	 * ); assertTrue(donnee.getJoueur() == 2,
	 * "test joueur pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)"
	 * ); }
	 *
	 */
	/*
	 * @Disabled
	 *
	 * @Test final void testGetDernierJouer() { Donnee donnee = new Donnee();
	 * assertTrue(donnee.getDernierJouer() == 0, "test de getDernierJouer init");
	 * donnee.ajoutPion(7); int i = donnee.getDernierJouer(); assertTrue(i == 6,
	 * "test de getDernierJouer 7 "); }
	 */
	@Test
	final void testDonneeIntArrayArray() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		assertTrue(donnee.getTableau(2, 5) == 1, "test du tableau pour la creation d'un tableau (int[][] tableau)");
		// assertTrue(donnee.getDernierJouer() == 0, "test de dernier joueur pour la
		// creation d'un tableau (int[][] tableau)");
		assertTrue(donnee.getPrecedent() == 0, "test de dernier jouer pour la creation d'un tableau (int[][] tableau)");
		assertTrue(donnee.getJoueur() == 1, "test joueur pour la creation d'un tableau (int[][] tableau)");
	}

	@Test
	final void testDonneeIntArrayArrayIntInt() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 5, 2);
		assertTrue(donnee.getTableau(2, 3) == 1,
				"test du tableau pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)");
		assertTrue(donnee.getDernierJouer() == 5,
				"test de dernier joueur pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)");
		assertTrue(donnee.getPrecedent() == 2,
				"test de dernier jouer pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)");
		assertTrue(donnee.getJoueur() == 1,
				"test joueur pour la creation d'un tableau (int[][] tableau, int dernierJouer, int joueur)");
	}

	@Test
	final void testGetJoueur() {
		Donnee donnee = new Donnee();
		assertTrue(donnee.getJoueur() == 1, "test de getJoueur init");
		donnee.ajoutPion(7);
		assertTrue(donnee.getJoueur() == 2, "test de getJoueur apres un ajout");
		donnee.ajoutPion(7);
		assertTrue(donnee.getJoueur() == 1, "test de getJoueur apres 2 ajout");

	}

	@Test
	final void testGetPrecedent() {
		Donnee donnee = new Donnee();
		assertTrue(donnee.getPrecedent() == 0, "test de getPrecedent init");
		donnee.ajoutPion(7);
		assertTrue(donnee.getPrecedent() == 1, "test de getPrecedent apres un ajout");
		donnee.ajoutPion(7);
		assertTrue(donnee.getPrecedent() == 2, "test de getPrecedent apres 2 ajout");
		donnee.ajoutPion(7);
		assertTrue(donnee.getPrecedent() == 1, "test de getPrecedent apres 3 ajout");
	}

	@Test
	final void testAjoutPion() {
		Donnee donnee = new Donnee();
		assertTrue(donnee.ajoutPion(7), "test de ajout pion a 7  doit revoyer true");
		assertTrue(!donnee.ajoutPion(8), "test de ajout pion a 8  doit revoyer false");
		assertTrue(!donnee.ajoutPion(0), "test de ajout pion a 0  doit revoyer false");
		assertTrue(donnee.getPrecedent() == 1, "verifie que precedent a bien changer apres un ajout");
		assertTrue(donnee.getJoueur() == 2, "verifie que Joueur a bien changer apres un ajout");
		assertTrue(donnee.getTableau(0, 6) == 1, "apres un ajout verifier qu'il est bien ajouter");
		donnee.ajoutPion(7);
		donnee.ajoutPion(7);
		donnee.ajoutPion(7);
		donnee.ajoutPion(7);
		donnee.ajoutPion(7);
		assertTrue(!donnee.ajoutPion(7), "test de ajout pion a 7 alors que coloneest pleine doit revoyer false");
	}

	@Test
	final void testGetTableau() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		assertTrue(donnee.getTableau(2, 3) == 1, "test GetTableau ");
	}

	@Test
	final void testGetHauteur() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		assertTrue(donnee.getHauteur() == 6, "test GetHauteur ");
	}

	@Test
	final void testGetLargeur() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		assertTrue(donnee.getLargeur() == 7, "test GetLargeur ");
	}

	@Test
	final void testGetColoneJouable() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 2, 0, 0, 0, 1 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		String message = Arrays.toString(donnee.getColoneJouable());
		assertTrue(message.equals("[1, 2, 4, 5, 6, 7]"),
				"test GetColoneJouable " + message + " au lieux de [1, 2, 4, 5, 6, 7]");
	}

	@Test
	final void testGetDernierJouer() {
		Donnee donnee = new Donnee();
		donnee.ajoutPion(4);
		assertTrue(donnee.getDernierJouer() == 3,
				"test GetDernierJouer " + donnee.getDernierJouer() + " au lieux de 3");
	}

	@Test
	final void testEnleverPion() {
		Donnee donnee = new Donnee();
		donnee.ajoutPion(1);
		donnee.ajoutPion(2);
		donnee.ajoutPion(2);
		donnee.ajoutPion(3);
		donnee.ajoutPion(5);
		donnee.ajoutPion(5);
		donnee.ajoutPion(7);
		assertTrue(donnee.getDernierJouer() == 6,
				"test GetDernierJouer " + donnee.getDernierJouer() + " au lieux de 6");
		donnee.enleverPion();
		assertTrue(donnee.enleverPion(), "renvoie false pour enleverPion alors que devrais renvoyer true");
		assertTrue(donnee.getDernierJouer() == 4,
				"test GetDernierJouer " + donnee.getDernierJouer() + " au lieux de 4");
		donnee.enleverPion();
		donnee.enleverPion();
		donnee.enleverPion();
		assertTrue(donnee.enleverPion(), "renvoie false pour enleverPion alors que devrais renvoyer true");
		assertTrue(donnee.getDernierJouer() == 0,
				"test GetDernierJouer " + donnee.getDernierJouer() + " au lieux de 0");
		assertTrue(!donnee.enleverPion(), "renvoie true pour enleverPion alors que devrais renvoyer false");

	}

	@Test
	final void testToString() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 2, 0, 0, 0, 1 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp);
		donnee.ajoutPion(5);
		String message = donnee + "";

		assertTrue(
				message.equals("| | |O| | | | |5\n| | |O| | | | |4\n| | |O| | | |X|3\n| | |O|X| |X|O|2\n"
						+ "| | |O|O|X|X|O|1\n|X|O|O|X|O|O|O|0\n 1 2 3 4 5 6 7\n le joueur 1 a jouer sur 5\n"),
				"test toString \n" + message
						+ " au lieux de \n| | |O| | | | |5\r\n| | |O| | | | |4\r\n| | |O| | | |X|3\r\n| | |O|X| |X|O|2\r\n| | |O|O|X|X|O|1\r\n|X|O|O|X|O|O|O|0\r\n 1 2 3 4 5 6 7 \n le joueur 1 a jouer sur 5\n");
		donnee = new Donnee();
		message = donnee + "";

		assertTrue(
				message.equals("| | | | | | | |5\n| | | | | | | |4\n| | | | | | | |3\n| | | | | | | |2\n"
						+ "| | | | | | | |1\n| | | | | | | |0\n 1 2 3 4 5 6 7\n"),
				"test toString \n" + message
						+ " au lieux de \n| | | | | | | |5\n| | | | | | | |4\n| | | | | | | |3\n| | | | | | | |2\n"
						+ "| | | | | | | |1\n| | | | | | | |0\n 1 2 3 4 5 6 7\n");
	}

}
