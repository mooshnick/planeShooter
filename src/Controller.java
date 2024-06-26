import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private Player player;
    private Scene scene;
    private boolean spacePressed = false;
    private boolean upPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean downPressed = false;

    public Controller(Player player, Scene scene) {
        this.player = player;
        this.scene = scene;
        update();
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            rightPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            upPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            downPressed = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE && !spacePressed) {
            this.spacePressed = true;
            this.player.fire();
        }

    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            this.spacePressed = false;
        }else if (e.getKeyCode() == KeyEvent.VK_W) {
            this.upPressed = false;
        }else if (e.getKeyCode() == KeyEvent.VK_A) {
            this.leftPressed = false;
        }else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.rightPressed = false;
        }else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.downPressed = false;
        }
    }

    public void update(){
        new Thread(()->{
            while (true){
                if (upPressed){
                    player.moveUp();
                    if (rightPressed){
                        player.moveRight();
                    } else if (leftPressed) {
                        player.moveLeft();
                    }
                } else if (downPressed) {
                    player.moveDown();
                    if (rightPressed){
                        player.moveRight();
                    } else if (leftPressed) {
                        player.moveLeft();
                    }
                }else if (rightPressed){
                    player.moveRight();
                } else if (leftPressed) {
                    player.moveLeft();
                }
                this.scene.repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}