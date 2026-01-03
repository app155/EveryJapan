package com.dbcp;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPUtil {
	private static final BasicDataSource ds = new BasicDataSource();
    
    static {
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3307/globalin_db");
        ds.setUsername("user");
        ds.setPassword("1234");
        ds.setMaxTotal(20);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
