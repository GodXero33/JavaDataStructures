package nodes;

public class Node {
	private int data;
	private Node next;

	public Node (int data) {
		this.data = data;
	}

	public int getData () {
		return this.data;
	}

	public void setData (int data) {
		this.data = data;
	}

	public Node getNext () {
		return this.next;
	}

	public void setNext (Node next) {
		this.next = next;
	}
}
