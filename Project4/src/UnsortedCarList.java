public class UnsortedCarList extends CarList {
	public UnsortedCarList() {
		super();
	}
	/**
	 *@description: Adds a Car Node to the end of the linked list as read from file
	 * @param d
	 */
	public void add(Car d) {
		append(d);
	}

}

