import java.sql.*;
public class conn {

//        Here we will do JDBC connectivity means connection krege database ke saath
//        Here we have 5 steps to do JDBC Connectivity

//        Step1:- Register the driver class :- MYSQL Driver
//        Step2:- Creating the Connection with the connection string
//        Step3:- Creating the statement
//        Step4:- Execute Mysql queries



    Connection c;
    Statement s;
    conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","12345678");
            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new conn();
    }
}
