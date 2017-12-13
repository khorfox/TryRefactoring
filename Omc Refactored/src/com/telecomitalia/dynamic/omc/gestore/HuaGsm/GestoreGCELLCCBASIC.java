package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreGCELLCCBASIC extends Gestore implements
		GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLCCBASIC.csv";
	public final static String CHIAVE = "GCELLCCBASIC";
	public String RLT;

	@Override
	public void load() {
		super.load();
		RLT = estraiCampo("\"RLT\"");
		output.println(generaRiga());

	}

	public GestoreGCELLCCBASIC(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"RLT"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+RLT+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreGCELLBASIC [RLT=" + RLT + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
