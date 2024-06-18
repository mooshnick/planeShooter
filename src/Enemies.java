import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemies {
    private CustomRectangle head;
    private CustomRectangle body;
    private CustomRectangle leftLeg;
    private CustomRectangle rightLeg;
    private int x;
    private int y;
    private int size;
    private int width;
    private int height;
    private int speed;
    private int gameWidth;
    private int gameHeight;


    public Enemies(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size=size;
        this.head = new CustomRectangle(x, y, size, size);
        this.body = new CustomRectangle(x - size / 2, y + size,
                size * 2, size * 2);

    }
    public Enemies(int gameWidth, int gameHeight){
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        Random random = new Random();
        this.x = random.nextInt(gameWidth - 50);
        this.y = 0;
        this.speed = random.nextInt(3) + 1;
        this.width = 50;
        this.height = 50;
    }

    public CustomRectangle getHead() {
        return head;
    }

    public Rectangle getBodyasRac() {
        Rectangle rac = new Rectangle(x - size / 2, y + size,
                size * 2, size * 2);
        return rac;
    }
    public void move() {
        y += speed;
        if (y > gameHeight) {
            y = 0;
            Random rand = new Random();
            x = rand.nextInt(gameWidth - width);
        }
    }

    public CustomRectangle getLeftLeg() {
        return leftLeg;
    }

    public CustomRectangle getRightLeg() {
        return rightLeg;
    }


    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        this.head.paint(g);
        this.body.paint(g);
    }

}
