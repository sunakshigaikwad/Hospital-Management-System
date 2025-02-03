package healthcare.management;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    public ImagePanel(String imagePath) {
        try {
            // Load image from the relative path
            backgroundImage = ImageIO.read(new File("images/" + imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Image not found: " + imagePath); // Print the missing image path
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
