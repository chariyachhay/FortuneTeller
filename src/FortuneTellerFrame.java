import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    private JPanel topPanel;
    private JLabel titleLabel;
    private Font titleFont;

    private JPanel middlePanel;
    private JTextArea fortuneArea;
    private JScrollPane scrollPane;
    private Font fortuneFont;

    private JPanel bottomPanel;
    private JButton fortuneButton;
    private JButton quitButton;
    private Font buttonFont;

    private String[] fortunes;
    private int lastIndex = -1;
    private Random random;

    public FortuneTellerFrame() {

        // setting up the frame stuff
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== top panel =====
        topPanel = new JPanel();

        titleFont = new Font("Serif", Font.BOLD, 40);

        ImageIcon icon = new ImageIcon(getClass().getResource("fortune.jpg"));

        titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);

        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setVerticalTextPosition(JLabel.BOTTOM);
        titleLabel.setFont(titleFont);

        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        // ===== middle panel =====
        middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());

        fortuneFont = new Font("Serif", Font.PLAIN, 18);

        fortuneArea = new JTextArea();
        fortuneArea.setFont(fortuneFont);
        fortuneArea.setEditable(false);

        scrollPane = new JScrollPane(fortuneArea);

        middlePanel.add(scrollPane, BorderLayout.CENTER);
        add(middlePanel, BorderLayout.CENTER);

        // ===== bottom panel =====
        bottomPanel = new JPanel();

        buttonFont = new Font("Serif", Font.BOLD, 18);

        fortuneButton = new JButton("Read My Fortune!");
        quitButton = new JButton("Quit");

        fortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        bottomPanel.add(fortuneButton);
        bottomPanel.add(quitButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // ===== fortunes array =====
        fortunes = new String[] {
                "a squirrel on campus will steal your brownie.",
                "you will end the semester with almost straight As but one B.",
                "you won't have to freeze the moment you step outside anymore.",
                "spring will come sooner than the groundhog said.",
                "you will accidentally step in slime.",
                "your friend will ask you to let them borrow $100.",
                "you will see a bird steal someone's fry.",
                "there will be a pug in your neighborhood tomorrow.",
                "a tiktok video will inspire you to start a hobby you won't finish.",
                "a group project partner will not do their part.",
                "you will gain and lose the same 5 pounds.",
                "treat yo self to 8 pastries today."
        };

        random = new Random();

        // button logic
        fortuneButton.addActionListener(e -> {

            int index = random.nextInt(fortunes.length);

            // make sure it doesnt repeat twice in a row
            while (index == lastIndex) {
                index = random.nextInt(fortunes.length);
            }

            lastIndex = index;

            fortuneArea.append(fortunes[index] + "\n");
        });

        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        // using toolkit to size frame to 3/4 of screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int)(screenSize.width * 0.75);
        int height = (int)(screenSize.height * 0.75);

        setSize(width, height);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new FortuneTellerFrame();
        });
    }
}
