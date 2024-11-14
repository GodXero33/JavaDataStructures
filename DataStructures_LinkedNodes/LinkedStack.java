import nodes.Node;

public class LinkedStack {
	private Node topNode;
	private int length;

	// Get the length of the stack.
	public int size () {
		return this.length;
	}

	// Reduce the length of the stack.
	public void setSize (int size) {
		if (size < 0 || size >= this.length) return;

		if (size == 0) {
			this.clear();
			return;
		}

		int index = this.length;
		Node current = this.topNode;

		while (current != null) {
			Node next = current.getNext();

			if (index < size + 1) {
				break;
			}

			index--;
			current.setNext(null);
			current = next;
		}

		this.topNode = current;
		this.length = size;
	}

	/**
	 * Adds a data to the top of the stack.
	 * @param data is the value that needs to add.
	 */
	public void push (int data) {
		Node node = new Node(data);
		node.setNext(this.topNode);
		this.topNode = node;
		this.length++;
	}

	// Removes and returns the data at the top of the stack. If the stack is empty returns -1.
	public int pop () {
		if (this.length == 0) return -1;

		int data = this.topNode.getData();
		this.topNode = this.topNode.getNext();
		this.length--;
		return data;
	}

	// Returns the data at the top without removing it, allowing a preview of the next data to be removed. If the stack is empty returns -1.
	public int peek () {
		if (this.length == 0) return -1;
		return this.topNode.getData();
	}

	// Get a shallow copy of the stack.
	public LinkedStack copy () {
		LinkedStack stack = new LinkedStack();
		Node current = this.topNode;

		for (int i = 0; i < this.length; i++) {
			stack.push(current.getData());
			current = current.getNext();
		}

		return stack;
	}

	// Check if the stack is empty or not. If stack is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Clear the stack.
	public void clear () {
		this.topNode = null;
		this.length = 0;
	}

	// Convert the stack into a Array.
	public int[] toArray () {
		int[] arr = new int[this.length];

		Node current = this.topNode;
		int index = 0;

		while (current != null) {
			arr[index] = current.getData();
			current = current.getNext();
			index++;
		}

		return arr;
	}

	// Convert the stack into a plain text(String).
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		Node current = this.topNode;

		builder.append('<');

		while (current != null) {
			builder.append(current.getData());

			if (current.getNext() != null) builder.append(", ");

			current = current.getNext();
		}

		builder.append('>');
		return builder.toString();
	}
}
