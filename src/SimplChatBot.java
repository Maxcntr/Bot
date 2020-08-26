
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplChatBot extends JFrame implements ActionListener {


    final String TITLE_OF_PROGRAM = "Cater: simpl chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WITHD = 350;
    final int WINDOW_HEIGHT = 450;

    JTextArea dialoque;  // area for dialog
    JCheckBox ai;         //enabl/disnabl AI
    JTextField massage;
    SimpleBot sbot;


    public static void main(String[] args) {
        new SimplChatBot();
    }
    SimplChatBot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WITHD, WINDOW_HEIGHT);
        setAlwaysOnTop(true);

        dialoque = new JTextArea();
        dialoque.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(dialoque);
        dialoque.setEnabled(false);




      JPanel br = new JPanel();
      br.setLayout(new BoxLayout(br, BoxLayout.X_AXIS));
      ai = new JCheckBox("AI");
      ai.doClick();
      massage = new JTextField();
      massage.addActionListener( this);
      JButton enter = new JButton("ENTER");
      enter.addActionListener( this);
        br.add(ai);
        br.add(massage);
        br.add(enter);

        add(BorderLayout.CENTER, scrollPane);
        add(BorderLayout.SOUTH, br);
        setVisible(true);
        sbot = new SimpleBot();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if(massage.getText().trim().length() > 0) {
            dialoque.append(massage.getText() +"\n");

            dialoque.append(TITLE_OF_PROGRAM.substring(0,9) +
                    sbot.seyInRetorn(massage.getText() , ai.isSelected())+ "\n");
        }
        massage.setText("   ");
        massage.requestFocusInWindow();
    }
}
