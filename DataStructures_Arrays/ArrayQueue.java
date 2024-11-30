public class ArrayQueue {
	private int[] queue;
	private int length;
	private double fact;
	private int initalSize;

	ArrayQueue (int initalSize, double fact) {
		if (initalSize < 1) initalSize = 1;

		this.fact = fact;
		this.queue = new int[initalSize];
		this.initalSize = initalSize;
	}

	ArrayQueue (int initalSize) {
		this(initalSize, 0.5);
	}

	ArrayQueue () {
		this(10, 0.5);
	}

	// Grow the source array by (1 + fact). If current length of the array is 10 and the fact is 0.5, then new array length is 15(10 * (1 + 0.5)).
	private void grow () {
		int newSize = (int) (this.queue.length * (1 + this.fact));
		int[] tmpQueue = new int[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpQueue[i] = this.queue[i];
		}

		this.queue = tmpQueue;
	}

	// Shrink the source array by 'fact' and add 1. If current length of the array is 15 and fact is 0.5, then new array length is 8((int) (15 * 0.5) + 1 = (int) 7.5 + 1 = 7 + 1 = 8).
	private void shrink () {
		int newSize = (int) (this.queue.length * this.fact) + 1;
		int[] tmpQueue = new int[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpQueue[i] = this.queue[i];
		}

		this.queue = tmpQueue;
	}

	// Check if the arrays needs to shrink or not.
	private void checkShrink () {
		if (this.length < (int) (this.queue.length * this.fact) + 1) {
			this.shrink();
		}
	}

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

		this.length = size;
	}

	/**
	 * Adds a data to the rear of the queue.
	 * @param data is the value that needs to add.
	 */
	public void enqueue (int data) {
		if (this.length + 1 > this.queue.length) this.grow();

		this.queue[this.length] = data;
		this.length++;
	}

	// Removes and returns the data at the front of the queue.
	public int dequeue () {
		if (this.length == 0) return -1;

		int data = this.queue[0];
		int next = this.queue[1];

		for (int i = 0; i < this.length - 1; i++) {
			this.queue[i] = next;
			next = this.queue[i + 2];
		}

		this.length--;
		this.checkShrink();
		return data;
	}

	// Returns the data at the front without removing it, allowing a preview of the next data to be removed.
	public int peek () {
		if (this.length == 0) return -1;
		return this.queue[0];
	}

	// Clear the queue.
	public void clear () {
		this.queue = new int[this.initalSize];
		this.length = 0;
	}

	// Get a shallow copy of the queue.
	public ArrayQueue copy () {
		ArrayQueue queue = new ArrayQueue(this.initalSize, this.fact);

		for (int i = 0; i < this.length; i++) {
			queue.enqueue(this.queue[i]);
		}

		return queue;
	}

	// Check if the queue is empty or not. If queue is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Convert the queue into an Array.
	public int[] toArray () {
		int[] arr = new int[this.length];

		for (int i = 0; i < this.length; i++) {
			arr[i] = this.queue[i];
		}

		return arr;
	}

	// Convert the queue into a plain text(String).
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		builder.append('<');

		for (int i = 0; i < this.length; i++) {
			builder.append(this.queue[i]);

			if (i != this.length - 1) builder.append(", ");
		}

		builder.append('>');
		return builder.toString();
	}
}
