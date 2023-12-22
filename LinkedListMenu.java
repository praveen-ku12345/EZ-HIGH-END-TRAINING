//Singly linked list
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insertBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Node inserted at the beginning successfully.");
    }

    public void insertMiddle(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node slow = head;
        Node fast = head;

        // Move 'fast' twice and 'slow' once
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }
        }

        newNode.next = slow.next;
        slow.next = newNode;

        System.out.println("Node inserted at the middle successfully.");
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Node inserted at the end successfully.");
    }

    public void deleteBegin() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from the beginning.");
            return;
        }

        head = head.next;
        System.out.println("Node deleted from the beginning successfully.");
    }

    public void deleteMiddle() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from the middle.");
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        // Move 'fast' twice and 'slow' once
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                prev = slow;
                slow = slow.next;
            }
        }

        if (prev != null) {
            prev.next = slow.next;
            System.out.println("Node deleted from the middle successfully.");
        } else {
            System.out.println("List has only one node. Cannot delete from the middle.");
        }
    }

    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty. Cannot delete from the end.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }

        System.out.println("Node deleted from the end successfully.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListMenu {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the middle");
            System.out.println("3. Insert at the end");
            System.out.println("4. Delete from the beginning");
            System.out.println("5. Delete from the middle");
            System.out.println("6. Delete from the end");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at the beginning: ");
                    int dataInsertBegin = scanner.nextInt();
                    list.insertBegin(dataInsertBegin);
                    break;
                case 2:
                    System.out.print("Enter data to insert at the middle: ");
                    int dataInsertMid = scanner.nextInt();
                    list.insertMiddle(dataInsertMid);
                    break;
                case 3:
                    System.out.print("Enter data to insert at the end: ");
                    int dataInsertEnd = scanner.nextInt();
                    list.insertEnd(dataInsertEnd);
                    break;
                case 4:
                    list.deleteBegin();
                    break;
                case 5:
                    list.deleteMiddle();
                    break;
                case 6:
                    list.deleteEnd();
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
