import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class Root extends JFrame implements ActionListener, FocusListener {

    // Globalizing Buttons, Labels, CheckBoxes and Panels references
    JButton d_type, no_s, s1, s2, back, back_;
    JRadioButton[] rb_ = new JRadioButton[11];
    JTextField Op_1, Op_2, O, R, Op;
    ButtonGroup g1 = new ButtonGroup();
    ButtonGroup g2 = new ButtonGroup();
    JButton[] p4_b_ref = new JButton[35];
    JButton[] p5_b_ref = new JButton[20];
    JButton[] p6_b_ref = new JButton[35];
    MPanel[] panels = new MPanel[11];
    int text_field = 1;

    Root() {
        // Get Logo
        ImageIcon logo = new ImageIcon("logo.gif");

        // Frame
        this.setTitle("Calculator"); // Name of Window
        this.setSize(380, 650); // Size of Window
        this.setIconImage(logo.getImage()); // Set Logo
        this.getContentPane().setBackground(new Color(0x0000)); // Set Background Color
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting Close on Ext
        this.setResizable(false); // Setting Resizing to False

        // Add panels for input, output display
        for (int k = 0; k < 4; k++) {
            panels[k] = new MPanel(370, 50);
            this.add(panels[k]);
        } // Panels with Flow layout
        panels[10] = new MPanel(370, 50);
        {
            panels[1].setLayout(new BorderLayout());
            panels[2].setLayout(new BorderLayout());
            panels[3].setLayout(new BorderLayout());
            panels[10].setLayout(new BorderLayout());
        } // Panels with Border layout
        this.add(panels[10]);

        // Panels with grid layout for input
        {
            panels[4] = new MPanel(370, 360, 7, 5);
            panels[5] = new MPanel(370, 360, 5, 4);
            panels[6] = new MPanel(370, 360, 7, 5);
            panels[7] = new MPanel(370, 600, 6, 2);
            panels[8] = new MPanel(370, 650, 12, 1);
            panels[9] = new MPanel(370, 650, 12, 1);
        }

        // Text Fields
        {
            Op_1 = new MTextField("Enter Operand 1 here");
            Op_1.addActionListener(this);
            Op_1.addFocusListener(this);

            O = new MTextField("Operator");
            O.addActionListener(this);
            O.addFocusListener(this);

            Op_2 = new MTextField("Enter Operand 2 here");
            Op_2.addActionListener(this);
            Op_2.addFocusListener(this);

            R = new MTextField("  Result");
            R.addActionListener(this);
            R.addFocusListener(this);
        }

        // Radio Buttons for number systems and data types
        String[] types = {"  Decimal", "  Hex-Decimal", "  Octal", "  Binary", "  Byte", "  Int", "  Short", "  Long", "  Float", "  Double"};
        for (int l = 0; l < 10; l++) {
            rb_[l] = new MRadioButton(types[l]);
        }

        // Buttons for panel 0
        s1 = new IButton("dd2.png");
        s1.addActionListener(this);
        s2 = new IButton("dd.png");
        s2.addActionListener(this);

        // Buttons for panel 7
        d_type = new BButton("Data Types", 0x808080);
        d_type.addActionListener(this);
        no_s = new BButton("No System", 0x808080);
        no_s.addActionListener(this);

        // Buttons for panel 8
        back = new IButton("R.png", "No Systems");
        back.addActionListener(this);

        // Buttons for panel 9
        back_ = new IButton("R.png", "Data Types");
        back_.addActionListener(this);

        // Array for Button Text and Colors of Panel 4
        String[] butt_ = {"2nd", "deg", "sin", "cos", "tan", "x^", "log", "ln", "(", ")", " \u221Ax", "AC", "delete_.png", "%", "/", "x!", "7", "8", "9", "x", "1/x", "4", "5", "6", "-", "pi", "1", "2", "3", "+", "switch_.png", "e", "0", ".", "equal_.png"};
        Integer[] color = {0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0xff8c00, 0xff8c00, 0xff8c00, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
        int i = 0;
        for (String s : butt_) {
            if (s.contains(".png")) {
                p4_b_ref[i] = new IButton(s);
            } else {
                p4_b_ref[i] = new BButton(s, color[i]);
            }
            p4_b_ref[i].addActionListener(this);
            panels[4].add(p4_b_ref[i]);
            i++;
        }// Enhanced Loop for Button Creation on Panel 4

        // Array for Button Text and Colors of Panel 5
        String[] butt_1 = {"AC", "delete_.png", "%", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "switch_.png", "0", ".", "equal_.png"};
        Integer[] color_ = {0xff8c00, 0xff8c00, 0xff8c00, 0xff8c00, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
        int j = 0;
        for (String s : butt_1) {
            if (s.contains(".png")) {
                p5_b_ref[j] = new IButton(s);
            } else {
                p5_b_ref[j] = new BButton(s, color_[j]);
            }
            p5_b_ref[j].addActionListener(this);
            panels[5].add(p5_b_ref[j]);
            j++;
        } // Enhanced Loop for Button Creation on Panel 5

        // Array for Button Text and Colors of Panel 6
        String[] butt_2 = {"2nd", "deg", "sin-1", "cos-1", "tan-1", "x^", "log", "ln", "(", ")", " \u221Ax", "AC", "delete_.png", "%", "/", "x!", "7", "8", "9", "x", "1/x", "4", "5", "6", "-", "pi", "1", "2", "3", "+", "switch_.png", "e", "0", ".", "equal_.png"};
        Integer[] colour = {0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0x808080, 0xff8c00, 0xff8c00, 0xff8c00, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xff8c00, 0x808080, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
        int l = 0;
        for (String s : butt_2) {
            if (s.contains(".png")) {
                p6_b_ref[l] = new IButton(s);
            } else {
                p6_b_ref[l] = new BButton(s, colour[l]);
            }
            p6_b_ref[l].addActionListener(this);
            panels[6].add(p6_b_ref[l]);
            l++;
        } // Enhanced loop for adding buttons to panel 6

        for (int n = 4; n < 10; n++) {
            this.add(panels[n]);
        } // Adding Panels

        // Creating Group of #Systems and Adding to panel
        panels[8].add(back);
        for (int m = 0; m < 4; m++) {
            g2.add(rb_[m]);
            panels[8].add(rb_[m]);
        }
        rb_[0].setSelected(true);

        // Creating Group of Data Types and Adding to panels
        panels[9].add(back_);
        for (int m = 4; m < 10; m++) {
            g1.add(rb_[m]);
            panels[9].add(rb_[m]);
        }
        rb_[5].setSelected(true); // Int

        // Adding Buttons, Text Fields

        {
            panels[1].add(Op_1);
            panels[2].add(O);
            panels[3].add(Op_2);
            panels[10].add(R);
            panels[7].add(d_type);
            panels[7].add(no_s);
            panels[0].add(s1);
            panels[0].add(s2);
        }
        s1.setEnabled(false);
        for (int m = 4; m < 10; m++) {
            panels[m].setVisible(false);
        } // Setting Panels Visibility
        panels[5].setVisible(true);

        this.setVisible(true); // Set Root/Frame Visibility to True
    } // Class Extension
    public static int Factorial(double no){
        int i , f = 1;
        int no_ = (int) no;
        for(i = 1;i<=no_;i++){
            f *= i;
        }
        return f;
    } // Factorial


    @Override
    public void actionPerformed(ActionEvent e) {
        // Action Listeners for Action of Different Buttons
        {
            if (e.getSource() == p5_b_ref[16]) {
                panels[4].setVisible(true);
                panels[5].setVisible(false);
            }
            if (e.getSource() == p4_b_ref[30]) {
                panels[4].setVisible(false);
                panels[5].setVisible(true);
            }
            if (e.getSource() == p6_b_ref[30]) {
                panels[6].setVisible(false);
                panels[5].setVisible(true);
            }
            if (e.getSource() == p4_b_ref[0]) {
                panels[4].setVisible(false);
                panels[6].setVisible(true);
                p6_b_ref[1].setEnabled(false);
            }
            if (e.getSource() == p6_b_ref[0]) {
                panels[4].setVisible(true);
                panels[6].setVisible(false);
                p6_b_ref[1].setEnabled(true);
            }
            if (e.getSource() == p4_b_ref[1]) {
                if (p4_b_ref[1].getText().equals("deg")) {
                    p4_b_ref[0].setEnabled(false);
                    p4_b_ref[1].setText("rad");
                } else {
                    p4_b_ref[0].setEnabled(true);
                    p4_b_ref[1].setText("deg");
                }
            }
            if (e.getSource() == s2) {
                s1.setEnabled(true);
                s2.setEnabled(false);
                for (int i = 1; i < 7; i++) {
                    panels[i].setVisible(false);
                }
                panels[10].setVisible(false);
                panels[7].setVisible(true);
            }
            if (e.getSource() == s1) {
                s1.setEnabled(false);
                s2.setEnabled(true);
                panels[1].setVisible(true);
                panels[2].setVisible(true);
                panels[3].setVisible(true);
                panels[10].setVisible(true);
                panels[5].setVisible(true);
                panels[7].setVisible(false);
                panels[8].setVisible(false);
                panels[9].setVisible(false);

            }
            if (e.getSource() == no_s) {
                for (int i = 0; i < 8; i++) {
                    panels[i].setVisible(false);
                }
                panels[10].setVisible(false);
                panels[8].setVisible(true);
            }
            if (e.getSource() == d_type) {
                for (int i = 0; i < 9; i++) {
                    panels[i].setVisible(false);
                }
                panels[10].setVisible(false);
                panels[9].setVisible(true);
            }
            if (e.getSource() == back || e.getSource() == back_) {
                s1.setEnabled(true);
                s2.setEnabled(false);
                panels[0].setVisible(true);
                for (int i = 1; i < 7; i++) {
                    panels[i].setVisible(false);
                }
                if (rb_[1].isSelected() || rb_[2].isSelected() || rb_[3].isSelected()){
                    rb_[4].setSelected(false);
                    rb_[5].setSelected(false);
                    rb_[6].setSelected(false);
                    rb_[7].setSelected(false);
                    rb_[8].setSelected(false);
                    rb_[9].setSelected(false);
                    rb_[5].setSelected(true);
                } // Radio Button Selection
                if (rb_[0].isSelected()){
                    for(int i= 0;i<20;i++)
                        p5_b_ref[i].setEnabled(true);
                } // Decimal Buttons
                if (rb_[1].isSelected()){
                    p5_b_ref[0].setEnabled(true);
                    p5_b_ref[1].setEnabled(true);
                    p5_b_ref[2].setEnabled(true);
                    p5_b_ref[3].setEnabled(true);
                    p5_b_ref[4].setEnabled(true);
                    p5_b_ref[5].setEnabled(true);
                    p5_b_ref[6].setEnabled(true);
                    p5_b_ref[7].setEnabled(true);
                    p5_b_ref[8].setEnabled(true);
                    p5_b_ref[9].setEnabled(true);
                    p5_b_ref[10].setEnabled(true);
                    p5_b_ref[11].setEnabled(true);
                    p5_b_ref[12].setEnabled(true);
                    p5_b_ref[13].setEnabled(true);
                    p5_b_ref[14].setEnabled(true);
                    p5_b_ref[15].setEnabled(true);
                    p5_b_ref[16].setEnabled(false);
                    p5_b_ref[17].setEnabled(true);
                    p5_b_ref[18].setEnabled(false);
                    p5_b_ref[19].setEnabled(true);
                } // Hex Buttons
                if (rb_[2].isSelected()){
                    p5_b_ref[0].setEnabled(true);
                    p5_b_ref[1].setEnabled(true);
                    p5_b_ref[2].setEnabled(true);
                    p5_b_ref[3].setEnabled(true);
                    p5_b_ref[4].setEnabled(true);
                    p5_b_ref[5].setEnabled(false);
                    p5_b_ref[6].setEnabled(false);
                    p5_b_ref[7].setEnabled(true);
                    p5_b_ref[8].setEnabled(true);
                    p5_b_ref[9].setEnabled(true);
                    p5_b_ref[10].setEnabled(true);
                    p5_b_ref[11].setEnabled(true);
                    p5_b_ref[12].setEnabled(true);
                    p5_b_ref[13].setEnabled(true);
                    p5_b_ref[14].setEnabled(true);
                    p5_b_ref[15].setEnabled(true);
                    p5_b_ref[16].setEnabled(false);
                    p5_b_ref[17].setEnabled(true);
                    p5_b_ref[18].setEnabled(false);
                    p5_b_ref[19].setEnabled(true);
                } // Octal Buttons
                if (rb_[3].isSelected()){
                    p5_b_ref[0].setEnabled(true);
                    p5_b_ref[1].setEnabled(true);
                    p5_b_ref[2].setEnabled(true);
                    p5_b_ref[3].setEnabled(true);
                    p5_b_ref[4].setEnabled(false);
                    p5_b_ref[5].setEnabled(false);
                    p5_b_ref[6].setEnabled(false);
                    p5_b_ref[7].setEnabled(true);
                    p5_b_ref[8].setEnabled(false);
                    p5_b_ref[9].setEnabled(false);
                    p5_b_ref[10].setEnabled(false);
                    p5_b_ref[11].setEnabled(true);
                    p5_b_ref[12].setEnabled(true);
                    p5_b_ref[13].setEnabled(false);
                    p5_b_ref[14].setEnabled(false);
                    p5_b_ref[15].setEnabled(true);
                    p5_b_ref[16].setEnabled(false);
                    p5_b_ref[17].setEnabled(true);
                    p5_b_ref[18].setEnabled(false);
                    p5_b_ref[19].setEnabled(true);
                } // Binary Buttons

                panels[7].setVisible(true);
            }
            // Action Listeners for Different Text Fields
            Op = new JTextField();
            if (text_field == 1) {
                Op = Op_1;
            } else if (text_field == 2) {
                Op = Op_2;
            }
            if (text_field == 1 || text_field == 2) {
                if (e.getSource() == p5_b_ref[0] || e.getSource() == p4_b_ref[11] || e.getSource() == p6_b_ref[11]) {
                    Op_1.setText("");
                    O.setText("");
                    Op_2.setText("");
                    R.setText("");
                }
                if (e.getSource() == p5_b_ref[1] || e.getSource() == p4_b_ref[12] || e.getSource() == p6_b_ref[12]) {
                    String value = Op.getText();
                    Op.setText("");
                    for (int i = 0; i < value.length() - 1; i++) {
                        Op.setText(Op.getText() + value.charAt(i));
                    }
                }
                if (e.getSource() == p5_b_ref[4] || e.getSource() == p4_b_ref[16] || e.getSource() == p6_b_ref[16]) {
                    Op.setText(Op.getText().concat(String.valueOf(7)));
                }
                if (e.getSource() == p5_b_ref[5] || e.getSource() == p4_b_ref[17] || e.getSource() == p6_b_ref[17]) {
                    Op.setText(Op.getText().concat(String.valueOf(8)));
                }
                if (e.getSource() == p5_b_ref[6] || e.getSource() == p4_b_ref[18] || e.getSource() == p6_b_ref[18]) {
                    Op.setText(Op.getText().concat(String.valueOf(9)));
                }
                if (e.getSource() == p5_b_ref[8] || e.getSource() == p4_b_ref[21] || e.getSource() == p6_b_ref[21]) {
                    Op.setText(Op.getText().concat(String.valueOf(4)));
                }
                if (e.getSource() == p5_b_ref[9] || e.getSource() == p4_b_ref[22] || e.getSource() == p6_b_ref[22]) {
                    Op.setText(Op.getText().concat(String.valueOf(5)));
                }
                if (e.getSource() == p5_b_ref[10] || e.getSource() == p4_b_ref[23] || e.getSource() == p6_b_ref[23]) {
                    Op.setText(Op.getText().concat(String.valueOf(6)));
                }
                if (e.getSource() == p5_b_ref[12] || e.getSource() == p4_b_ref[26] || e.getSource() == p6_b_ref[26]) {
                    Op.setText(Op.getText().concat(String.valueOf(1)));
                }
                if (e.getSource() == p5_b_ref[13] || e.getSource() == p4_b_ref[27] || e.getSource() == p6_b_ref[27]) {
                    Op.setText(Op.getText().concat(String.valueOf(2)));
                }
                if (e.getSource() == p5_b_ref[14] || e.getSource() == p4_b_ref[28] || e.getSource() == p6_b_ref[28]) {
                    Op.setText(Op.getText().concat(String.valueOf(3)));
                }
                if (e.getSource() == p5_b_ref[17] || e.getSource() == p4_b_ref[32] || e.getSource() == p6_b_ref[32]) {
                    Op.setText(Op.getText().concat(String.valueOf(0)));
                }
                if (e.getSource() == p5_b_ref[18] || e.getSource() == p4_b_ref[33] || e.getSource() == p6_b_ref[33]) {
                    Op.setText(Op.getText().concat("."));
                }
                if (e.getSource() == p4_b_ref[31] || e.getSource() == p6_b_ref[31]) {
                    Op.setText("");
                    Op.setText(Op.getText().concat(String.valueOf(2.718)));
                }
                if (e.getSource() == p4_b_ref[8] || e.getSource() == p6_b_ref[8]) {
                    Op.setText(Op.getText().concat("("));
                }
                if (e.getSource() == p4_b_ref[9] || e.getSource() == p6_b_ref[9]) {
                    Op.setText(Op.getText().concat(")"));
                }
                if (e.getSource() == p4_b_ref[25] || e.getSource() == p6_b_ref[25]) {
                    Op.setText("");
                    Op.setText(Op.getText().concat("3.1415"));
                }
            }
            if (text_field == 3) {
                if (e.getSource() == p5_b_ref[0] || e.getSource() == p4_b_ref[11] || e.getSource() == p6_b_ref[11]) {
                    Op_1.setText("");
                    O.setText("");
                    Op_2.setText("");
                    R.setText("");
                }
                if (e.getSource() == p5_b_ref[1] || e.getSource() == p4_b_ref[12] || e.getSource() == p4_b_ref[12]) {
                    String value = O.getText();
                    O.setText("");
                    for (int i = 0; i < value.length() - 1; i++) {
                        O.setText(O.getText() + value.charAt(i));
                    }
                }
                if (e.getSource() == p5_b_ref[2] || e.getSource() == p4_b_ref[13] || e.getSource() == p6_b_ref[13]) {
                    O.setText("");
                    O.setText(O.getText().concat(" % "));
                }
                if (e.getSource() == p5_b_ref[3] || e.getSource() == p4_b_ref[14] || e.getSource() == p6_b_ref[14]) {
                    O.setText("");
                    O.setText(O.getText().concat(" / "));
                }
                if (e.getSource() == p5_b_ref[7] || e.getSource() == p4_b_ref[19] || e.getSource() == p6_b_ref[19]) {
                    O.setText("");
                    O.setText(O.getText().concat(" x "));
                }
                if (e.getSource() == p5_b_ref[11] || e.getSource() == p4_b_ref[24] || e.getSource() == p6_b_ref[24]) {
                    O.setText("");
                    O.setText(O.getText().concat(" - "));
                }
                if (e.getSource() == p5_b_ref[15] || e.getSource() == p4_b_ref[29] || e.getSource() == p6_b_ref[29]) {
                    O.setText("");
                    O.setText(O.getText().concat(" + "));
                }
                if (e.getSource() == p4_b_ref[5] || e.getSource() == p6_b_ref[5]) {
                    O.setText("");
                    O.setText(O.getText().concat(" ^ "));
                }
                if (e.getSource() == p4_b_ref[6] || e.getSource() == p6_b_ref[6]) {
                    O.setText("");
                    O.setText(O.getText().concat(" log "));
                }
                if (e.getSource() == p4_b_ref[7] || e.getSource() == p6_b_ref[7]) {
                    O.setText("");
                    O.setText(O.getText().concat(" ln "));
                }
                if (e.getSource() == p4_b_ref[10] || e.getSource() == p6_b_ref[10]) {
                    O.setText("");
                    O.setText(O.getText().concat(" \u221A "));
                }
                if (e.getSource() == p4_b_ref[15] || e.getSource() == p6_b_ref[15]) {
                    O.setText("");
                    O.setText(O.getText().concat(" ! "));
                }
                if (e.getSource() == p4_b_ref[20] || e.getSource() == p6_b_ref[20]) {
                    O.setText("");
                    O.setText(O.getText().concat(" ^(-1) "));
                }
                if (e.getSource() == p4_b_ref[2]) {
                    O.setText("");
                    O.setText(O.getText().concat(" sin( "));
                }
                if (e.getSource() == p4_b_ref[3]) {
                    O.setText("");
                    O.setText(O.getText().concat(" cos( "));
                }
                if (e.getSource() == p4_b_ref[4]) {
                    O.setText("");
                    O.setText(O.getText().concat(" tan( "));
                }
                if (e.getSource() == p6_b_ref[2]) {
                    O.setText("");
                    O.setText(O.getText().concat(" sin-1( "));
                }
                if (e.getSource() == p6_b_ref[3]) {
                    O.setText("");
                    O.setText(O.getText().concat(" cos-1( "));
                }
                if (e.getSource() == p6_b_ref[4]) {
                    O.setText("");
                    O.setText(O.getText().concat(" tan-1( "));
                }
            }
        }
        if (e.getSource() == p5_b_ref[19] || e.getSource() == p4_b_ref[34] || e.getSource() == p6_b_ref[34]) {

            if (rb_[0].isSelected()) {

                if (rb_[4].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Byte.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Byte.MIN_VALUE) {
                        try{
                        if (Double.parseDouble(Op_2.getText()) <= Byte.MAX_VALUE && Double.parseDouble(Op_2.getText()) >= Byte.MIN_VALUE) {
                            if (O.getText().contains(" + ")) {
                                int r = (byte) Double.parseDouble(Op_1.getText()) + (byte) Double.parseDouble(Op_2.getText());
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains(" - ")) {
                                int r = (byte) Double.parseDouble(Op_1.getText()) - (byte) Double.parseDouble(Op_2.getText());
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains(" x ")) {
                                int r = (byte) Double.parseDouble(Op_1.getText()) * (byte) Double.parseDouble(Op_2.getText());
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains(" / ")) {
                                int r = (byte) Double.parseDouble(Op_1.getText()) / (byte) Double.parseDouble(Op_2.getText());
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains(" % ")) {
                                int r = (byte) Double.parseDouble(Op_1.getText()) % (byte) Double.parseDouble(Op_2.getText());
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("^")){
                                int r = (byte) Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                R.setText(Integer.toString(r));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Operator 2 is not Byte", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                            }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                int r = (byte) Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }else if (O.getText().contains("ln")){
                                int r = (int) Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                int r =(byte) Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("!")) {
                                int r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                byte r = (byte) Math.sin(r_);
                                R.setText(Byte.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                byte r = (byte) Math.cos(r_);
                                R.setText(Byte.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                byte r = (byte) Math.tan(r_);
                                R.setText(Byte.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                int r =(byte) Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                int r =(byte) Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("tan-1(")){
                                int r =(byte) Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                int r = 1 / (byte) Double.parseDouble(Op_1.getText()) ;
                                R.setText(Integer.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Byte", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Byte Operations
                else if (rb_[5].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Integer.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Integer.MIN_VALUE) {
                        try{
                            if (Double.parseDouble(Op_2.getText()) <= Integer.MAX_VALUE && Double.parseDouble(Op_2.getText()) >= Integer.MIN_VALUE) {
                                if (O.getText().contains(" + ")) {
                                    int r = (int) Double.parseDouble(Op_1.getText()) + (int) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains(" - ")) {
                                    int r = (int) Double.parseDouble(Op_1.getText()) - (int) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                }
                                else if (O.getText().contains(" x ")) {
                                    int r = (int) Double.parseDouble(Op_1.getText()) * (int) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains(" / ")) {
                                    int r = (int) Double.parseDouble(Op_1.getText()) / (int) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                }
                                else if (O.getText().contains(" % ")) {
                                    int r = (int) Double.parseDouble(Op_1.getText()) % (int) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains("^")){
                                    int r = (int) Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                    R.setText(Integer.toString(r));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Operator 2 is not Int", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                int r = (int) Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }else if (O.getText().contains("ln")){
                                int r = (int) Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                int r =(int) Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("!")) {
                                int r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                int r = (int) Math.sin(r_);
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                int r = (int) Math.cos(r_);
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                int r = (int) Math.tan(r_);
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                int r =(int) Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                int r =(int) Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("tan_1(")){
                                int r =(int) Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                int r = 1 / (int) Double.parseDouble(Op_1.getText()) ;
                                R.setText(Integer.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Int", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Int Operations
                else if (rb_[6].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Short.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Short.MIN_VALUE) {
                        try{
                            if (Double.parseDouble(Op_2.getText()) <= Short.MAX_VALUE && Double.parseDouble(Op_2.getText()) >= Short.MIN_VALUE) {
                                if (O.getText().contains(" + ")) {
                                    int r = (short) Double.parseDouble(Op_1.getText()) + (short) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains(" - ")) {
                                    int r = (short) Double.parseDouble(Op_1.getText()) - (short) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                }
                                else if (O.getText().contains(" x ")) {
                                    int r = (short) Double.parseDouble(Op_1.getText()) * (short) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains(" / ")) {
                                    int r = (short) Double.parseDouble(Op_1.getText()) / (short) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                }
                                else if (O.getText().contains(" % ")) {
                                    int r = (short) Double.parseDouble(Op_1.getText()) % (short) Double.parseDouble(Op_2.getText());
                                    R.setText(Integer.toString(r));
                                } else if (O.getText().contains("^")){
                                    int r = (short) Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                    R.setText(Integer.toString(r));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Operator 2 is not Short", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                int r = (short) Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }else if (O.getText().contains("ln")){
                                int r = (short) Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                int r =(short) Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("!")) {
                                int r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                short r = (short) Math.sin(r_);
                                R.setText(Short.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                short r = (short) Math.cos(r_);
                                R.setText(Short.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                short r = (short) Math.tan(r_);
                                R.setText(Short.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                int r =(short) Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                int r =(short) Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            } else if (O.getText().contains("tan_1(")){
                                int r =(short) Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Integer.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                int r = 1 / (short) Double.parseDouble(Op_1.getText()) ;
                                R.setText(Integer.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Short", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Short Operations
                else if (rb_[7].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Long.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Long.MIN_VALUE) {
                        try{
                            if (Double.parseDouble(Op_2.getText()) <= Long.MAX_VALUE  && Double.parseDouble(Op_2.getText()) >= Long.MIN_VALUE ) {
                                if (O.getText().contains(" + ")) {
                                    long r = (long) Double.parseDouble(Op_1.getText()) + (long) Double.parseDouble(Op_2.getText());
                                    R.setText(Long.toString(r));
                                } else if (O.getText().contains(" - ")) {
                                    long r = (long) Double.parseDouble(Op_1.getText()) - (long) Double.parseDouble(Op_2.getText());
                                    R.setText(Long.toString(r));
                                }
                                else if (O.getText().contains(" x ")) {
                                    long r = (long) Double.parseDouble(Op_1.getText()) * (long) Double.parseDouble(Op_2.getText());
                                    R.setText(Long.toString(r));
                                } else if (O.getText().contains(" / ")) {
                                    long r = (long) Double.parseDouble(Op_1.getText()) / (long) Double.parseDouble(Op_2.getText());
                                    R.setText(Long.toString(r));
                                }
                                else if (O.getText().contains(" % ")) {
                                    long r = (long) Double.parseDouble(Op_1.getText()) % (long) Double.parseDouble(Op_2.getText());
                                    R.setText(Long.toString(r));
                                } else if (O.getText().contains("^")){
                                    long r = (long) Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                    R.setText(Long.toString(r));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Operator 2 is not Long", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                long r = (long) Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            }else if (O.getText().contains("ln")){
                                long r = (long) Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                long r =(long) Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            } else if (O.getText().contains("!")) {
                                long r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Long.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                long r = (long) Math.sin(r_);
                                R.setText(Long.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                long r = (long) Math.cos(r_);
                                R.setText(Long.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                long r = (long) Math.tan(r_);
                                R.setText(Long.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                long r =(long) Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                long r =(long) Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            } else if (O.getText().contains("tan_1(")){
                                long r =(long) Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Long.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                long r = 1 / (long) Double.parseDouble(Op_1.getText()) ;
                                R.setText(Long.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Long", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Long Operations
                else if (rb_[8].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Float.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Float.MIN_VALUE) {
                        try{
                            if (Double.parseDouble(Op_2.getText()) <= Float.MAX_VALUE && Double.parseDouble(Op_2.getText()) >= -Float.MIN_VALUE) {
                                if (O.getText().contains(" + ")) {
                                    double r = (float) Double.parseDouble(Op_1.getText()) + (float) Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains(" - ")) {
                                    double r = (float) Double.parseDouble(Op_1.getText()) - (float) Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                }
                                else if (O.getText().contains(" x ")) {
                                    double r = (float) Double.parseDouble(Op_1.getText()) * (float) Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains(" / ")) {
                                    double r = (float) Double.parseDouble(Op_1.getText()) / (float) Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                }
                                else if (O.getText().contains(" % ")) {
                                    double r = (float) Double.parseDouble(Op_1.getText()) % (float) Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains("^")){
                                    double r = (float) Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                    System.out.println(r);
                                    R.setText(Double.toString(r));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Operator 2 is not Float", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                double r = (float) Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }else if (O.getText().contains("ln")){
                                double r = (float) Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                double r =(float) Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("!")) {
                                double r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                float r = (float) Math.sin(r_);
                                R.setText(Float.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                float r = (float) Math.cos(r_);
                                R.setText(Float.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                float r = (float) Math.tan(r_);
                                R.setText(Float.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                double r =(float) Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                double r =(float) Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("tan_1(")){
                                double r =(float) Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                double r = 1 / (float) Double.parseDouble(Op_1.getText()) ;
                                R.setText(Double.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Float", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Float Operations
                else if (rb_[9].isSelected()) {
                    if (Double.parseDouble(Op_1.getText()) <= Double.MAX_VALUE && Double.parseDouble(Op_1.getText()) >= Double.MIN_VALUE) {
                        try{
                            if (Double.parseDouble(Op_2.getText()) <= Double.MAX_VALUE && Double.parseDouble(Op_2.getText()) >= Double.MIN_VALUE) {
                                if (O.getText().contains(" + ")) {
                                    double r = Double.parseDouble(Op_1.getText()) + Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains(" - ")) {
                                    double r = Double.parseDouble(Op_1.getText()) - Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                }
                                else if (O.getText().contains(" x ")) {
                                    double r = Double.parseDouble(Op_1.getText()) * Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains(" / ")) {
                                    double r = Double.parseDouble(Op_1.getText()) / Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                }
                                else if (O.getText().contains(" % ")) {
                                    double r = Double.parseDouble(Op_1.getText()) % Double.parseDouble(Op_2.getText());
                                    R.setText(Double.toString(r));
                                } else if (O.getText().contains("^")){
                                    double r = Math.pow(Double.parseDouble(Op_1.getText()), Double.parseDouble(Op_2.getText()));
                                    R.setText(Double.toString(r));
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Operator 2 is not Double", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        catch(Exception e_){
                            if (O.getText().contains("log")){
                                double r = Math.log10(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }else if (O.getText().contains("ln")){
                                double r = Math.log(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains(" \u221A ")){
                                double r = Math.sqrt(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("!")) {
                                double r = Factorial(Double.parseDouble(Op_1.getText())) ;
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("sin(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                double r = Math.sin(r_);
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("cos(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                double r = Math.cos(r_);
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("tan(")){
                                double r_ = Double.parseDouble(Op_1.getText());
                                if(Objects.equals(p4_b_ref[1].getText(), "deg")){
                                    r_ = Math.toRadians(r_);
                                }
                                double r = Math.tan(r_);
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("sin-1(")){
                                double r = Math.asin(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("cos-1(")){
                                double r = Math.acos(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            } else if (O.getText().contains("tan_1(")){
                                double r = Math.atan(Double.parseDouble(Op_1.getText()));
                                R.setText(Double.toString(r));
                            }
                            else if (O.getText().contains("^(-1)")){
                                double r = 1 / Double.parseDouble(Op_1.getText());
                                R.setText(Double.toString(r));
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operator 1 is not Double", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } // Double Operations


            } // Decimal
            if (rb_[1].isSelected()){
                if (O.getText().contains(" + ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 16);
                        int h2 = Integer.valueOf(Op_2.getText(), 16);
                        R.setText(Integer.toHexString((h1+h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" - ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 16);
                        int h2 = Integer.valueOf(Op_2.getText(), 16);
                        R.setText(Integer.toHexString((h1-h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" x ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 16);
                        int h2 = Integer.valueOf(Op_2.getText(), 16);
                        R.setText(Integer.toHexString((h1*h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" / ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 16);
                        int h2 = Integer.valueOf(Op_2.getText(), 16);
                        R.setText(Integer.toHexString((h1/h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" % ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 16);
                        int h2 = Integer.valueOf(Op_2.getText(), 16);
                        R.setText(Integer.toHexString((h1%h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } // Hex-Decimal
            if (rb_[2].isSelected()){
                if (O.getText().contains(" + ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 8);
                        int h2 = Integer.valueOf(Op_2.getText(), 8);
                        R.setText(Integer.toOctalString((h1+h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" - ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 8);
                        int h2 = Integer.valueOf(Op_2.getText(), 8);
                        R.setText(Integer.toOctalString((h1-h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" x ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 8);
                        int h2 = Integer.valueOf(Op_2.getText(), 8);
                        R.setText(Integer.toOctalString((h1*h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" / ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 8);
                        int h2 = Integer.valueOf(Op_2.getText(), 8);
                        R.setText(Integer.toOctalString((h1/h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" % ")) {
                    try{int h1 = Integer.valueOf(Op_1.getText(), 8);
                        int h2 = Integer.valueOf(Op_2.getText(), 8);
                        R.setText(Integer.toOctalString((h1%h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } // Octal
            if (rb_[3].isSelected()){
                if (O.getText().contains(" + ")) {
                    try{
                        int h1 = Integer.valueOf(Op_1.getText(), 2);
                        int h2 = Integer.valueOf(Op_2.getText(), 2);
                        R.setText(Integer.toBinaryString((h1+h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" - ")) {
                    try{
                        int h1 = Integer.valueOf(Op_1.getText(), 2);
                        int h2 = Integer.valueOf(Op_2.getText(), 2);
                        R.setText(Integer.toBinaryString((h1-h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" x ")) {
                    try{
                        int h1 = Integer.valueOf(Op_1.getText(), 2);
                        int h2 = Integer.valueOf(Op_2.getText(), 2);
                        R.setText(Integer.toBinaryString((h1*h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (O.getText().contains(" / ")) {
                    try{
                        int h1 = Integer.valueOf(Op_1.getText(), 2);
                        int h2 = Integer.valueOf(Op_2.getText(), 2);
                        R.setText(Integer.toBinaryString((h1/h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if (O.getText().contains(" % ")) {
                    try{
                        int h1 = Integer.valueOf(Op_1.getText(), 2);
                        int h2 = Integer.valueOf(Op_2.getText(), 2);
                        R.setText(Integer.toBinaryString((h1%h2)));
                    }
                    catch (Exception e_1){
                        JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } // Binary
        } // Operations
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == Op_1) text_field = 1;
        if (e.getSource() == Op_2) text_field = 2;
        if (e.getSource() == O) text_field = 3;
        if (e.getSource() == R) text_field = 4;
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == Op_1) text_field = 1;
        if (e.getSource() == Op_2) text_field = 2;
    }
}
