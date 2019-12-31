package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInForm extends JFrame {
    private int Width = 320, Height = 220, MAX_LOGIN_LENGTH = 10;
    private static final int LOG_IN = 0, REGISTER = 1;
    private FrameActionListener FListener;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    LogInForm(String title, JFrame parent) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setBounds(parent.getX() + 50, parent.getY() + 50, Width, Height);

        FListener = new FrameActionListener();

        addTextFields();
        addButtons();
    }

    Component getComponentByName(String name) {
        for (Component cnt : getContentPane().getComponents()) {
            if (cnt.getName().equals(name)) {
                return cnt;
            }
        }
        return null;
    }

    void addTextFields() {
        addLoginField();
        addPasswordField();
    }

    void addButtons() {
        addLogInButton();
        addRegisterButton();
    }

    void addLoginField() {
        JTextField loginField = new JTextField(MAX_LOGIN_LENGTH);
        loginField.setVisible(true);
        loginField.setName("Login Field");
        loginField.setBounds(20, 20, 100, 30);
        loginField.setBorder(new LineBorder(Color.red, 3, true));
        loginField.addActionListener(FListener);
        getContentPane().add(loginField);
    }

    void addPasswordField() {
        JTextField passwordField = new JPasswordField(MAX_LOGIN_LENGTH);
        passwordField.setVisible(true);
        passwordField.setName("Password Field");
        passwordField.setBounds(20, 70, 100, 30);
        passwordField.setBorder(new LineBorder(Color.green, 3, true));
        getContentPane().add(passwordField);
    }

    void addLogInButton() {
        JButton logInButton = new JButton();
        logInButton.setVisible(true);
        logInButton.setText("Log In");
        logInButton.setName("Log In");
        logInButton.setBounds(20, 120, 100, 30);
        logInButton.addActionListener(FListener);
        getContentPane().add(logInButton);
    }

    void addRegisterButton() {
        JButton logInButton = new JButton();
        logInButton.setVisible(true);
        logInButton.setText("Register");
        logInButton.setName("Register");
        logInButton.setBounds(150, 120, 100, 30);
        logInButton.addActionListener(FListener);
        getContentPane().add(logInButton);
    }

    private class FrameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Component obj = (Component) e.getSource();
            String name = obj.getName();
            if (name.equals("Login Field")) {
                loginFieldAction();
            } else if (name.equals("Log In")){
                submitAction(LOG_IN);
            } else if (name.equals("Register")) {
                submitAction(REGISTER);
            }
        }

        private void loginFieldAction() {
            JTextField pass_field = (JTextField) getComponentByName("Password Field");
            pass_field.requestFocus();
        }

        private void submitAction(int queryType) {
            JTextField login = (JTextField) getComponentByName("Login Field");
            JPasswordField password = (JPasswordField) getComponentByName("Password Field");
            if (login.getText().isEmpty() || password.getPassword().length == 0) {
                login.setText("");
                password.setText("");
                JOptionPane.showMessageDialog(LogInForm.this,
                        "Empty login or password field");
                return;
            }
            String got_token = submit(queryType);
            if (got_token.equals("Wrong Password")) {
                login.setText("");
                password.setText("");
                JOptionPane.showMessageDialog(LogInForm.this,
                        "Wrong login or password");
            } else if (got_token.equals("Error")) {
                login.setText("");
                password.setText("");
                JOptionPane.showMessageDialog(LogInForm.this,
                        "An error occurred");
            } else {
                Main.setToken(got_token);
                dispose();
            }
        }
    }

    String submit(int type) { // type = LOG_IN or REGISTER
        String t = "";

        return t;
    }
}
