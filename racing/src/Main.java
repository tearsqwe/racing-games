import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame f=new JFrame("Racing games");
        f.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        f.setSize(1500,540);
        f.add(new Road());
        f.setVisible(true);


    }
}