package DataAccess;
import Business.Account;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 3/28/2017.
 */
public class AccountDAO {

   private PreparedStatement stmt=null;

    public String create(Account account) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="INSERT INTO Accounts(idAccount,ClientFK,Type,Amount,Date) VALUES(?,?,?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, account.getID());
            stmt.setInt(2, account.getClientFK());
            stmt.setString(3, account.getType());
            stmt.setInt(4, account.getAmount());
            stmt.setString(5, account.getDate());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            if (sqlException.getMessage().contains("foreign key"))
                return "The owner of the account should already exist as a client";
            else return sqlException.getMessage();
        }
        return "Inserted successfully";

    }

    public String update(int oldID, Account account) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="UPDATE Accounts SET idAccount=?, ClientFK=?, Type=?, Amount=?, Date=? WHERE idAccount=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, account.getID());
            stmt.setInt(2, account.getClientFK());
            stmt.setString(3, account.getType());
            stmt.setLong(4, account.getAmount());
            stmt.setString(5, account.getDate());
            stmt.setInt(6, oldID);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Inserted successfully";
    }

    public String delete(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="DELETE FROM Accounts WHERE idAccount=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return "Deleted successfully";
    }

    public ArrayList<Account> listAccounts() {
        Connection connection = DatabaseConnection.getConnection();
        try {
            ArrayList<Account> list=new ArrayList<Account>();
            String query="SELECT * FROM Accounts";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            while (result.next()) {
                Account account = new Account(result.getInt("idAccount"), result.getInt("ClientFK"), result.getString("Type"), result.getInt("Amount"), result.getString("Date"));
                list.add(account);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public Account viewAccount(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM Accounts WHERE idAccount=?";
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            Account account = null;
            while (result.next()) {
                account = new Account(result.getInt("idAccount"), result.getInt("ClientFK"), result.getString("Type"), result.getInt("Amount"), result.getString("Date"));
            }
            return account;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}