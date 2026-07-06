import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * MainAppFrame sets up the main GUI window.
 * It contains input fields, a button to add tasks, and a label to show progress.
 */
public class MainAppFrame extends JFrame implements ActionListener {
    private TaskManager manager;
    private TaskPanel panel;
    private JTextField inputField;
    private JLabel statusLabel;

    // Sets up the frame, GUI components, and layout
    public MainAppFrame() {
        super("Mini Productivity Visualizer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(new BorderLayout());

        manager = new TaskManager();
        panel = new TaskPanel(manager);
        add(panel, BorderLayout.CENTER);

        // Top input panel with text field and button
        JPanel topPanel = new JPanel();
        inputField = new JTextField(15);
        JButton addButton = new JButton("Add Task");
        statusLabel = new JLabel("0 completed out of 0");

        addButton.addActionListener(this);

        topPanel.add(new JLabel("Task:"));
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(statusLabel);

        add(topPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    // Handles button clicks to add a new task
    @Override
    public void actionPerformed(ActionEvent e) {
        String desc = inputField.getText().trim();
        if (!desc.isEmpty()) {
            panel.addNewTask(desc);
            inputField.setText("");
            updateStatus();
        }
    }

    // Updates the progress label with task completion stats
    private void updateStatus() {
        int done = manager.getCompletedCount();
        int total = manager.getAllTasks().size();
        statusLabel.setText(done + " completed out of " + total);
    }
}
