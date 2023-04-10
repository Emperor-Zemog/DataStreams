import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Mercury extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    JButton docButton = new JButton("Select Text File");

    JButton processButton = new JButton("Search The File");
    JButton quit = new JButton("Quit");
    JFileChooser docSelect = new JFileChooser();
    String selectedText = "";
    boolean docChose = false;
    boolean searchStart = false;

    public Mercury(){
        super();
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Actions", TitledBorder.LEFT, TitledBorder.TOP));
        c.weightx = 1;

        c.ipady = 0;

        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;

        add(quit,c);
        c.gridx = 2;
        c.gridy = 1;
        add(processButton,c);
        c.gridx = 3;
        c.gridy = 1;
        add(docButton,c);

    }
    public void mercuryListen(Streamliner cincy){
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(new JFrame(),"Sure? You want to exit?", "Quit Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);

                }else if (result == JOptionPane.NO_OPTION){

                }else {

                }
            }
        });
        docButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                docSelect.showDialog(new JFrame(), "Choose Document");
                selectedText=docSelect.getSelectedFile().getName();
                docChose = true;
                cincy.writeUFText(getDocCont());


            }
        });
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(docChose==true){
                    searchStart = true;
                    String rawDoc = getDocCont();
                    String lowDoc = rawDoc.toLowerCase();
                    String val = cincy.getSSTring().toLowerCase();
                    ArrayList<String> sList = new ArrayList<String>();


                    sList = splitSubstrings(lowDoc);
                    ArrayList<String> filDoc = (ArrayList<String>) sList.stream().filter(c -> c.contains(val)).collect(Collectors.toList());
                    for(int x =0; x<filDoc.size();x++) {
                        cincy.writeFText(filDoc.get(x));
                    }




                }
            }
        });

    }

    public boolean isDocChose() {
        return docChose;
    }
    public String getDocCont(){
        File doc = docSelect.getSelectedFile();
        Path fPath= Path.of(doc.getPath());
        String subject="";
        try {
            subject= Files.readString(fPath);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return subject;
    }

    public boolean isSearchStart() {
        return searchStart;
    }
    public static ArrayList<String> splitSubstrings(String s)
    {


        int i, j;


        int stringLength = s.length();


        ArrayList<String> subStringList = new ArrayList<String>();

        i=0;
        j=0;
        while(i<stringLength){
            if(s.charAt(i)=='.'&& s.charAt(i+1)==' '){
                subStringList.add(s.substring(j,i));
                j=i+1;
            } else if(s.charAt(i)=='.'&& s.charAt(i)=='\n'){
                subStringList.add(s.substring(j,i));
                j=i+1;
            }else if(s.charAt(i)=='!'&& s.charAt(i+1)=='\n'){
                subStringList.add(s.substring(j,i));
                j=i+1;
            }else if(s.charAt(i)=='!'&& s.charAt(i+1)==' '){
                subStringList.add(s.substring(j,i));
                j=i+1;
            }else if(s.charAt(i)=='?'&& s.charAt(i+1)=='\n'){
                subStringList.add(s.substring(j,i));
                j=i+1;
            }else if(s.charAt(i)=='?'&& s.charAt(i+1)==' '){
                subStringList.add(s.substring(j,i));
                j=i+1;
            }else if(s.charAt(i)=='?') {
                subStringList.add(s.substring(j, i));
                j = i + 1;
            }else if(s.charAt(i)=='!') {
                subStringList.add(s.substring(j, i));
                j = i + 1;



            }else if (i==stringLength-1) {
                subStringList.add(s.substring(j,i));
            }
            i++;
        }


        return subStringList;
    }
}
