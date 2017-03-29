package Business;

/**
 * Created by Sergiu Coca on 3/27/2017.
 */
public class Client {
    private int id;
    private String name;
    private long PNC;
    private String address;

    public Client(int id, String name, long PNC, String address) {
        this.id = id;
        this.name = name;
        this.PNC = PNC;
        this.address = address;
    }

    public Client(String name, long PNC, String address){
        this.name = name;
        this.PNC = PNC;
        this.address = address;
    }

    public static boolean validate(long PNC)
    {
        if(PNC>=1000000000000L && PNC<=9999999999999L) return true;
        else return false;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPNC() {
        return PNC;
    }

    public void setPNC(int PNC) {
        this.PNC = PNC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
