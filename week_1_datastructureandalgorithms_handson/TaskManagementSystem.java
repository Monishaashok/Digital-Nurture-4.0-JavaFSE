class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class TaskLinkedList {
    Task head;

    // Add task at end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added.");
    }

    // Search task by ID
    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) return current;
            current = current.next;
        }
        return null;
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // Traverse and print all tasks
    public void listTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(101, "Design UI", "Pending");
        taskList.addTask(102, "Develop Backend", "In Progress");
        taskList.addTask(103, "Testing", "Pending");

        System.out.println("\n--- All Tasks ---");
        taskList.listTasks();

        System.out.println("\n--- Searching Task ID 102 ---");
        Task found = taskList.searchTask(102);
        System.out.println(found != null ? found : "Task not found.");

        System.out.println("\n--- Deleting Task ID 101 ---");
        taskList.deleteTask(101);

        System.out.println("\n--- Updated Task List ---");
        taskList.listTasks();
    }
}
