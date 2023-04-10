import javax.swing.*;
import java.awt.*;

public class DataTrain extends JFrame {
    public DataTrain (){
        super("Show and Tell");


        boolean processFin= false;

        Streamliner cincy = new Streamliner();
        Mercury detroit = new Mercury();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());
        c.weightx = 1;
        c.weighty=1;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        add(cincy,c);
        c.gridx = 0;
        c.gridy = 1;
        add(detroit,c);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen

        setSize((int) (screenWidth / 1.25), (int) (screenHeight / 1.25));

        setLocation((int) (screenWidth / 9.5), (int) (screenHeight / 9));

        // Render the Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        detroit.mercuryListen(cincy);


        show();
    }
}
