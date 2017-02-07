package db;

import java.util.Map;
import java.util.Objects;

/**
 * Created by ahmad on 2/7/17.
 */
public class DBManager {
    SqlDB db;
    public DBManager(SqlDB db) {
        this.db = db;
    }

    public void newUser(User user) {
        db.beginTransaction();
        db.insert("CreditCard", mapFor(user.getCreditCard()));
        db.insert("User", mapFor(user));
        db.endTransaction();
    }

    Map<String, Object> mapFor(User user) {
        return null;
    }

    Map<String, Object> mapFor(CreditCard creditCard) {
        return null;
    }
}
