package spring.boot.grpc.unary.controller;

import com.google.protobuf.Descriptors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.grpc.unary.service.EmployeeService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/getEmployee/{employeeId}")
    public Map<Descriptors.FieldDescriptor,Object> getEmployee(@PathVariable Integer employeeId) {
        return employeeService.getEmployees(employeeId);
    }
}
