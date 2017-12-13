package com.telecomitalia.dynamic.omc.gestoreEriUmts;

import com.telecomitalia.dynamic.omc.Gestore;
import com.telecomitalia.dynamic.omc.GestoreInterface;

public class GestoreUtranCell extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_UMTS/UtranCell.csv";
	public final static String CHIAVE = "UtranCell";
	public String userLabel;
	public String lac;
	public String cId;
	public String sac;
	public String uarfcnDl;
	public String uarfcnUl;
	public String primaryScramblingCode;
	public String primarySchPower;
	
	
	public GestoreUtranCell(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"userLabel"+";"
		+"lac"+";"
		+"cId"+";"
		+"sac"+";"
		+"uarfcnDl"+";"
		+"uarfcnUl"+";"
		+"primaryScramblingCode"+";"
		+"primarySchPower"+";"
		+"NOMEFILE_OMC");
	}
	
	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	
	@Override
	public void load() {
		
		// scrive i primi dati della riga
		super.load();
		
		// Leggere prima tutti i dati non definiti in liste
		userLabel = estraiCampo("\"userLabel\"");
		lac = estraiCampo("\"lac\"");
		cId = estraiCampo("\"cId\"");
		sac = estraiCampo("\"sac\"");
		uarfcnDl = estraiCampo("\"uarfcnDl\"");
		uarfcnUl = estraiCampo("\"uarfcnUl\"");
		primaryScramblingCode = estraiCampo("\"primaryScramblingCode\"");
		primarySchPower = estraiCampo("\"primarySchPower\"");
			
		// Estrae i dati della lista in una stringa con i campi separati da ","
	
		output.println(generaRiga());
	}


	private String generaRiga() {

		return version+";"+distName+";"+id+";"
		+userLabel+";"
		+lac+";"
		+cId+";"
		+sac+";"
		+uarfcnDl+";"
		+uarfcnUl+";"
		+primaryScramblingCode+";"
		+primarySchPower+";"
		+nomeFileOmc;
	}


	@Override
	public String toString() {
		return "GestoreUtranCell [userLabel=" + userLabel + ", lac=" + lac
				+ ", cId=" + cId + ", sac=" + sac + ", uarfcnDl=" + uarfcnDl
				+ ", uarfcnUl=" + uarfcnUl + ", primaryScramblingCode="
				+ primaryScramblingCode + ", primarySchPower="
				+ primarySchPower + ", version=" + version + ", distName="
				+ distName + ", id=" + id + "]";
	}


}
