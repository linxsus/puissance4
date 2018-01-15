package puissance4.persistant;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import puissance4.modele.Donnee;

@RunWith(JUnitPlatform.class)
class DonneeOrdinateurTest {

	DonneeOrdinateur donneeOrdinateur;
	Donnee donnee;
	DonneeOrdinateur donneeOrdinateurTemp;

	@BeforeEach
	public void initAll() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		donnee = new Donnee(temp);
		donneeOrdinateur = new DonneeOrdinateur(5, 100, donnee);

	}

	@Test
	public void testIsCalculer() {
		assertTrue(!donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a false apres init");

	}

	@Test
	public void testSetCalculer() {
		donneeOrdinateur.setCalculer(true);
		assertTrue(donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a false apres init");
	}
	/*
	 * @Test final void testToString() { fail("Not yet implemented"); }
	 */

	@Test
	public void testGetColonne() {
		int temp = donneeOrdinateur.getColonne();
		assertTrue(temp == 5, "test si la valeur Colonne est bien a 5 apres init mais est a " + temp);
	}

	@Test
	public void testSetColonne() {
		donneeOrdinateur.setColonne(7);
		int temp = donneeOrdinateur.getColonne();
		assertTrue(temp == 7, "test si la valeur Colonne est bien a 7 apres setColonne mais est a " + temp);
	}

	@Test
	public void testGetResultat() {
		int temp = donneeOrdinateur.getResultat();
		assertTrue(temp == 100, "test si la valeur resultat est bien a 100 apres init mais est a " + temp);
	}

	@Test
	public void testSetResultat() {
		donneeOrdinateur.setResultat(300);
		int temp = donneeOrdinateur.getResultat();
		assertTrue(temp == 300, "test si la valeur Colonne est bien a 300 apres setResultat mais est a " + temp);
	}

	@Test
	public void testGetDonnee() {
		Donnee temp = donneeOrdinateur.getDonnee();
		assertTrue(temp == donnee, "test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp
				+ " au lieux de" + donnee);
	}

	@Test
	public void testSetDonnee() {
		int tempInt[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 2, 2, 2, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 1, 2 },
				{ 0, 1, 2, 1, 2, 0, 1 }, { 0, 1, 2, 1, 2, 0, 0 }, { 0, 1, 2, 1, 2, 0, 0 } };
		Donnee temp = new Donnee(tempInt);
		donneeOrdinateur.setDonnee(temp);
		Donnee resultat = donneeOrdinateur.getDonnee();
		assertTrue(temp == resultat, "test si la valeur donnee est bien a celle envoyer apres un getDonnee mais est a "
				+ resultat + " au lieux de" + temp);
	}

	@Test
	public void testDonneeOrdinateurIntIntDonnee() {
		int temp = donneeOrdinateur.getResultat();
		assertTrue(temp == 100, "test si la valeur resultat est bien a 100 apres init mais est a " + temp);
		Donnee temp1 = donneeOrdinateur.getDonnee();
		assertTrue(temp1 == donnee, "test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp1
				+ " au lieux de" + donnee);
		int temp2 = donneeOrdinateur.getColonne();
		assertTrue(temp2 == 5, "test si la valeur Colonne est bien a 5 apres init mais est a " + temp);
		assertTrue(!donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a false apres init");
	}

	@Test
	public void testDonneeOrdinateur() {
		donneeOrdinateurTemp = new DonneeOrdinateur();
		int temp = donneeOrdinateurTemp.getResultat();
		assertTrue(temp == 0, "test si la valeur resultat est bien a 0 apres init mais est a " + temp);
		Donnee temp1 = donneeOrdinateurTemp.getDonnee();
		assertTrue(temp1 == null, "test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp1
				+ " au lieux de null");
		int temp2 = donneeOrdinateurTemp.getColonne();
		assertTrue(temp2 == 0, "test si la valeur Colonne est bien a 0 apres init mais est a " + temp);
		assertTrue(!donneeOrdinateurTemp.isCalculer(), "test si la valeur Calculer est bien a false apres init");

	}
}
