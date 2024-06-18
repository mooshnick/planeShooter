import java.awt.*;

public class Bullet {

    private int x;
    private int y;
    private boolean end = false;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
        fire();
    }
    public Rectangle getbulletasRac() {
        Rectangle rac = new Rectangle(this.x,this.y,3,3);
        return rac;
    }
    public void fire(){
        new Thread(()->{
            while (y >= 0){
                y--;
                try {
                    Thread.sleep(5);
                }catch (Exception e){
                }
            }
            end = true;
        }).start();

    }


    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, 5, 10);
    }

    public boolean isEnd(){
        return end;
    }
}