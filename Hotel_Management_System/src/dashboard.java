import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {
    JButton add;
    dashboard(){
        setLayout(null);
        setBounds(0,0,1550,1000);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);


//      Creating Menu :- Here we have classes for menu

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb); // Use setJMenuBar instead of add

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);

        JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        /* when we have buttons then we use ar.gerSource == button but here we have menu items so for that use getActionCommand() */

        if(ae.getActionCommand().equals("RECEPTION")){
            new reception();
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new addEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new addRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new addDrivers();
        }

    }

    public static void main(String[] args) {
        new dashboard();
    }
}
