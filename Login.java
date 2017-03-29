package Presentation;

/**
 * Created by Sergiu Coca on 3/29/2017.
 */
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

public class Login {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
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

    public Login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(UIManager.getFont("Label.font"));
        lblUsername.setBounds(110, 45, 73, 14);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(UIManager.getFont("Label.font"));
        lblPassword.setBounds(110, 84, 73, 14);
        panel.add(lblPassword);

        textField = new JTextField();
        textField.setFont(UIManager.getFont("TextField.font"));
        textField.setBounds(193, 42, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setFont(UIManager.getFont("TextField.font"));
        textField_1.setBounds(193, 81, 86, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                EmployeeDAO e=new EmployeeDAO();
                Administrator a=new Administrator();
                RegularUser ru=new RegularUser();
                if(e.login(textField.getText(),textField_1.getText())=="Admin") {
                    a.getFrame().setVisible(true);
                    frame.setVisible(false);
                }
                    else{
                    ru.getFrame().setVisible(true);
                    frame.setVisible(false);
                }

            }
        });
        btnLogin.setFont(UIManager.getFont("Button.font"));
        btnLogin.setBounds(158, 147, 89, 23);
        panel.add(btnLogin);
    }
}
