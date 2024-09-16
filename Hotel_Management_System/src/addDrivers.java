import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDrivers extends JFrame  implements ActionListener {
    JButton add , cancel;
    JTextField tfname , tfage, tfphone , tfmodel, tflocation;
    JComboBox typecombo , availablecombo , agecombo , genderCombo;
    addDrivers(){
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);


        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblname.setBounds(64, 70, 102, 22);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(174, 70, 156, 20);
        add(tfname);


        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(64, 110, 102, 22);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(174, 110, 156, 20);
        add(tfage);


        JLabel lblclean = new JLabel("Gender");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblclean.setBounds(64, 150, 102, 22);
        add(lblclean);

        String cleanOptions[] = {"Male","Female"};
        genderCombo = new JComboBox(cleanOptions);
        genderCombo.setBounds(176, 150, 154, 20);
        genderCombo.setBackground(Color.white);
        add(genderCombo);


        JLabel lblphone = new JLabel("Phone No");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblphone.setBounds(64, 190, 110, 22);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(174, 190, 156, 20);
        add(tfphone);


//        Bed Type
        JLabel lbltype = new JLabel("Car Name");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbltype.setBounds(64, 230, 102, 22);
        add(lbltype);

        tfmodel = new JTextField();
        tfmodel.setBounds(174, 230, 156, 20);
        add(tfmodel);


        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(64, 270, 102, 22);
        add(lblavailable);

        String driverOptions[] = {"Available","Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(176, 270, 154, 20);
        availablecombo.setBackground(Color.white);
        add(availablecombo);


        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbllocation.setBounds(64, 310, 102, 22);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(174, 310, 156, 20);
        add(tflocation);


        add = new JButton("Add Drivers");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setOpaque(true); // Ensure the background color is displayed
        add.setBorderPainted(false); // Remove the border
        add.setBounds(64, 380, 120, 33);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true); // Ensure the background color is displayed
        cancel.setBorderPainted(false); // Remove the border
        cancel.setBounds(198, 380, 111, 33);
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300,200,980,470);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = (String) tfage.getText();
            String gender = (String) genderCombo.getSelectedItem();
            String phone = tfphone.getText();
            String brand = tfmodel.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();

            try{
                conn conn = new conn();
                String query = "insert into driver values ('"+name+"','"+age+"','"+gender+"','"+phone+"','"+brand+"','"+availability+"','"+location+"')";

                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null," New Driver Added Successfully");

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
        new addDrivers();
    }
}

