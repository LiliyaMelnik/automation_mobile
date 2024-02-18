package db.service;

import db.crud.Crud;
import lombok.SneakyThrows;

import static java.lang.String.format;

public class UserTable extends Crud {

    public void insertAlice() {
        insert("INSERT INTO USERS (name, age) VALUES ('Alice', 20)");
    }

    public void updateAlice() {
        update("UPDATE USERS SET age=22 WHERE name='Alice'");
    }

    public void deleteAlice() {
        delete("DELETE FROM USERS WHERE name='Alice'");
    }

    @SneakyThrows
    public void selectAllUsers() {
        var rs = select("SELECT * FROM USERS");

        while (rs.next()) {
            String name = rs.getString("name");
            Integer age = rs.getInt("age");

            System.out.println(format("User - {username: %s, age: %d}", name, age));
        }
    }
}
