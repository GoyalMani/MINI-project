package com.company.proemployee;
//this is first class for employee to get and set the value in field
public class Employee {
    private int id;
    private String name;
    private String email;
    private int age;
    public Employee()//constructor with no parameter
    {

    }
    public Employee(int id,String name,String email,int age)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.age=age;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
       return age;
    }

   public void setAge(int  age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

