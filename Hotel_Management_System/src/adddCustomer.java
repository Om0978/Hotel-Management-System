import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class adddCustomer extends JFrame implements ActionListener {
    JComboBox comboId;
    JTextField tfnumber , tfname , tfcountry , tfdeposit;
    JRadioButton rmale , rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    adddCustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblid);

        String options[] = {"Aadhar Card","Passport","Driving License","Voter-id Card","Ration Card"};
        comboId = new JComboBox(options);
        comboId.setBounds(200,80,150,25);
        comboId.setBackground(Color.white);
        add(comboId);


        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.white);
        rmale.setBounds(200,200,100,25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.white);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);


        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lblroom);

        // Choice is work like JComboBox but in Choice you can add items
        croom = new Choice();
        // extracting data from room table
        try{
            conn conn = new conn();
            String query = "Select * from room where availability = 'Available' ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("room_number"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,280,150,25);
        add(croom);


        JLabel lbltime = new JLabel("Checkin Time");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbltime);

        Date date = new Date();

        checkintime = new JLabel(""+date);
        checkintime.setBounds(200,320,150,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkintime);


        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,360,100,20);
        lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);


        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setOpaque(true); // Ensure the background color is displayed
        add.setBorderPainted(false);
        add.setBounds(50,410,120,30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setOpaque(true);
        back.setBorderPainted(false);
        back.setBounds(200,410,120,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);


        setBounds(350,200,800,550);
        setVisible(true);
    }

    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id = (String) comboId.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }
            else{
                gender = "Female";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try{
                String query = "insert into customer values('"+id+ "','"+number+ "','"+name+ "','"+gender+ "','"+country+ "','"+room+ "','"+time+ "','"+deposit+"')";
                String query2 = "update room set availability = 'Occupied' where room_number = '"+room+"'";

                conn conn = new conn();
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
                setVisible(false);
                new reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new reception();
        }
    }
    public static void main(String[] args) {
        new adddCustomer();
    }
}
