/**
 * @author Luis Toro
 * @date 4-8-19
 * @lab section: 11E
 * @description: Defines the class Car
 */
public class Car {
	private String make;
	private String model;
	private int year;
	private int mile;

	@Override
	// convert object to string and displays as read from file format
	public String toString() {
		return  make + ", " + model + ", " + year + ", " + mile;
	}

	public Car(String make, String model, int year, int mile) {  
		if(make == null || model == null) throw new IllegalArgumentException("Bad String");
		if(year < 1900 || mile < 0 ) throw new IllegalArgumentException("Bad Number");
		this.make = make;
		this.model = model;
		this.year = year;
		this.mile = mile;
	}

	// Class setter and getters 
	public void  setMake(String make) {
		if(make == null ) throw new IllegalArgumentException("Bad String");
		this.make = make;
	}

	public String getMake() {
		return make;
	}

	public void setModel(String model) {
		if(model == null ) throw new IllegalArgumentException("Bad String");

		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void  setYear(int year) {
		if(year < 1900 ) throw new IllegalArgumentException("The year must be 1900 or greater");
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void  setMile(int mile) {
		if(mile < 0 ) throw new IllegalArgumentException("Mileage must be 0 or greater");
		this.mile = mile;
	}

	public int getMile() {
		return mile;
	}

	/**
	 * @description: Turn object Car to a string and find its differences to test for letter order
	 * @param other
	 * @return 
	 */
	public int compare(Car other) {
		return this.toString().compareToIgnoreCase(other.toString());

	}

}
