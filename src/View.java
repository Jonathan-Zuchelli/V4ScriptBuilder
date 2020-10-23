import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class View extends JFrame implements ActionListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private double screenHeight = screenSize.getHeight();
    private double screenWidth = screenSize.getWidth();

    public final int FRAME_HEIGHT = (int)screenHeight/2;
    public final int FRAME_WIDTH = (int)screenWidth/2;

    private App mApp;

    public View(App pApp){
        mApp = pApp;

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        setTitle("V4 Script Generator");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocation((int)screenWidth / 4, (int)screenHeight / 4);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        switch (event.getActionCommand()){
            case "Exit":
                mApp.exit();
        }
    }
}
