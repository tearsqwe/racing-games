import javax.swing.*;
import java.awt.*;

public class bonus
{
    int x;
    int y;
    Image img=new ImageIcon("D:\\java2\\racing\\src\\resources\\coin.png").getImage();
    Road road;
    public Rectangle getRect()
    {
        return new Rectangle(x,y,70, 70);
    }
    public bonus(int x, int y, Road road)
    {
        this.x=x;
        this.y=y;
        this.road=road;
    }
    public void coinCollect(bonus bonus)
    {

    }
}


