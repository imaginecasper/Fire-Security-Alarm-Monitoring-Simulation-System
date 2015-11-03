
import javax.swing.JDialog;

public class Wizard extends JDialog{

  public CommandCenter commandCenter;
  
  public Wizard(CommandCenter commandCenter, String wizardName){
    super(commandCenter, wizardName);
    this.commandCenter = commandCenter;
    setModal(true);
    setSize(450,400);
    setResizable(false);
  }
  
  public abstract String getWizardName();
  
  public abstract void launch();
}
