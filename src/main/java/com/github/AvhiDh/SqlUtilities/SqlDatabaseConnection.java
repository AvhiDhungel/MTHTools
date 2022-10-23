package com.github.AvhiDh.SqlUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDatabaseConnection {

    private String url, db, user, password;
    private Connection conn;

    public SqlDatabaseConnection(String url, String db, String user, String password) {
        this.url = url;
        this.db  = db;
        this.user = user;
        this.password = password;

        try {conn = DriverManager.getConnection(getConnectionString(), user, password);}
        catch (SQLException e) {e.printStackTrace();}
    }

    public SqlDataReader execute(SqlQueryBuilder query) {
        return execute(query.toString());
    }
    public SqlDataReader execute(String query) {
        try {
            renew();
            Statement s = conn.createStatement();
            return new SqlDataReader(s.executeQuery(query));
        }
        catch(SQLException e){
            e.printStackTrace();
            return new SqlDataReader();
        }
    }

    public void executeNonQuery(SqlQueryBuilder query) {
        executeNonQuery(query.toString());
    }
    public void executeNonQuery(String query) {
        try {
            renew();
            Statement s = conn.createStatement();
            s.executeUpdate(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (!conn.isClosed()){conn.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renew() { renew(false); }
    public void renew(Boolean force) {
        try {
            if (force || !isValid()) {
                if (!conn.isClosed()){conn.close();}
                conn = DriverManager.getConnection(getConnectionString(),user,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        try {
            return conn.isValid(0);
        } catch (SQLException e) {
          e.printStackTrace();
          return false;
        }
    }

    public boolean isClosed() {
        try {
            return conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getConnectionString() {
        return String.format("jdbc:mysql://%s/%s", url, db);
    }


}