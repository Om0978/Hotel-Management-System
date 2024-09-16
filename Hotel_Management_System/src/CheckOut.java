import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomnumber , lblcheckintime , lblcheckouttime;
    JButton checkout , back ;
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,120,30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150,130,120,30);
        add(lblroomnumber);


        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,120,30);
        add(lblcheckin);

        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150,180,200,30);
        add(lblcheckintime);


        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,120,30);
        add(lblcheckout);

        Date date = new Date();
        lblcheckouttime = new JLabel(""+date);
        lblcheckouttime.setBounds(150,230,200,30);
        add(lblcheckouttime);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setOpaque(true);
        checkout.setBorderPainted(false);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

//        adding values of Jlables

        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image2);



        setBounds(300,200,800,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkout){
            // checkout ke time pr customer table me se us customer ka data delete kra hai
            // and room table me se us room ki availability occupied se available krni hai
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where room_number = '"+lblroomnumber.getText()+"'";

            try{
                conn conn = new conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new CheckOut();
    }
}
