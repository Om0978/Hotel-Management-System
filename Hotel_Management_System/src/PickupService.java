import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;  //importing rs2xml.jar

public class PickupService extends JFrame implements ActionListener {
    JTable table;
    JButton back , submit;
    Choice typeofcar;
    JCheckBox available;
    PickupService(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Type Of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        try{
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            while (rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


//        Creating Table with help of class JTable(data,headers) , data aap ka rs2xml.jar ki help se aa jaye ga but headers aapko manually bnane pdege
//        Now we are creating headers

        JLabel l1 = new JLabel("Name");
        l1.setBounds(30,160,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l1);


        JLabel l2 = new JLabel("Age");
        l2.setBounds(170,160,100,20);
        l2.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300,160,150,20);
        l3.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l3);

        JLabel l4 = new JLabel("Phone Number");
        l4.setBounds(450,160,130,20);
        l4.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l4);

        JLabel l5 = new JLabel("Brand");
        l5.setBounds(600,160,100,20);
        l5.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l5);

        JLabel l6 = new JLabel("Availability");
        l6.setBounds(735,160,100,20);
        l6.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(885,160,100,20);
        l7.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l7);


        table = new JTable();
        table.setBounds(30,200,1000,300);
        add(table);

        try{
            conn conn = new conn();
            String query = "Select * from driver";
            ResultSet rs = conn.s.executeQuery(query);
//            now here we use rs2xml.jar package to put all data into table
            table.setModel(DbUtils.resultSetToTableModel(rs)); // with help of this all data pass into table
        }
        catch(Exception e){
            e.printStackTrace();
        }

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true); // Ensure the background color is displayed
        submit.setBorderPainted(false);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);


        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setOpaque(true); // Ensure the background color is displayed
        back.setBorderPainted(false);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);


        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
//                here we make 2 queries if bed-type is single or double and checkbox is checked or not
                String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";

                conn conn = new conn();
                ResultSet rs = conn.s.executeQuery(query);

                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new PickupService();
    }
}
