import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.*;

public class Main extends JFrame implements ActionListener {
    Main(){
        //here we will use swing concept
        // here will create our frame

        // setSize(1366,565);  //setting size of frame setting length , breadth
        // setLocation(100,100);
        setBounds(100,100,1366,565);
        setLayout(null);


//      inserting image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366,565); //locationX,locationY , Length , Breadth
        add(image); //this function will help to add things on frame



//      ADDING TEXT :- Main use of JLabel is to write text on frame
        JLabel text = new JLabel("Hotel Management System");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.white);  // this color class present in awt package
        text.setFont(new Font("serif", Font.PLAIN , 50));
        image.add(text);



//      creating Button :- JButton help to create button
        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        image.add(next); // we want ki button image ke uppr aaye so that we add next button on image
        next.setBackground(Color.WHITE);
        next.setForeground(Color.MAGENTA);

        next.addActionListener(this); // with help of this aap ye pta lga skte ho ki kis button pr click hua hai

        next.setFont(new Font("serif", Font.PLAIN , 24));

        setVisible(true);   // byDefault visibility of frame is false



//      adding Dipper on text
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
    }

//  we implements ActionListener for allowing actions on buttons
    public void actionPerformed(ActionEvent ae){
//      button click pr kay kaam krna hai wo batate hai is button me

        setVisible(false);
        new login(); // calling login constructor and open login page

    }
    public static void main(String[] args) {
        new Main();
    }
}