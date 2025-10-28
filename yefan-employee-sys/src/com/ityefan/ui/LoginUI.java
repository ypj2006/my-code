package com.ityefan.ui;

import com.ityefan.bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField loginNameField;        // 用户名输入框
    private JPasswordField passwordField;     // 密码输入框
    private JButton loginButton;              // 登录按钮（新增成员变量）
    private JButton registerButton;           // 注册按钮（新增成员变量）
    private static ArrayList<User> allUsers = new ArrayList<>();

    public LoginUI() {
        initializeUI();
        initializeUsers();
    }

    // 初始化三个示例用户
    private void initializeUsers() {
        allUsers.add(new User("管理员", "123456", "admin"));
        allUsers.add(new User("张三", "123", "zhangsan"));
        allUsers.add(new User("李四", "456", "lisi"));
    }

    private void initializeUI() {
        // 设置窗口基本属性
        setTitle("叶凡人事管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 300);
        setLocationRelativeTo(null); // 居中显示

        // 设置整体布局
        setLayout(new BorderLayout());

        // 定义统一的蓝色
        Color primaryColor = new Color(70, 130, 180);

        // 创建顶部标题面板
        JPanel topPanel = new JPanel();
        topPanel.setBackground(primaryColor);
        JLabel titleLabel = new JLabel("欢迎登录");
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // 创建中间表单面板
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 用户名
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(userLabel, gbc);

        loginNameField = new JTextField(15);
        loginNameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(loginNameField, gbc);

        // 密码
        JLabel passLabel = new JLabel("密码:");
        passLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passLabel, gbc);

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(passwordField, gbc);

        add(formPanel, BorderLayout.CENTER);

        // 创建底部按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // 登录按钮 - 去掉 JButton 类型声明
        loginButton = new JButton("登录");
        loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(100, 35));
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(true);
        loginButton.setContentAreaFilled(true);
        loginButton.addActionListener(this);

        // 注册按钮 - 去掉 JButton 类型声明
        registerButton = new JButton("注册");
        registerButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        registerButton.setBackground(primaryColor);
        registerButton.setForeground(Color.WHITE);
        registerButton.setPreferredSize(new Dimension(100, 35));
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(true);
        registerButton.setContentAreaFilled(true);
        registerButton.addActionListener(this);

        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login();
        }
        // 如果以后要用注册按钮：else if (e.getSource() == registerButton) { ... }
    }

    private void login() {
        String loginName = loginNameField.getText();
        String password = new String(passwordField.getPassword());
        User user = findUserIndex(loginName);
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "密码错误！");
                return;
            }
            System.out.println("登录成功！");
            new EmployeeManagerUI();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "登录失败！");
        }
    }

    private User findUserIndex(String loginName) {
        for (int i = 0; i < LoginUI.allUsers.size(); i++) {
            User user = LoginUI.allUsers.get(i);
            if (user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
