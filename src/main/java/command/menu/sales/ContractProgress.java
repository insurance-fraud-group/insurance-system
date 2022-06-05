package command.menu.sales;

import command.SalesCommand;
import command.menu.Menu;
import domain.Contract;
import java.util.function.Consumer;

public enum ContractProgress implements Menu {

  ContractConclusion("계약 체결", (contract) -> SalesCommand.concludeContract(contract)),
  ContractRejection("계약 거절", (contract) -> SalesCommand.rejectContract(contract));

  private final String label;
  private final Consumer<Contract> operator;

  ContractProgress(String label, Consumer<Contract> operator) {
    this.label = label;
    this.operator = operator;
  }

  public void execute(Contract contract) {
    operator.accept(contract);
  }

  @Override
  public void execute() {

  }

  @Override
  public String toString() {
    return this.label;
  }
}
