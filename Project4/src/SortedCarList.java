public class SortedCarList extends CarList {
	public SortedCarList() {
		super();
	}
	/**
	 * @description: Adds a car node to the linked list in a alphabetical way. 
	 * @param d
	 */
	public void add(Car d) {
		CarNode preNode = first ,nxNode = preNode.next;
		CarNode newNode = new CarNode(d);
		// shifts previous and next node through linked list, if not last node and is alphabetically correct  
		while(nxNode !=null && nxNode.data.compare(d) < 0){
			preNode = nxNode; // left-side node is now equal to right-side node
			nxNode = nxNode.next;//right-side node now equal to the node to its right
		}
		//prepend node
		newNode.next = nxNode; // new Car Node points to the next node 
		preNode.next = newNode; // previous node points to the new Car Node
	}
}