// Sep002.java

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return head;

        // Step 1: Count size
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // If k is greater than size
        if (k > n) return head;

        // If both nodes are same (no need to swap)
        if (2 * k - 1 == n) return head;

        // Step 2: Find kth node from start and its previous
        Node prev1 = null, node1 = head;
        for (int i = 1; i < k; i++) {
            prev1 = node1;
            node1 = node1.next;
        }

        // Step 3: Find kth node from end and its previous
        Node prev2 = null, node2 = head;
        for (int i = 1; i < n - k + 1; i++) {
            prev2 = node2;
            node2 = node2.next;
        }

        // Step 4: Swap nodes
        if (prev1 != null) prev1.next = node2;
        if (prev2 != null) prev2.next = node1;

        // Swap next pointers
        Node tempNext = node1.next;
        node1.next = node2.next;
        node2.next = tempNext;

        // Update head if needed
        if (k == 1) head = node2;
        if (k == n) head = node1;

        return head;
    }
}

public class Sep002 {
    // Utility function to print the list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility function to create a sample list
    static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Node head = createList(arr);

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        int k = 2; // Example: swap 2nd node from start and end
        head = sol.swapKth(head, k);

        System.out.println("List after swapping " + k + "th node from start and end:");
        printList(head);
    }
}
