package com.telecomitalia.dynamic.omc.gestoreHuaUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreUPSCH extends Gestore implements
		GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/UPSCH.csv";
	public final static String CHIAVE = "UPSCH";
	public String PSCHPOWER;

	@Override
	public void load() {
		super.load();
		PSCHPOWER = estraiCampo("\"PSCHPOWER\"");
		output.println(generaRiga());

	}

	public GestoreUPSCH(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"PSCHPOWER"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+PSCHPOWER+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreUPSCH [PSCHPOWER=" + PSCHPOWER + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
