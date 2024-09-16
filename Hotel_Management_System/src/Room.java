import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;  //importing rs2xml.jar

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,0,600,600);
        add(image);

//        Creating Table with help of class JTable(data,headers) , data aap ka rs2xml.jar ki help se aa jaye ga but headers aapko manually bnane pdege
//        Now we are creating headers

        JLabel l1 = new JLabel("Room No");
        l1.setBounds(10,10,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l1);


        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120,10,100,20);
        l2.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(220,10,100,20);
        l3.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(310,10,100,20);
        l4.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(410,10,100,20);
        l5.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l5);





        table = new JTable();
        table.setBounds(10,40,500,400);
        add(table);

        try{
            conn conn = new conn();
            String query = "Select * from room";
            ResultSet rs = conn.s.executeQuery(query);
//            now here we use rs2xml.jar package to put all data into table
            table.setModel(DbUtils.resultSetToTableModel(rs)); // with help of this all data pass into table
        }
        catch(Exception e){
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true); // Ensure the background color is displayed
        back.setBorderPainted(false);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);


        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new Room();
    }
}
