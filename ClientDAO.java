package DataAccess;

import Business.Account;
import Business.Client;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 3/28/2017.
 */
public class ClientDAO {
    private PreparedStatement stmt=null;

    public String create(Client client) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="INSERT INTO Clients(idClient,Name,PNC,Address) VALUES(?,?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getName());
            stmt.setLong(3, client.getPNC());
            stmt.setString(4, client.getAddress());
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

    public String update(int oldID, Client client) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="UPDATE Clients SET idClient=?, Name=?, PNC=?, Address=? WHERE idClient=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, client.getId());
            stmt.setString(2, client.getName());
            stmt.setLong(3, client.getPNC());
            stmt.setString(4, client.getAddress());
            stmt.setInt(5, oldID);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Update successfully";
    }

    public String delete(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="DELETE FROM Clients WHERE idClient=?";
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

    public ArrayList<Client> listClients() {
        Connection connection = DatabaseConnection.getConnection();
        try {
            ArrayList<Client> list=new ArrayList<Client>();
            String query="SELECT * FROM Clients";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            while (result.next()) {
                Client client = new Client(result.getInt("idClient"), result.getString("Name"), result.getLong("PNC"), result.getString("Address"));
                list.add(client);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public Client viewAccount(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM Clients WHERE idClients=?";
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            Client client = null;
            while (result.next()) {
                client = new Client(result.getInt("idClient"), result.getString("Name"), result.getLong("PNC"), result.getString("Address"));
            }
            return client;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}
