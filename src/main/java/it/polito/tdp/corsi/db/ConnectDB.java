package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {	
		
		try {
			String url = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root";
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Errore di connesione!");
			e.printStackTrace();
			return null;
		}	
	}

}