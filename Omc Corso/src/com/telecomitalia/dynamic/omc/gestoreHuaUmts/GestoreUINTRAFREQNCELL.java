package com.telecomitalia.dynamic.omc.gestoreHuaUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreUINTRAFREQNCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_UMTS/UINTRAFREQNCELL.csv";
	public final static String CHIAVE = "UINTRAFREQNCELL";
	public String NCELLID;

	public GestoreUINTRAFREQNCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"NCELLID"+";"
		+"NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		NCELLID = estraiCampo("\"NCELLID\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+NCELLID+";"
		+nomeFileOmc;
	}
	
	
	@Override
	public String toString() {
		return "GestoreUINTRAFREQNCELL [NCELLID=" + NCELLID + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}

}
