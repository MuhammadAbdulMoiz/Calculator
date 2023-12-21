import javax.swing.*;
import java.awt.*;

public class IButton extends JButton {
    IButton(String args) {
        ImageIcon icon = new ImageIcon(args); // Import Logo
        this.setIcon(icon); // Setting Icon
        this.setHorizontalAlignment(this.CENTER);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Color.BLACK); // Setting color of Button
        this.setFocusable(false);
    }

    IButton(String args, String text) {
        ImageIcon icon = new ImageIcon(args); // Import Logo
        this.setIcon(icon); // Setting Icon
        this.setHorizontalAlignment(JButton.CENTER);
        this.setBorderPainted(false);
        this.setText(text);
        this.setForeground(new Color(0xff8c00));
        this.setHorizontalTextPosition(JButton.RIGHT);
        this.setFont(new Font("Arial Narrow", Font.BOLD, 26));
        this.setIconTextGap(10);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setBackground(Color.BLACK); // Setting color of Button
        this.setFocusable(false);
    }
}
