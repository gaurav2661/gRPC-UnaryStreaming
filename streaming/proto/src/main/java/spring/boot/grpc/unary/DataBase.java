package spring.boot.grpc.unary;

import grpc.spring.boot.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Employee> getEmployees() {
        return new ArrayList<>(){
            {
               add(Employee.newBuilder()
                       .setEmployeeId(123)
                       .setDesignation("Software Engineer")
                       .setName("John smith").build()) ;
            }
        };
    }
}
