import javax.swing.*;
import java.awt.*;

public class MTextField extends JTextField {
    MTextField(String text){
        this.setBounds(90, 20, 250, 40);
        this.setBackground(Color.BLACK);
        this.setForeground(new Color(0xf39e55));
        this.setSize(300, 40);
        this.setText(text);
        this.setCaretColor(Color.WHITE);
        this.setFont(new Font("Arial Narrow", Font.BOLD, 24)); // Font Styling
        this.setHorizontalAlignment(JTextField.TRAILING);
        this.setBorder(BorderFactory.createEmptyBorder());
    }
}
