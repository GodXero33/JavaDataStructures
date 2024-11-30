# Node

The `Node` class represents a node in a linked list, containing an integer value (`data`) and a reference to the next node in the list.

## Fields

- **data**: The integer value stored in the node.
- **next**: The reference to the next node in the list. This is `null` if the node is the last node in the list.

## Constructors

- **Node(int data)**: Constructs a `Node` with the specified `data` and the `next` reference set to `null`.

## Methods

### Public Methods

- **getData()**: Returns the value stored in the node.

- **setData(int data)**: Sets the value of the node to the specified `data`.

- **getNext()**: Returns the next node in the list.

- **setNext(Node next)**: Sets the next node of the current node to the specified `next` node.

## Example Usage

```java
Node node1 = new Node(10);
Node node2 = new Node(20);

node1.setNext(node2);

System.out.println(node1.getData());  // Output: 10
System.out.println(node1.getNext().getData()); // Output: 20
```

## Notes

- **Linked List Structure**: The `Node` class is intended for use in a singly linked list, where each node contains a value and a reference to the next node in the list.

- **Null References**: The `next` reference is `null` for the last node in the list, indicating the end of the list.
