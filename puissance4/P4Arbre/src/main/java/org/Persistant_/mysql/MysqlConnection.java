package org.Persistant_.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class MysqlConnection {
	private static String url = "jdbc:mysql://localhost/Puissance4?autoReconnect=true&useSSL=false";
	private static String login = "Puissance4";
	private static String passwd = "p4C@llans";
	private static Connection cn = null;
	private static Statement st = null;

	/**
	 * creation de la connexion a la base de donnee
	 */
	private void init() {
		if (cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");// Etape 1 : Chargement du driver
				cn = DriverManager.getConnection(url, login, passwd); // Etape 2 : r�cup�ration de la connexion
				st = cn.createStatement();// Etape 3 : Cr�ation d'un statement
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					cn.close();// lib�rer ressources de la m�moire.
					st.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.Persistant_.BaseConnection#cn()
	 */
	public Connection cn() {
		if (cn == null) {
			init();
		}
		return cn;
	}

	/**
	 * retourne le statement de la connexion a la base de donnee
	 *
	 * @return statement de la connexion a la base de donnee
	 *
	 */
	public Statement st() {
		if (st == null) {
			init();
		}
		return st;
	}

	/**
	 * !!!!ATENTION DOIT ETRE UTILISER AVANT TOUTE LES AUTRES METHODE DE LA CLASS!!!
	 * initialise la valeur url pour la connexion.
	 */
	public void setUrl(String newUrl) {
		url = newUrl;
		try {
			if (st != null) {
				st.close();
			}
			if (cn != null) {
				cn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cn = null;
		st = null;
		init();
	}

	public void refresh() {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cn = null;
		init();
	}

}
