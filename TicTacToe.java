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
import java.util.Random;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel button_panel = new JPanel();
    Random random = new Random();
    JButton[] buttons = new JButton[9];
    String playerName = "";
    boolean firstround = true;
    int score = 0;
    boolean playerturn = true;
    boolean computerturn = false;
    boolean wait = false;

    public TicTacToe() {
        if (firstround == true) {

            firstround = false;
            this.playerName = JOptionPane.showInputDialog(frame, "Enter your name:", "Player Name",
                    JOptionPane.PLAIN_MESSAGE);
            if (this.playerName == null || playerName.trim().isEmpty()) {
                this.playerName = "Player";
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLayout(new BorderLayout());

        JLabel scoreLabel = new JLabel("Score: Computer: 0 | " + this.playerName + ": " + this.score);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.LIGHT_GRAY);
        scoreLabel.setForeground(Color.BLACK);
        frame.add(scoreLabel, BorderLayout.NORTH);

        button_panel.setSize(10, 10);
        button_panel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();

            buttons[i].setPreferredSize(new Dimension(10, 10));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);
        }
        frame.add(button_panel, BorderLayout.CENTER);

        frame.setVisible(true);

        // actionPerformed(e);

    }

    public String playerName() {

        return this.playerName;
    }

    public void checkresult() {

        for (int i = 0; i < 9; i++) {

            if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"
                    && playerturn == true) {

                this.score++;

                reset();

            }

        }

    }

    public void reset() {

        for (int i = 0; i < 9; i++) {

            buttons[i].setText("");
        }

        JLabel scoreLabel = new JLabel("Score: Computer: 0 | " + this.playerName + ": " + this.score);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 50));
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.LIGHT_GRAY);
        scoreLabel.setForeground(Color.BLACK);
        frame.add(scoreLabel, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i] && buttons[i].getText() == "" && playerturn == true) {

                buttons[i].setText("X");
                playerturn = false;

                computerturn = true;
                checkresult();

            }

            if (e.getSource() == buttons[i] && buttons[i].getText() == "" && computerturn == true) {

                buttons[i].setText("O");
                playerturn = true;

                computerturn = false;
                checkresult();

            }

        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}