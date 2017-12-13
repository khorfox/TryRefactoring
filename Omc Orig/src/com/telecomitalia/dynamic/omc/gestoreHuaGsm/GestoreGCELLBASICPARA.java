package com.telecomitalia.dynamic.omc.gestoreHuaGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreGCELLBASICPARA extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLBASICPARA.csv";
	public final static String CHIAVE = "GCELLBASICPARA";
	public String RXMIN;
	//public String OUTINNREXLEVTHRED;
	//public String INTOINNREXLEVTHRED;
	public String MAXTA;

	public GestoreGCELLBASICPARA(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"RXMIN"+";"
		//+"OUTINNREXLEVTHRED"+";"
		//+"INTOINNREXLEVTHRED"+";"
		+"MAXTA"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		RXMIN = estraiCampo("\"RXMIN\"");
		//OUTINNREXLEVTHRED = estraiCampo("\"OUTINNREXLEVTHRED\"");
		//INTOINNREXLEVTHRED = estraiCampo("\"INTOINNREXLEVTHRED\"");
		MAXTA = estraiCampo("\"MAXTA\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+RXMIN+";"
		//+OUTINNREXLEVTHRED+";"
		//+INTOINNREXLEVTHRED+";"
		+MAXTA+";"
		+nomeFileOmc;
	}
	
	@Override
	public String toString() {
		return "GestoreGCELLBASICPARA [RXMIN=" + RXMIN + ", MAXTA=" + MAXTA
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}

}
