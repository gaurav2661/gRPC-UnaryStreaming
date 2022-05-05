package spring.boot.grpc.unary.service;

import com.google.protobuf.Descriptors;
import grpc.spring.boot.Employee;
import grpc.spring.boot.EmployeeServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeService {
    @GrpcClient("grpc-client")
    EmployeeServiceGrpc.EmployeeServiceBlockingStub serviceBlockingStub;

    public Map<Descriptors.FieldDescriptor,Object> getEmployees(int employeeId){
        Employee employee = Employee.newBuilder().setEmployeeId(employeeId).build();
        Employee responseEmployee = serviceBlockingStub.getEmployee(employee);
        return responseEmployee.getAllFields();
    }
}
