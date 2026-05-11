package com.employee;

import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

      label:
      while (true) {
        try {

          System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("1. VIEW EMPLOYEES");
            System.out.println("2. CREATE EMPLOYEE");
            System.out.println("3. UPDATE EMPLOYEE");
            System.out.println("4. DELETE EMPLOYEE");
            System.out.println("5. FIND EMPLOYEE");
          System.out.println("(Any other number to quit)");

            System.out.println("CHOOSE AN OPTION: ");

          String choice = sc.nextLine();

            EmployeeRepository repo = new EmployeeRepository();
            switch (choice) {
                case "1":

                    repo.getAllEmployees();
                    break;
                case "2": {
                    System.out.println("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Employee Division: ");
                    String role = sc.nextLine();
                    System.out.println("Enter Employee Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    EmployeeModel newEmp = new EmployeeModel(name, role, salary);

                    repo.addEmployee(newEmp);
                    break;
                }
                case "3": {
                    System.out.println("Enter Employee ID: ");
                    int id = sc.nextInt();
                    EmployeeModel oldData = repo.getEmployeeData(id);
                    sc.nextLine();

                    System.out.println("Update Employee Name (leave blank to keep \'"+ oldData.getName() +"\'): ");
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        name = oldData.getName();
                    }

                    System.out.println("Update Employee Division (leave blank to keep \'"+ oldData.getDivision() +"\'): ");
                    String division = sc.nextLine();
                    if (division.isEmpty()) {
                        division = oldData.getDivision();
                    }

                    System.out.println("Update Employee Salary (leave blank to keep "+ oldData.getSalary() +"): ");
                    String salary = sc.nextLine();
                    double newSalary;
                    if (salary.isEmpty()) {
                        newSalary = oldData.getSalary();
                    } else{
                        newSalary = Double.parseDouble(salary);
                    }

                    EmployeeModel updatedEmp = new EmployeeModel(name, division, newSalary);

                    repo.updateEmployee(id, updatedEmp);
                    break;
                }
                case "4": {
                    System.out.println("Enter Employee ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    repo.deleteEmployee(id);
                    break;
                }
                case "5": {
                  System.out.println("1. By ID\n2. By name\n3. By Division");
                  choice = sc.nextLine();
                  switch (choice) {
                    case "1":
                      System.out.println("Enter Employee ID: ");
                      int id = sc.nextInt();
                      sc.nextLine();
                      repo.findById(id);
                      break;

                    case "2":
                      System.out.println("Enter Employee Name: ");
                      String name = sc.nextLine();

                      repo.findByName(name);
                      break;

                    case "3":
                      System.out.println("Enter Employee Division: ");
                      String div = sc.nextLine();
                      repo.findByDivision(div);
                      break;

                    default:
                      System.out.println("Wrong choice");
                  }

                  break;
                }
                default:
                    System.out.println("Application quit.");
                    break label;
            }

            System.out.println("Press any key to continue...");
            sc.nextLine();
            System.out.print("\n\n\n\n\n\n\n");

        } catch (Exception e) {
          System.out.println("Invalid input: ");
          System.out.println(e.getMessage());
          sc.nextLine();
        }

      }


  }
}
