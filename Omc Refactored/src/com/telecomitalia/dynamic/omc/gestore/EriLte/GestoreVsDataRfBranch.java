package com.telecomitalia.dynamic.omc.gestore.EriLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreVsDataRfBranch extends Gestore implements GestoreInterface {

	static final String NOME_FILE = "ERI_LTE/vsDataRfBranch.csv";
	public final static String CHIAVE = "vsDataRfBranch";
	public String ulAttenuation;
	public String dlAttenuation;

	
	public GestoreVsDataRfBranch(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"ulAttenuation"+";"
		+"dlAttenuation"+";"
		+"NOMEFILE_OMC");
	}

	
	@Override
	public void load() {
		super.load();
		
		// Estrae i dati della lista in una stringa con i campi separati da ","
		// In questa lista dovrà essere utilizzato solo il rpimo valore
		dlAttenuation = estraiLista("\"dlAttenuation\"");
		
		// Estrae i dati della lista in una stringa con i campi separati da ","
		// In questa lista dovrà essere utilizzato solo il rpimo valore
		ulAttenuation = estraiLista("\"ulAttenuation\"");

				
		output.println(generaRiga());
	}
	
	
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+ulAttenuation+";"
		+dlAttenuation+";"
		+nomeFileOmc;
	}


	@Override
	public String getNomeFile() {
		return NOME_FILE;
	}

	@Override
	public String toString() {
		return "GestoreVsDataRfBranch [ulAttenuation=" + ulAttenuation
				+ ", dlAttenuation=" + dlAttenuation + ", version=" + version
				+ ", distName=" + distName + ", id=" + id + "]";
	}


}
