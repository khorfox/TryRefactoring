package com.telecomitalia.dynamic.omc.gestore.EriLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreVsDataENodeBFunction extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_LTE/vsDataENodeBFunction.csv";
	public final static String CHIAVE = "vsDataENodeBFunction";
	public String mcc;
	public String mnc;
	public String eNBId;
	
	
	
	public GestoreVsDataENodeBFunction(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"mcc"+";"
		+"mnc"+";"
		+"eNBId"+";"
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
		eNBId = estraiCampo("\"eNBId\"");
				
		// Estrae i dati in Item di Lista
		// Chiave Lista = eNodeBPlmnId
		mcc = estraiItem("\"eNodeBPlmnId\"", "\"mcc\"");
		mnc = estraiItem("\"eNodeBPlmnId\"", "\"mnc\"");
	
		output.println(generaRiga());
	}


	private String generaRiga() {

		return version+";"+distName+";"+id+";"
		+mcc+";"
		+mnc+";"
		+eNBId+";"
		+nomeFileOmc;
	}


	@Override
	public String toString() {
		return "GestoreVsDataENodeBFunction [mcc=" + mcc + ", mnc=" + mnc
				+ ", eNBId=" + eNBId + ", version=" + version + ", distName="
				+ distName + ", id=" + id + "]";
	}


}
