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
//import java.util.Timer;
import javax.swing.Timer;

import javax.swing.*;
//import java.awt.event.*;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel button_panel = new JPanel();
    Random random = new Random();
    JButton[] buttons = new JButton[9];
    String player1Name = "";
    String player2Name = "";
    boolean firstround = true;
    int score1 = 0;
    int score2 = 0;
    boolean player1turn = true;
    boolean player2turn = false;
    boolean wait = false;
    JLabel scoreLabel;

    public TicTacToe() {
        if (firstround == true) {

            firstround = false;
            this.player1Name = JOptionPane.showInputDialog(frame, "Player 1, Please Enter your name:", "Player1 Name",
                    JOptionPane.PLAIN_MESSAGE);
            if (this.player1Name == null || player1Name.trim().isEmpty()) {
                this.player1Name = "Player1";
            }

            this.player2Name = JOptionPane.showInputDialog(frame, "Player 2, Please Enter your name:", "Player2 Name",
                    JOptionPane.PLAIN_MESSAGE);
            if (this.player2Name == null || player2Name.trim().isEmpty()) {
                this.player1Name = "Player2";
            }

        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLayout(new BorderLayout());

        scoreLabel = new JLabel(
                "Score: " + this.player1Name + " (X): " + this.score1 + " | " + this.player2Name + " (O): "
                        + this.score2 + "\n\n " + this.player1Name + "'s turn");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
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

    }

    public String player1Name() {

        return this.player1Name;
    }

    public void checkresult() {

        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

        if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"
                && player2turn == true) {

            player2turn = false;
            player1turn = true;

            this.score1++;

            Timer timer = new Timer(1000, e -> reset());
            timer.setRepeats(false);
            timer.start();

        }

    }

    public void reset() {

        for (int i = 0; i < 9; i++) {

            buttons[i].setText("");
        }

        scoreLabel = new JLabel(
                "Score: " + this.player1Name + " (X): " + this.score1 + " | " +
                        this.player2Name + " (O): "
                        + this.score2 + "\n\n " + this.player1Name + "'s turn");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setOpaque(true);
        scoreLabel.setBackground(Color.LIGHT_GRAY);
        scoreLabel.setForeground(Color.BLACK);
        frame.add(scoreLabel, BorderLayout.NORTH);

    }

    public void updateScoreLabel() {
        String currentPlayer = player1turn ? this.player1Name : this.player2Name;
        scoreLabel.setText("Score: " + this.player1Name + " (X): " + this.score1 + " | " + this.player2Name + " (O): "
                + this.score2 + "\n\n " + currentPlayer + "'s turn");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i] && buttons[i].getText() == "" && player1turn == true) {

                buttons[i].setText("X");
                player1turn = false;

                player2turn = true;

                // checkresult();

            }

            else if (e.getSource() == buttons[i] && buttons[i].getText() == "" && player2turn == true) {

                buttons[i].setText("O");
                player1turn = true;

                player2turn = false;
                // checkresult();

            }

            checkresult();
            updateScoreLabel();
            // break;

        }

        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

}