import java.util.PriorityQueue;
import com.eclipsesource.json.JsonArray;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) { 
        val = x; 
    }

    // Convert a JsonArray to a ListNode linked list
    public static ListNode arrayToListNode(JsonArray jsonArray) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        for (int i = 0; i < jsonArray.size(); i++) {
            current.next = new ListNode(jsonArray.get(i).asInt());
            current = current.next;
        }
        return dummy.next;
    }

    // For the purpose of merging multiple linked lists, we can add this utility
    public static ListNode[] jsonArrayToListNodeArray(JsonArray jsonArray) {
        ListNode[] listNodes = new ListNode[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            listNodes[i] = arrayToListNode(jsonArray.get(i).asArray());
        }
        return listNodes;
    }

    // Helper method to convert a ListNode back to an array (for output)
    public static int[] listNodeToArray(ListNode head) {
        ListNode current = head;
        List<Integer> result = new ArrayList<>();
        
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // This part will depend on the specific driver format you are using.
        // If using JsonArray as input, simulate the input here or rely on the driver.
    }
}
