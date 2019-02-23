package LinkList;

/**
 * 
 * @author jingjiejiang Feb 18, 2019
 *
 */
public class LinkedListCycleII {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode detectCycle(ListNode head) {
		
		boolean hasCycle = false;
		if (head == null || head.next == null) return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (slow != null && fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;

            if (fast == slow) {
				hasCycle = true;
				break;
			}
		}
		
		if (hasCycle == false) return null;
		
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		
		return slow;
    }
}