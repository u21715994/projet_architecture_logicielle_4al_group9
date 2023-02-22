package com.example.projet_architecture_logicielle_4al_groupe_9;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.projet_architecture_logicielle_4al_groupe_9.modele.SQL;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjetArchitectureLogicielle4alGroupe9ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	/**
	 * Test de connexion à notre BDD
	 */
	void testConnexionSQL() {
		SQL sql = new SQL();
		assertNotNull(sql);
	}

}
