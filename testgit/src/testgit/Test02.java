package testgit;

	import java.sql.*;

	public class Test02 {

	    public static int jdbcLevel;

	    // Note: Static block runs before main begins.
	    // Therefore, there is access to jdbcLevel in
	    // main.
	    {
	        try {
	            Class.forName("java.sql.Blob");

	            try {
	                Class.forName("java.sql.ParameterMetaData");
	                // Found a JDBC 3.0 interface.  Must support JDBC 3.0.
	                jdbcLevel = 3;
	            } catch (ClassNotFoundException ez) {
	                // Could not find the JDBC 3.0 ParameterMetaData class.  
	                // Must be running under a JVM with only JDBC 2.0 
	                // support.
	                jdbcLevel = 2;
	            }

	        } catch (ClassNotFoundException ex) {
	            // Could not find the JDBC 2.0 Blob class.  Must be 
	            // running under a JVM with only JDBC 1.0 support.
	            jdbcLevel = 1;
	        }
	    }

	    // Program entry point.
	    public static void main(java.lang.String[] args) 
	    {
	        Connection c = null;

	        try {
	            // Get the driver registered.
	            Class.forName("com.ibm.db2.jdbc.app.DB2Driver");

	            c = DriverManager.getConnection("jdbc:db2:ctciha9x.rchland.ibm.com");
	            DatabaseMetaData dmd = c.getMetaData();

	            if (jdbcLevel == 1) {
	                System.out.println("No support is provided for getUDTs.  Just return.");
	                System.exit(1);
	            }

	            ResultSet rs = dmd.getUDTs(null, "CUJOSQL", "SSN%", null);
	            while (rs.next()) {

	                // Fetch all the columns that have been available since the 
	                // JDBC 2.0 release.
	                System.out.println("TYPE_CAT is " + rs.getString("TYPE_CAT"));
	                System.out.println("TYPE_SCHEM is " + rs.getString("TYPE_SCHEM"));
	                System.out.println("TYPE_NAME is " + rs.getString("TYPE_NAME"));
	                System.out.println("CLASS_NAME is " + rs.getString("CLASS_NAME"));
	                System.out.println("DATA_TYPE is " + rs.getString("DATA_TYPE"));
	                System.out.println("REMARKS is " + rs.getString("REMARKS"));

	                // Fetch all the columns that were added in JDBC 3.0.
	                if (jdbcLevel > 2) {
	                    System.out.println("BASE_TYPE is " + rs.getString("BASE_TYPE"));
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            if (c != null) {
	                try {
	                    c.close();
	                } catch (SQLException e) {
	                    // Ignoring shutdown exception.
	                }
	            }
	        }
	    }
	}

