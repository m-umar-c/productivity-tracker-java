/*
    Program Description:
    This is a simple graphical productivity tracker.
    The user types a task description and clicks "Add Task" to add it to the screen.
    Tasks appear as red boxes. Clicking a box turns it green to mark it completed.
    A label shows how many tasks have been completed.

    Swing Components:
    - JTextField: for entering task descriptions
    - JButton: to add a new task
    - JLabel: shows task progress

    2D Graphics:
    - Tasks are drawn as colored rectangles on a JPanel

    Event Listeners:
    - ActionListener: adds tasks to the screen
    - MouseListener: marks tasks as complete when clicked
*/

public class Project2Runner {
    public static void main(String[] args) { 
        new MainAppFrame();
    }
}
