// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    // Constructor to initialize the node with a value
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Deserialize method to convert a string like "[2, 4, 3]" into a linked list
    public static ListNode deserialize(String data) {
        // Remove the brackets and split the string by commas
        data = data.replaceAll("\\[|\\]", "").trim();
        if (data.isEmpty()) return null;
        
        String[] values = data.split(",\\s*");
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify list creation
        ListNode current = dummyHead;

        // Parse each value and create a linked list
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value));
            current = current.next;
        }

        return dummyHead.next;  // Return the actual list (skip the dummy node)
    }

    // Helper method to serialize the list back to string (optional, useful for debugging)
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the addition logic
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;  // Initialize carry to 0

        // Traverse both linked lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;  // Get value from l1 or 0 if l1 is null
            int y = (l2 != null) ? l2.val : 0;  // Get value from l2 or 0 if l2 is null
            int sum = carry + x + y;            // Calculate the sum of current digits and carry

            carry = sum / 10;                   // Update carry
            current.next = new ListNode(sum % 10);  // Create a new node for the digit
            current = current.next;             // Move to the next node

            // Move to the next nodes in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's any carry left, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // Return the next of dummyHead which is the actual result list
        return dummyHead.next;
    }

    // Helper function to print the linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Input: [2, 4, 3] and [5, 6, 4]
        String l1Str = "[2, 4, 3]";
        String l2Str = "[5, 6, 4]";
        
        // Deserialize the input strings to linked lists
        ListNode l1 = ListNode.deserialize(l1Str);
        ListNode l2 = ListNode.deserialize(l2Str);

        // Adding the two numbers
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Printing the result (should be 7 -> 0 -> 8, which is 807)
        solution.printList(result);
    }
}
