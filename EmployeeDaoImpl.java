package com.company.proemployee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao
{
    Connection connection;
    public EmployeeDaoImpl()  {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
   public  void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee(name,email,age) values (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setString(2, employee.getEmail());
        preparedStatement.setInt(3, employee.getAge());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Employee employee");
        else
            System.out.println("something went wrong!");
    }



    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String sql="update employee set name =?,email=?,age=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getEmail());
        preparedStatement.setInt(3,employee.getAge());
        preparedStatement.setInt(4,employee.getId());
        int count= preparedStatement.executeUpdate();
             if (count>0)
                 System.out.println("Record updated");
             else
                 System.out.println("failed to updated");

    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
     String sql1=" delete from employee where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1,id);
        int count=preparedStatement.executeUpdate();
        if (count>0)
            System.out.println("Record deleted");
        else
            System.out.println("Deletion operation failed ");
    }

   /* @Override// use when in main inserting manully
    public List<Employee> getEmployee() throws SQLException {
        return null;
    }*/

    @Override
    public List<Employee> getEmployee() throws SQLException {
        //return null;used when only using addemployee
        List<Employee>employees=new ArrayList<>();
        String sql="Select * from employee";
        Statement statement=connection.createStatement();
        ResultSet resultset =statement.executeQuery(sql);
        while (resultset.next()){
            int id =resultset.getInt(1);
            String name=resultset.getString(2);
            String email=resultset.getString(3);
            int age =resultset.getInt(4);
            Employee employee =new Employee(id,name,email,age);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) throws SQLException {
     Employee employee = new Employee();
        String sql = "select * from employee where id=" + id;
     Statement statement=connection.createStatement();
     ResultSet rs = statement.executeQuery(sql);
     rs.next();
     if(rs!=null)
     {
         int id1 = rs.getInt(1);
         String name = rs.getString(2);
         String email=rs.getString(3);
         int age=rs.getInt(4);
         employee = new Employee(id1,name,email,age);

     }
     else {
         System.out.println("Record not found");
     }

      return employee;

    }
}

