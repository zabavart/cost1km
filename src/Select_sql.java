import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select_sql {
 
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/company";
    private static final String user = "root";
    private static final String password = "45begala";
 
    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
 
    public static void main(String args[]) {
qw:{    int a=0;
        Scanner st = new Scanner(System.in);
        String query="";
        String query1="";
        
        System.out.println("Все имена и названия на латинице \n"
                +"-----------------------------------------------\n"
                + "Выберите действие: \n"+
                "1) Добавить нового сотрудника в отдел \n"+
                "2) Вывести всех сотрудников определенного отдела \n"+
                "3) Вывод всех подчиненных определенного руководителя");
        System.out.print("Введите номер действия: ");
        
        Scanner sc = new Scanner(System.in); 
        a = sc.nextInt();
        
        System.out.println();
        if (a!=1 && a!=2 && a!=3) System.exit(0);
        
        //возможность добавление новых сотрудников в отделы
        if (a==1){ 
            
        String FIO=""; 
        String bossname="";
        String otdel_name="";
        int id_otdel=0;
        int idboss=0;
        System.out.print("Введите название отдела:"); otdel_name=st.nextLine(); 
        System.out.print("Введите Фамилию:"); FIO=st.nextLine(); 
        System.out.println();
        
        query = "Select idOtdel from Otdel where otdel_name=\""+otdel_name+"\";";
        
                    try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                id_otdel = rs.getInt(1);
                }
 
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
       }
                    
        int idboss1=idboss;            
        int id_otdel1=id_otdel;         
        query = "insert into sotrud (FIO, id_Otdel)\n" +
        "VALUES ('"+FIO+"','"+id_otdel1+"');";
                try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            stmt.executeUpdate(query);
            
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
       }
            System.out.println("Сотрудник добавлен\n"); 
        }
        
        
    
        
        //возможность вывода всех сотрудников заданного отдела.
        if(a==2) { 
        String Otdel_name="";
        
        System.out.print("Введите название отдела:"); Otdel_name=st.nextLine();
            query = "SELECT idSotrud, FIO, id_boss FROM company.sotrud s "
                    + "inner join company.otdel o on (id_Otdel=idOtdel)where Otdel_name=\""+Otdel_name+"\";";
            System.out.println();
            System.out.println("Сотрудники отдела "+Otdel_name);
            System.out.println("--------------------------------");
            
            try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                int id_boss = rs.getInt(3);
                System.out.print("idSotrud:"+id+" FIO:"+FIO+" id_boss:"+id_boss+"\n");
            }
            
           
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
       }

            }
        
        //возможность вывода всех подчиненных определенного руководителя.        
        if(a==3){
        String FIO_Boss="";
        System.out.print("Введите Фамилию руководителя:");
        FIO_Boss=st.nextLine();
        int idboss=0;
        query1="SELECT idSotrud FROM sotrud WHERE FIO=\""+FIO_Boss+"\";";
               
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            rs = stmt.executeQuery("SELECT idSotrud FROM sotrud WHERE FIO=\""+FIO_Boss+"\";");
            
            while (rs.next()) {
                idboss = rs.getInt(1);
                }
            
             
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
       }

        int idboss1=idboss;
        query="SELECT idSotrud, FIO, id_boss FROM sotrud WHERE id_boss="+idboss1+" \n" +
                "union\n" +
                " select s1.idSotrud, s1.FIO, s1.id_boss from sotrud s1, sotrud s2\n" +
                " where s1.id_boss=s2.idSotrud and s2.id_boss="+idboss1+";";
           System.out.println();
           System.out.println("Подчиненные "+FIO_Boss+":" );     
           System.out.println("--------------------------------");
             try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
 
            // getting Statement object to execute query
            stmt = con.createStatement();
 
            // executing SELECT query
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String FIO = rs.getString(2);
                int id_boss = rs.getInt(3);
                System.out.print("id:"+id+" Name:"+FIO+" id_boss:"+id_boss+"\n");
            }
 
 
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
       }
            }
        
       
}
}
}