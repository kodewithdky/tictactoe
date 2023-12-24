/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WhoWinSeries {

    public WhoWinSeries(String message) {
        JFrame jf=new JFrame();
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        
        JLabel jl=new JLabel(message);
        jl.setBounds(50, 100, 300, 50);
        jl.setFont(new Font("DK", 1, 30));
        jf.add(jl);
        
        jf.setVisible(true);
    }
   
}
