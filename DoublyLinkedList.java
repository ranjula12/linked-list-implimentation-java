
public class DoublyLinkedList {
	Node head;
	int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		// Code goes here...
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertAtStart(int data) {
		// Code goes here...
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			size++;
		} else {
			Node newNode = new Node(null, data, head);
			head.previous = newNode;
			head = newNode;

			size++;

		}
	}

	public void insertLast(int data) {
		// Code goes here...
		if (isEmpty()) {
			Node node = new Node(data);
			head = node;
		} else {
			Node currentNode = head;

			while (currentNode.next != null) {

				currentNode = currentNode.next;

			}

			Node lasNode = new Node(currentNode, data, null);
			currentNode.next = lasNode;
			size++;

		}

	}

	public void insertAt(int val, int Position) {
		// Code goes here...
		if (isEmpty() || Position < 0 || Position > size) {
			System.out.println("wrong input:");
		} else {
			Node currentNode = head;

			for (int i = 0; i < Position - 1; i++) {
				currentNode = currentNode.next;
			}
			Node newNode = new Node(currentNode, val, currentNode.next);
			currentNode.next = newNode;
			currentNode.next.previous = newNode;

			size++;
		}

	}

	public void deleteFirst() {
		// Code goes here...
		if (isEmpty()) {

			System.out.println("nothing to delite node!");
		} else {
			head = head.next;
			head.previous = null;
			size--;
		}

	}

	public void deleteLast() {
		// Code goes here...
		if (isEmpty()) {
			System.out.println("nothing to delite node!");
		} else {
			Node currentNode = head, previousNode;
			while (currentNode.next.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = null;
			size--;
		}

	}

	public void deleteAt(int Position) {
		// Code goes here...
		if (Position > 1 && Position < size - 1) {
			Node currentNode = head, nextNode;
			for (int i = 0; i < Position - 1; i++) {
				currentNode = currentNode.next;
			}
			nextNode = currentNode.next;
			currentNode.next = nextNode.next;
			nextNode.next.previous = currentNode.next;

			size--;
		} else {
			System.out.println("is not valid poosition to delete so plz use another methode to delete last or fitst");
		}

	}

	public void countNodes() {
		// Code goes here...
		System.out.println("total nodes :" + size);
	}

	public void show() {
		// Code goes here...
		if (isEmpty()) {
			System.out.println("no items to show in linked list!");
		} else {
			Node currentNode = head;
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
			System.out.println("");
		}
	}
}