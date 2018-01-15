package org.P4Optimisation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.P4Metier.Ordinateur;
import org.P4Metier.id.GestIdDonneeInt3;
import org.P4Metier.id.GestIdDonneeLong;
import org.P4Modele_.jeux.GestDonneeTabByte;
import org.P4Modele_.jeux.GestDonneeTabInt;
import org.openjdk.jmh.annotations.Benchmark;

public class BenchmarkGagnee {

	@Benchmark
	public void testIdLongTabInt() {
		int temp[][] = { { 1, 2, 1, 1, 0, 1, 0 }, { 0, 0, 2, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		donnee.setDonnee(temp);
		Ordinateur<T> ordinateur = getOrdinateur(donnee);
		int i = ordinateur.jouer(donnee);
		assertTrue(5 == i, "pour gagner doit jouer en 5 a jouer en" + i + "\n" + donnee);

		GestDonneeTabInt donneeBase = new GestDonneeTabInt();
		GestIdDonneeLong donneeId = new GestIdDonneeLong(donneeBase);
		donneeId.setDonnee(temp);
		donneeId.ajoutPion(4);
		donneeId.ajoutPion(5);
		donneeId.ajoutPion(4);
		donneeId.enleverPion();
		donneeId.getIdBaseDonnee();
	}

	@Benchmark
	public void testIdLongTabByte() {
		GestDonneeTabByte donneeBase = new GestDonneeTabByte();
		GestIdDonneeLong donneeId = new GestIdDonneeLong(donneeBase);
		donneeId.ajoutPion(4);
		donneeId.ajoutPion(5);
		donneeId.ajoutPion(4);
		donneeId.enleverPion();
		donneeId.getIdBaseDonnee();
	}

	@Benchmark
	public void testIdIntTabByte() {
		GestDonneeTabByte donneeBase = new GestDonneeTabByte();
		GestIdDonneeInt3 donneeId = new GestIdDonneeInt3(donneeBase);
		donneeId.ajoutPion(4);
		donneeId.ajoutPion(5);
		donneeId.ajoutPion(4);
		donneeId.enleverPion();
		donneeId.getIdBaseDonnee();
	}

	@Benchmark
	public void testIdIntTabint() {
		GestDonneeTabInt donneeBase = new GestDonneeTabInt();
		GestIdDonneeInt3 donneeId = new GestIdDonneeInt3(donneeBase);
		donneeId.ajoutPion(4);
		donneeId.ajoutPion(5);
		donneeId.ajoutPion(4);
		donneeId.enleverPion();
		donneeId.getIdBaseDonnee();
	}

	// public static Donnee donnee;
	// public static OrdinateurBasic ordi;
	//
	// @Setup
	// public static void init() {
	// donnee = new Donnee();
	// ordi = new OrdinateurBasic(donnee, false, 2);
	// }
	//
	// @Benchmark
	// public int testMethod() {
	//
	// return ordi.jouer();
	// }

	// @Benchmark
	// public void testMethod1() {
	// Donnee donnee = new Donnee();
	// OrdinateurBasic ordi = new OrdinateurBasic(donnee, false, 4);
	// int aJouer = ordi.jouer();
	// donnee.ajoutPion(aJouer);
	// }
	//
	// @Benchmark
	// public void testMethod2() {
	// Donnee donnee = new Donnee();
	// OrdinateurBasic ordi = new OrdinateurBasic(donnee, false, 3);
	// int aJouer = ordi.jouer();
	// donnee.ajoutPion(aJouer);
	// }
}
