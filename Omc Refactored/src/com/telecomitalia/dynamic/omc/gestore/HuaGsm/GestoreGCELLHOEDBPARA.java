package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLHOEDBPARA extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLHOEDBPARA.csv";
	public final static String CHIAVE = "GCELLHOEDBPARA";
	public String OUTINNREXLEVTHRED;
	public String INTOINNREXLEVTHRED;
	
	public GestoreGCELLHOEDBPARA(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"OUTINNREXLEVTHRED"+";"
		+"INTOINNREXLEVTHRED"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		OUTINNREXLEVTHRED = estraiCampo("\"OUTINNREXLEVTHRED\"");
		INTOINNREXLEVTHRED = estraiCampo("\"INTOINNREXLEVTHRED\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+OUTINNREXLEVTHRED+";"
		+INTOINNREXLEVTHRED+";"
		+nomeFileOmc;
	}
	
	@Override
	public String toString() {
		return "GestoreGCELLHOEDBPARA [OUTINNREXLEVTHRED=" + OUTINNREXLEVTHRED
				+ ", INTOINNREXLEVTHRED=" + INTOINNREXLEVTHRED + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
