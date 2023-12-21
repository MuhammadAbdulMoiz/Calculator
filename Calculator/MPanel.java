import javax.swing.*;
import java.awt.*;

public class MPanel extends JPanel {
    MPanel(int width, int height) { //Flow layout
        this.setPreferredSize(new Dimension(width, height));// Setting Dimensions
        this.setBackground(Color.BLACK); // Setting Background
        this.setLayout(new FlowLayout()); // Setting Layout
    }

    MPanel(int width, int height, int rows, int cols) {
        this.setPreferredSize(new Dimension(width, height)); // Setting Dimensions
        this.setBackground(Color.BLACK); // Setting Background
        this.setLayout(new GridLayout(rows, cols)); // Setting Layout
    }
}
