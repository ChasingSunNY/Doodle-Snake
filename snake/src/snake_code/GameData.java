package snake_code;

import javax.swing.*;
import java.net.URL;

public class GameData {
    // 定位图片地址
    public static URL headerURL = GameData.class.getResource("/snake_pic/header.png");
    // 绘制图片
    public static ImageIcon headerImage = new ImageIcon(headerURL);


    // 蛇头部
    public static URL upUrl =  GameData.class.getResource("/snake_pic/up.png");
    public static URL leftUrl =  GameData.class.getResource("/snake_pic/left.png");
    public static URL rightUrl =  GameData.class.getResource("/snake_pic/right.png");
    public static URL downUrl =  GameData.class.getResource("/snake_pic/down.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    // 身体
    public static URL bodyUrl =  GameData.class.getResource("/snake_pic/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
    // 豆豆
    public static URL foodUrl =  GameData.class.getResource("/snake_pic/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);


}
