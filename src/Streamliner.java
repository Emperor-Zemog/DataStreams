import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Streamliner extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    JTextArea sLUnF = new JTextArea("", 15, 50); // Text area
    JTextArea sLFil = new JTextArea("", 15, 50); // Text area
    JLabel unFilTitle = new JLabel("Unfiltered");
    JLabel filTitle = new JLabel("Filtered");
    JLabel sSLTitle = new JLabel("Search String:");
    JTextArea lineIType = new JTextArea("", 1, 10);


    public Streamliner (){
        super();
        sLUnF.setLineWrap(true);
        JScrollPane sbrUnText = new JScrollPane(sLUnF); // Scroll pane for text area
        sbrUnText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sLFil.setLineWrap(true);
        JScrollPane sbrFilText = new JScrollPane(sLFil); // Scroll pane for text area
        sbrFilText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Compare & Contrast", TitledBorder.LEFT, TitledBorder.TOP));
        c.weightx = 1;

        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        add(sSLTitle, c);
        c.gridx = 0;
        c.gridy = 1;
        add(lineIType,c);
        c.gridx = 0;
        c.gridy = 2;
        add(unFilTitle, c);
        c.gridx = 0;
        c.gridy = 3;
        add(sbrUnText, c);
        c.gridx = 1;
        c.gridy = 2;
        add(filTitle, c);
        c.gridx = 1;
        c.gridy = 3;
        add(sbrFilText, c);



    }
    public void writeUFText(String outText){
        int past = sLUnF.getText().length();
        if(past==0) {
            sLUnF.setText(outText);
        }else {
            sLUnF.setText(sLUnF.getText()+"\n"+outText);

        }

    }
    public void writeFText(String outText){
        int past = sLFil.getText().length();
        if(past==0) {
            sLFil.setText(outText);
        }else {
            sLFil.setText(sLFil.getText()+"\n"+outText);

        }

    }
    public String getSSTring(){
        return lineIType.getText();
    }
}
