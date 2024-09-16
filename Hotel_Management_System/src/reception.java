import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class reception extends JFrame implements ActionListener {
    JButton newCustomer , rooms , department , allEmployee , customers , managerInfo , checkout , update , roomStatus , pickup , searchRoom , logout;
    reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.white);
        newCustomer.setOpaque(true); // Ensure the background color is displayed
        newCustomer.setBorderPainted(false);
        newCustomer.setOpaque(true);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.white);
        rooms.setOpaque(true); // Ensure the background color is displayed
        rooms.setBorderPainted(false);
        rooms.setOpaque(true);
        rooms.addActionListener(this);
        add(rooms);

        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.white);
        department.setOpaque(true); // Ensure the background color is displayed
        department.setBorderPainted(false);
        department.setOpaque(true);
        department.addActionListener(this);
        add(department);

        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setForeground(Color.white);
        allEmployee.setOpaque(true); // Ensure the background color is displayed
        allEmployee.setBorderPainted(false);
        allEmployee.setOpaque(true);
        allEmployee.addActionListener(this);
        add(allEmployee);

        customers = new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.white);
        customers.setOpaque(true); // Ensure the background color is displayed
        customers.setBorderPainted(false);
        customers.setOpaque(true);
        customers.addActionListener(this);
        add(customers);

        managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.white);
        managerInfo.setOpaque(true); // Ensure the background color is displayed
        managerInfo.setBorderPainted(false);
        managerInfo.setOpaque(true);
        managerInfo.addActionListener(this);
        add(managerInfo);

        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.white);
        checkout.setOpaque(true); // Ensure the background color is displayed
        checkout.setBorderPainted(false);
        checkout.setOpaque(true);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        update.setOpaque(true); // Ensure the background color is displayed
        update.setBorderPainted(false);
        update.setOpaque(true);
        update.addActionListener(this);
        add(update);

        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.white);
        roomStatus.setOpaque(true); // Ensure the background color is displayed
        roomStatus.setBorderPainted(false);
        roomStatus.setOpaque(true);
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.white);
        pickup.setOpaque(true); // Ensure the background color is displayed
        pickup.setBorderPainted(false);
        pickup.setOpaque(true);
        pickup.addActionListener(this);
        add(pickup);

        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.white);
        searchRoom.setOpaque(true); // Ensure the background color is displayed
        searchRoom.setBorderPainted(false);
        searchRoom.setOpaque(true);
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        logout.setOpaque(true); // Ensure the background color is displayed
        logout.setBorderPainted(false);
        logout.setOpaque(true);
        logout.addActionListener(this);
        add(logout);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new adddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allEmployee){
            setVisible(false);
            new EmployeesInfo();
        }
        else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateStatus();
        }

        else if(ae.getSource()==roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new PickupService();
        }
        else if(ae.getSource()==checkout){
            setVisible(false);
            new CheckOut();
        }
        else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }

    }
    public static void main(String[] args) {
        new reception();
    }
}
