import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 * TaskPanel is a JPanel that handles drawing tasks and user interaction (mouse clicks).
 * It uses random positioning to place new tasks and allows clicking to mark them complete.
 */
public class TaskPanel extends JPanel implements MouseListener {
    private TaskManager manager;
    private Random rand;

    // Constructor initializes panel and mouse listener
    public TaskPanel(TaskManager manager) {
        this.manager = manager;
        this.rand = new Random();
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    // Adds a new task with a random location on the panel
    public void addNewTask(String desc) {
        int x = rand.nextInt(getWidth() - 160);
        int y = rand.nextInt(getHeight() - 50);
        Task task = new Task(desc, x, y);
        manager.addTask(task);
        repaint();
    }

    // Draws all tasks on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Task t : manager.getAllTasks()) {
            t.draw((Graphics2D) g);
        }
    }

    // Handles mouse click events to toggle task completion
    @Override
    public void mouseClicked(MouseEvent e) {
        for (Task t : manager.getAllTasks()) {
            if (t.getBounds().contains(e.getPoint())) {
                t.toggleComplete();
                repaint();
                break;
            }
        }
    }

    // Unused mouse events (required by interface)
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
