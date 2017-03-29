package Presentation;

/**
 * Created by Sergiu Coca on 3/29/2017.
 */
import Business.Account;
import Business.Client;
import DataAccess.AccountDAO;
import DataAccess.ClientDAO;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static Presentation.View.scrollPane;

public class RegularUser {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    ClientDAO clientDAO=new ClientDAO();
    AccountDAO accountDAO=new AccountDAO();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegularUser window = new RegularUser();
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

    public RegularUser() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(UIManager.getFont("Label.font"));
        lblName.setBounds(10, 47, 46, 14);
        panel.add(lblName);

        JLabel lblPnc = new JLabel("PNC");
        lblPnc.setFont(UIManager.getFont("Label.font"));
        lblPnc.setBounds(10, 78, 46, 14);
        panel.add(lblPnc);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setFont(UIManager.getFont("Label.font"));
        lblAddress.setBounds(10, 109, 59, 14);
        panel.add(lblAddress);

        textField = new JTextField();
        textField.setFont(UIManager.getFont("TextField.font"));
        textField.setBounds(66, 44, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(UIManager.getFont("TextField.font"));
        textField_1.setBounds(66, 75, 86, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(UIManager.getFont("TextField.font"));
        textField_2.setBounds(66, 106, 86, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JButton btnAddClient = new JButton("Add");
        btnAddClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client=new Client(textField.getText(),Long.parseLong(textField_1.getText()),textField_2.getText());
                clientDAO.create(client);
            }
        });
        btnAddClient.setFont(UIManager.getFont("Button.font"));
        btnAddClient.setBounds(63, 151, 89, 23);
        panel.add(btnAddClient);

        JButton btnEditClient = new JButton("Edit ");
        btnEditClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Client client=new Client(textField.getText(),Long.parseLong(textField_1.getText()),textField_2.getText());
                clientDAO.update(Integer.parseInt(textField_6.getText()),client);
            }
        });
        btnEditClient.setFont(UIManager.getFont("Button.font"));
        btnEditClient.setBounds(63, 185, 89, 23);
        panel.add(btnEditClient);


        JButton btnViewClient = new JButton("View ");
        btnViewClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View view=new View();
                view.getFrame().setVisible(true);
                frame.setVisible(false);

            }
        });
        btnViewClient.setFont(UIManager.getFont("Button.font"));
        btnViewClient.setBounds(63, 219, 89, 23);
        panel.add(btnViewClient);

        JLabel lblType = new JLabel("Type");
        lblType.setFont(UIManager.getFont("Label.font"));
        lblType.setBounds(223, 47, 59, 14);
        panel.add(lblType);

        JLabel lblAmount = new JLabel("Amount");
        lblAmount.setFont(UIManager.getFont("Label.font"));
        lblAmount.setBounds(223, 78, 59, 14);
        panel.add(lblAmount);

        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(UIManager.getFont("Label.font"));
        lblDate.setBounds(223, 109, 46, 14);
        panel.add(lblDate);

        textField_3 = new JTextField();
        textField_3.setFont(UIManager.getFont("TextField.font"));
        textField_3.setBounds(290, 44, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setFont(UIManager.getFont("TextField.font"));
        textField_4.setBounds(290, 75, 86, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setFont(UIManager.getFont("TextField.font"));
        textField_5.setBounds(290, 106, 86, 20);
        panel.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblClientsOpperation = new JLabel("Clients opperations");
        lblClientsOpperation.setFont(UIManager.getFont("Label.font"));
        lblClientsOpperation.setBounds(40, 11, 112, 14);
        panel.add(lblClientsOpperation);

        JLabel lblAccountOperation = new JLabel("Account operations");
        lblAccountOperation.setFont(UIManager.getFont("Label.font"));
        lblAccountOperation.setBounds(279, 11, 112, 14);
        panel.add(lblAccountOperation);

        JLabel lblregularUser = new JLabel("~Regular user~");
        lblregularUser.setFont(UIManager.getFont("Label.font"));
        lblregularUser.setBounds(302, 236, 107, 14);
        panel.add(lblregularUser);

        JButton btnNewButton = new JButton("Logout");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login=new Login();
                    login.getFrame().setVisible(true);
                    frame.setVisible(false);
            }
        });
        btnNewButton.setFont(UIManager.getFont("Button.font"));
        btnNewButton.setBounds(203, 232, 89, 23);
        panel.add(btnNewButton);

        JLabel lblId = new JLabel("Id");
        lblId.setFont(UIManager.getFont("Label.font"));
        lblId.setBounds(10, 140, 46, 14);
        panel.add(lblId);

        textField_6 = new JTextField();
        textField_6.setFont(UIManager.getFont("TextField.font"));
        textField_6.setBounds(66, 137, 86, 20);
        panel.add(textField_6);
        textField_6.setColumns(10);

        JButton btnAddAccount = new JButton("Add ");
        btnAddAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Account account=new Account(textField_3.getText(),Integer.parseInt(textField_4.getText()),textField_5.getText(),Integer.parseInt(textField_6.getText()));
                accountDAO.create(account);
            }
        });
        btnAddAccount.setFont(UIManager.getFont("Button.font"));
        btnAddAccount.setBounds(236, 151, 89, 23);
        panel.add(btnAddAccount);

        JButton btnDeleteAccount = new JButton("Delete ");
        btnDeleteAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                accountDAO.delete(Integer.parseInt(textField_6.getText()));
            }
        });
        btnDeleteAccount.setFont(UIManager.getFont("Button.font"));
        btnDeleteAccount.setBounds(236, 185, 89, 23);
        panel.add(btnDeleteAccount);

        JButton btnEditAccount = new JButton("Edit");
        btnEditAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Account account=new Account(textField_3.getText(),Integer.parseInt(textField_4.getText()),textField_5.getText(),Integer.parseInt(textField_6.getText()));
                accountDAO.update(Integer.parseInt(textField_6.getText()),account);
            }
        });
        btnEditAccount.setFont(UIManager.getFont("Button.font"));
        btnEditAccount.setBounds(335, 185, 89, 23);
        panel.add(btnEditAccount);

        JButton btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View view=new View();
                view.getFrame().setVisible(true);
                frame.setVisible(false);
            }
        });
        btnView.setFont(UIManager.getFont("Button.font"));
        btnView.setBounds(335, 151, 89, 23);
        panel.add(btnView);
    }
}
