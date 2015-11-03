import javax.swing.JFrame;

public class CommandCenter extends JFrame{

	boolean loggedIn;
	int permission;
	Floor[] floors;
	
	public CommandCenter(){
		super("Fire & Security Alarm Monitoring Simulation System");
		setSize(800, 550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void turnOn(){
		
	}
	
	public void loadInterface(int permission){
		
	}
	
	public void displayMessage(String message, int severity){
		
	}
	
	private void goToFloor(int floorNumber){
		
	}
	
	private void seeAll(){
		
	}
	
	private void launchWizard(int wizardIndex){
		
	}
	
	public void updateFloor(Floor floor){
		
	}
	
	private void updateCommandCenter(){
		
	}
	
	private class ReportExtractor implements Runnable{

		@Override
		public void run() {
			//TODO establish connection to modules
		}
		
		
	}
}
