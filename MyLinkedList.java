package stable;

public class MyLinkedList<T> {

	private static int counter;
	private Node<T> head;
 
	// Default constructor
	public MyLinkedList() {
 
	}
	
	// appends the specified element to the end of this list.
		public void add(T data) {
	 
			// Initialize Node only for 1st element
			if (head == null) {
				head = new Node<T>(data);
			}
	 
			Node<T> temp = new Node<T>(data);
			Node<T> current = head;
	 
			if (current != null) {
	 
				// starting at the head node, move to the end of the list and then add element after last node
				while (current.getNext() != null) {
					current = current.getNext();
				}
	 
				current.setNext(temp);
			}
	 
			// increment the number of elements variable
			incrementCounter();
		}
		
		private static int getCounter() {
			return counter;
		}
	 
		private static void incrementCounter() {
			counter++;
		}
	 
		private void decrementCounter() {
			counter--;
		}
		
		public void add(T data, int index) {
			Node<T> temp = new Node<T>(data);
			Node<T> current = head;
	 
			if (current != null) {
				for (int i = 0; i < index && current.getNext() != null; i++) {
					current = current.getNext();
				}
			}
	 
			temp.setNext(current.getNext());
	 
			current.setNext(temp);
	 
			incrementCounter();
		}
		
	 
		// returns the element at the specified position in this list.
		public T get(int index)
		{
			if (index < 0)
				return null;
			Node<T> current = null;
			if (head != null) {
				current = head.getNext();
				for (int i = 0; i < index; i++) {
					if (current.getNext() == null)
						return null;
	 
					current = current.getNext();
				}
				return current.getData();
			}
			return null; //current
	 
		}
	 
		// removes the element at the specified position in this list.
		public boolean remove(int index) {
	 
			if (index < 1 || index > size())
				return false;
	 
			Node<T> current = head;
			if (head != null) {
				for (int i = 0; i < index; i++) {
					if (current.getNext() == null)
						return false;
	 
					current = current.getNext();
				}
				current.setNext(current.getNext().getNext());
	 
				decrementCounter();
				return true;
	 
			}
			return false;
		}
	 
		public int size() {
			return getCounter();
		}
	 
		public String toString() {
			String output = "";
	 
			if (head != null) {
				Node<T> current = head.getNext();
				while (current != null) {
					output += "[" + current.getData().toString() + "]";
					current = current.getNext();
				}
	 
			}
			return output;
		}
	 
		
		
}
