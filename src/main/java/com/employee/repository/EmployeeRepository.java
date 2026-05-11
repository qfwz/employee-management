package com.employee.repository;

import com.employee.config.DatabaseConfig;
import com.employee.model.EmployeeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeRepository {

    // CREATE
    public void addEmployee(EmployeeModel emp) {

        String sql = "INSERT INTO employees(name, division, salary) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDivision());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();

            System.out.println("Employee added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public void getAllEmployees() {

        String sql = "SELECT * FROM employees";

        try (Connection conn = DatabaseConfig.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n=== Employee List ===");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("division") + " | " +
                                rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ BY ID
    public void getEmployeeById(int id) {

        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("division") + " | " +
                                rs.getDouble("salary")
                );
            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateEmployee(int id, EmployeeModel emp) {

        String sql = "UPDATE employees SET name=?, division=?, salary=? WHERE id=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDivision());
            ps.setDouble(3, emp.getSalary());
            ps.setInt(4, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated");
            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteEmployee(int id) {

        String sql = "DELETE FROM employees WHERE id=?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted");
            } else {
                System.out.println("Employee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    FIND BY ID
    public void findById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("=== Employee Found ===");
                System.out.println("ID       : " + rs.getInt("id"));
                System.out.println("Name     : " + rs.getString("name"));
                System.out.println("Division : " + rs.getString("division"));
                System.out.println("Salary   : " + rs.getInt("salary"));
            } else {
                System.out.println("Employee not found");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EmployeeModel getEmployeeData(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new EmployeeModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );

            } else {
                System.out.println("Employee not found");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



//    FIND BY NAME
    public  void findByName(String name) {
        String sql = "SELECT * FROM employees WHERE name = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                System.out.println("=== Employee Found ===");
                System.out.println("ID      : " + rs.getString("id"));
                System.out.println("Name      : " + rs.getString("name"));
                System.out.println("Division : " + rs.getString("division"));
                System.out.println("Salary   : " + rs.getInt("salary"));
                found = true;
            }
            if (!found) {
                System.out.println("Employee not found");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }



    //    BY ROLE
    public  void findByDivision(String division) {
        String sql = "SELECT * FROM employees WHERE division = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, division);

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                System.out.println("=== Employee Found ===");
                System.out.println("ID      : " + rs.getString("id"));
                System.out.println("Name      : " + rs.getString("name"));
                System.out.println("Division : " + rs.getString("division"));
                System.out.println("Salary   : " + rs.getInt("salary"));
                found = true;
            }
            if (!found) {
                System.out.println("Employee not found");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}