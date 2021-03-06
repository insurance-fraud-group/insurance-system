package command.menu;

import command.AdjusterCmd;

public enum AdjusterMenu implements Menu{
  EXAMINE("면/부책 검토", AdjusterCmd::examineIndemnity),
  DAMAGE_ADJUSTMENT("손해사정", AdjusterCmd::adjustDamage),
  COMPENSATION("보상", AdjusterCmd::compensate);

  private final String label;
  private final Runnable runnable;

  AdjusterMenu(String label, Runnable runnable) {
    this.label = label;
    this.runnable = runnable;
  }

  public void execute() {
    runnable.run();
  }

  @Override
  public String toString() {
    return this.label;
  }
}
