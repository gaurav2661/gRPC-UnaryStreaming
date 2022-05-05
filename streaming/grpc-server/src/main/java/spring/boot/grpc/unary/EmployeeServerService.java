package spring.boot.grpc.unary;

import grpc.spring.boot.Employee;
import grpc.spring.boot.EmployeeServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EmployeeServerService extends EmployeeServiceGrpc.EmployeeServiceImplBase {
    @Override
    public void getEmployee(Employee request, StreamObserver<Employee> responseObserver) {
        DataBase.getEmployees()
                .stream()
                .filter(employee -> employee.getEmployeeId() == request.getEmployeeId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}
