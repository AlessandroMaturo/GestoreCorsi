package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Divisione;
import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {

	//qua potresti avere sia Corso corso che String codins
	public List<Studente> getStudentiByCorso(String codins) {
		
		String sql = "SELECT s.matricola, s.cognome, s.nome, s.cds FROM studente s, iscrizione i WHERE s.matricola=i.matricola AND i.codins=?";
		
		List<Studente> result = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,codins); //occhio che qua è una string
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result.add(new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("cds")));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}
		
	public List<Divisione> getDivisioneStudenti(String codins){
			
		String sql = "SELECT s.cds, COUNT(*) AS n "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola=i.matricola AND i.codins=? AND s.cds <> ' ' "
				+ "GROUP BY s.cds";
		
		List<Divisione> result = new ArrayList<Divisione>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,codins); //occhio che qua è una string
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result.add(new Divisione(rs.getString("cds"),rs.getInt("n"))); //perchè ho ridefinito come n quel numero
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
	}
		
			
		
	}
	
}
