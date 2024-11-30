package nodes;

public class BinaryNode {
	private BinaryNode leftNode;
	private BinaryNode rightNode;
	private int data;

	public BinaryNode (int data) {
		this.data = data;
	}

	public BinaryNode (BinaryNode leftNode, int data) {
		this.leftNode = leftNode;
		this.data = data;
	}

	public BinaryNode (BinaryNode leftNode, BinaryNode rightNode, int data) {
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.data = data;
	}

	public void setData (int data) {
		this.data = data;
	}

	public int getData () {
		return this.data;
	}

	public void setLeft (BinaryNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryNode getLeft () {
		return this.leftNode;
	}

	public void setRight (BinaryNode rightNode) {
		this.rightNode = rightNode;
	}

	public BinaryNode getRight () {
		return this.rightNode;
	}

	public String toString () {
		String left;
		String right;

		if (this.leftNode == null) {
			left = "null";
		} else {
			left = this.leftNode.getData() + "";
		}

		if (this.rightNode == null) {
			right = "null";
		} else {
			right = this.rightNode.getData() + "";
		}
		return "{ \"value\": " + this.data + ", \"left\": " + left + ", \"right\": " + right + " }";
	}
}
