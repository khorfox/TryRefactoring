/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.EriGsm.GestoreBSC;
import com.telecomitalia.dynamic.omc.gestore.EriGsm.GestoreCELL;
import com.telecomitalia.dynamic.omc.gestore.EriGsm.GestoreCHANNEL_GROUP;
import com.telecomitalia.dynamic.omc.gestore.EriGsm.GestoreINTERNAL_CELL;
import com.telecomitalia.dynamic.omc.gestore.EriGsm.GestoreNREL;

/**
 * @author TL000547
 * 
 */
public class ManagerEriGsm extends ManagerGeneric {

	public ManagerEriGsm() {
		super();
	}


	public ManagerEriGsm(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
		}


	protected void setGestori(String nomeFile) {
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreINTERNAL_CELL.CHIAVE, new GestoreINTERNAL_CELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCELL.CHIAVE, new GestoreCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBSC.CHIAVE, new GestoreBSC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCHANNEL_GROUP.CHIAVE, new GestoreCHANNEL_GROUP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreNREL.CHIAVE, new GestoreNREL(nomeFile,dirCsv));
	}

	
}
