import javax.swing.*;
import java.awt.*;

public class MRadioButton extends JRadioButton {
    MRadioButton(String args) {
        // Import Icons
        ImageIcon x = new ImageIcon("rad_off.png");
        ImageIcon y = new ImageIcon("rad_on.png");

        this.setText(args); // Setting Text
        this.setFocusable(false);
        this.setFont(new Font("Arial Narrow", Font.BOLD, 22)); // Styling Font
        this.setForeground(Color.WHITE); // Font color
        this.setBackground(Color.BLACK); // Background color

        // Setting icons
        this.setIcon(x);
        this.setSelectedIcon(y);
    }
}
