class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // Method to create a linked list from a string representation for testing
    public static ListNode deserialize(String data) {
        if (data == null || data.equals("[]") || data.equals("")) {
            return null;
        }
        
        // Remove brackets and split by comma
        data = data.replaceAll("\\[|\\]", "");
        String[] values = data.split(",");
        
        // Initialize the head of the list
        ListNode head = new ListNode(Integer.parseInt(values[0].trim()));
        ListNode current = head;
        
        // Create the rest of the list
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(Integer.parseInt(values[i].trim()));
            current = current.next;
        }
        
        return head;
    }

    // Method to convert ListNode back to a string for output
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Base case: if list is empty or has only one node, return head as is
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize a dummy node to simplify the swap process
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Iterate through the list while there are pairs to swap
        while (prev.next != null && prev.next.next != null) {
            // Identify the nodes to swap
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Perform the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move to the next pair
            prev = first;
        }
        
        // Return the new head of the list
        return dummy.next;
    }
}
