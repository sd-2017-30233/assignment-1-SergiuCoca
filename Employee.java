package Business;

/**
 * Created by Sergiu Coca on 3/27/2017.
 */
public class Employee {

    private int idEmployee;
    private String Name;
    private String Username;
    private String Password;
    private int Admin;

    public Employee(int idEmployee, String name, String username, String password, int admin) {
        this.idEmployee = idEmployee;
        this.Name = name;
        this.Username = username;
        this.Password = password;
        this.Admin = admin;
    }

    public Employee(String name, String username, String password, int admin){
        this.Name = name;
        this.Username = username;
        this.Password = password;
        this.Admin = admin;
    }

    public Employee(){

    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAdmin() {
        return Admin;
    }

    public void setAdmin(int admin) {
        Admin = admin;
    }
}
