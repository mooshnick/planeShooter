import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int x;
    private int y;
    private List<Bullet> bullets;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        bullets = new ArrayList<>();

    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
        for (int i = 0; i < bullets.size() ; i++){
            if (bullets.get(i).isEnd()){
                bullets.remove(bullets.get(i--));
            }else {
                bullets.get(i).draw(g);
            }
        }
    }
    public void fire() {
        Bullet b = new Bullet(x + 25, y);
        b.fire();
        bullets.add(b);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public boolean colided(Enemies enemy , Bullet bullet)
    {
        return enemy.getBodyasRac().intersects(bullet.getbulletasRac());
    }
    public void moveRight() {
        this.x+=1;
    }
    public void moveLeft() {
        this.x-=1;
    }
    public void moveUp() {
        this.y-=1;
    }
    public void moveDown() {
        this.y+=1;
    }

}
