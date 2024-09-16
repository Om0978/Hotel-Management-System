import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addRooms extends JFrame  implements ActionListener {
    JButton add , cancel;
    JTextField tfroom , tfprice;
    JComboBox typecombo , availablecombo , cleancombo ;
    addRooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);


//        Room Number
        JLabel lblroomno = new JLabel("Rooms Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80,130,30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);


//        Available or not
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String availableOptions[] = {"Available","Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);


//        Cleaning Status
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblclean.setBounds(60,180,130,30);
        add(lblclean);

        String cleanOptions[] = {"Cleaned","Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);


//        Room Price
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblprice.setBounds(60,230,130,30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);


//        Bed Type
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeOptions[] = {"Single Bed","Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);

        add = new JButton("Add Room");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setOpaque(true); // Ensure the background color is displayed
        add.setBorderPainted(false); // Remove the border
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true); // Ensure the background color is displayed
        cancel.setBorderPainted(false); // Remove the border
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try{
                conn conn = new conn();
                String query = "insert into room values ('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null," New Room Added Successfully");

                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new addRooms();
    }
}