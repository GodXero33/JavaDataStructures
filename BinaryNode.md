# BinaryNode

The `BinaryNode` class represents a node in a binary tree, containing a value (`data`) and references to its left and right children. Each node in the tree can either have 0, 1, or 2 children.

## Fields

- **leftNode**: The left child node of the current node.
- **rightNode**: The right child node of the current node.
- **data**: The integer value stored in the node.

## Constructors

- **BinaryNode(int data)**: Constructs a `BinaryNode` with the specified `data`, and both `leftNode` and `rightNode` set to `null`.
  
- **BinaryNode(BinaryNode leftNode, int data)**: Constructs a `BinaryNode` with the specified `data`, and the `leftNode` set to the specified `leftNode`. The `rightNode` is set to `null`.
  
- **BinaryNode(BinaryNode leftNode, BinaryNode rightNode, int data)**: Constructs a `BinaryNode` with the specified `data`, `leftNode`, and `rightNode`.

## Methods

### Public Methods

- **setData(int data)**: Sets the value of the node to the specified `data`.

- **getData()**: Returns the value stored in the node.

- **setLeft(BinaryNode leftNode)**: Sets the left child of the node to the specified `leftNode`.

- **getLeft()**: Returns the left child of the node.

- **setRight(BinaryNode rightNode)**: Sets the right child of the node to the specified `rightNode`.

- **getRight()**: Returns the right child of the node.

- **toString()**: Returns a string representation of the node in the format:

  ```json
  { "value": <data>, "left": <left child data>, "right": <right child data> }
  ```

  If a child is `null`, it is represented as `"null"`.

## Example Usage

```java
BinaryNode node1 = new BinaryNode(10);
BinaryNode node2 = new BinaryNode(5);
BinaryNode node3 = new BinaryNode(15);
BinaryNode node4 = new BinaryNode(node2, node3, 10);

node1.setLeft(node2);
node1.setRight(node3);

System.out.println(node1.getData());           // Output: 10
System.out.println(node1.getLeft().getData()); // Output: 5
System.out.println(node1.getRight().getData());// Output: 15
System.out.println(node4.toString());         // Output: { "value": 10, "left": 5, "right": 15 }
```

## Notes

- **Binary Tree Structure**: The `BinaryNode` class is intended to represent a node in a binary tree, where each node can have up to two children (`leftNode` and `rightNode`).
  
- **Null Children**: If a node has no left or right child, the corresponding child pointer will be `null`.

- **String Representation**: The `toString()` method outputs the node's data and the values of its children (if any) in a structured format suitable for debugging or visualizing the tree.
