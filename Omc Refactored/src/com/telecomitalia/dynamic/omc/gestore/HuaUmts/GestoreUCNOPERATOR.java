package com.telecomitalia.dynamic.omc.gestore.HuaUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreUCNOPERATOR extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/UCNOPERATOR.csv";
	public final static String CHIAVE = "UCNOPERATOR";
	public String MCC;
	public String MNC;

	public GestoreUCNOPERATOR(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"MCC"+";"
		+"MNC"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		MCC = estraiCampo("\"MCC\"");
		MNC = estraiCampo("\"MNC\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+MCC+";"
		+MNC+";"
		+nomeFileOmc;
	}
	
	@Override
	public String toString() {
		return "GestoreUCNOPERATOR [MCC=" + MCC + ", MNC=" + MNC + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
