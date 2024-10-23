package basics;
import java.util.Stack;

class LinkedListPalindrome {
    public static void main(String args[]) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.ptr = two;
        two.ptr = three;
        three.ptr = four;
        four.ptr = five;
        five.ptr = six;
        six.ptr = seven;

        boolean condition = isPalindrome(one);
        System.out.println("isPalindrome: " + condition);
    }

    // Function to check if the linked list is a palindrome
    static boolean isPalindrome(Node head) {
        Node slow = head;
        boolean isPalin = true;
        Stack<Integer> stack = new Stack<>();

        // Push each element of the linked list onto the stack
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.ptr;
        }

        // Compare elements from the stack with the original linked list
        while (head != null) {
            int i = stack.pop();
            if (head.data == i) {
                isPalin = true;
            } else {
                isPalin = false;
                break;
            }
            head = head.ptr;
        }

        return isPalin;
    }
}

class Node {
    int data;
    Node ptr;

    Node(int d) {
        ptr = null;
        data = d;
    }
}
