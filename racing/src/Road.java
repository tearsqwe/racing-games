import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Road extends JPanel implements ActionListener, Runnable {
    Timer mainTimer=new Timer(20, this);
    Image img =new ImageIcon("D:\\java2\\racing\\src\\resources\\road.jpg").getImage();
    public Road()
    {
        mainTimer.start();
        enemiesFactory.start();
        addKeyListener(new myKeyAdapter());
        setFocusable(true);
    }
    player p= new player();
    Thread enemiesFactory=new Thread(this);//ПЕРВЫЙ ПОТОК, СОЗДАЁТ ВРАЖЕСКИЕ МАШИНКИ
    List<enemy> enemies = new ArrayList<enemy>();
    private class myKeyAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e)
        {
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g)
    {
        g=(Graphics2D) g;// приведение типов
        g.drawImage(img, p.layer1, 0, null);// отрисовка объекта img
        g.drawImage(img, p.layer2, 0, null);
        g.drawImage(p.img, p.x, p.y, null);


        double Speed=(200/player.max_speed)* p.speed;
        int score=p.way/10;
        g.setColor(Color.green);
        g.drawString("Скорость: " + Speed + "км/ч", 30, 30);
        g.drawString("счёт: " + score + " Очков", 30, 60);

        Iterator<enemy> i=enemies.iterator();
        while(i.hasNext())
        {
            enemy e= i.next();
            if( e.x>=2400|| e.x<=-2400)
            {
                i.remove();
            } else {
            e.move();
            g.drawImage(e.img,e.x, e.y, null);}

        }
    }
    public void actionPerformed(ActionEvent e)
    {
    p.move();
    repaint();
    CollisionWithEnemies();
    //testwin();
    }

    //private void testwin() {
      //  if(p.way)
    //}

    private void CollisionWithEnemies() {
        Iterator<enemy> i=enemies.iterator();
        while(i.hasNext())
        {
            enemy e=i.next();
            if(p.getRect().intersects(e.getRect())){
                JOptionPane.showMessageDialog(null, "You Died");// поражение
                System.exit(1);
            }
        }
    }

    @Override
    public void run()
    {
        while(true)
        {
            Random rand=new Random();
            try
            {
                Thread.sleep(rand.nextInt(2000));
                enemies.add( new enemy(1600, rand.nextInt(600), rand.nextInt(50),this));
            }
            catch(InterruptedException e){e.printStackTrace();}
        }
    }
}
