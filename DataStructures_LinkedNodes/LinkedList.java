import nodes.Node;

public class LinkedList {
	private Node headNode;
	private int length;

	// Get the length of the list.
	public int size () {
		return this.length;
	}

	// Reduce the length of the list.
	public void setSize (int size) {
		if (size < 0 || size >= this.length) return;

		if (size == 0) {
			this.clear();
			return;
		}

		int index = 0;
		Node current = this.headNode;

		while (current != null) {
			if (index == size - 1) {
				current.setNext(null);
				break;
			}

			index++;
			current = current.getNext();
		}

		this.length = size;
	}

	/**
	 * Append a data at end of the list.
	 * @param data is the value that needs to append.
	 */
	public void append (int data) {
		Node node = new Node(data);

		if (this.length == 0) {
			this.headNode = node;
			this.length++;
			return;
		}

		Node current = this.headNode;

		while (current.getNext() != null) {
			current = current.getNext();
		}

		current.setNext(node);
		this.length++;
		return;
	}

	/**
	 * Insert a data at specific location of the list.
	 * @param index is the location that data needs to insert.
	 * @param data is the value that needs to insert.
	 */
	public void insert (int index, int data) {
		if (index < 0 || index > this.length - 1) return;

		Node node = new Node(data);

		if (index == 0) {
			node.setNext(this.headNode);
			this.headNode = node;
			this.length++;
			return;
		}

		int counter = 0;
		Node current = this.headNode;

		while (current != null) {
			if (index - 1 == counter) {
				Node next = current.getNext();
				current.setNext(node);
				node.setNext(next);
				this.length++;
				break;
			}

			counter++;
			current = current.getNext();
		}
	}

	/**
	 * Remove a specific data from the list. The first occurrence of the larget data will be removed.
	 * @param data is the value that needs to remove from the list.
	 */
	public void remove (int data) {
		Node current = this.headNode;
		Node prev = null;

		while (current != null) {
			if (current.getData() == data) {
				if (prev == null) {
					this.headNode = this.headNode.getNext();
				} else {
					prev.setNext(current.getNext());
				}

				this.length--;
				break;
			}

			prev = current;
			current = current.getNext();
		}
	}

	/**
	 * Remove a data from specific location in the list and return that removed data.
	 * @param index is the location that needs to remove data.
	 * @return the value of the removed data.
	 */
	public int pop (int index) {
		if (index < 0 || index >= this.length) return -1;

		Node current = this.headNode;
		Node prev = null;
		int counter = 0;
		int data = -1;

		while (current != null) {
			if (counter == index) {
				if (prev == null) {
					data = this.headNode.getData();
					this.headNode = this.headNode.getNext();
				} else {
					data = current.getData();
					prev.setNext(current.getNext());
				}

				this.length--;
				break;
			}

			counter++;
			prev = current;
			current = current.getNext();
		}

		return data;
	}

	// Remove very last data from the list and return the value of removed data.
	public int pop () {
		return this.pop(this.length - 1);
	}

	// Clear the list.
	public void clear () {
		this.headNode = null;
		this.length = 0;
	}

	/**
	 * Get the location of first occurrence of a specific data.
	 * @param data is the value that needs to search
	 * @return the index of first occurrence of the target data. If there is no data found then return -1.
	 */
	public int indexOf (int data) {
		int index = 0;
		Node current = this.headNode;

		while (current != null) {
			if (current.getData() == data) return index;

			index++;
			current = current.getNext();
		}

		return -1;
	}

	/**
	 * Get total count of a specific data repeated in the list.
	 * @param data is the value that needs to search.
	 * @return the count of target data.
	 */
	public int count (int data) {
		int count = 0;
		Node current = this.headNode;

		while (current != null) {
			if (current.getData() == data) count++;

			current = current.getNext();
		}

		return count;
	}

	// Get a shallow copy of the list.
	public LinkedList copy () {
		LinkedList list = new LinkedList();

		Node current = this.headNode;

		while (current != null) {
			list.append(current.getData());
			current = current.getNext();
		}

		return list;
	}

	// Reverses the order of datas in the list.
	public void reverse () {
		Node current = this.headNode;
		Node previous = null;
		Node next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}

		this.headNode = previous;
	}

	/**
	 * Update the value of a data in specific location.
	 * @param index is the location that needs to update.
	 * @param data is the new value of the target data.
	 */
	public void set (int index, int data) {
		if (index < 0 || index > this.length - 1) return;

		int counter = 0;
		Node current = this.headNode;

		while (current != null) {
			if (counter == index) current.setData(data);

			counter++;
			current = current.getNext();
		}
	}

	/**
	 * Get the value of a data in specific location.
	 * @param index is the location of the data that needs to get the value.
	 * @return the value of target data. If index is out of bounds returns -1.
	 */
	public int get (int index) {
		if (index < 0 || index > this.length - 1) return -1;

		int counter = 0;
		Node current = this.headNode;

		while (current != null) {
			if (counter == index) return current.getData();

			counter++;
			current = current.getNext();
		}

		return -1;
	}

	// Check if the list is empty or not. If list is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Convert the list into an Array.
	public int[] toArray () {
		int[] arr = new int[this.length];

		Node current = this.headNode;
		int index = 0;

		while (current != null) {
			arr[index] = current.getData();
			current = current.getNext();
			index++;
		}

		return arr;
	}

	// Convert the list into a plain text(String).
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		Node current = this.headNode;

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
