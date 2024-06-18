import java.awt.*;

public class CustomRectangle {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public CustomRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.fillRect(this.x, this.y, this.width, this.height);
    }
}