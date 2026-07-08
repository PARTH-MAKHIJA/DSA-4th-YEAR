import java.util.*;
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
}
public class AddTwoNumbers {
    public static Node add(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }
            temp.next = new Node(sum % 10);
            temp = temp.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
    public static Node createList(Scanner sc, int n) {
        Node dummy = new Node(0);
        Node temp = dummy;
        for (int i = 0; i < n; i++) {
            temp.next = new Node(sc.nextInt());
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" ");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter digits:");
        Node head1 = createList(sc, n1);
        System.out.print("Enter size of second number: ");
        int n2 = sc.nextInt();
        System.out.println("Enter digits:");
        Node head2 = createList(sc, n2);
        Node result = add(head1, head2);
        System.out.print("Sum: ");
        printList(result);
        sc.close();
    }
}