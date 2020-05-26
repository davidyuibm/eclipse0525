package testgit;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class Test03
{
    public static void main(java.lang.String[] args) 
    throws Exception
    {
    	 DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());

    //	Connection c = DriverManager.getConnection("jdbc:db2:ctciha9x.rchland.ibm.com","davidyu","taiwan12");
    	Connection c = DriverManager.getConnection("jdbc:as400://ctciha9x.rchland.ibm.com", "davidyu", "taiwan12");  
    	// Get the database meta data from the connection.
    	DatabaseMetaData dbMeta = c.getMetaData();
    	 
    	// Get a list of tables matching this criteria.           
    	String catalog = "iasp02";
    	String schema = "testlib";
    	String table  = "testable"; // % indicates search pattern
    	String types[] = {"TABLE", "VIEW", "SYSTEM TABLE"};
    	ResultSet rs = dbMeta.getTables(catalog, schema, table, types);
    	 
    	// ... iterate through the ResultSet to get the values.
    	 
    	// Close the connection.
    	c.close();
    }
}
