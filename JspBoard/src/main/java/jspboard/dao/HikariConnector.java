package jspboard.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnector {

	HikariDataSource dataSource;
	
	public HikariConnector(String driverName, String jdbcUrl, String userName, String password) {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverName);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(userName);
		config.setPassword(password);

		dataSource = new HikariDataSource(config);
	}
	
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close() {
		dataSource.close();
	}
}
