package Business;

/**
 * Created by Sergiu Coca on 3/27/2017.
 */
public class Account {
    private int ID;
    private int clientFK;
    private String type;
    private int amount;
    private String date;

    public Account(int ID, int clientFK, String type, int amount, String date) {
        this.ID = ID;
        this.clientFK = clientFK;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Account(String type, int amount, String date, int clientFK){
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.clientFK = clientFK;
    }

    public boolean accountValidation(int amount){
            if(amount<0) return false;
            return true;
        }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClientFK() {
        return clientFK;
    }

    public void setClientFK(int clientFK) {
        this.clientFK = clientFK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
