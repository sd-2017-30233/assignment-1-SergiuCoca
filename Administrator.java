package Presentation;

/**
 * Created by Sergiu Coca on 3/29/2017.
 */
import Business.Client;
import Business.Employee;
import DataAccess.EmployeeDAO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrator {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    EmployeeDAO employeeDAO=new EmployeeDAO();



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Administrator window = new Administrator();
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

    public Administrator() {
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
        lblName.setBounds(28, 44, 69, 14);
        panel.add(lblName);

        JLabel lblUsename = new JLabel("Usename");
        lblUsename.setFont(UIManager.getFont("Label.font"));
        lblUsename.setBounds(28, 78, 81, 14);
        panel.add(lblUsename);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(UIManager.getFont("Label.font"));
        lblPassword.setBounds(28, 109, 69, 14);
        panel.add(lblPassword);

        JLabel lblAdmin = new JLabel("Admin");
        lblAdmin.setFont(UIManager.getFont("Label.font"));
        lblAdmin.setBounds(28, 140, 46, 14);
        panel.add(lblAdmin);

        textField = new JTextField();
        textField.setFont(UIManager.getFont("TextField.font"));
        textField.setBounds(107, 41, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(UIManager.getFont("TextField.font"));
        textField_1.setBounds(107, 75, 86, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setFont(UIManager.getFont("TextField.font"));
        textField_2.setBounds(107, 106, 86, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setFont(UIManager.getFont("TextField.font"));
        textField_3.setBounds(107, 137, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JLabel lbladministrator = new JLabel("~Administrator~");
        lbladministrator.setBounds(220, 236, 119, 14);
        panel.add(lbladministrator);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee employee=new Employee(textField.getText(),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_2.getText()));
                employeeDAO.create(employee);
            }
        });
        btnAdd.setFont(UIManager.getFont("Button.font"));
        btnAdd.setBounds(289, 40, 89, 23);
        panel.add(btnAdd);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeeDAO.delete(Integer.parseInt(textField_4.getText()));
            }
        });
        btnDelete.setFont(UIManager.getFont("Button.font"));
        btnDelete.setBounds(289, 74, 89, 23);
        panel.add(btnDelete);

        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee employee=new Employee(textField.getText(),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_2.getText()));
                employeeDAO.update(Integer.parseInt(textField_4.getText()),employee);
            }
        });
        btnEdit.setFont(UIManager.getFont("Button.font"));
        btnEdit.setBounds(289, 105, 89, 23);
        panel.add(btnEdit);

        JButton btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View view=new View();
                view.getFrame().setVisible(true);
                frame.setVisible(false);
            }
        });
        btnView.setFont(UIManager.getFont("Button.font"));
        btnView.setBounds(289, 136, 89, 23);
        panel.add(btnView);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login=new Login();
                login.getFrame().setVisible(true);
                frame.setVisible(false);
            }
        });
        btnLogout.setBounds(104, 232, 89, 23);
        panel.add(btnLogout);

        JLabel lblId = new JLabel("Id");
        lblId.setFont(UIManager.getFont("Label.font"));
        lblId.setBounds(28, 180, 46, 14);
        panel.add(lblId);

        textField_4 = new JTextField();
        textField_4.setFont(UIManager.getFont("TextField.font"));
        textField_4.setBounds(107, 177, 86, 20);
        panel.add(textField_4);
        textField_4.setColumns(10);
    }

}
