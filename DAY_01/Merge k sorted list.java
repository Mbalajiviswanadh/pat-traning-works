package DAY_01;
import java.util.PriorityQueue;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

 class Merge_k_LL {
    public ListNode mergeKLists(ListNode[] lists) {
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
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        ListNode[] lists = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode head = null;
            ListNode tail = null;

            int value;
            while ((value = scanner.nextInt()) != -1) {
                ListNode newNode = new ListNode(value);

                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }

            lists[i] = head;
        }

        Merge_k_LL solution = new Merge_k_LL();
        ListNode mergedList = solution.mergeKLists(lists);
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
