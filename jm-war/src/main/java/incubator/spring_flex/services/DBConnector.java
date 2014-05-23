package incubator.spring_flex.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnector {
    public static Boolean getConnection(String login,String pass) {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test_db";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "December12";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT login,pass FROM table_name");
            while (res.next()) {
                String loginDB = res.getString("login");
                String passDB = res.getString("pass");
                if(login.equals(loginDB)&&pass.equals(passDB)){
                    conn.close();
                    return true;                                                                } else {
                    conn.close();
                    return  false;
                }
            }
           /* int val = st.executeUpdate("INSERT into event VALUES(" + 1 + "," + "'Easy'" + ")");
            if (val == 1) System.out.print("Successfully inserted value");*/
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;

    }
}

