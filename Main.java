package com.company.proemployee;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
	//EMPLOYEE DAO
        //this will insert method manually
       /* EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

        Employee employee = new Employee();
        employee.setName("Mark");
        employee.setEmail("m@gmail.com");
        employee.setAge(23);

        dao.addEmployee(employee);*/
       // sout("**************");

// use menu option and switch statemente
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        Scanner scanner =new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("Welcome to SqlJava");
            System.out.println("What do you want to do?");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Get all Employee");
            System.out.println("5. Get employee by ID");
            System.out.println("6. Exit ");
            System.out.println("lets start enter your choice");
            int input=scanner.nextInt();

            switch(input) {
                case 1:{
                    // adding employee
                    System.out.println("Enter Name:  ");
                    String name = scanner.next();
                    System.out.println("Enter Email:  ");
                    String email = scanner.next();
                    System.out.println("Enter age");
                    int age =scanner.nextInt();
                    Employee newEmployee = new Employee();
                    newEmployee.setName(name);
                    newEmployee.setEmail(email);
                    newEmployee.setAge(age);
                    dao.addEmployee(newEmployee);
                    break;
            }
                case 2: {
                    //update(update employee where id =2
                    System.out.println("Enter id  you want to update");
                    int j=scanner.nextInt();
                    System.out.println("Enter name ");
                    String name=scanner.next();
                    System.out.println("Enter email");
                    String email= scanner.next();
                    System.out.println("Enter age");
                    int age= scanner.nextInt();
                    Employee employee= new Employee(j,name,email,age);

                    dao.updateEmployee(employee);
                    break;
                }
                case 3: {
                    //delete(delete from employee where id=4
                    System.out.println("Enter id to delete");
                    int i=scanner.nextInt();
                    dao.deleteEmployee(i);

                break;
                }

                case 4:{
                    //get all (select * from employee
                    List<Employee>employees=dao.getEmployee();
                    for (Employee employee:employees){
                        System.out.println(employee);
                    }
                    break;
                }

                case 5:{
                    //get employee by id(select * from employee where id=3
                    System.out.print("Enter id for the record you want to fetch ");
                    int id=scanner.nextInt();
                    Employee employee=dao.getEmployeeById(id);
                    System.out.println(employee);
                    break;


                }

                case 6:{
                    //exit
                    System.out.println("Thank you");
                    System.out.println("exit");
                    break;
                }
                default:
                    System.out.println(" Please choose between 1-6");





            }
        }

    }
}
