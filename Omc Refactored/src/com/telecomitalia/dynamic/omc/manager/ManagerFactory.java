package com.telecomitalia.dynamic.omc.manager;

import java.util.Hashtable;

import com.telecomitalia.dynamic.omc.model.Costruttore;
import com.telecomitalia.dynamic.omc.model.Tecnologia;

public class ManagerFactory {
	private Costruttore costruttore;
	private Tecnologia tecnologia;
	

	
	@SuppressWarnings("serial")
	private final static Hashtable<String,Manager> tabManger = new Hashtable<String,Manager>() {{
		put(Costruttore.Ericsonn.toString() + Tecnologia.Gsm.toString()  , new ManagerEriGsm() );
		put(Costruttore.Ericsonn.toString() + Tecnologia.Umts.toString()  , new ManagerEriUmts() );
		put(Costruttore.Ericsonn.toString() + Tecnologia.Lte.toString()  , new ManagerEriLte() );
		put(Costruttore.Huawei.toString() + Tecnologia.Gsm.toString()  , new ManagerHuaGsm() );
		put(Costruttore.Huawei.toString() + Tecnologia.Umts.toString()  , new ManagerHuaUmts() );
		put(Costruttore.Huawei.toString() + Tecnologia.Lte.toString()  , new ManagerHuaLte() );
		put(Costruttore.NokiaSiemens.toString() + Tecnologia.Gsm.toString()  , new ManagerNsnGsm() );
		put(Costruttore.NokiaSiemens.toString() + Tecnologia.Umts.toString()  , new ManagerNsnUmts() );
		put(Costruttore.NokiaSiemens.toString() + Tecnologia.Lte.toString()  , new ManagerNsnLte() );
	}};

	public ManagerFactory(Costruttore costruttore, Tecnologia tecnologia) {
		this.costruttore = costruttore;
		this.tecnologia = tecnologia;
	}

	public Manager getManager(String path, String nomeFile, String pathCsv) {
		switch (costruttore) {
		case Ericsonn:
			switch (tecnologia) {
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
			switch (tecnologia) {
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
			switch (tecnologia) {
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
		return new ManagerEmpty(nomeFile,path,pathCsv);
	}

	public Manager getManagerAdv(String path, String nomeFile, String pathCsv) {
		ManagerGeneric manager = (ManagerGeneric) tabManger.get(costruttore.toString() + tecnologia.toString());
		manager.setDIR_PATH(path);
		manager.setDirCsv(pathCsv);
		manager.setNomeFile(nomeFile);
		manager.setGestori(nomeFile);
		return manager;
	}

	public Manager getManagerExtreme(String path, String nomeFile, String pathCsv) {
		try {
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("com.telecomitalia.dynamic.omc.manager.Manager" + costruttore.toCamelCase() + tecnologia.toCamelCase());
			ManagerGeneric manager = (ManagerGeneric)c.newInstance();
			manager.setDIR_PATH(path);
			manager.setDirCsv(pathCsv);
			manager.setNomeFile(nomeFile);
			manager.setGestori(nomeFile);
			return manager;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ManagerEmpty(nomeFile,path,pathCsv);
	}



}
