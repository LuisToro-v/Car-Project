public abstract class CarList{
	protected CarNode first = new CarNode(null);
	protected CarNode last = first;
	protected int length =  0;

	public CarList() {
		//first is the dummy node 
		first = new CarNode(null);
		//last is also a dummy node
		last = first;
		length = 0;
	}

	public void append(Car d) {
		CarNode newNode =  new CarNode(d);
		last.next = newNode; // last node points to new node
		last = newNode; // new node becomes last node
		length++;
	}
	
	public String toString() {
		CarNode p = first.next;
		String returnString = "";
		// Continue filling  string to be return with cars from linked list until there are no more 
		while(p != null) {
			// string to be return equal it previous string and new car string 
			returnString += p.data + "\n"; 
			p = p.next;	// move to next node	
		}
		return returnString;
	}
	// Same as toString but only convert those of said make into a string
	public String searchByMake(String s) {
		CarNode p = first.next;
		String returnString = "";
		while(p != null) {
			if(p.data.getMake().equalsIgnoreCase(s))
			returnString += p.data + "\n"; 
			p = p.next;	
		}
		return returnString;
	}
	// Check if the Make is on list
	public boolean isThere(String s) {
			CarNode p = first.next;
			while(p!= null) {
				if(p.data.getMake().equalsIgnoreCase(s)) return true;
				p = p.next;
			}
			return false;
		}		
	}