package com.aplazo.api.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void createDatabase() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS CREDIT_REQUEST ( \r\n" + "   ID BIGINT AUTO_INCREMENT, \r\n"
				+ "   AMOUNT REAL NOT NULL, \r\n" + "   TERMS INTEGER NOT NULL, \r\n" + "   RATE REAL NOT NULL \r\n"
				+ ");");
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PAYMENT_RESPONSE ( \r\n" + "   ID BIGINT AUTO_INCREMENT, \r\n"
				+ "   CREDIT BIGINT NOT NULL, \r\n" + "   AMOUNT REAL NOT NULL, \r\n"
				+ "   NUMBER INTEGER NOT NULL, \r\n" + "   DATE DATE NOT NULL \r\n" + ");");
	}

}
