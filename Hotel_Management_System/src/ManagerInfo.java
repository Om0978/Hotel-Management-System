import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.*;  //importing rs2xml.jar

public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    ManagerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


//        Creating Table with help of class JTable(data,headers) , data aap ka rs2xml.jar ki help se aa jaye ga but headers aapko manually bnane pdege
//        Now we are creating headers

        JLabel l1 = new JLabel("Name");
        l1.setBounds(10,10,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(130,10,100,20);
        l2.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(250,10,100,20);
        l3.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l3);

        JLabel l4 = new JLabel("Job");
        l4.setBounds(385,10,100,20);
        l4.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l4);

        JLabel l5 = new JLabel("Salary");
        l5.setBounds(500,10,100,20);
        l5.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l5);

        JLabel l6 = new JLabel("Phone");
        l6.setBounds(640,10,100,20);
        l6.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l6);

        JLabel l7 = new JLabel("Email");
        l7.setBounds(770,10,100,20);
        l7.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l7);

        JLabel l8 = new JLabel("Aadhar");
        l8.setBounds(890,10,100,20);
        l8.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l8);


        table = new JTable();
        table.setBounds(10,40,989,400);
        add(table);

//        //        these lines will add border to the table
//
//        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        table.setGridColor(Color.BLACK);
//        table.setShowGrid(true);

        try{
            conn conn = new conn();
            String query = "Select * from employee where job = 'Manager'";
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
        back.setBounds(420,500,120,30);
        add(back);


        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
