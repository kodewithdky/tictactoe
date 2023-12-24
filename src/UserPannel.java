/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserPannel implements ActionListener {

    JFrame jf;
    JLabel jl1, jl2,jl3;
    JTextField jt1, jt2;
    JButton jb;
    JComboBox jcb;
    String[] series={"3","5","7","9"};
    public UserPannel() {
        jf = new JFrame("Tic Tac Toe game by  DK");
        jf.setSize(600, 400);
        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jl1 = new JLabel("Enter Player One: ");
        jl1.setBounds(50, 50, 120, 30);
        jf.add(jl1);

        jt1 = new JTextField("DK");
        jt1.setBounds(200, 50, 250, 40);
        jf.add(jt1);

        jl2 = new JLabel("Enter Player Two: ");
        jl2.setBounds(50, 100, 120, 30);
        jf.add(jl2);

        jt2 = new JTextField("KP");
        jt2.setBounds(200, 100, 250, 40);
        jf.add(jt2);
        
        jl3=new JLabel("Select series:");
        jl3.setBounds(50, 150, 120, 30);
        jf.add(jl3);
        
        jcb=new JComboBox(series);
        jcb.setBounds(200, 150, 250, 40);
        jf.add(jcb);

        jb = new JButton("Star Game");
        jb.setBounds(240, 280, 120, 50);
        jb.addActionListener(this);
        jf.add(jb);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            String player1 = jt1.getText();
            String player2 = jt2.getText();
            String series=(String)jcb.getSelectedItem();
            GamePannel gp = new GamePannel(player1, player2,Integer.parseInt(series));
            gp.openGamePannel();
            jf.setVisible(false);

        }
    }

}
