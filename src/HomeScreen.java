import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JPanel {

    public static final int WIDTH = Window.WIDTH;
    public static final int HEIGHT = Window.HEIGHT;

    private final ImageIcon BACKGROUND_IMAGE;

    public HomeScreen(int x, int y) {

        this.setBounds(x, y, WIDTH, HEIGHT);

        BACKGROUND_IMAGE = new ImageIcon("resources/Photos/Background_image.png");
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        g2d.drawImage(BACKGROUND_IMAGE.getImage(), getX(), getY(),WIDTH,HEIGHT, this);
    }
}
