import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {

    public FortuneTellerFrame() {

        // setting up the frame stuff
        setTitle("fortune teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // gonna use borderlayout like prof said
        setLayout(new BorderLayout());

        // just basic size for now
        setSize(600, 400);

        // centers it on screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {

        // using invokelater like prof wants for swing
        SwingUtilities.invokeLater(() -> {
            new FortuneTellerFrame();
        });
    }
}
