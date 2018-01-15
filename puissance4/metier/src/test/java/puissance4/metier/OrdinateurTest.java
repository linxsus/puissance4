package puissance4.metier;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import puissance4.modele.Donnee;

@RunWith(JUnitPlatform.class)
class OrdinateurTest {

	@Test
	final void testJouer1() {
		int temp[][] = { { 1, 2, 1, 1, 0, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 4, 1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(5 == i, "pour gagner doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer2() {
		int temp[][] = { { 1, 2, 2, 1, 1, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

		Donnee donnee = new Donnee(temp, 2, 1);
		// System.out.println(donnee);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer(donnee);
		// System.out.println(donnee);
		assertTrue(7 == i, "pour gagner doit jouer en 7 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer3() {
		int temp[][] = { { 1, 2, 2, 1, 2, 1, 0 }, { 0, 0, 2, 2, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(6 == i, "pour gagner doit jouer en 6 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer4() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 0, 0, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(5 == i, "pour gagner doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer5() {
		int temp[][] = { { 1, 2, 1, 1, 0, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		donnee.ajoutPion(1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer();
		assertTrue(5 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer6() {
		int temp[][] = { { 1, 2, 2, 1, 1, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		donnee.ajoutPion(1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer();
		assertTrue(7 == i, "pour ne pas perdre doit jouer en 7 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer7() {
		int temp[][] = { { 1, 2, 2, 1, 2, 1, 0 }, { 0, 0, 2, 2, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		donnee.ajoutPion(1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer();
		assertTrue(6 == i, "pour ne pas perdre doit jouer en 6 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer8() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 0, 0, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		donnee.ajoutPion(1);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer();
		assertTrue(5 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	final void testJouer9() {
		int temp[][] = { { 1, 1, 2, 2, 1, 2, 0 }, { 2, 1, 1, 2, 1, 0, 0 }, { 0, 2, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 2, 1);
		// System.out.println(donnee);
		Ordinateur ordinateur = new Ordinateur(donnee);
		int i = ordinateur.jouer();
		assertTrue(4 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}
}
