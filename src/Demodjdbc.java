import java.sql.*; /* step 1 - import the package*/

public class Demodjdbc {
    public static void main(String[] args){
        /*
        * Steps to connect to DB
        * 1. import package
        * 2. load and register (optional coz its is done behind the scenes since java4)
        * 3. create a connection
        * 4. create a statement
        * 5. execute the statement
        * 6 process the results
        * 7. close the connection
        * */

        String url = "jdbc:postgresql://localhost:5432/demojavadb";
        String username = "postgres";
        String password = "kal123";
//        String sqlQuery = "SELECT * FROM students";
//        String sqlQuery = "SELECT * FROM students  WHERE \"Sid\" = 1";
        String sqlQuery = "INSERT INTO students values (6, 59, 'John')";

        try {
//        step 2
            Class.forName("org.postgresql.Driver");

//            step 3 create a connection to DB. e use the Connection interface from the package
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("connection established");

//            step 4 create a statement
            Statement st = con.createStatement();

//            step 5 execute a statement
//            ResultSet results = st.executeQuery(sqlQuery);
//            System.out.println(results.next());
            boolean status =  st.execute(sqlQuery);

            System.out.println(status);

//            while (results.next()) {
//                System.out.println(results.getInt(2));
//            }

            con.close();
            System.out.println("connection closed");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
