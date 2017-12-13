package com.telecomitalia.dynamic.omc.gestoreHuaLte;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

// Estrae, dal managedObjet CELL, i campi necessari
public class GestoreCELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "HUA_LTE/CELL.csv";
	public final static String CHIAVE = "CELL";
	public String CELLNAME;
	public String CELLACTIVESTATE;
	public String CELLADMINSTATE;
	public String LOCALCELLID;
	public String PHYCELLID;
	public String DLEARFCN;

	public GestoreCELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version" + ";" + "distName" + ";" + "id" + ";"
				+ "CELLNAME" + ";" + "CELLACTIVESTATE" + ";" + "CELLADMINSTATE"
				+ ";" + "LOCALCELLID" + ";" + "PHYCELLID" + ";" + "DLEARFCN" + ";"
				+ "NOMEFILE_OMC");
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public void load() {
		super.load();
		CELLNAME = estraiCampo("\"CELLNAME\"");
		CELLACTIVESTATE = estraiCampo("\"CELLACTIVESTATE\"");
		CELLADMINSTATE = estraiCampo("\"CELLADMINSTATE\"");
		LOCALCELLID = estraiCampo("\"LOCALCELLID\"");
		PHYCELLID = estraiCampo("\"PHYCELLID\"");
		DLEARFCN = estraiCampo("\"DLEARFCN\"");
		output.println(generaRiga());
	}

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" + CELLNAME + ";"
				+ CELLACTIVESTATE + ";" + CELLADMINSTATE + ";" + LOCALCELLID
				+ ";" + PHYCELLID + ";" + DLEARFCN + ";"+ nomeFileOmc;
	}

	@Override
	public String toString() {
		return "GestoreCELL [CELLNAME=" + CELLNAME + ", CELLACTIVESTATE="
				+ CELLACTIVESTATE + ", CELLADMINSTATE=" + CELLADMINSTATE
				+ ", LOCALCELLID=" + LOCALCELLID + ", PHYCELLID=" + PHYCELLID
				+ ", DLEARFCN=" + DLEARFCN + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}

}
