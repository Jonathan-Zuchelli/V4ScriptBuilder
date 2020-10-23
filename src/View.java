import sun.plugin.dom.css.RGBColor;
import sun.plugin2.util.ColorUtil;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;


public class View extends JFrame implements ActionListener {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private double screenHeight = screenSize.getHeight();
    private double screenWidth = screenSize.getWidth();

    public final int FRAME_HEIGHT = (int)screenHeight/2;
    public final int FRAME_WIDTH = (int)screenWidth/2;

    private App mApp;
    private JLabel mAppLabel;
    private JLabel mAppDesc;
    private JButton mNewDeployment;
    private JButton mSiteUpdate;
    private JButton mUpdateConnectionString;
    private JButton mRestartAPI;
    private JButton mRemoveSite;
    private JButton mGenerateScript;
    private JButton mExit;

    private JTextArea mScriptOutput;

    private JLabel mNameSpace;
    private JLabel mDNS;
    private JLabel mAPIBuild;
    private JLabel mBookingBuild;
    private JLabel mOptionsBuild;
    private JLabel mDBIP;
    private JLabel mDBUser;
    private JLabel mDBPassword;
    private JLabel mDBName;

    private JTextField mNameSpaceText;
    private JTextField mDNSText;
    private JTextField mAPIBuildText;
    private JTextField mBookingBuildText;
    private JTextField mOptionsBuildText;
    private JTextField mDBIPText;
    private JTextField mDBUserText;
    private JTextField mDBPasswordText;
    private JTextField mDBNameText;

    public View(App pApp){
        mApp = pApp;

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 1;
        constraints.weighty = .25;
        constraints.insets = new Insets(5,0,5,0);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;


        mNewDeployment = new JButton("New Deployment");
        mNewDeployment.setFont(new Font("Arial", Font.BOLD, 12));
        mSiteUpdate = new JButton("Site Update");
        mSiteUpdate.setFont(new Font("Arial", Font.BOLD, 12));
        mUpdateConnectionString = new JButton("Update Connection String");
        mUpdateConnectionString.setFont(new Font("Arial", Font.BOLD, 12));
        mRestartAPI = new JButton("Restart APIs");
        mRestartAPI.addActionListener(this);
        mRestartAPI.setFont(new Font("Arial", Font.BOLD, 12));
        mRemoveSite = new JButton("Remove Site");
        mRemoveSite.setFont(new Font("Arial", Font.BOLD, 12));
        buttonPanel.add(mNewDeployment, constraints);
        buttonPanel.add(mSiteUpdate, constraints);
        buttonPanel.add(mUpdateConnectionString, constraints);
        buttonPanel.add(mRestartAPI, constraints);
        buttonPanel.add(mRemoveSite, constraints);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(0,0,5,0);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.PAGE_END;

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new GridBagLayout());
        mExit = new JButton("Exit");
        mExit.setFont(new Font("Arial", Font.BOLD, 12));
        mExit.addActionListener(this);
        exitPanel.add(mExit, constraints);

        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridBagLayout());
        mAppLabel = new JLabel("V4 Script Generator", SwingConstants.CENTER);
        mAppLabel.setFont(new Font("Arial", Font.BOLD, 36));
        mAppDesc = new JLabel("", SwingConstants.CENTER);
        mAppDesc.setFont(new Font("Arial", Font.PLAIN, 20));
        mAppDesc.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelPanel.add(mAppLabel, constraints);
        labelPanel.add(mAppDesc, constraints);

        constraints.weightx = 0;
        constraints.weighty = 0;

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new GridBagLayout());
        mGenerateScript = new JButton("Generate Script");
        mGenerateScript.setBackground(Color.GREEN);
        mGenerateScript.setFont(new Font("Arial", Font.BOLD, 12));
        mScriptOutput = new JTextArea("sudo ./deploy_all.sh -n {namespace} -t {APIBuild} -t-opt {OptionsBuild} " +
                "-t-res {ORESBuild} -dns {DNS}.cps.golf -https true -dbcon 'Server={DB IP Address},PORT;" +
                "Database={DB Name};User Id={DB Username};Password={DB password};MultipleActiveResultSets=True;'");
        mScriptOutput.setLineWrap(true);
        mScriptOutput.setWrapStyleWord(true);

        constraints.anchor = GridBagConstraints.NORTHEAST;
        constraints.weightx = GridBagConstraints.NONE;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0,0,5,0);

        outputPanel.add(mGenerateScript, constraints);

        constraints.insets = new Insets(0,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;


        outputPanel.add(mScriptOutput, constraints);
        outputPanel.setVisible(false);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.add(buttonPanel);
        mainPanel.add(labelPanel);
        mainPanel.add(exitPanel);
        mainPanel.add(outputPanel);

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
            case "Restart APIs":
                mNewDeployment.setVisible(false);
                break;
        }
    }
}
