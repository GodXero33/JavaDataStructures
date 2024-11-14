import nodes.BinaryNode;

public class BinarySearchTree {
	private BinaryNode rootNode;
	private int count;

	// Returns the number of nodes with values in the BST. This is constant time (O(1)) as the count is updated during insertions and deletions.
	public int size () {
		return this.count;
	}

	/**
	 * Inserts a new node with the specified data into the Binary Search Tree (BST).
	 * The insertion maintains the BST property where:
	 * - Nodes with values less than the current node go to the left.
	 * - Nodes with values greater than the current node go to the right.
	 * @param data is the data value to be inserted into the tree.
	 */
	public void insert (int data) {
		BinaryNode node = new BinaryNode(data);

		if (this.rootNode == null) {
			this.rootNode = node;
			this.count++;
			return;
		}

		BinaryNode current = this.rootNode;
		BinaryNode parent = null;

		while (current != null) {
			parent = current;

			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			} else {
				// The data value is already in the tree. No need to insert.
				return;
			}
		}

		if (data < parent.getData()) {
			parent.setLeft(node);
		} else {
			parent.setRight(node);
		}

		this.count++;
	}

	/**
	 * Searches for a node with the specified data in the Binary Search Tree (BST).
	 * The search follows the BST property, where:
	 * - Values smaller than the current node's data are to the left.
	 * - Values larger than the current node's data are to the right.
	 * 
	 * @param data is the data value to search for in the tree.
	 * @return the node containing the specified data if found, or null if not found.
	 */
	public BinaryNode find (int data) {
		if (this.rootNode == null) return null;

		BinaryNode current = this.rootNode;

		while (current != null) {
			if (data < current.getData()) {
				current = current.getLeft();
			} else if (data > current.getData()) {
				current = current.getRight();
			} else {
				// Terget data is found.
				break;
			}
		}

		return current;
	}

	/**
	 * Deletes the node with the specified data from the Binary Search Tree (BST).
	 * The deletion follows these steps:
	 * - If the node is a leaf (has no children), simply remove it.
	 * - If the node has one child, replace it with its child.
	 * - If the node has two children, replace it with its inorder successor (smallest node in the right subtree).
	 * 
	 * @param data is the data value to delete from the tree.
	 */
	public void delete (int data) {
		if (this.rootNode == null) return;

		BinaryNode current = this.rootNode;
		BinaryNode parent = null;

		// Find the node to delete
		while (current != null) {
			if (data < current.getData()) {
				parent = current;
				current = current.getLeft();
			} else if (data > current.getData()) {
				parent = current;
				current = current.getRight();
			} else {
				// Terget data is found.
				break;
			}
		}

		if (current == null) return;

		BinaryNode left = current.getLeft();
		BinaryNode right = current.getRight();

		// Node is a leaf (no children).
		if (left == null && right == null) {
			if (parent == null) {
				// If the node to delete is the root and it has no children, set root to null.
				this.rootNode = null;
			} else if (parent.getLeft() == current) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		//  Node has only one child (either left or right).
		else if (left == null) {
			if (parent == null) {
				// If the node to delete is the root and it has a right child, make the right child the new root.
				this.rootNode = null;
			} else if (parent.getLeft() == current) {
				parent.setLeft(right);
			} else {
				parent.setRight(right);
			}
		} else if (right == null) {
			if (parent == null) {
				// If the node to delete is the root and it has a left child, make the left child the new root.
				this.rootNode = null;
			} else if (parent.getLeft() == current) {
				parent.setLeft(left);
			} else {
				parent.setRight(left);
			}
		}
		// Node has two children.
		else {
			// Find the inorder successor (smallest node in the right subtree)
			BinaryNode successorParent = current;
			BinaryNode successor = right;

			// Traverse to the leftmost node in the right subtree (the inorder successor)
			while (successor.getLeft() != null) {
				successorParent = successor;
				successor = successor.getLeft();
			}

			// Replace the data of the current node with the inorder successor's data
			current.setData(successor.getData());

			// Remove the inorder successor
			if (successorParent.getLeft() == successor) {
				successorParent.setLeft(successor.getRight());
			} else {
				successorParent.setRight(successor.getRight());
			}
		}

		this.count--;
	}

	/**
	 * Converts a BinaryNode into a formatted string representation for JSON-like output.
	 * This method recursively builds a string that includes the node's value, left child, and right child in a structured format, with indentation to represent the tree hierarchy.
	 * 
	 * @param node is the current node to be converted into a string.
	 * @param lvl is the current level of the node in the tree, used for indentation.
	 * @param indent is the string to be repeated for indentation purposes.
	 * @returna formatted string representing the node and its children.
	 */
	private String binaryNodeToString (BinaryNode node, int lvl, String indent) {
		BinaryNode leftNode = node.getLeft();
		BinaryNode rightNode = node.getRight();
		String left;
		String right;
		String indentPara = indent.repeat(lvl);
		String indentContent = indent.repeat(lvl + 1);

		if (leftNode == null) {
			left = "null";
		} else {
			left = this.binaryNodeToString(leftNode, lvl + 1, indent);
		}

		if (rightNode == null) {
			right = "null";
		} else {
			right = this.binaryNodeToString(rightNode, lvl + 1, indent);
		}

		return "{\n" + indentContent + "\"value\": " + node.getData() + ", \n" + indentContent + "\"left\": " + left + ", \n" + indentContent + "\"right\": " + right + "\n" + indentPara + "}";
	}

	/**
	 * Converts the Binary Search Tree (BST) to a JSON-like string representation.
	 * 
	 * @param indentSize is the number of spaces to use for indentation in the output.
	 * @return a string representing the entire tree in a structured JSON-like format.
	 */
	public String toJSON (int indentSize) {
		if (this.rootNode == null) return "{}";
		return this.binaryNodeToString(this.rootNode, 0, " ".repeat(indentSize));
	}

	// Converts the Binary Search Tree (BST) to a default JSON-like string representation with an indentation of 4 spaces.
	public String toString () {
		return this.toJSON(4);
	}
}
