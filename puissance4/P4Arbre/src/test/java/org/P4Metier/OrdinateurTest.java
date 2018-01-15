package org.P4Metier;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@Disabled
@RunWith(JUnitPlatform.class)
interface OrdinateurTest<T> {

	abstract GestIdDonnee<T> getDonee();

	abstract Ordinateur<T> getOrdinateur(GestIdDonnee<T> donnee);

	@Test
	default void testJouer1() {
		int temp[][] = { { 1, 2, 1, 1, 0, 1, 0 }, { 0, 0, 2, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(5 == i, "pour gagner doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer2() {
		int temp[][] = { { 1, 2, 2, 1, 1, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };

		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		int i = ordinateur.jouer(donnee);
		// System.out.println(donnee);
		assertTrue(7 == i, "pour gagner doit jouer en 7 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer3() {
		int temp[][] = { { 1, 2, 2, 1, 2, 1, 0 }, { 0, 0, 2, 2, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(6 == i, "pour gagner doit jouer en 6 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer4() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 0, 0, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(5 == i, "pour gagner doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer5() {
		int temp[][] = { { 1, 2, 1, 1, 0, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		donnee.ajoutPion(1);
		int i = ordinateur.jouer();
		assertTrue(5 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer6() {
		int temp[][] = { { 1, 2, 2, 1, 1, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		donnee.ajoutPion(1);
		int i = ordinateur.jouer();
		assertTrue(7 == i, "pour ne pas perdre doit jouer en 7 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer7() {
		int temp[][] = { { 1, 2, 2, 1, 2, 1, 0 }, { 0, 0, 2, 2, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		donnee.ajoutPion(1);
		int i = ordinateur.jouer();
		assertTrue(6 == i, "pour ne pas perdre doit jouer en 6 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer8() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 0, 0, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		donnee.ajoutPion(1);
		int i = ordinateur.jouer();
		assertTrue(5 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}

	@Test
	default void testJouer9() {
		int temp[][] = { { 1, 1, 2, 2, 1, 2, 0 }, { 2, 1, 1, 2, 1, 0, 0 }, { 0, 2, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 2, 0, 0, 0, 0 } };
		GestIdDonnee<T> donnee = getDonee();
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		// System.out.println(donnee);
		int i = ordinateur.jouer();
		assertTrue(4 == i, "pour ne pas perdre doit jouer en 5 a jouer en" + i + "\n" + donnee);
	}
}
