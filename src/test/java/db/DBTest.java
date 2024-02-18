package db;

import db.service.UserTable;
import org.testng.annotations.Test;

public class DBTest {

    private final UserTable userTable = new UserTable();

    @Test
    void shouldBeAddedAndDeleteAlice() {
        userTable.insertAlice();
        userTable.updateAlice();
        userTable.deleteAlice();
        userTable.selectAllUsers();
    }

}
