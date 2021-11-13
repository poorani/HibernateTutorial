package hibernate.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String JDBCUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pwd = "hbstudent";

        try{
            Connection connection = DriverManager.getConnection(JDBCUrl,user,pwd);
            System.out.println("Connection Succesful");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
