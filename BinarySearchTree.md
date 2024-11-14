# BinarySearchTree

The `BinarySearchTree` class is a custom implementation of a binary search tree (BST). The tree follows the standard properties of a BST, where for any node:
- The left subtree contains nodes with smaller values.
- The right subtree contains nodes with larger values.

## Fields

- **root**: The root node of the tree.
- **count**: The total number of nodes in the tree.

## Methods

### Public Methods

- **size()**: Returns the number of nodes in the BST. This operation is constant time (O(1)) as the count is maintained during insertions and deletions.
  
- **insert(int data)**: Inserts a new node with the specified data into the BST. If the value already exists, no insertion occurs.

- **find(int data)**: Searches for a node containing the specified data in the BST. Returns the node if found, or `null` if not found.

- **delete(int data)**: Deletes the node with the specified data from the BST. The method handles the following cases:
  - If the node is a leaf (no children), it is simply removed.
  - If the node has one child, it is replaced by its child.
  - If the node has two children, it is replaced by its inorder successor (smallest node in the right subtree).

- **toJSON(int indentSize)**: Converts the BST to a JSON-like string representation, with indentation of the specified size. This helps visualize the tree structure in a structured format.

- **toString()**: Converts the BST to a JSON-like string representation with a default indentation of 4 spaces.

### Private Methods

- **binaryNodeToString(BinaryNode node, int lvl, String indent)**: A helper method to recursively convert a `BinaryNode` into a formatted string suitable for JSON output. This method is used by `toJSON()`.

## Example Usage

```java
BinarySearchTree bst = new BinarySearchTree();
bst.insert(10);
bst.insert(5);
bst.insert(15);
bst.insert(3);

System.out.println(bst.size());    // Output: 4
System.out.println(bst.find(5));  // Output: BinaryNode with data 5
bst.delete(5);

System.out.println(bst.toString());  // Output: JSON-like string representation of the tree
```

## Notes
- The `insert()`, `find()`, and `delete()` methods follow the standard behavior of a Binary Search Tree.
- **Inorder Successor**: The node with two children is replaced by its inorder successor, which is the smallest node in the right subtree.
