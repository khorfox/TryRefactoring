package com.telecomitalia.dynamic.omc.gestoreNsnLte;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreLNMME extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "NSN_LTE/LNMME.csv";
	public final static String CHIAVE = "LNMME";
	public String mmeName;

	@Override
	public void load() {
		super.load();
		mmeName = estraiCampo("\"mmeName\"");
		output.println(generaRiga());
	}

	public GestoreLNMME(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"mmeName"+";"
		+"NOMEFILE_OMC");
	}

	private String generaRiga() {

		return version+";"+distName+";"+id+";"
		+mmeName+";"
		+nomeFileOmc;
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreLNMME [mmeName=" + mmeName + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
