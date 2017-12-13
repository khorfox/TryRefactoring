package com.telecomitalia.dynamic.omc.gestore.HuaUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreUNODEB extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/UNODEB.csv";
	public final static String CHIAVE = "UNODEB";
	public String NODEBNAME;

	public GestoreUNODEB(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"NODEBNAME"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		NODEBNAME = estraiCampo("\"NODEBNAME\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+NODEBNAME+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreUNODEB [NODEBNAME=" + NODEBNAME + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
