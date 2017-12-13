/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreADCE;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreBSC;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreBTS;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreBTSNE;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreHOC;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestorePOC;
import com.telecomitalia.dynamic.omc.gestore.NsnGsm.GestoreTRX;


/**
 * @author TL000547
 * 
 */
public class ManagerNsnGsm  extends ManagerGeneric {

	public ManagerNsnGsm() {
		super();
	}

	public ManagerNsnGsm(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreADCE.CHIAVE, new GestoreADCE(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBSC.CHIAVE, new GestoreBSC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBTS.CHIAVE, new GestoreBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBTSNE.CHIAVE, new GestoreBTSNE(nomeFile,dirCsv));
		gestoriClasse.put(GestoreHOC.CHIAVE, new GestoreHOC(nomeFile,dirCsv));
		gestoriClasse.put(GestorePOC.CHIAVE, new GestorePOC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreTRX.CHIAVE, new GestoreTRX(nomeFile,dirCsv));
	}
	


}
