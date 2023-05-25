import javax.swing.*;
import java.awt.*;

public class enemy {
    int x;
    int y;
    int speed;
    Image img= new ImageIcon("D:\\java2\\racing\\src\\resources\\enemy1.png").getImage();
    Road road;
    public Rectangle getRect()
    {
        return new Rectangle(x,y,210, 121);
    }
    public enemy(int x, int y, int speed, Road road)
    {
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.road=road;
    }
    public void move()
    {
        x=x-road.p.speed+speed;
    }
}
