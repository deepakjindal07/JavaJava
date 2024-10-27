package basics_large;
public class MergeSortLinkedList {

	static Node head = null;

    // Node class for linked list
    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    // Function to merge two sorted linked lists
    Node sortedMerge(Node a, Node b) {
        Node result = null;

        if (a == null) {
			return b;
		}
        if (b == null) {
			return a;
		}

        // Compare values and merge nodes accordingly
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // Function to perform merge sort on a linked list
    Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: return if list is empty or has only one node
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        Node left = mergeSort(head); // Recursively sort the left half
        Node right = mergeSort(nextOfMiddle); // Recursively sort the right half

        return sortedMerge(left, right); // Merge the sorted halves
    }

    // Function to find the middle node of a linked list
    public static Node getMiddle(Node head) {
        if (head == null) {
			return head;
		}

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Utility function to print the linked list
    void printList(Node headRef) {
        while (headRef != null) {
            System.out.print(headRef.val + " ");
            headRef = headRef.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortLinkedList li = new MergeSortLinkedList();

        // Creating the linked list
        head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(5);
        head.next.next.next = new Node(20);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);

        // Applying merge sort
        head = li.mergeSort(head);
        System.out.print("Sorted Linked List: ");
        li.printList(head);
    }
}
