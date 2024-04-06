package DAY_01;

import java.util.LinkedList;
import java.util.Scanner;

 class Reverse_KNodes {
    public static LinkedList<Integer> reverseKNodes(LinkedList<Integer> list, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int size = list.size();

        for (int i = 0; i < size; i += k) {
            int end = Math.min(i + k, size);

            if (end - i == k) {
                for (int j = end - 1; j >= i; j--) {
                    result.add(list.get(j));
                }
            } else {
                for (int j = i; j < end; j++) {
                    result.add(list.get(j));
                }
            }
        }

        return result;
    }

    public static void printListVertically(LinkedList<Integer> list) {
        for (int value : list) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>();

        int value;
        while ((value = scanner.nextInt()) != -1) {
            linkedList.add(value);
        }

        int k = scanner.nextInt();

        LinkedList<Integer> reversedList = reverseKNodes(linkedList, k);

        printListVertically(reversedList);
        scanner.close();
    }
}

