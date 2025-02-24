package collections;
import java.util.Stack;

public class StackExample {
    
    // Pushing elements onto the stack
    static void stackPush(Stack<Integer> stack) {
        System.out.println("\nPushing elements onto the stack:");
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.print(i + " ");
        }
        System.out.println("\nCurrent Stack: " + stack);
    }

    // Popping elements from the stack
    static void stackPop(Stack<Integer> stack) {
        System.out.println("\nPopping elements from the stack:");

        if (stack.isEmpty()) {
            System.out.println("Stack is empty! Cannot pop elements.");
            return;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nStack is now empty.");
    }

    // Displaying the top element of the stack
    static void stackPeek(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            System.out.println("\nElement on stack top: " + stack.peek());
        } else {
            System.out.println("\nStack is empty! No top element.");
        }
    }

    // Searching for an element in the stack
    static void stackSearch(Stack<Integer> stack, int element) {
        int pos = stack.search(element);

        if (pos == -1) {
            System.out.println(element + " not found in the stack.");
        } else {
            System.out.println(element + " found at position: " + pos + " (from top).");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stackPush(stack);  // Push 0-4 onto the stack
        stackPop(stack);   // Pop all elements
        stackPush(stack);  // Push 0-4 again
        stackPeek(stack);  // Show top element
        stackSearch(stack, 2); // Search for 2
        stackSearch(stack, 6); // Search for 6 (not in stack)
    }
}
