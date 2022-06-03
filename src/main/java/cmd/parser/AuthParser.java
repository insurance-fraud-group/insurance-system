package cmd.parser;

import domain.enums.EmployeeType;
import java.util.Arrays;

public class AuthParser extends Parser {

  private static class InstanceHolder {

    private static final AuthParser INSTANCE = new AuthParser();
  }

  private AuthParser() {
    super();
  }

  public static AuthParser getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public void initialize() {
    System.out.println("Auth");
  }

  public EmployeeType getEmployeeType() {
    System.out.println("직군을 선택해주세요");
    Arrays.stream(EmployeeType.values()).forEach(type -> {
      System.out.println(
          Integer.toString(type.ordinal() + 1)
              .concat(". ")
              .concat(type.name()));
    });

    System.out.print("직군 : ");
    while (!sc.hasNextInt()) {
      sc.next();
      System.out.println("Please enter a number within the range.");
    }

    int employeeType = sc.nextInt();
    return (employeeType < 1 || employeeType > EmployeeType.values().length) ? getEmployeeType()
        : EmployeeType.values()[employeeType - 1];
  }

  public String getEmail() {
    System.out.print("이메일 : ");
    return sc.next();
  }

  public String getPassword() {
    System.out.print("패스워드 : ");
    return sc.next();
  }

  public String getName() {
    System.out.print("이름 : ");
    return sc.next();
  }
}