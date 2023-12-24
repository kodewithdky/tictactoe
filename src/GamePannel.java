/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @Dharmendra Kumar Yadav
 */
public class GamePannel implements ActionListener {

    JFrame jf;
    JButton[] jb = new JButton[10];
    int count = 0;
    String xo_value = "", title_str;
    boolean win = false;
    Color color1;
    String player1, player2;
    String player_how_wins;
    boolean player1_turm = true;
    int total_series;
    int series_count = 1;
    int player1_win_count = 0, player2_win_count = 0;

    public GamePannel(String player1, String player2, int total_series) {
        this.player1 = player1;
        this.player2 = player2;
        this.total_series = total_series;
    }

    void openGamePannel() {
        jf = new JFrame();
        jf.setTitle(player1 + " (x) turns");
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(3, 3));
        for (int i = 1; i < 10; i++) {
            jb[i] = new JButton();
            jb[i].addActionListener(this);
            jf.add(jb[i]);
        }
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count += 1;
        if (player1_turm == true) {
            color1 = Color.green;
            xo_value = "x";
            title_str = "0";
            jf.setTitle(player2 + " (" + title_str + ") turns");
            player1_turm = false;
        } else {
            color1 = Color.yellow;
            xo_value = "0";
            title_str = "x";
            jf.setTitle(player1 + " (" + title_str + ") turns");
            player1_turm = true;
        }
        for (int i = 1; i < 10; i++) {
            if (e.getSource() == jb[i]) {
                jb[i].setBackground(color1);
                jb[i].setFont(new Font("DK", 1, 50));
                jb[i].setText(xo_value);
                jb[i].setEnabled(false);
            }
        }
        winningPossibilities();
        howWins();

    }

    void winningPossibilities() {
        if (jb[1].getText() == jb[2].getText() && jb[2].getText() == jb[3].getText() && jb[3].getText() != "") {
            win = true;
        } else if (jb[4].getText() == jb[5].getText() && jb[5].getText() == jb[6].getText() && jb[6].getText() != "") {
            win = true;
        } else if (jb[7].getText() == jb[8].getText() && jb[8].getText() == jb[9].getText() && jb[9].getText() != "") {
            win = true;
        } else if (jb[1].getText() == jb[4].getText() && jb[4].getText() == jb[7].getText() && jb[7].getText() != "") {
            win = true;
        } else if (jb[2].getText() == jb[5].getText() && jb[5].getText() == jb[8].getText() && jb[8].getText() != "") {
            win = true;
        } else if (jb[3].getText() == jb[6].getText() && jb[6].getText() == jb[9].getText() && jb[9].getText() != "") {
            win = true;
        } else if (jb[1].getText() == jb[5].getText() && jb[5].getText() == jb[9].getText() && jb[9].getText() != "") {
            win = true;
        } else if (jb[3].getText() == jb[5].getText() && jb[5].getText() == jb[7].getText() && jb[7].getText() != "") {
            win = true;
        } else {
            win = false;
        }
    }

    void howWins() {
        if (win == true) {
            series_count += 1;
            if (xo_value.equals("x")) {
                player_how_wins = player1;
                player1_win_count += 1;
            } else {
                player_how_wins = player2;
                player2_win_count += 1;
            }
            String win_title = player_how_wins + " (" + xo_value + ") wins";
            jf.setTitle(win_title);
            JOptionPane.showMessageDialog(jf, win_title);
            reStartGame();
        } else if (win == false && count == 9) {
            series_count += 1;
            JOptionPane.showMessageDialog(jf, "Game Over");
            reStartGame();
        }
    }

    void reStartGame() {
        if (total_series >= series_count) {
            int i = JOptionPane.showConfirmDialog(jf, "Do you want to restart game?");
            if (i == 0) {
                for (int j = 1; j < 10; j++) {
                    jb[j].setText("");
                    jb[j].setBackground(null);
                }
                btnSetEnabling(true);
                count = 0;
                if (player_how_wins.equals(player1)) {
                    player1_turm = true;
                } else {
                    player1_turm = false;
                }
                win = false;
                jf.setTitle(player_how_wins + " (" + xo_value + ") turns");
            } else if (i == 1) {
                System.exit(0);
            } else {
                btnSetEnabling(false);

            }
        } else {
            JOptionPane.showMessageDialog(jf, "Series is completed...!!");
            if (player1_win_count > player2_win_count) {
                //JOptionPane.showMessageDialog(jf, player1+" Win the series!");
                new WhoWinSeries(player1 + " Win the series!");
                jf.setVisible(false);

            } else if (player2_win_count > player1_win_count) {
                //JOptionPane.showMessageDialog(jf,player2+" wint the siries!");
                new WhoWinSeries(player2 + " Win the series!");
                jf.setVisible(false);
            } else {
                //JOptionPane.showMessageDialog(jf, "Series Draw!");
                new WhoWinSeries("Series Draw!");
                jf.setVisible(false);
            }
        }

    }
    void btnSetEnabling(boolean b) {
        for (int i = 1; i < 10; i++) {
            jb[i].setEnabled(b);

        }

    }

}
