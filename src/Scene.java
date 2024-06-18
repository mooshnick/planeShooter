import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Scene extends JPanel {
    private final Player p1;
    private final ArrayList<Enemies> enemies;
    //   private  Enemies enemy;
    public static final int ENEMIES_COUNT = 5;

    public Scene(int x, int y, int wight, int height) {
        this.setBounds(x, y, wight, height);
        p1 = new Player(250, height - 100);
        //    this.enemies = new Enemies(x, y, 50);
        Random random = new Random();
        this.enemies = new ArrayList<>();
        for (int i = 0; i < ENEMIES_COUNT; i++) {
            Enemies enemy = new Enemies(
                    random.nextInt(0, wight),
                    random.nextInt(0, height),
                    30);
            this.enemies.add(enemy);
        }
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new Controller(this.p1, this));
        mainGameLoop();
    }
//    public void mainGameLoop(){
//        new Thread(()->{
//            while (true) {
//                for (Enemies enemy : this.enemies)
//                {
//                    for(Bullet bul: p1.getBullets())
//                    {
//                        if(enemy.getBodyasRac().intersects(bul.getbulletasRac()))
//                        {
//                            enemies.remove(enemy);
//                        }
//                    }
//
//                }
//                this.repaint();
//                try {
//                    Thread.sleep(5);
//                } catch (Exception ignored) {
//
//                }
//            }
//
//        }).start();
//    }
    public void mainGameLoop() {
        new Thread(() -> {
            while (true) {
                Iterator<Enemies> enemyIterator = enemies.iterator();
                while (enemyIterator.hasNext()) {
                    Enemies enemy = enemyIterator.next();

                    Iterator<Bullet> bulletIterator = p1.getBullets().iterator();
                    while (bulletIterator.hasNext()) {
                        Bullet bullet = bulletIterator.next();

                        if (enemy.getBodyasRac().intersects(bullet.getbulletasRac())) {
                            enemyIterator.remove();
                            bulletIterator.remove();
                            break;
                        }
                    }
                }
                this.repaint();
                try {
                    Thread.sleep(5);
                } catch (Exception ignored) {
                }
            }
        }).start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        p1.draw(g);
        for (Enemies enemy : this.enemies) {
            enemy.paint(g);
        }
    }

}
