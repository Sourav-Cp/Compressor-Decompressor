package GUI;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import compdecomp.Decompress;
import compdecomp.compress;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainFrame extends JFrame implements ActionListener{
    
    JButton CompressButton;
    JButton DecompressButton;

    MainFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);


    CompressButton = new JButton("Click Here");
    CompressButton.setBounds(300,25,100,30);
    CompressButton.addActionListener(this);

    DecompressButton = new JButton("Click Here");
    DecompressButton.setBounds(300,200,100,30);
    DecompressButton.addActionListener(this);

    JLabel l1 = new JLabel("To Compress a File :");
    JLabel l2 = new JLabel("To Decompress a File :");

    l1.setFont(new Font("Verdana",Font.BOLD,20));
    l2.setFont(new Font("Verdana",Font.BOLD,20));

    l1.setBounds(20,25,300,30);
    l2.setBounds(20,200,300,30);

    this.add(CompressButton);
    this.add(DecompressButton);
    this.add(l1);
    this.add(l2);
    this.setSize(600 , 400);
    this.getContentPane().setBackground(Color.blue);
    this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
    if (e.getSource() == CompressButton){
    JFileChooser filechooser = new JFileChooser();
    int response = filechooser.showSaveDialog(null);
    if(response == JFileChooser.APPROVE_OPTION){

    File file = new File(filechooser.getSelectedFile().getAbsolutePath());

    try{
       compress.method(file);
    }
    catch(Exception ee){
    JOptionPane.showMessageDialog(null,ee.toString());
        }
    }
}
    if (e.getSource() == DecompressButton){
    JFileChooser filechooser = new JFileChooser();
    int response = filechooser.showSaveDialog(null);
    if(response == JFileChooser.APPROVE_OPTION){

    File file = new File(filechooser.getSelectedFile().getAbsolutePath());

    try{
      Decompress.method(file);
    }
    catch(Exception ee){
    JOptionPane.showMessageDialog(null,ee.toString());
        }
    }
}
}

    
}
