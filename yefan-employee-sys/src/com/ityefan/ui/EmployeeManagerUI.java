package com.ityefan.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeManagerUI extends JFrame {
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Employee> employees;
    private int nextId = 1; // 自增ID
    private static final Random rand = new Random();

    // 员工类（包含所有字段）
    static class Employee {
        int id;
        String name;
        String gender;
        int age;
        String phone;
        String position;
        double salary;
        String hireDate; // 入职日期，格式如 "2023-05-20"
        String department;

        public Employee(int id, String name, String gender, int age, String phone,
                        String position, double salary, String hireDate, String department) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.phone = phone;
            this.position = position;
            this.salary = salary;
            this.hireDate = hireDate;
            this.department = department;
        }

        Object[] toRow() {
            return new Object[]{id, name, gender, age, phone, position, salary, hireDate, department};
        }
    }

    public EmployeeManagerUI() {
        initializeData();
        initializeUI();
    }

    private void initializeData() {
        employees = new ArrayList<>();
    }

    private void initializeUI() {
        setTitle("员工信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600); // 宽度增加以适应更多列
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new BorderLayout());

        // ========== 第一行：搜索框 + 搜索按钮 + 添加按钮 ==========
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

        searchField = new JTextField(20);
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchField.setToolTipText("输入姓名/部门/职位等关键词搜索");

        JButton searchButton = new JButton("搜索");
        searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchButton.addActionListener(e -> performSearch());

        JButton addButton = new JButton("添加");
        addButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        addButton.addActionListener(e -> showAddDialog());

        topPanel.add(new JLabel("搜索:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);
        add(topPanel, BorderLayout.NORTH);

        // ========== 中间：表格 ==========
        String[] columns = {"ID", "姓名", "性别", "年龄", "电话", "职位", "薪资", "入职日期", "部门"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 调整列宽（可选）
        table.getColumnModel().getColumn(0).setMaxWidth(50); // ID 列窄一点
        table.getColumnModel().getColumn(2).setMaxWidth(50); // 性别列窄一点
        table.getColumnModel().getColumn(3).setMaxWidth(50); // 年龄列窄一点

        refreshTable(); // 填充数据

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // ========== 右键菜单 ==========
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("修改");
        JMenuItem deleteItem = new JMenuItem("删除");

        editItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int modelIndex = table.convertRowIndexToModel(selectedRow);
                Employee emp = employees.get(modelIndex);
                showEditDialog(emp, modelIndex);
            }
        });

        deleteItem.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int modelIndex = table.convertRowIndexToModel(selectedRow);
                int result = JOptionPane.showConfirmDialog(
                        this,
                        "确定要删除员工 " + employees.get(modelIndex).name + " 吗？",
                        "确认删除",
                        JOptionPane.YES_NO_OPTION
                );
                if (result == JOptionPane.YES_OPTION) {
                    employees.remove(modelIndex);
                    refreshTable();
                }
            }
        });

        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        // 绑定右键事件
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row != -1) table.setRowSelectionInterval(row, row);
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row != -1) table.setRowSelectionInterval(row, row);
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        this.setVisible(true);
        // 回车搜索
        searchField.addActionListener(e -> performSearch());
    }

    private void performSearch() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            refreshTable();
            return;
        }

        List<Employee> filtered = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.name.contains(keyword) || emp.department.contains(keyword) ||
                    emp.position.contains(keyword) || emp.phone.contains(keyword) ||
                    emp.gender.equals(keyword) || String.valueOf(emp.age).contains(keyword)) {
                filtered.add(emp);
            }
        }
        displayEmployees(filtered);
    }

    private void refreshTable() {
        displayEmployees(employees);
    }

    private void displayEmployees(List<Employee> list) {
        tableModel.setRowCount(0);
        for (Employee emp : list) {
            tableModel.addRow(emp.toRow());
        }
    }

    // 显示添加对话框
    private void showAddDialog() {
        JDialog dialog = new JDialog(this, "添加员工", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nameField = new JTextField(15);
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"男", "女"});
        JTextField ageField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JTextField posField = new JTextField(15);
        JTextField salaryField = new JTextField(15);
        JTextField dateField = new JTextField(15); // 格式：yyyy-MM-dd
        JTextField deptField = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 0; dialog.add(new JLabel("姓名:"), gbc);
        gbc.gridx = 1; dialog.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; dialog.add(new JLabel("性别:"), gbc);
        gbc.gridx = 1; dialog.add(genderBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2; dialog.add(new JLabel("年龄:"), gbc);
        gbc.gridx = 1; dialog.add(ageField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; dialog.add(new JLabel("电话:"), gbc);
        gbc.gridx = 1; dialog.add(phoneField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; dialog.add(new JLabel("职位:"), gbc);
        gbc.gridx = 1; dialog.add(posField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; dialog.add(new JLabel("薪资:"), gbc);
        gbc.gridx = 1; dialog.add(salaryField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; dialog.add(new JLabel("入职日期:"), gbc);
        gbc.gridx = 1; dialog.add(dateField, gbc);
        dateField.setToolTipText("格式：yyyy-MM-dd");

        gbc.gridx = 0; gbc.gridy = 7; dialog.add(new JLabel("部门:"), gbc);
        gbc.gridx = 1; dialog.add(deptField, gbc);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("确定");
        JButton cancelButton = new JButton("取消");

        okButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String gender = (String) genderBox.getSelectedItem();
                int age = Integer.parseInt(ageField.getText().trim());
                String phone = phoneField.getText().trim();
                String pos = posField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());
                String hireDate = dateField.getText().trim();
                String dept = deptField.getText().trim();

                if (name.isEmpty() || phone.isEmpty() || pos.isEmpty() || dept.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "请填写必填字段！", "输入错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 简单验证日期格式
                if (!hireDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(dialog, "入职日期格式应为 yyyy-MM-dd", "格式错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                employees.add(new Employee(nextId++, name, gender, age, phone, pos, salary, hireDate, dept));
                refreshTable();
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "年龄或薪资格式不正确！", "输入错误", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        dialog.add(buttonPanel, gbc);

        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    // 显示修改对话框
    private void showEditDialog(Employee emp, int index) {
        JDialog dialog = new JDialog(this, "修改员工", true);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JTextField nameField = new JTextField(emp.name, 15);
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"男", "女"});
        genderBox.setSelectedItem(emp.gender);
        JTextField ageField = new JTextField(String.valueOf(emp.age), 15);
        JTextField phoneField = new JTextField(emp.phone, 15);
        JTextField posField = new JTextField(emp.position, 15);
        JTextField salaryField = new JTextField(String.valueOf(emp.salary), 15);
        JTextField dateField = new JTextField(emp.hireDate, 15);
        JTextField deptField = new JTextField(emp.department, 15);

        gbc.gridx = 0; gbc.gridy = 0; dialog.add(new JLabel("姓名:"), gbc);
        gbc.gridx = 1; dialog.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; dialog.add(new JLabel("性别:"), gbc);
        gbc.gridx = 1; dialog.add(genderBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2; dialog.add(new JLabel("年龄:"), gbc);
        gbc.gridx = 1; dialog.add(ageField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; dialog.add(new JLabel("电话:"), gbc);
        gbc.gridx = 1; dialog.add(phoneField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; dialog.add(new JLabel("职位:"), gbc);
        gbc.gridx = 1; dialog.add(posField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; dialog.add(new JLabel("薪资:"), gbc);
        gbc.gridx = 1; dialog.add(salaryField, gbc);

        gbc.gridx = 0; gbc.gridy = 6; dialog.add(new JLabel("入职日期:"), gbc);
        gbc.gridx = 1; dialog.add(dateField, gbc);

        gbc.gridx = 0; gbc.gridy = 7; dialog.add(new JLabel("部门:"), gbc);
        gbc.gridx = 1; dialog.add(deptField, gbc);

        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("保存");
        JButton cancelButton = new JButton("取消");

        okButton.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String gender = (String) genderBox.getSelectedItem();
                int age = Integer.parseInt(ageField.getText().trim());
                String phone = phoneField.getText().trim();
                String pos = posField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());
                String hireDate = dateField.getText().trim();
                String dept = deptField.getText().trim();

                if (name.isEmpty() || phone.isEmpty() || pos.isEmpty() || dept.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "请填写必填字段！", "输入错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!hireDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    JOptionPane.showMessageDialog(dialog, "入职日期格式应为 yyyy-MM-dd", "格式错误", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                emp.name = name;
                emp.gender = gender;
                emp.age = age;
                emp.phone = phone;
                emp.position = pos;
                emp.salary = salary;
                emp.hireDate = hireDate;
                emp.department = dept;

                refreshTable();
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "年龄或薪资格式不正确！", "输入错误", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        dialog.add(buttonPanel, gbc);

        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new EmployeeManagerUI().setVisible(true);
        });
    }
}