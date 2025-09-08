// Define the Node class
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

// Solution class containing merge sort logic
class Solution {

    // Merge two sorted linked lists
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    // Find middle of linked list
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge Sort function
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        return merge(left, right);
    }
}

// Main class to test the solution
public class Sep009 {

    // Utility function to print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Create unsorted linked list: 30 -> 20 -> 40 -> 10 -> 50
        Node head = new Node(30);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(50);

        System.out.println("Original List:");
        printList(head);

        // Apply merge sort
        Solution solution = new Solution();
        head = solution.mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
