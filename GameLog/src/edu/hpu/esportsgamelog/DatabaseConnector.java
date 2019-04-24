package edu.hpu.esportsgamelog;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/****************************************************\
 *												    *	
 *  @author Joecelyn Saloma, Cherlyn Kay Alejandro  *
 * 											 	    *
\****************************************************/
public class DatabaseConnector 
{
	private final String hostName = "hpuesports.database.windows.net";
    private final String port = "1433";
    private final String dbName = "eSportsDB";
    private final String user = "jsaloma";
    private final String password = "Password1!";
    private final String encrypt = "true";
    private final String trustServerCertificate = "false";
    private final String hostNameInCertificate = "*.database.windows.net";
    private final String loginTimeout = "30";
    private final String url = String.format("jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s;encrypt=%s;trustServerCertificate=%s;hostNameInCertificate=%s;loginTimeout=%s;",
        hostName, port, dbName, user, password, encrypt, trustServerCertificate, hostNameInCertificate, loginTimeout);
    private transient Connection conn = null;
    private String schema = null;
    private volatile transient boolean error = false;
	
    //Default Constructor
    public DatabaseConnector() 
    {
		connect();
        if (conn == null) 
        {
        	System.err.println("Attempting to reconnect...");
        	System.out.println((connect()) ? "Connected" : "Cannot connect to database...");
        } 
        else System.out.println("Successfully Connected...Continuing Application");
    }
    
    private boolean connect() 
    {
		try {
			conn = DriverManager.getConnection(url);
			schema = conn.getSchema();
			System.out.println("Successful connection - Schema: " + schema);
		}catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("Failed to connect...");
			conn = null;
		}
        
		return (conn == null) ? false : true;
    }
    
    public boolean reconnect() 
    {
    	//statement = create new one; << for globalize
    	boolean rc_con = false;
    	
    	//If no con, discon then recon, both true, then success, else something failed
    	rc_con = (conn == null) ? connect() : disconnect() && connect();
		
    	return rc_con;
    } 
    
    public boolean disconnect() 
    {
        //stmt = null; << for globalize
    	boolean ds_con = false;
		
    	try {
			conn.close();
			conn = null;
			ds_con = true;
		} catch (SQLException sqle) {
			System.err.println("Disconnected...");
			ds_con = false;
		}
		
    	return ds_con;
    }
    
    public boolean connected() 
    {
    	return !(conn == null);
	}
	
	private String process_String(String args) 
	{
		String proc = args;
		//Check for single, change to double
		proc = proc.replaceAll("'", "''");
		return proc;
	}
    
    //SQL Query method for SQL testing
    public ResultSet query(String query) 
    {
        //Finish this, figure out other ones...
        ResultSet result = null;
        
        try {
        	//Globalize that v
            Statement stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			//stmt.close();
			//stmt = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.err.println("SQL statement failed");
        }
        
        return result;
    }
 }