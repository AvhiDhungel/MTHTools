package com.github.AvhiDh.SqlUtilities;

import com.github.AvhiDh.Utilities.Guid;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SqlDataReader {

    private ResultSet rs;

    public SqlDataReader(){};
    public SqlDataReader(ResultSet rs) {
        this.rs = rs;
    }

    public boolean read() {
        try {
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getString(String column) {
        try {
            return rs.getString(column);
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public Guid getGuid(String column) {
        try {
            return new Guid(rs.getString(column));
        } catch (Exception e) {
            e.printStackTrace();
            return Guid.empty();
        }
    }

    public boolean getBoolean(String column) {
        try {
            return rs.getBoolean(column);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer getInteger(String column) {
        try {
            return rs.getInt(column);
        } catch (SQLException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }

    public Double getDouble(String column) {
        try {
            return rs.getDouble(column);
        } catch (SQLException e) {
            e.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    public Date getDate(String column) {
        try {
            return new Date(rs.getTimestamp(column).getTime());
        } catch (SQLException e) {
            e.printStackTrace();
            return new Date(Integer.MIN_VALUE);
        }
    }

    public Object get(String column) {
        try {
            return rs.getObject(column);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
