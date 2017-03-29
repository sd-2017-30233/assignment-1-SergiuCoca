package DataAccess;


import Business.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergiu Coca on 3/29/2017.
 */
public class EmployeeDAO {

    private PreparedStatement stmt=null;

    public String login(String user,String password){
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM  Employees e where e.username=? AND e.password=?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                if(result.getInt("Admin")==1)  return "Admin";
                else return "Regular";
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return "Nu-i bine ceva!";
    }

    public String create(Employee employee) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="INSERT INTO Employees(idEmployee,Name,Username,Password,Admin) VALUES(?,?,?,?,?)";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, employee.getIdEmployee());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getUsername());
            stmt.setString(4, employee.getPassword());
            stmt.setInt(5, employee.getAdmin());
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return "Inserted successfully";

    }

    public String update(int oldID, Employee employee) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="UPDATE Employees SET idEmployee=?, Name=?, Username=?, Password=?, Admin=? WHERE idEmployee=?";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, employee.getIdEmployee());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getUsername());
            stmt.setString(4, employee.getPassword());
            stmt.setInt(5, employee.getAdmin());
            stmt.setInt(6, oldID);
            stmt.executeUpdate();
            stmt.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return sqlException.getMessage();
        }
        return "Updated successfully";
    }

    public String delete(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query="DELETE FROM Employees WHERE idEmployee=?";
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

    public ArrayList<Employee> listEmployees() {
        Connection connection = DatabaseConnection.getConnection();
        try {
            ArrayList<Employee> list=new ArrayList<Employee>();
            String query="SELECT * FROM Employees";
            stmt = connection.prepareStatement(query);
            ResultSet result=stmt.executeQuery();
            Employee employee = null;
            while (result.next()) {
                employee = new Employee(result.getInt("idEmployee"), result.getString("Name"), result.getString("Username"), result.getString("Password"), result.getInt("Admin"));
                list.add(employee);
            }
            stmt.close();
            connection.close();
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

    public Employee viewAccount(int id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            String query = "SELECT * FROM Employees WHERE idEmployee=?";
            stmt = connection.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            Employee employee = null;
            while (result.next()) {
                employee = new Employee(result.getInt("idEmployee"), result.getString("Name"), result.getString("Username"), result.getString("Password"), result.getInt("Admin"));
            }
            return employee;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }

}
