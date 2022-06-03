package service.impl;

import domain.Employee;
import utils.dto.AuthDto;
import repository.EmployeeRepository;
import service.AuthService;

public class AuthServiceImpl implements AuthService {

  private final EmployeeRepository employeeRepository;

  public AuthServiceImpl() {
    employeeRepository = new EmployeeRepository();
  }

  @Override
  public AuthDto.SignupResponse signup(AuthDto.SignupRequest request) {
    Employee employee = Employee.builder().employeeType(request.getEmployeeType())
        .email(request.getEmail()).password(request.getPassword()).name(request.getName()).build();

    employeeRepository.save(employee);

    return AuthDto.SignupResponse.builder().employeeType(employee.getEmployeeType())
        .name(employee.getName()).build();
  }

  @Override
  public AuthDto.SigninResponse signin(AuthDto.SigninRequest request) {
    Employee employee = employeeRepository.findBy("email", request.getEmail());

    if (request.getPassword().equals(employee.getPassword())) {
      return AuthDto.SigninResponse.builder().employeeType(employee.getEmployeeType())
          .name(employee.getName()).build();
    }

    return null;
  }
}
