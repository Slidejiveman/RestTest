package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBDao {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public List<User> getAllUsers() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/iad_school?" //should be school probably
              + "user=webappuser&password=webappuser");

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from student");
      return createUserList(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
  }

  private ArrayList<User> createUserList(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
	  ArrayList<User> userList = new ArrayList<User>();
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String id = resultSet.getString("id");
      String last_name = resultSet.getString("last_name");
      String first_name = resultSet.getString("first_name");
      User user = new User(id, last_name, first_name,"Student");
      userList.add(user);
   
    }
    return userList;
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 
