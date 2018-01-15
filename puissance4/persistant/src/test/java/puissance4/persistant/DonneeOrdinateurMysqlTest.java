package puissance4.persistant;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mysql.ordinateurBasic.DonneeBase;

import puissance4.modele.Donnee;

@RunWith(JUnitPlatform.class)
class DonneeOrdinateurMysqlTest {

	DonneeOrdinateur donneeOrdinateur;
	DonneeBase donnee;
	DonneeOrdinateur donneeOrdinateurTemp;

	@BeforeEach
	public void initAll() {
		int temp[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 0, 0, 2, 2, 0, 1, 2 }, { 0, 0, 2, 1, 0, 1, 2 },
				{ 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		donnee = new DonneeBase(temp, 1, 1);
		donneeOrdinateur = new DonneeOrdinateurMysql(5, 100, donnee);

	}

	@Disabled
	@Test
	public void testIsCalculer() {
		donneeOrdinateur.setCalculer(false);
		assertTrue(!donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a false apres init");
		donneeOrdinateur.setCalculer(true);
		assertTrue(donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a true apres init");

	}

	@Disabled
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
		assertTrue(temp.toString().equals(donnee.toString()),
				"test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp + " au lieux de"
						+ donnee);
	}

	@Test
	public void testSetDonnee() {
		int tempInt[][] = { { 1, 2, 2, 1, 2, 2, 2 }, { 2, 2, 2, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 1, 2 },
				{ 0, 1, 2, 1, 2, 0, 1 }, { 0, 1, 2, 1, 2, 0, 0 }, { 0, 1, 2, 1, 2, 0, 0 } };
		Donnee temp = new Donnee(tempInt);
		donneeOrdinateur.setDonnee(temp);
		Donnee resultat = donneeOrdinateur.getDonnee();
		assertTrue(temp.toString().equals(resultat.toString()),
				"test si la valeur donnee est bien a celle envoyer apres un getDonnee mais est a " + resultat
						+ " au lieux de" + temp);
	}

	@Disabled
	@Test
	public void testDonneeOrdinateurIntIntDonnee() {
		int temp = donneeOrdinateur.getResultat();
		assertTrue(temp == 100, "test si la valeur resultat est bien a 100 apres init mais est a " + temp);
		Donnee temp1 = donneeOrdinateur.getDonnee();
		assertTrue(temp1.toString().equals(donnee.toString()),
				"test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp1 + " au lieux de"
						+ donnee);
		int temp2 = donneeOrdinateur.getColonne();
		assertTrue(temp2 == 5, "test si la valeur Colonne est bien a 5 apres init mais est a " + temp);
		donneeOrdinateur.setCalculer(false);
		assertTrue(!donneeOrdinateur.isCalculer(), "test si la valeur Calculer est bien a false apres init");
	}

	@Test
	public void testDonneeOrdinateur() {
		donneeOrdinateurTemp = new DonneeOrdinateurMysql();
		int temp = donneeOrdinateurTemp.getResultat();
		assertTrue(temp == 0, "test si la valeur resultat est bien a 0 apres init mais est a " + temp);
		assertTrue(!donneeOrdinateurTemp.isCalculer(), "test si la valeur Calculer est bien a false apres init");
		Donnee temp1 = donneeOrdinateurTemp.getDonnee();
		assertTrue(temp1.toString().equals(
				"| | | | | | | |5\n| | | | | | | |4\n| | | | | | | |3\n| | | | | | | |2\n| | | | | | | |1\n| | | | | | | |0\n 1 2 3 4 5 6 7\n"),
				"test si la valeur donnee est bien a celle envoyer apres init mais est a " + temp1
						+ " au lieux de null");
	}
}