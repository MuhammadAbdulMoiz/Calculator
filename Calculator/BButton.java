import javax.swing.*;
import java.awt.*;

public class BButton extends JButton {
    BButton(String args, Integer hex) {
        this.setText(args); // Setting Text
        this.setFont(new Font("Arial Narrow", Font.BOLD, 24)); // Font Styling
        this.setFocusable(false);
        this.setForeground(new Color(hex)); // Setting color of Button
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createEmptyBorder()); // No Borders
    }
}
