import java.awt.*;

/*
 * Task class represents a visual task with a description, position, and completion status.
 * It includes methods to draw the task, toggle its completion, and check for clicks.
 */
public class Task {
    private String description;
    private boolean completed;
    private int x, y, width = 150, height = 40;

    // Constructor that sets the description and the task's position on the panel
    public Task(String description, int x, int y) {
        this.description = description;
        this.completed = false;
        this.x = x;
        this.y = y;
    }

    // Toggles the task between completed and not completed
    public void toggleComplete() {
        completed = !completed;
    }

    // Returns true if the task is completed
    public boolean isCompleted() {
        return completed;
    }

    // Returns a rectangle representing the task's area (used for click detection)
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    // Draws the task on the panel with color indicating completion status
    public void draw(Graphics2D g) {
        g.setColor(completed ? Color.GREEN : Color.RED);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.drawString(description, x + 10, y + 25);
    }
}
