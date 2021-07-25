package snake_code;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        JFrame out = new JFrame("贪吃蛇小游戏");

        //1.静态窗口 JFrame
        out.setBounds(10,10,900,720);
        out.setResizable(false); // 窗口大小是否可以改变
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭事件


        //2. 面板 JPanel
        out.add(new GamePanel());



        out.setVisible(true); //设置窗口可见性
    }
}
