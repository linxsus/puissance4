package puissance4.metier;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.P4XG.PF;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import puissance4.modele.Donnee;

@RunWith(JUnitPlatform.class)
class GagneeTest {

	@Test
	final void testGagnerHorizontalBas1() {
		int temp[][] = { { 1, 1, 1, 1, 0, 1, 0 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 0, 1);
		// System.out.println(donnee);
		Gagnee gagnee = new Gagnee();
		assertTrue(gagnee.isGagnee(donnee));
	}

	@Test
	final void testGagnerHorizontalBas2() {
		int temp[][] = { { 1, 2, 2, 1, 1, 1, 1 }, { 0, 0, 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 5, 1);
		// System.out.println(donnee);
		Gagnee gagnee = new Gagnee();
		assertTrue(gagnee.isGagnee(donnee));
	}

	@Test
	final void testGagnerHorizontalhaut1() {
		int temp[][] = { { 1, 2, 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1, 2, 1 },
				{ 2, 1, 2, 1, 2, 1, 2 }, { 2, 1, 2, 1, 2, 1, 2 }, { 2, 1, 2, 1, 1, 1, 1 } };
		Donnee donnee = new Donnee(temp, 6, 1);
		// System.out.println(donnee);
		Gagnee gagnee = new Gagnee();
		assertTrue(gagnee.isGagnee(donnee));
	}

	@Test
	final void testGagnerHorizontalhaut2() {
		int temp[][] = { { 1, 2, 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1, 2, 1 },
				{ 2, 1, 2, 1, 2, 1, 2 }, { 2, 1, 2, 1, 2, 1, 2 }, { 2, 2, 2, 2, 1, 1, 2 } };
		Donnee donnee = new Donnee(temp, 2, 2);
		// System.out.println(donnee);
		Gagnee gagnee = new Gagnee();
		assertTrue(gagnee.isGagnee(donnee));
	}

	@Test
	final void testGagnerdiagonalBas2() {
		int temp[][] = { { 1, 2, 1, 1, 1, 2, 1 }, { 1, 1, 1, 2, 0, 0, 1 }, { 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Donnee donnee = new Donnee(temp, 3, 1);
		// System.out.println(donnee);
		Gagnee gagnee = new Gagnee();
		assertTrue(gagnee.isGagnee(donnee));
	}

	@Test
	final void testTestByte() {
		Gagnee gagnee = new Gagnee();
		assertTrue((int) PF.privateFonction(gagnee, "test", new Byte("15")) == 1,
				"x00001111 devrait etre a gagner et est a perdu");
		assertTrue((int) PF.privateFonction(gagnee, "test", new Byte("30")) == 1,
				"x00011110 devrait etre a gagner et est a perdu");
		assertTrue((int) PF.privateFonction(gagnee, "test", new Byte("62")) == 1,
				"x00111110 devrait etre a gagner et est a perdu");
		assertTrue((int) PF.privateFonction(gagnee, "test", new Byte("14")) != 1,
				"x00001110 devrait etre a pedue et est a gagner");
	}

}
