import java.util.ArrayList;

/*
 * TaskManager stores and manages all the tasks in the application.
 * It provides methods to add tasks and get task lists and statistics.
 */
public class TaskManager {
    private ArrayList<Task> tasks;

    // Initializes an empty task list
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Adds a new task to the list
    public void addTask(Task t) {
        tasks.add(t);
    }

    // Returns the full list of tasks
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    // Returns the number of completed tasks
    public int getCompletedCount() {
        int count = 0;
        for (Task t : tasks) {
            if (t.isCompleted()) count++;
        }
        return count;
    }
}
