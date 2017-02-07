package db;

/**
 * Created by ahmad on 2/7/17.
 */
public class User {
    String name;
    String email;
    String password;
    CreditCard creditCard;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
