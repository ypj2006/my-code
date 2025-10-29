package com.ityefan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame{
    private static final String imagePath = "stone-maze/src/image/";
    private int[][] imagesData = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //定义一个数组，储存游戏胜利状态
    private int[][] winData = new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //定义两个空白变量记录当前空白色块的位置;
    private int row;// 行索引
    private int col;// 列索引
    private int count = 0;//统计总共移动步数
    public MainFrame(){
        //调用一个初始化方法，初始化窗口大小等信息
        initFrame();
        //打乱数组色块顺序，再展示
        initRandomArray();
        //初始化界面，展示数字色块
        initImage();
        this.setVisible(true);
        //初始化系统菜单，点击菜单显示退出系统和重启游戏
        initMenu();
        //给窗口绑定上下左右按键事件
        initKeyPressEvent();
    }

    private void initKeyPressEvent() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                //获取当前按钮的编号
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP:
                        switchAndMove(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        switchAndMove(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        switchAndMove(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        switchAndMove(Direction.RIGHT);
                        break;
                }
            }
        });
    }
    //控制数据交换和图片移动
    private void switchAndMove(Direction direction, boolean updateCount){
        switch (direction){
            case UP:
                if(row < imagesData.length-1){
                    int temp = imagesData[row][col];
                    imagesData[row][col] = imagesData[row+1][col];
                    imagesData[row+1][col] = temp;
                    row++;
                    if(updateCount) count++;
                }
                break;
            case DOWN:
                if(row > 0){
                    int temp = imagesData[row][col];
                    imagesData[row][col] = imagesData[row-1][col];
                    imagesData[row-1][col] = temp;
                    row--;
                    if(updateCount) count++;
                }
                break;
            case LEFT:
                if(col < imagesData.length-1){
                    int temp = imagesData[row][col];
                    imagesData[row][col] = imagesData[row][col+1];
                    imagesData[row][col+1] = temp;
                    col++;
                    if(updateCount) count++;
                }
                break;
            case RIGHT:
                if(col > 0){
                    int temp = imagesData[row][col];
                    imagesData[row][col] = imagesData[row][col-1];
                    imagesData[row][col-1] = temp;
                    col--;
                    if(updateCount) count++;
                }
                break;
        }
        initImage();
    }
    // 为了保持接口兼容性，添加一个默认更新计数的重载方法
    private void switchAndMove(Direction direction){
        switchAndMove(direction, true);
    }

    private void initRandomArray() {
        // 通过随机移动空格来打乱拼图，确保游戏可解
        int shuffleCount = 100; // 打乱的步数
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < shuffleCount; i++) {
            // 获取所有可能的移动方向
            java.util.List<Direction> possibleMoves = new java.util.ArrayList<>();

            if (row > 0) possibleMoves.add(Direction.DOWN);
            if (row < imagesData.length - 1) possibleMoves.add(Direction.UP);
            if (col > 0) possibleMoves.add(Direction.RIGHT);
            if (col < imagesData[0].length - 1) possibleMoves.add(Direction.LEFT);

            // 随机选择一个方向进行移动
            Direction move = possibleMoves.get(random.nextInt(possibleMoves.size()));
            switchAndMove(move);
        }
        // 重置步数计数器
        count = 0;
        OUT:
        for (int i = 0; i < imagesData.length; i++) {
            for (int j = 0; j < imagesData[i].length; j++) {
                if (imagesData[i][j] == 0){
                    //定位到空白方块位置
                    row = i;
                    col = j;
                    break OUT;//跳出整个循环
                }
            }
        }
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("系统");
        JMenuItem exitJi = new JMenuItem("退出");
        menu.add(exitJi);
        exitJi.addActionListener(e -> {
            dispose();
        });
        JMenuItem restartJi = new JMenuItem("重启");
        menu.add(restartJi);
        restartJi.addActionListener(e -> {
            //重启游戏
            initRandomArray();
            initImage();
            count = 0;
        });
        menuBar.add(menu);//添加菜单
        this.setJMenuBar(menuBar);//添加菜单栏

    }

    private void initImage(){
        //清空窗口
        this.getContentPane().removeAll();
        //展示步数
        JLabel countLabel = new JLabel("当前移动："+count+"步");
        countLabel.setBounds(10,10,100,20);
        this.add(countLabel);
        //对文字进行美化
        countLabel.setFont(new Font("微软雅黑",Font.BOLD,13));
        //判断是否赢了
        if (isWin()){
            JLabel winLabel = new JLabel(new ImageIcon(imagePath+"win.png"));
            winLabel.setBounds(114,230,266,137);
            this.add(winLabel);
        }
        //展示一个行列矩阵的数字色块依次铺满窗口
        for (int i = 0; i < imagesData.length; i++) {
            for (int j = 0; j < imagesData[i].length; j++) {
                String imageName = imagesData[i][j] + ".png";
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(imagePath+imageName));
                label.setBounds(26+j*100,60+i*100,100,100);
                this.setLayout(null);
                this.add(label);
            }
        }
        JLabel background = new JLabel(new ImageIcon(imagePath+"background.png"));
        background.setBounds(-6,-43,465,575);
        this.add(background);
        this.repaint();
    }

    private boolean isWin() {
        for (int i = 0; i < imagesData.length; i++) {
            for (int j = 0; j < imagesData[i].length; j++) {
                if (imagesData[i][j] != winData[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private void initFrame(){
        setTitle("石头迷阵 1.0 —— YeFan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(465,575);
        setLocationRelativeTo(null);
        this.setLayout(null);
    }
}
