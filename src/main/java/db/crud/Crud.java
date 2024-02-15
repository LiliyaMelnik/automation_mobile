package db.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import static db.config.Config.getStatement;

public class Crud {

    protected void insert(String sql) {
        operator(sql);
        System.out.println("Insert was successful");
    }

    protected void update(String sql) {
        operator(sql);
        System.out.println("Update was successful");
    }

    protected void delete(String sql) {
        operator(sql);
        System.out.println("Delete was successful");
    }

    protected ResultSet select(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void operator(String sql) {
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
