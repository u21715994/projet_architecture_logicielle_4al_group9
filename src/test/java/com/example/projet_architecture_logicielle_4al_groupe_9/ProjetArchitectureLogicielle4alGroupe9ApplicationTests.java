package com.example.projet_architecture_logicielle_4al_groupe_9;

import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Client;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.projet_architecture_logicielle_4al_groupe_9.modele.SQL;
import static org.junit.jupiter.api.Assertions.*;


import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Consultant;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.Disponibility;
import com.example.projet_architecture_logicielle_4al_groupe_9.domain.PayementMode;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjetArchitectureLogicielle4alGroupe9ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	/**
	 * Test de connexion à notre BDD
	 * BDD sur une machine appartenant à Bastien LEUWERS
	 */
	void testConnexionSQL() {
		SQL sql = new SQL();
		assertNotNull(sql);
	}

	private static SQL sql;

	@BeforeAll
	static void setUp() {
		sql = new SQL();
	}

	@Test
	public void testAddAndGetConsultant() {
		Consultant consultant = new Consultant("moi", "toi", 500.0f, Arrays.asList("Java", "Spring"), Arrays.asList(Disponibility.MONDAY, Disponibility.WEDNESDAY), PayementMode.PAYEMENT_ONCE);
		SQL consultantDAO = new SQL();

		// Adding the consultant to the database
		consultantDAO.addConsultant(consultant);

		// Getting the consultant from the database
		Consultant consultantFromDB = consultantDAO.getConsultantByLastName("toi");

		// Checking if the retrieved consultant is not null
		assertNotNull(consultantFromDB);

		// Checking if the retrieved consultant has the same last name as the added consultant
		assertEquals("toi", consultantFromDB.getLastName());

		// Checking if the retrieved consultant has the same average daily rate as the added consultant
		assertEquals(500.0f, consultantFromDB.getAverageDailyRate());

		// Checking if the retrieved consultant has the same skills as the added consultant
		assertTrue(consultantFromDB.getSkills().containsAll(Arrays.asList("Java", "Spring")));

		// Checking if the retrieved consultant has the same disponibilities as the added consultant
		assertTrue(consultantFromDB.getDisponibilities().containsAll(Arrays.asList(Disponibility.MONDAY, Disponibility.WEDNESDAY)));

		// Checking if the retrieved consultant has the same payment mode as the added consultant
		assertEquals(PayementMode.PAYEMENT_ONCE, consultantFromDB.getPaymentMode());

		// Deleting the added consultant from the database
		consultantDAO.deleteConsultant(consultantFromDB.getID());
	}
	/**
	 * Test de la méthode updateConsultant
	 */
	@Test
	public void testUpdateConsultant() {

		SQL consultantDAO = new SQL();
		// Creating the consultant to update
		Consultant consultant = new Consultant("John", "Doe", 800f, Arrays.asList("Java", "SQL"), Arrays.asList(Disponibility.SATURDAY), PayementMode.PAYEMENT_ONCE);
		consultantDAO.addConsultant(consultant);
		String id = consultant.getID();
		System.out.println(id);


		// Updating the consultant
		consultant.setLastName("Smith");
		consultant.setAverageDailyRate(1000f);
		consultant.setSkills(Arrays.asList("Java", "Python", "JavaScript"));
		consultant.setDisponibilities(Arrays.asList(Disponibility.SATURDAY));
		consultant.setPaymentMode(PayementMode.PAYEMENT_THREE_TIME);
		consultantDAO.updateConsultant(consultant);

		// Checking if the update has been done
		Consultant consultantFromDB = consultantDAO.getConsultant(id);
		assertNotNull(consultantFromDB);
		assertEquals("Smith", consultantFromDB.getLastName());
		assertEquals(1000f, consultantFromDB.getAverageDailyRate());
		assertTrue(consultantFromDB.getSkills().containsAll(Arrays.asList("Java", "Python", "JavaScript")));
		assertEquals(Arrays.asList(Disponibility.SATURDAY), consultantFromDB.getDisponibilities());
		assertEquals(PayementMode.PAYEMENT_THREE_TIME, consultantFromDB.getPaymentMode());

		// Deleting the added consultant from the database
		consultantDAO.deleteConsultant(id);
	}

	@Test
	void testAddClient() {
		SQL sql = new SQL();
		String nom = "Client1";
		sql.addClient(nom);
		Client client = sql.getClientByNom(nom);
		assertNotNull(client);
		assertEquals(nom, client.getName());
		sql.deleteClient(client.getName());
	}

	@Test
	void testUpdateClient() {
		SQL sql = new SQL();
		String nom = "Client2";
		sql.addClient(nom);
		Client client = sql.getClientByNom(nom);
		String name = "ClientUP";
		sql.updateClient(client.getName(), name);
		client = sql.getClientByNom(name);
		assertNotNull(client);
		assertEquals(name, client.getName());
		sql.deleteClient(client.getName());
	}

	@Test
	void testDeleteClient() {
		SQL sql = new SQL();
		String nom = "Client3";
		sql.addClient(nom);
		Client client = sql.getClientByNom(nom);
		sql.deleteClient(client.getName());
		client = sql.getClientByNom(nom);
		assertNull(client);
	}




}
