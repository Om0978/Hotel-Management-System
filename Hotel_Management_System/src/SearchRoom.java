import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;  //importing rs2xml.jar

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back , submit;
    JComboBox bedType;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);


        bedType = new JComboBox(new String[] {"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        add(available);



//        Creating Table with help of class JTable(data,headers) , data aap ka rs2xml.jar ki help se aa jaye ga but headers aapko manually bnane pdege
//        Now we are creating headers

        JLabel l1 = new JLabel("Room No");
        l1.setBounds(40,160,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l1);


        JLabel l2 = new JLabel("Availability");
        l2.setBounds(250,160,100,20);
        l2.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l2);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setBounds(430,160,150,20);
        l3.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(660,160,100,20);
        l4.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l4);

        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(850,160,100,20);
        l5.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l5);





        table = new JTable();
        table.setBounds(60,200,1000,300);
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
                String query1 = "select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
                String query2 = "select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";

                conn conn = new conn();
                ResultSet rs;
                if(available.isSelected()){
                    // agr checkbox selected hai tb query2 run krni hai
                    rs = conn.s.executeQuery(query2);
                }
                else{
                    // agr checkbox selected nhi hai tb query1 run krni hai
                    rs = conn.s.executeQuery(query1);
                }
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
        new SearchRoom();
    }
}
