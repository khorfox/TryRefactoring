package com.telecomitalia.dynamic.omc.gestoreEriGsm;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreINTERNAL_CELL extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_GSM/INTERNAL_CELL.csv";
	public final static String CHIAVE = "INTERNAL_CELL";
	public String MCC;
	public String MNC;
	public String LAC;
	public String CI;
	public String BSPWRB;
	public String ACCMIN;
	public String BCC;
	public String NCC;
	public String BSPWR;
	public String BCCHNO;
	public String MSTXPWR;
	public String CELL_STATE;
	public String LAYERTHR;
	public String RLINKT;

	@Override
	public void load() {
		super.load();
		MCC = estraiCampo("\"MCC\"");
		MNC = estraiCampo("\"MNC\"");
		LAC = estraiCampo("\"LAC\"");
		CI = estraiCampo("\"CI\"");
		BSPWRB = estraiCampo("\"BSPWRB\"");
		ACCMIN = estraiCampo("\"ACCMIN\"");
		BCC = estraiCampo("\"BCC\"");
		NCC = estraiCampo("\"NCC\"");
		BSPWR = estraiCampo("\"BSPWR\"");
		BCCHNO = estraiCampo("\"BCCHNO\"");
		MSTXPWR = estraiCampo("\"MSTXPWR\"");
		CELL_STATE = estraiCampo("\"CELL_STATE\"");
		LAYERTHR = estraiCampo("\"LAYERTHR\"");
		RLINKT = estraiCampo("\"RLINKT\"");

		output.println(generaRiga());
	}

	
	public GestoreINTERNAL_CELL(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"MCC"+";"
		+"MNC"+";"
		+"LAC"+";"
		+"CI"+";"
		+"BSPWRB"+";"
		+"ACCMIN"+";"
		+"BCC"+";"
		+"NCC"+";"
		+"BSPWR"+";"
		+"BCCHNO"+";"
		+"MSTXPWR"+";"
		+"CELL_STATE"+";"
		+"LAYERTHR"+";"
		+"RLINKT"+";"
		+"NOMEFILE_OMC");
	}
	

	private String generaRiga() {
		return version + ";" + distName + ";" + id + ";" 
		+ MCC + ";"
		+ MNC + ";" 
		+ LAC + ";" 
		+ CI + ";" 
		+ BSPWRB + ";" 
		+ ACCMIN + ";"
		+ BCC + ";" 
		+ NCC + ";" 
		+ BSPWR + ";" 
		+ BCCHNO + ";" 
		+ MSTXPWR + ";"
		+ CELL_STATE + ";" 
		+ LAYERTHR + ";" 
		+ RLINKT + ";"
		+ nomeFileOmc;
	}

	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreINTERNAL_CELL [MCC=" + MCC + ", MNC=" + MNC + ", LAC="
				+ LAC + ", CI=" + CI + ", BSPWRB=" + BSPWRB + ", ACCMIN="
				+ ACCMIN + ", BCC=" + BCC + ", NCC=" + NCC + ", BSPWR=" + BSPWR
				+ ", BCCHNO=" + BCCHNO + ", MSTXPWR=" + MSTXPWR
				+ ", CELL_STATE=" + CELL_STATE + ", LAYERTHR=" + LAYERTHR
				+ ", RLINKT=" + RLINKT + ", version=" + version + ", distName="
				+ distName + ", id=" + id + ", nomeFileOmc=" + nomeFileOmc
				+ "]";
	}

}
