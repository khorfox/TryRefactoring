package com.telecomitalia.dynamic.omc.gestore.EriLte;

import com.telecomitalia.dynamic.omc.gestore.Gestore;
import com.telecomitalia.dynamic.omc.gestore.GestoreInterface;

public class GestoreVsDataEUtranCellFDD extends Gestore implements GestoreInterface{

	static final String NOME_FILE = "ERI_LTE/vsDataEUtranCellFDD.csv";
	public final static String CHIAVE="vsDataEUtranCellFDD";
	public String cellId;
	public String sectorCarrierRef;
	public String physicalLayerCellIdGroup;
	public String physicalLayerSubCellId;
	public String tac;
	public String earfcndl;
	public String administrativeState;
	
		
	public GestoreVsDataEUtranCellFDD(String nome, String path) {
		super();
		nomeFileOmc = nome;
		inizializza(path);
		// Inserisce la prima riga di intestazione
		output.println("version"+";"+"distName"+";"+"id"+";"
		+"cellId"+";"
		+"sectorCarrierRef"+";"
		+"physicalLayerCellIdGroup"+";"
		+"physicalLayerSubCellId"+";"
		+"tac"+";"
		+"earfcndl"+";"
		+"administrativeState"+";"
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
		
		// Legge i dati non definiti in liste
		cellId = estraiCampo("\"cellId\"");
		physicalLayerCellIdGroup = estraiCampo("\"physicalLayerCellIdGroup\"");
		physicalLayerSubCellId = estraiCampo("\"physicalLayerSubCellId\"");
		tac = estraiCampo("\"tac\"");
		earfcndl = estraiCampo("\"earfcndl\"");
		administrativeState = estraiCampo("\"administrativeState\"");
		
		// Estrae i dati della lista in una stringa con i campi separati da ","
		// In questa lista dovrà essere utilizzato solo il rpimo valore
		sectorCarrierRef = estraiLista("\"sectorCarrierRef\"");
		
				
		output.println(generaRiga());
	
	}
	
	private String generaRiga() {
		return version+";"+distName+";"+id+";"
		+cellId+";"
		+sectorCarrierRef+";"
		+physicalLayerCellIdGroup+";"
		+physicalLayerSubCellId+";"
		+tac+";"
		+earfcndl+";"
		+administrativeState+";"
		+nomeFileOmc;
	}

	
	@Override
	public String toString() {
		return "GestoreVsDataEUtranCellFDD [cellId=" + cellId
				+ ", sectorCarrierRef=" + sectorCarrierRef
				+ ", physicalLayerCellIdGroup=" + physicalLayerCellIdGroup
				+ ", physicalLayerSubCellId=" + physicalLayerSubCellId
				+ ", tac=" + tac + ", earfcndl=" + earfcndl
				+ ", administrativeState=" + administrativeState + ", version="
				+ version + ", distName=" + distName + ", id=" + id + "]";
	}
	
}
