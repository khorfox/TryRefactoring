package com.telecomitalia.dynamic.omc.gestore.EriLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreVsDataTermPointToMme extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_LTE/vsDataTermPointToMme.csv";
	public final static String CHIAVE = "vsDataTermPointToMme";
	public String mmeName;
	

	public GestoreVsDataTermPointToMme(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"mmeName"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	
		
	@Override
	public void load() {
		
		// scrive i primi dati della riga
		super.load();
			
		mmeName = estraiCampo("\"mmeName\"");
		
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+mmeName+";"
		+nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreVsDataTermPointToMme [mmeName=" + mmeName + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
