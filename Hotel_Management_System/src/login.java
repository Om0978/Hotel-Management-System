import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements  ActionListener{
    JTextField username , password;
    JButton login , cancel;
    login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

//      Creating textFiled for this you have a class called JTextField
//      we make this JTextField username and password global accessed because we have to use these in actionPerformed so we make it global access
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);

        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);


//      we make this login and cancle global access so that its scope will be present in actionPerformed function
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setOpaque(true); // Ensure the background color is displayed
        login.setBorderPainted(false); // Remove the border
        login.addActionListener(this);
        add(login);


        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setOpaque(true); // Ensure the background color is displayed
        cancel.setBorderPainted(false); // Remove the border
        cancel.addActionListener(this);
        add(cancel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT); // set image size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,200,200);
        add(image);

        setBounds(500,200,600,300);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
//          with help of getText() function you can get the value of input field and it returns string value
            String user = username.getText();
            String pass = password.getText();

//          now we will check through database by hit the query to check for login details
            try{
                conn c = new conn(); //making connection to databsse

                String query = "select * from login where username ='"+user+"' and password='"+pass+"'";

                // when we just read data from database then we use executeQuery() function
                ResultSet rs = c.s.executeQuery(query); // it execute our sql query here we use object of conn class and then use s (statement ) for executing query


                if(rs.next()){
                    new dashboard();// if query matches the details then open dashboard { creating object of dashboard class }
                    setVisible(false);
                }
                else{
//                   with help of JOptionPane a pop-up shown in window
                    JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
                    setVisible(false);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
