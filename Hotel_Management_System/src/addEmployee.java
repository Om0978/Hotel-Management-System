import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addEmployee extends JFrame implements ActionListener {
    JTextField tfname , tfemail , tfphone , tfage , tfsalary , tfaadhar;
    JRadioButton rbmale , rbfemale;
    JButton submit;
    JComboBox cbjob;
    addEmployee(){
        setLayout(null);

//        name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);


//        age
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);


//        gender
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblgender);

        // these are radio buttons
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280,130,90,30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN,14));
        add(rbfemale);

        // we used this so that if male radio-button is selected then we can not select female radio-button
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);


//        job
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lbljob);

        // here we make drop-down
        String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
        cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);


//        salary
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);


//        phone

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);


//        email
        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60,330,330,30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60,380,330,30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

//        submit button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setOpaque(true); // Ensure the background color is displayed
        submit.setBorderPainted(false); // Remove the border
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

//        adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT); // with help of this we can scale the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370); // with help of this we can crope the image
        add(image);

        getContentPane().setBackground(Color.white);
        setBounds(350 ,200,850,540);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }
        else if(rbfemale.isSelected()){
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem(); // cbjob.getSelectedItem() this return object so we typecast it to String


//        validation ***********************************************************************************
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty !!");
            return;
        }
        if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age should not be empty !!");
            return;
        }
//        if(email.equals("")){
//            JOptionPane.showMessageDialog(null,"Email should not be empty !!");
//            return;
//        }
//        if(aadhar.equals("")){
//            JOptionPane.showMessageDialog(null,"Aadhar should not be empty !!");
//            return;
//        }



//        Database work

        try{
            conn conn = new conn();

            String query = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";

            // when we want to update database then we have to use executeUpdate() function
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
       new addEmployee();
    }
}
