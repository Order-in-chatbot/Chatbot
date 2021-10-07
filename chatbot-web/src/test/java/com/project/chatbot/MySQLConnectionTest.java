package com.project.chatbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import org.junit.Test;

public class MySQLConnectionTest {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://127.0.0.1:3306/fallinorder?useSSL=false";
    static final String USERNAME = "root";
    static final String PASSWORD = "onlyroot";
    
    @Test
    public void getMySQLConnectionTest() {
        
        Connection conn = null;
        Statement stmt = null;
        
        try {
            
            logger.info("==================== MySQL Connection START ====================");
            
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
 
            String sql = "SELECT * from store_list";
 
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                
                int storeno = rs.getInt("storeno");
                String storename = rs.getString("storename");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
 
                logger.info("storeno : " + storeno + ", ");
                logger.info("storename : " + storename + ", ");
                logger.info("phone : " + phone+",");
                logger.info("address : " + address);
                
            }
 
            rs.close();
            stmt.close();
            conn.close();
 
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        
        logger.info("==================== MySQL Connection END ====================");
    }
}