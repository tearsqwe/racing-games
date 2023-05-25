import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class player {
    public static final int max_speed=70;
    public static final int max_top=5;
    public static final int max_bot=360;

    Image img_c=new ImageIcon("D:\\java2\\racing\\src\\resources\\car5.png").getImage();
    Image img_up=new ImageIcon("D:\\java2\\racing\\src\\resources\\car5_up.png").getImage();
    Image img_down=new ImageIcon("D:\\java2\\racing\\src\\resources\\car5_down.png").getImage();
    Image img=img_c;
    public Rectangle getRect()
    {
        return new Rectangle(x,y,240, 130);
    }
    int speed=0;
    int acc=0;
    int way=0;
    int x=100;
    int y=30;
    int dy=0;

    int layer1=0;
    int layer2=1500;
    public void move() {
        way+=speed;
        speed+=acc;
        if(speed<=0) speed=0;
        if(speed>= max_speed) speed=max_speed;
        y-=dy;
        if( y<=max_top) y=max_top;
        if(y>=max_bot) y=max_bot;
        if (layer2-speed<=0)
        {
            layer1=0;
            layer2=1200;
        }
        else {
            layer1 -= speed;
            layer2 -= speed;
        }
    }
    public void keyPressed(KeyEvent e)
    {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT)
        {
            acc=1;
        }
        if(key==KeyEvent.VK_LEFT)
        {
            acc=-1;
        }
        if(key==KeyEvent.VK_UP)
        {
            dy=7;
            img=img_up;
        }
        if(key==KeyEvent.VK_DOWN)
        {
            dy=-7;
            img=img_down;
        }

    }
    public void keyReleased(KeyEvent e)
    {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT||key==KeyEvent.VK_LEFT)
        {
            acc=0;
        }
        if(key==KeyEvent.VK_UP|| key==KeyEvent.VK_DOWN)
        {
            dy=0;
            img=img_c;
        }
    }
}
