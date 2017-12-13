package com.telecomitalia.dynamic.omc.gestore.HuaGsm;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreGCELLHOEMG extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_GSM/GCELLHOEMG.csv";
	public final static String CHIAVE = "GCELLHOEMG";
	public String TALIMIT;
	
	
	public GestoreGCELLHOEMG(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"TALIMIT"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		TALIMIT = estraiCampo("\"TALIMIT\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+TALIMIT+";"
		+nomeFileOmc;
	}

	
	@Override
	public String toString() {
		return "GestoreGCELLHOEMG [TALIMIT=" + TALIMIT + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
