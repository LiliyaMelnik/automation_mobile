package db.config;

import db.config.impl.BaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

public class Config {

    private Config() {
    }
    private static final BaseConfig config = create(BaseConfig.class, getProperties());
    private static final String DB_URL = config.urlDB();
    private static final String DB_USER = System.getProperty("usernameDB");
    private static final String DB_PASSWORD = System.getProperty("passwordDB");
    private static Statement statement = null;
    private static Connection connection = null;

    public static Statement getStatement() {
        if (statement == null) {
            try {
                statement = getConnection().createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return statement;
        }
        return statement;
    }

    private static Connection getConnection() {
        if (connection == null) {
            System.out.println("Try to connection to PostgreSQL");

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL driver is not found");
                throw new RuntimeException(e);
            }

            System.out.println("PostgreSQL driver successfully connected");

            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                System.out.println("Connection failed");
                throw new RuntimeException(e);
            }

            return connection;
        }
        return connection;
    }
}
