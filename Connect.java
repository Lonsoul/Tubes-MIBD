// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

// public class Connect {
//     public static void main(String[] args) {
//         String dbURL = "jdbc:sqlserver://localhost;encrypt=true;trustServerCertificate=true;databaseName=TubesMIBD";
//         String user = "sa";
//         String password = "dockerStrongPwd123";

//         Connection conn = null;
//         try {
//             // Register the JDBC driver (optional for newer versions)
//             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

//             // Open a connection
//             conn = DriverManager.getConnection(dbURL, user, password);

//             System.out.println("Connected to the database successfully!");
//         } catch (SQLException | ClassNotFoundException e) {
//             e.printStackTrace();
//         } finally {
//             if (conn != null) {
//                 try {
//                     conn.close();
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }
//     }
// }