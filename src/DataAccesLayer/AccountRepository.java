package DataAccesLayer;

import Domain.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountRepository {
    private SqlConnection connection = null;

    public AccountRepository(SqlConnection sqlConnection) {
        this.connection = sqlConnection;
    }
        public ArrayList<Account> getAccounts(){
            ResultSet set = connection.executeSql("SELECT * FROM Account");

            ArrayList<Account> accounts = new ArrayList<>();
            try {
                while (set.next()) {
                    accounts.add(new Account(
                            set.getString("Naam"),
                            set.getString("Straat"),
                            set.getString("Postcode"),
                            set.getString("Huisnummer"),
                            set.getString("Plaats")));
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            return accounts;
        }
    }

