import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;  //importing rs2xml.jar

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

//        Creating Table with help of class JTable(data,headers) , data aap ka rs2xml.jar ki help se aa jaye ga but headers aapko manually bnane pdege
//        Now we are creating headers

        JLabel l1 = new JLabel("Departments");
        l1.setBounds(100,10,100,20);
        l1.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l1);

        JLabel l2 = new JLabel("Budget");
        l2.setBounds(350,10,100,20);
        l2.setFont(new Font("Tahoma", Font.BOLD,15));
        add(l2);



        table = new JTable();
        table.setBounds(100,50,500,300);
        add(table);


        try{
            conn conn = new conn();
            String query = "Select * from department";
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
        back.setBounds(280,400,120,30);
        add(back);


        setBounds(400,200,700,480);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new Department();
    }
}
