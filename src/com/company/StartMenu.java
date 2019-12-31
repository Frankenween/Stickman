package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartMenu extends JFrame {
    private int Width = 500, Height = 500;
    ButtonClickListener clickListener;


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    public StartMenu(String title) {
        super(title);
        setSize(Width, Height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        clickListener = new ButtonClickListener();

        addButtons();
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (btn.getName().equals("Exit")) {
                exitButtonClicked();
            } else if (btn.getName().equals("Create New Model")) { // Create New System
                CNMButtonClicked();
            } else if (btn.getName().equals("Log In or Register")) {
                logInButtonClicked();
            } else if (btn.getName().equals("Register")) {

            }
        }

        private void logInButtonClicked() {
            LogInForm logInForm = new LogInForm("Log In or Register", StartMenu.this);
        }

        private void exitButtonClicked() {
            dispose();
        }

        private void CNMButtonClicked() {

        }
    }

    private void addButtons() {
        addExitButton();
        addEditButton();
        addLogInButton();
    }

    private void addExitButton() {
        JButton btnExit = new JButton();
        btnExit.setText("Close");
        btnExit.setName("Exit");
        btnExit.setVisible(true);
        btnExit.setBounds(50, 150, 100, 50);
        btnExit.addActionListener(clickListener);
        getContentPane().add(btnExit);
    }

    private void addEditButton() {
        JButton btnEdit = new JButton();
        btnEdit.setText("Create New Model");
        btnEdit.setName("Create New Model");
        btnEdit.setVisible(true);
        btnEdit.setBounds(50, 20, 100, 50);
        btnEdit.addActionListener(clickListener);
        getContentPane().add(btnEdit);
    }

    private void addLogInButton() {
        JButton btnLogIn = new JButton();
        btnLogIn.setText("Sign in");
        btnLogIn.setName("Log In or Register");
        btnLogIn.setVisible(true);
        btnLogIn.setBounds(50, 85, 100, 50);
        btnLogIn.addActionListener(clickListener);
        getContentPane().add(btnLogIn);
    }
}
