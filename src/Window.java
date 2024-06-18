import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
        public static final int WIDTH = 800;
        public static final int HEIGHT = 600;

        public Window () {
            this.setTitle("Pilot fight");
            this.setSize(WIDTH, HEIGHT);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.add(new Scene(0,0,800,600));

            JButton button = new JButton();
            JButton twoButton = new JButton();
            this.add(button);
            this.add(twoButton);

            button.setBounds(HEIGHT / 3 + 60,530,320,60);
            twoButton.setBounds(HEIGHT / 3 + 60,600,320,60);

            button.setText("התחל");
            twoButton.setText("הוראות");

            button.addActionListener((event)-> {

            });


            this.add(new HomeScreen(0,0));

            this.setVisible(true);
        }
}