package com.telecomitalia.dynamic.omc;

import java.io.IOException;
import java.util.Hashtable;

public abstract class ManagerAbstract implements Manager {

	protected String DIR_PATH = "D:/Workspace/FILE_OMC/";
	protected String nomeFile;
	protected int numeroOggettiCaricati = 0;
	protected Hashtable<String, Gestore> gestoriClasse;
	protected static final String TAG_CLASS = "class=";
	public String dirCsv;
	public boolean debug = false;
	
	public ManagerAbstract() {
		super();
	}

	public abstract int parse() throws IOException;
	
	public void stampaNomeFile() {
		if(debug ){
			for (Gestore el : gestoriClasse.values()) {
				System.out.println(el.getNomeFile());
				el.termina();
			}
		}
	}
		public void stampaGestore(Gestore gestore) {
			if(debug ){
				System.out.println(gestore);
			}
	}
	
	
}