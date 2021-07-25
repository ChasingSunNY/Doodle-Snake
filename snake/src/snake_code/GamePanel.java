package snake_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;
    int[] locationX = new int[600];
    int[] locationY = new int[600];
    String fx;
    boolean isStart = false;
    boolean isFail = false;
    Timer timer = new Timer(50,this);
    int foodx;
    int foody;
    int score = 0;
    Random random = new Random();


    public GamePanel(){
        init();
        //获取监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    public void init(){
        length =3;
        locationX[0]=100;locationY[0]=100;
        locationX[1]=75;locationY[1]=100;
        locationX[2]=50;locationY[2]=100;
        fx ="R";
        foodx= 25+25*random.nextInt(34);
        foody= 75+25*random.nextInt(23);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //改变背景
        this.setBackground(Color.GRAY);
        //绘制游戏区域
        GameData.headerImage.paintIcon(this,g,25,10);
        // 绘制游戏区域
        g.fillRect(25,75,850,600 );
        g.setColor(Color.orange);
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("Sunny的贪吃蛇小游戏",25,40);
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑",Font.BOLD,15));
        g.drawString("积分："+score,800,50);
        g.drawString("长度："+(length-3),800,35);

        if(fx.equals("R")){
            GameData.right.paintIcon(this,g,locationX[0],locationY[0]);
        }
        else if (fx.equals("L")){
            GameData.left.paintIcon(this,g,locationX[0],locationY[0]);
        }
        else if (fx.equals("D")){
            GameData.down.paintIcon(this,g,locationX[0],locationY[0]);
        }
        else{
            GameData.up.paintIcon(this,g,locationX[0],locationY[0]);
        }

        for (int i = 1; i < length; i++) {
            GameData.body.paintIcon(this,g,locationX[i],locationY[i]);
        }

        GameData.food.paintIcon(this,g,foodx,foody);
        if(!isStart){
            g.setColor(Color.cyan);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,400);
        }
        if(isFail){
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败，按下空格重新开始",150,400);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart && isFail == false){
            for (int i = length-1; i >0; i--) {
                locationX[i] = locationX[i-1];
                locationY[i] = locationY[i-1];
            }
            if (fx.equals("R")) {
                locationX[0] = locationX[0] + 25;
                // 边界判断
                if (locationX[0] > 850) {
                    locationX[0] = 25;
                }

            } else if (fx.equals("L")) {
                locationX[0] = locationX[0] - 25;
                // 边界判断
                if (locationX[0] < 25) {
                    locationX[0] = 850;
                }
            } else if (fx.equals("D")) {
                locationY[0] = locationY[0] + 25;
                // 边界判断
                if (locationY[0] > 650) {
                    locationY[0] = 75;
                }

            } else if (fx.equals("U")) {
                locationY[0] = locationY[0] - 25;
                // 边界判断
                if (locationY[0] < 75) {
                    locationY[0] = 650;
                }
            }
            if(locationX[0]==foodx && locationY[0]==foody){
                length++;
                foodx= 25+25*random.nextInt(34);
                foody= 75+25*random.nextInt(23);
                score += 25;
            }
            repaint();
            for (int i = 1; i <length ; i++) {
                if(locationX[0]==locationX[i] && locationY[0]==locationY[i]){
                    isFail =true;
                }
            }
        }

        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();
            } else {
                isStart = !isStart;
            }
            repaint();// 刷新界面
        }

        // 键盘控制走向
        if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }
        if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }

}
