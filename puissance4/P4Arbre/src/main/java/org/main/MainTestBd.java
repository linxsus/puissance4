package org.main;

import org.P4Metier.Factory.Factory;
import org.P4Metier.id.GestIdDonneeLong;
import org.P4Metier.ordi.OrdinateurArbre;
import org.Persistant_.mysql.MysqlConnection;

public class MainTestBd {

	public static void main(String[] args) {
		int temp[][] = { { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		Factory factory = new Factory(true, true, true, true);
		MysqlConnection mysqlconnexion = factory.getMysqlConnection();

		mysqlconnexion.setUrl("jdbc:mysql://192.168.1.16/Puissance4?autoReconnect=true&useSSL=false");
		GestIdDonneeLong donnee = (GestIdDonneeLong) factory.getGestIDDonnee();
		donnee.setDonnee(temp);
		OrdinateurArbre ordi = (OrdinateurArbre) factory.getOrdinateur(donnee);
		ordi.setTourMax(48);
		ordi.jouer();

	}

}
