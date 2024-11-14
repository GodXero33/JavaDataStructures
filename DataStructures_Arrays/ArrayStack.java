public class ArrayStack {
	private int[] stack;
	private int length;
	private double fact;
	private int initalSize;

	ArrayStack (int initalSize, double fact) {
		if (initalSize < 1) initalSize = 1;

		this.fact = fact;
		this.stack = new int[initalSize];
		this.initalSize = initalSize;
	}

	ArrayStack (int initalSize) {
		this(initalSize, 0.5);
	}

	ArrayStack () {
		this(10, 0.5);
	}

	// Grow the source array by (1 + fact). If current length of the array is 10 and the fact is 0.5, then new array length is 15(10 * (1 + 0.5)).
	private void grow () {
		int newSize = (int) (this.stack.length * (1 + this.fact));
		int[] tmpStack = new int[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpStack[i] = this.stack[i];
		}

		this.stack = tmpStack;
	}

	// Shrink the source array by 'fact' and add 1. If current length of the array is 15 and fact is 0.5, then new array length is 8((int) (15 * 0.5) + 1 = (int) 7.5 + 1 = 7 + 1 = 8).
	private void shrink () {
		int newSize = (int) (this.stack.length * this.fact) + 1;
		int[] tmpStack = new int[newSize];

		for (int i = 0; i < this.length; i++) {
			tmpStack[i] = this.stack[i];
		}

		this.stack = tmpStack;
	}

	// Check if the arrays needs to shrink or not.
	private void checkShrink () {
		if (this.length < (int) (this.stack.length * this.fact) + 1) {
			this.shrink();
		}
	}

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

		this.length = size;
	}

	/**
	 * Adds a data to the top of the stack.
	 * @param data is the value that needs to add.
	 */
	public void push (int data) {
		if (this.length + 1 > this.stack.length) this.grow();

		this.stack[this.length] = data;
		this.length++;
	}

	// Removes and returns the data at the top of the stack. If the stack is empty returns -1.
	public int pop () {
		if (this.length == 0) return -1;

		this.length--;
		this.checkShrink();
		return this.stack[this.length];
	}

	// Returns the data at the top without removing it, allowing a preview of the next data to be removed. If the stack is empty returns -1.
	public int peek () {
		if (this.length == 0) return -1;
		return this.stack[this.length - 1];
	}

	// Clear the stack.
	public void clear () {
		this.stack = new int[this.initalSize];
		this.length = 0;
	}

	// Get a shallow copy of the stack.
	public ArrayStack copy () {
		ArrayStack stack = new ArrayStack(this.initalSize, this.fact);

		for (int i = 0; i < this.length; i++) {
			stack.push(this.stack[i]);
		}

		return stack;
	}

	// Check if the stack is empty or not. If stack is empty returns 'true', otherwise 'false'.
	public boolean isEmpty () {
		return this.length == 0;
	}

	// Convert the stack into an Array.
	public int[] toArray () {
		int[] arr = new int[this.length];

		for (int i = this.length - 1; i >= 0; i--) {
			arr[i] = this.stack[i];
		}

		return arr;
	}

	// Convert the stack into a plain text(String).
	public String toString () {
		if (this.length == 0) return "<>";

		StringBuilder builder = new StringBuilder();
		builder.append('<');

		for (int i = this.length - 1; i >= 0; i--) {
			builder.append(this.stack[i]);

			if (i != 0) builder.append(", ");
		}

		builder.append('>');
		return builder.toString();
	}
}
