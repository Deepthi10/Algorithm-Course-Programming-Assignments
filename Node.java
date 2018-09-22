package stable;

public class Node<T> {

	Node<T> next;

	T data;

	// Node constructor
	public Node(T dataValue) {
		next = null;
		data = dataValue;
	}

	@SuppressWarnings("unused")
	public Node(T dataValue, Node<T> nextValue) {
		next = nextValue;
		data = dataValue;
	}

	public T getData() {
		return data;
	}

	@SuppressWarnings("unused")
	public void setData(T dataValue) {
		data = dataValue;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> nextValue) {
		next = nextValue;
	}

}
