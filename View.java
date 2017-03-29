package Presentation;

/**
 * Created by Sergiu Coca on 3/29/2017.
 */
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Business.Account;
import Business.Client;
import DataAccess.AccountDAO;
import DataAccess.ClientDAO;


import java.awt.BorderLayout;

public class View {

    static JTable table;
    static JTable table1;
    static JTable table2;
    static JScrollPane scrollPane = new JScrollPane();
    private JFrame frame;
    private ClientDAO clientDAO=new ClientDAO();
    private AccountDAO accountDAO=new AccountDAO();


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View window = new View();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public View() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        scrollPane.setBounds(10, 11, 295, 151);
        panel.add(scrollPane);

        ArrayList<Client> list=clientDAO.listClients();
        ArrayList<Account> list1=accountDAO.listAccounts();

        String[] column={"ID","Nume","PNC","Address"};
        Object[][] date=new Object[clientDAO.listClients().size()][4];
        int i=0;
        Iterator<Client> it=clientDAO.listClients().iterator();
        while(it.hasNext())
        {
            Client c = it.next();
            date[i][0] = c.getId();
            date[i][1] = c.getName();
            date[i][2] = c.getPNC();
            date[i][3] = c.getAddress();
            i++;
        }

        table = new JTable(date,column);
        scrollPane.setViewportView(table);

        String[] column1={"ID","ClientId","Type","Amount","Data"};
        Object[][] date1=new Object[list1.size()][5];
        int j=0;
        Iterator<Account> it1=list1.iterator();
        while(it1.hasNext())
        {
            Account a = it1.next();
            date[j][0] = a.getID();
            date[j][1] = a.getClientFK();
            date[j][2] = a.getType();
            date[j][3] = a.getDate();
            j++;
        }
        table1 = new JTable(date1,column1);
    }

}
