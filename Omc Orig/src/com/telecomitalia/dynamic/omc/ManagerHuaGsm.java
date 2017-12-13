/**
 * 
 */
package com.telecomitalia.dynamic.omc;

import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreBSC;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreBTS;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreG2GNCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreG3GNCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELL;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLBASICPARA;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLCCBASIC;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLFREQ;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLGPRS;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLHOEDBPARA;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLHOEMG;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLHOIUO;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLMAGRP;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGCELLSERVPARA;
import com.telecomitalia.dynamic.omc.gestoreHuaGsm.GestoreGEXT3GCELL;


/**
 * @author TL000547
 * 
 */
public class ManagerHuaGsm extends ManagerAbstract {

	public ManagerHuaGsm(String nomeFile, String path, String pathCsv) {
		super();
		this.nomeFile = nomeFile;
		this.DIR_PATH = path;
		this.dirCsv=pathCsv;
		gestoriClasse = new Hashtable<String, Gestore>();
		// definisco un elemento di una hashtable per ogni managedObject-class
		// da gestire
		gestoriClasse.put(GestoreBSC.CHIAVE, new GestoreBSC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreBTS.CHIAVE, new GestoreBTS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreG2GNCELL.CHIAVE, new GestoreG2GNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELL.CHIAVE, new GestoreGCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLCCBASIC.CHIAVE, new GestoreGCELLCCBASIC(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLBASICPARA.CHIAVE, new GestoreGCELLBASICPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLFREQ.CHIAVE, new GestoreGCELLFREQ(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLGPRS.CHIAVE, new GestoreGCELLGPRS(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOEMG.CHIAVE, new GestoreGCELLHOEMG(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOIUO.CHIAVE, new GestoreGCELLHOIUO(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLMAGRP.CHIAVE, new GestoreGCELLMAGRP(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLSERVPARA.CHIAVE, new GestoreGCELLSERVPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGCELLHOEDBPARA.CHIAVE, new GestoreGCELLHOEDBPARA(nomeFile,dirCsv));
		gestoriClasse.put(GestoreG3GNCELL.CHIAVE, new GestoreG3GNCELL(nomeFile,dirCsv));
		gestoriClasse.put(GestoreGEXT3GCELL.CHIAVE, new GestoreGEXT3GCELL(nomeFile,dirCsv));
	}



}
