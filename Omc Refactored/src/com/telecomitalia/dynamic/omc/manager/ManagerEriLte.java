/**
 * 
 */
package com.telecomitalia.dynamic.omc.manager;

import com.telecomitalia.dynamic.omc.gestore.EriLte.GestoreVsDataENodeBFunction;
import com.telecomitalia.dynamic.omc.gestore.EriLte.GestoreVsDataEUtranCellFDD;
import com.telecomitalia.dynamic.omc.gestore.EriLte.GestoreVsDataRfBranch;
import com.telecomitalia.dynamic.omc.gestore.EriLte.GestoreVsDataSectorEquipmentFunction;
import com.telecomitalia.dynamic.omc.gestore.EriLte.GestoreVsDataTermPointToMme;

/**
 * @author TL000547
 * 
 */
public class ManagerEriLte extends ManagerGeneric {

	public ManagerEriLte() {
		super();
	}


	public ManagerEriLte(String nomeFile, String path, String pathCsv) {
		super(nomeFile, path, pathCsv);
	}

	
	@Override
	protected void setGestori(String nomeFile) {
		gestoriClasse.put(GestoreVsDataENodeBFunction.CHIAVE, new GestoreVsDataENodeBFunction(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataEUtranCellFDD.CHIAVE, new GestoreVsDataEUtranCellFDD(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataRfBranch.CHIAVE, new GestoreVsDataRfBranch(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataSectorEquipmentFunction.CHIAVE, new GestoreVsDataSectorEquipmentFunction(nomeFile,dirCsv));
		gestoriClasse.put(GestoreVsDataTermPointToMme.CHIAVE, new GestoreVsDataTermPointToMme(nomeFile,dirCsv));
	}

}
