package com.telecomitalia.dynamic.omc;

import java.io.File;
import java.util.Date;

import com.telecomitalia.dynamic.omc.model.Costruttore;
import com.telecomitalia.dynamic.omc.model.Tecnologia;

public class Client {
	
	public String costruttore;
	public String tecnologia;
	private final static String[] OUT_DIRECTORY = new String[] {"ERI_GSM","ERI_LTE","ERI_UMTS","HUA_GSM","HUA_LTE","HUA_UMTS","NSN_GSM","NSN_LTE","NSN_UMTS"};

	public Client(String costruttore, String tecnologia) {
		super();
		this.costruttore = costruttore;
		this.tecnologia = tecnologia;
	}


	public Manager getManager(String path, String nomeFile, String pathCsv) {
		switch (Costruttore.get(costruttore)) {
		case Ericsonn:
			switch (Tecnologia.get(tecnologia)) {
			case Gsm:
				return new ManagerEriGsm(nomeFile,path,pathCsv);
			case Lte:
				return new ManagerEriLte(nomeFile,path,pathCsv);
			case Umts:
				return new ManagerEriUmts(nomeFile,path,pathCsv);
			default:
				break;
			}
			break;
		case Huawei:
			switch (Tecnologia.get(tecnologia)) {
			case Gsm:
				return new ManagerHuaGsm(nomeFile,path,pathCsv);
			case Lte:
				return new ManagerHuaLte(nomeFile,path,pathCsv);
			case Umts:
				return new ManagerHuaUmts(nomeFile,path,pathCsv);
			default:
				break;
			}
			break;
		case NokiaSiemens:
			switch (Tecnologia.get(tecnologia)) {
			case Gsm:
				return new ManagerNsnGsm(nomeFile,path,pathCsv);
			case Lte:
				return new ManagerNsnLte(nomeFile,path,pathCsv);
			case Umts:
				return new ManagerNsnUmts(nomeFile,path,pathCsv);
			default:
				break;
			}
			break;
		default:
			break;
		
		}
		return new ManagerEmpty();
	}


	private void creaSingolaDirectory(String path, String nomeDir) {
		File file = new File(path + File.separator + nomeDir);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			throw new Exception("Nessun argomento in input");
		} else if (args.length != 5) {
			throw new Exception("Passare in input: costruttore tecnica path nomefile pathCsv");
		} else {
			System.out.println("Inizio Elaborazione " + new Date());
			System.out.println("Elaborazione del file: " + args[3] + " presente sotto " + args[2]);
			if (!Costruttore.isCorrect(args[0])){
				throw new Exception("Costruttore errato, ricevuto: " + args[0] + " atteso " + Costruttore.lista());
			}
			if (!Tecnologia.isCorrect(args[1])){
				throw new Exception("Tecnologia errata, ricevuto: " + args[1] + " atteso " + Tecnologia.lista());
			}
			Client client = new Client(args[0],args[1]);
			System.out.println("Creo le directory di out se non presenti");
			for (String el:Client.OUT_DIRECTORY) {
				client.creaSingolaDirectory(args[4], el);
			}
			System.out.println("Individuo il manager per il file corrente");
			Manager manager = client.getManager(args[2]+ File.separator,args[3],args[4]+ File.separator);
			System.out.println("Elaboro: " + manager.getClass().getSimpleName());
			int oggettiCaricati = manager.parse();
			System.out.println("Oggetti Caricati n.: " + oggettiCaricati);
			System.out.println("Fine Elaborazione " + new Date());
		}
	}



}
