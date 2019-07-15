import javax.swing.*;
import java.awt.event.*;
public class EditMenuHandler implements ActionListener {
	private static CarGUI car;
	public EditMenuHandler (CarGUI c) {
		car = c;
	}
	
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		String userInput;
		if (menuName.equals("Search")) {
			userInput = JOptionPane.showInputDialog(null, "Search by make:");
			if(!FileMenuHandler.unsortedCar.isThere(userInput)) 
				JOptionPane.showMessageDialog(null, "Invaild input");
			else car.searchPrint(userInput); 
		}
	}
} 