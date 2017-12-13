package com.telecomitalia.dynamic.omc.gestore.EriUmts;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreManagedElement extends Gestore implements GestoreInterface{

	static final String NOME_FILE = "ERI_UMTS/ManagedElement.csv";
	public final static String CHIAVE="ManagedElement";
	public String managedElementType;
	public String userLabel;
		
	
	public GestoreManagedElement(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"managedElementType"+";"
		+"userLabel"+";"
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
		managedElementType = estraiCampo("\"managedElementType\"");
		userLabel = estraiCampo("\"userLabel\"");
				
		// Estrae i dati della lista in una stringa con i campi separati da ","
		
		
		output.println(generaRiga());
	
	}
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+managedElementType+";"
		+userLabel+";"
		+nomeFileOmc;
	}

	
	@Override
	public String toString() {
		return "GestoreManagedElement [managedElementType="
				+ managedElementType + ", userLabel=" + userLabel
				+ ", version=" + version + ", distName=" + distName + ", id="
				+ id + "]";
	}
	
}
