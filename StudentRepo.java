package com.itsc.labExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentRepo {

  public void createDBAndTable() {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root",
        "tamr@miracle24!")) {
      Statement statement = connection.createStatement();
      statement.executeUpdate("CREATE DATABASE IF NOT EXISTS StudentDatabase");
      statement.executeUpdate("USE StudentDatabase");
      statement.executeUpdate("CREATE TABLE IF NOT EXISTS Students (" +
          "id INT PRIMARY KEY, " +
          "name VARCHAR(100), " +
          "email VARCHAR(100))");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void insertIntoTable(Student student) {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentDatabase", "root",
        "password")) {
      String query = "INSERT INTO Students (id, name, email) VALUES (" + student.getId() + ", '" + student.getName()
          + "', '" + student.getEmail() + "')";
      Statement statement = connection.createStatement();
      statement.executeUpdate(query);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
