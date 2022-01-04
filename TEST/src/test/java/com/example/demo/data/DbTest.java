package com.example.demo.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
public class DbTest {

	@Autowired
	DataSource dataSource;
	
	private Logger log = LogManager.getLogger(DbTest.class);
	
	@Test
	public void connection() throws SQLException {
		try(Connection connection = dataSource.getConnection()) {
			DatabaseMetaData metaData = connection.getMetaData();
			log.info("URL : " + metaData.getURL());
			log.info("DriverName : " + metaData.getDriverName());
			log.info("UserNmae : " + metaData.getUserName());
		}
	}
	
	
	
}