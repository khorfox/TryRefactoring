package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreGCELLHOIUO extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLHOIUO.csv";
	public final static String CHIAVE = "GCELLHOIUO";
	public String RECLEVTHRES;

	@Override
	public void load() {
		super.load();
		RECLEVTHRES = estraiCampo("\"RECLEVTHRES\"");
		output.println(generaRiga());
	}

	public GestoreGCELLHOIUO(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"RECLEVTHRES"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+RECLEVTHRES+";"
		+nomeFileOmc;
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreGCELLHOIUO [RECLEVTHRES=" + RECLEVTHRES + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
