import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalWallClock extends JFrame {

    JLabel timeLabel;
    JLabel dateLabel;
    JLabel titleLabel;

    DigitalWallClock() {

        // Create window
        setTitle("Digital Wall Clock");
        setSize(750, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(15, 20, 45));
        panel.setLayout(new GridLayout(3, 1));

        // Title
        titleLabel = new JLabel("DIGITAL WALL CLOCK");
        titleLabel.setForeground(new Color(180, 150, 255));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // Time
        timeLabel = new JLabel();
        timeLabel.setForeground(new Color(120, 200, 255));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 80));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        // Date
        dateLabel = new JLabel();
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add components
        panel.add(titleLabel);
        panel.add(timeLabel);
        panel.add(dateLabel);

        add(panel);

        // Update clock every second
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        // Show current time immediately
        updateClock();

        setVisible(true);
    }

    void updateClock() {

        Date now = new Date();

        SimpleDateFormat timeFormat =
                new SimpleDateFormat("hh:mm:ss a");

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("EEEE, dd MMMM yyyy");

        timeLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
    }

    public static void main(String[] args) {
        new DigitalWallClock();
    }
}