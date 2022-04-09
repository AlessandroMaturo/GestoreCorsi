package it.polito.tdp.corsi.model;

import java.util.Objects;

public class Corso {
	
	private String codins;
	private Integer crediti;
	private String nome;
	private Integer pb;
	
	public Corso(String codins, Integer crediti, String nome, Integer db) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pb = db;
	}

	public String getCodins() {
		return codins;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public Integer getCrediti() {
		return crediti;
	}

	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDb() {
		return pb;
	}

	public void setDb(Integer db) {
		this.pb = db;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codins);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		return Objects.equals(codins, other.codins);
	}

	@Override
	public String toString() {
		return "Corso [codins=" + codins + ", crediti=" + crediti + ", nome=" + nome + ", db=" + pb + "]";
	}



	
}
