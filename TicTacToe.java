import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel button_panel = new JPanel();
    JButton[] buttons = new JButton[9];
    String playerName = "";
    boolean firstround = true;

    public TicTacToe() {
        if (firstround) {
            this.playerName = JOptionPane.showInputDialog(frame, "Enter your name:", "Player Name",
                    JOptionPane.PLAIN_MESSAGE);
            if (this.playerName == null || playerName.trim().isEmpty()) {
                this.playerName = "Player";
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());

        JLabel scoreLabel = new JLabel("Score: Computer - 0 | " + this.playerName + " - 0");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.LIGHT_GRAY);
        scoreLabel.setForeground(Color.BLACK);
        frame.add(scoreLabel, BorderLayout.NORTH);

        button_panel.setLayout(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(10, 5));
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);
        }
        frame.add(button_panel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    public String playerName() {

        return this.playerName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}