package com.telecomitalia.dynamic.omc.gestoreHuaGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLSERVPARA extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLSERVPARA.csv";
	public final static String CHIAVE = "GCELLSERVPARA";
	public String RXLEVACCMIN;


	public GestoreGCELLSERVPARA(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"RXLEVACCMIN"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		RXLEVACCMIN = estraiCampo("\"RXLEVACCMIN\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+RXLEVACCMIN+";"
		+nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreGCELLSERVPARA [RXLEVACCMIN=" + RXLEVACCMIN
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}

}
