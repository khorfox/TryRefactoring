package com.telecomitalia.dynamic.omc.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.telecomitalia.dynamic.omc.model.Costruttore;
import com.telecomitalia.dynamic.omc.model.Tecnologia;

public class ManagerFactoryTest {

	private String path = "C:\\temp";
	private String pathCsv = "C:\\ZZ-SoftwareFactory-0-Sviluppo\\DYNAMIC_INVENTORY\\Workspace-Corso\\Omc Refactored" + "\\csv\\";
	private String nomeFile = "prova.csv";

	@Before
	public void setUp() throws Exception {
		System.out.println("inizializzo");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("finalizzo");
	}

	@Test
	public void testGetManagerEriGsm() {
		ManagerFactory factory = new ManagerFactory(Costruttore.Ericsonn, Tecnologia.Gsm);
		Manager manager = factory.getManager(nomeFile, path,  pathCsv);
		assertTrue(manager instanceof ManagerEriGsm);
	}

	@Test
	public void testGetManagerEriGsmNone() {
		ManagerFactory factory = new ManagerFactory(Costruttore.Ericsonn, Tecnologia.Gsm);
		Manager manager = factory.getManager(nomeFile, path,  pathCsv);
		assertFalse(manager instanceof ManagerEriUmts);
	}

	@Test
	public void testGetManagerHuaLte() {
		ManagerFactory factory = new ManagerFactory(Costruttore.Huawei, Tecnologia.Lte);
		Manager manager = factory.getManager(nomeFile, path,  pathCsv);
		assertTrue(manager instanceof ManagerHuaLte);
	}

	@Test
	public void testGetManagerEriGsmAdv() {
		ManagerFactory factory = new ManagerFactory(Costruttore.Ericsonn, Tecnologia.Gsm);
		Manager manager = factory.getManagerAdv(nomeFile, path,  pathCsv);
		assertTrue(manager instanceof ManagerEriGsm);
	}

	@Test
	public void testGetManagerEriGsmExtreme() {
		ManagerFactory factory = new ManagerFactory(Costruttore.Ericsonn, Tecnologia.Gsm);
		Manager manager = factory.getManagerExtreme(nomeFile, path,  pathCsv);
		assertTrue(manager instanceof ManagerGeneric);
		assertTrue(manager instanceof ManagerEriGsm);
	}


	
}
