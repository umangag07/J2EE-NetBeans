    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class firstjdbc {
    
 public static void main(String[] args) {                      

        Connection conn = null; 

        Statement stmt = null; 

        try{ 

              
//        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbcdb","root","");      

    

        stmt = conn.createStatement(); 

        String sql; 

        sql = "SELECT * from emp"; 

        ResultSet rs = stmt.executeQuery(sql); 

         

        while(rs.next()){    

            System.out.print("ID: " + rs.getInt(1));          

            System.out.print(", Name: " + rs.getString(2)); 

            System.out.print(", Salary: " + rs.getInt(3)); 

            System.out.println();    

      }       

        rs.close(); 

        stmt.close(); 

        conn.close(); 

    }catch(SQLException se){ 

    

      se.printStackTrace(); 

   } 

    } 

     

} 
