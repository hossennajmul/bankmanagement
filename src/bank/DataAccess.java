package bank;

import java.sql.*;
public class DataAccess {
    private Connection conn;
    private Statement stm;

    private String connStr = "jdbc:oracle:thin:@localhost:1521:XE";
    private String dbusername = "voot";
    private String dbpassword = "tiger";

    public DataAccess()
    {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.conn = DriverManager.getConnection(connStr, dbusername, dbpassword);
            this.stm = this.conn.createStatement();
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public ResultSet getResultSet(String sql)
    {
        try{
            return this.stm.executeQuery(sql);
        } catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean executeSQL(String sql)
    {
        try{
            return this.stm.execute(sql);
        } catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    protected void finalize()
    {
        try{
            this.stm.close();
            this.conn.close();
        } catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}

