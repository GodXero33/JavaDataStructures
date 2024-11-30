import nodes.Node;

public class LinkedQueue {
	private Node frontNode;
	private Node rearNode;
	private int length;

	// Get the length of the queue.
	public int size () {
		return this.length;
	}

	// Reduce the length of the queue.
	public void setSize (int size) {
		if (size < 0 || size >= this.length) return;

		if (size == 0) {
			this.clear();
			return;
		}

		int index = 0;
		Node current = this.frontNode;
		
		while (current != null) {
			if (index == size - 1) {
				current.setNext(null);
				this.rearNode = current;
				break;
			}

			index++;
			current = current.getNext();
		}

		this.length = size;
	}

	/**
	 * Adds a data to the rear of the queue.
	 * @param data is the value that needs to add.
	 */
	public void enqueue (int data) {
		Node node = new Node(data);

		if (this.length == 0) {
			this.frontNode = node;
			this.rearNode = node;
		} else {
			this.rearNode.setNext(node);
			this.rearNode = node;
		}

		this.length++;
	}

	// Removes and returns the data at the front of the queue.
	public int dequeue () {
		if (this.length == 0) return -1;

		int data = this.frontNode.getData();
		this.frontNode = this.frontNode.getNext();
		this.length--;

		if (this.length == 0) this.rearNode = null;

		return data;
	}

	// Returns the data at the front without removing it, allowing a preview of the next data to be removed.
	public int peek () {
		if (this.length == 0) return -1;
		return this.frontNode.getData();
	}

	// Get a shallow copy of the queue.
	public LinkedQueue copy () {
		LinkedQueue queue = new LinkedQueue();
		int[] data = this.toArray();

		for (int i = data.length - 1; i >= 0; i--) {
			queue.enqueue(data[i]);
		}

		return queue;
	}

	// Check if the queue is empty or not. If queue is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Clear the queue.
	public void clear () {
		this.frontNode = this.rearNode = null;
		this.length = 0;
	}

	// Convert the queue into a Array.
	public int[] toArray () {
		int[] arr = new int[this.length];

		Node current = this.frontNode;
		int index = 0;

		while (current != null) {
			arr[index] = current.getData();
			current = current.getNext();
			index++;
		}

		return arr;
	}

	// Convert the queue into a plain text(String).
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		Node current = this.frontNode;

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
