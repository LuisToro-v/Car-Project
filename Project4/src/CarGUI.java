/**
 * @author Luis Toro
 * @date 4-29-19
 * @lab section: 11E
 * @description: Defines the class CarGUI
 */
import javax.swing.*;   
import java.awt.*;

public class CarGUI {
	private static JFrame frame = new JFrame();
	private static TextArea left = new TextArea();
	private static TextArea right = new TextArea();
	private static Container pane;

	public CarGUI(){
		initializeFrame();
		createFileMenu();
		print();
	}

	private static void initializeFrame() { 
		// initialize the Frame with these set conditions 
		frame.setTitle("Project 4: Car GUI");
		frame.setSize(800,400);
		frame.setLocation(550,300);
		//Grid layout compose of 1 row and 2 columns 
		frame.setLayout(new GridLayout(1,2));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}
	private void createFileMenu( ) {
		JMenuBar menuBar  = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		FileMenuHandler handler  = new FileMenuHandler(this);
		JMenu editMenu = new JMenu("Edit");
		EditMenuHandler Ehandler  = new EditMenuHandler(this);
		JMenuItem item;

		//Creates the open tab
		item = new JMenuItem("Open");
		// event listener for said item
		item.addActionListener(handler);
		// insert item to the menu 
		fileMenu.add( item );
		// insert horizontal separator
		fileMenu.addSeparator();

		//Creates the reset tab for testing purposes
		item = new JMenuItem("Reset");   
		item.addActionListener(handler);
		fileMenu.add( item );
		fileMenu.addSeparator();
		
		//Creates the quit tab
		item = new JMenuItem("Quit");       
		item.addActionListener(handler);
		fileMenu.add( item );
		
		//Creates the Search tab on edit menu
		item = new JMenuItem("Search");       
		item.addActionListener(Ehandler);
		editMenu.add( item );
		
		// set up the menu bar
		frame.setJMenuBar(menuBar); 
		// insert menus to the bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
	} 

	public void print() {
		// text field may not be edited
		left.setEditable(false);
		right.setEditable(false);
		left.setText("");
		right.setText("");
		pane = frame.getContentPane();
		// Text areas are added to the content pane 
		pane.add(left);
		pane.add(right);  
		frame.setVisible(true);
	}
	
	public void setPrint() {
		left.setText("Unsorted Car List: \n");
		right.setText("Sorted Car List: \n");
		left.append(FileMenuHandler.unsortedCar+ ""); 
		right.append(FileMenuHandler.sortedCar + "");
	}
	public void searchPrint(String s) {
		left.setText("Unsorted Car List: \n");
		right.setText("Sorted Car List: \n");
		// These print only cars of said make
		left.append(FileMenuHandler.unsortedCar.searchByMake(s)  + ""); 
		right.append(FileMenuHandler.sortedCar.searchByMake(s)    + "");	
	}
}