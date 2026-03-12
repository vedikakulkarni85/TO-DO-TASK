import java.util.*;

class Node {
    String task;
    int priority;
    Node next;

    Node(String task, int priority) {
        this.task = task;
        this.priority = priority;
        this.next = null;
    }
}

class LinkedListDSA {

    Node head;

    void addTask(String task, int priority) {
        Node newNode = new Node(task, priority);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.println("Task: " + temp.task + " | Priority: " + temp.priority);
            temp = temp.next;
        }
    }

    boolean removeTask(String task) {

        if (head == null) return false;

        if (head.task.equalsIgnoreCase(task)) {
            head = head.next;
            return true;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.task.equalsIgnoreCase(task)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}

public class DSA_TODO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedListDSA list = new LinkedListDSA();
        Queue<String> queue = new LinkedList<>();
        Stack<String> completed = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int choice;

        do {

            System.out.println("\n------ TO DO TASK MANAGER ------");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. View Completed Tasks");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter task name: ");
                    String task = sc.nextLine();

                    System.out.print("Enter priority (1 High / 2 Medium / 3 Low): ");
                    int priority = sc.nextInt();

                    list.addTask(task, priority);
                    queue.add(task);
                    pq.add(priority);

                    System.out.println("Task Added Successfully");

                    break;

                case 2:

                    System.out.println("\n------ TASK LIST ------");
                    list.displayTasks();

                    break;

                case 3:

                    System.out.print("Enter task name to complete: ");
                    String doneTask = sc.nextLine();

                    if (list.removeTask(doneTask)) {
                        completed.push(doneTask);
                        System.out.println("Task Completed");
                    } else {
                        System.out.println("Task not found");
                    }

                    break;

                case 4:

                    System.out.println("\n------ COMPLETED TASKS ------");

                    if (completed.isEmpty()) {
                        System.out.println("No completed tasks");
                    } else {
                        for (String t : completed) {
                            System.out.println(t);
                        }
                    }

                    break;

                case 5:

                    System.out.println("Exiting program...");
                    break;

                default:

                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}