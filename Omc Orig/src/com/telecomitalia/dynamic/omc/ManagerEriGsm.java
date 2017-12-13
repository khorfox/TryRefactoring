/**
 * 
 */
package com.telecomitalia.dynamic.omc;

import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.gestoreEriGsm.GestoreBSC;
import com.telecomitalia.dynamic.omc.gestoreEriGsm.GestoreCELL;
import com.telecomitalia.dynamic.omc.gestoreEriGsm.GestoreCHANNEL_GROUP;
import com.telecomitalia.dynamic.omc.gestoreEriGsm.GestoreINTERNAL_CELL;
import com.telecomitalia.dynamic.omc.gestoreEriGsm.GestoreNREL;

/**
 * @author TL000547
 * 
 */
public class ManagerEriGsm extends ManagerAbstract {

	public ManagerEriGsm(String nomeFile, String path, String pathCsv) {
		super();
		this.nomeFile = nomeFile;
		this.DIR_PATH = path;
		this.dirCsv=pathCsv;
		gestoriClasse = new Hashtable<String, Gestore>();
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreINTERNAL_CELL.CHIAVE, new GestoreINTERNAL_CELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCELL.CHIAVE, new GestoreCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBSC.CHIAVE, new GestoreBSC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreCHANNEL_GROUP.CHIAVE, new GestoreCHANNEL_GROUP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreNREL.CHIAVE, new GestoreNREL(nomeFile,dirCsv));
		}

	
}
