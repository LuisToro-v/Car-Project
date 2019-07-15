import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
public class FileMenuHandler implements ActionListener {
	private static String fileName;
	private static CarGUI car;
	// Car linked list for unsorted car
	   static UnsortedCarList unsortedCar = new UnsortedCarList();
	// Car linked list for sorted car
	   static SortedCarList sortedCar = new SortedCarList();

	public FileMenuHandler (CarGUI c) {
		car = c;
	}
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {
			open();
			// Updates the list
			car.setPrint();
		}
		// Reset for testing purposes
		else if (menuName.equals("Reset")) {
			JOptionPane.showMessageDialog(null,"You clicked Reset"); 
			 unsortedCar = new UnsortedCarList();
			 sortedCar = new SortedCarList();
			 //reset the panel
			 car.print();
		}
		else if (menuName.equals("Quit")) {
			//JOptionPane.showMessageDialog(null,"You clicked Quit"); 
			System.exit(0);
		}
		
	} //actionPerformed
	private void open() {
		//Instantiate JFileChooser
		JFileChooser chooser = new JFileChooser("./");
		//Display files only 
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		chooser.showOpenDialog(null);
		File selected = chooser.getSelectedFile();
		fileName= selected.toString();
		fillList(fileName,unsortedCar,sortedCar);
	}
	private static void fillList (String fileName, UnsortedCarList unsort, SortedCarList sort) {
		TextFileInput myFile = new TextFileInput(fileName); 
		String line = myFile.readLine(); 
		StringTokenizer myToken;
		// counts the number of element in array
		// If there are still more line in file continue
		while(line != null) {
			myToken = new StringTokenizer(line, ","); // Divides elements of line 
			// Only when the line has four valid argument continue the assignment
			if(myToken.countTokens() == 4) {
				// Set the tokens of the line to their respected types
				String make = myToken.nextToken(); 
				String model = myToken.nextToken();
				int year = Integer.parseInt(myToken.nextToken());
				int mile = Integer.parseInt(myToken.nextToken());
				// fills in the car linkedList with parameter from file
				Car fullCar =new Car(make,model,year,mile);
				unsort.add(fullCar);
				sort.add(fullCar);
			}
			else {
				// If four token are not present loop through tokens 
				while(myToken.hasMoreTokens()) {
					// print token 
					System.out.print(myToken.nextToken() + ", ");
				}
				//print the next invalid file line on the next console line  
				System.out.println();
			}
			// read next line of the file
			line = myFile.readLine(); 
		}
	}
}
