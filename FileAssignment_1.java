/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclass;

import com.sun.org.apache.xml.internal.serialize.Printer;
import file.JFontchooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer.UIResource;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.BadLocationException;
import static oracle.jrockit.jfr.events.Bits.length;
//import javax.swing.*;
//import javax.swing.event.*;

/**
 *
 * @author Shimaa
 */
public class FileAssignment_1 extends JFrame implements ActionListener {

    JTextArea jta;
    JTextField status;
    JScrollPane jsp;
    JCheckBoxMenuItem cbMenuItem;
    JLabel statusBar = new JLabel();
    public FileAssignment_1() {
       // super("QuickChange v1.0");
        initUI();
    }

    private void initUI() {

        jta = new JTextArea(14, 34);//14,34
        jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setLayout(new FlowLayout());
        //setLayout(new BorderLayout());
        add(jsp);
        setTitle("Untitled-Notepad");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
  //      setJMenuBar(FileAssignment.menuBarCreator());
      //   add(FileAssignment.setTitle());
        // setVisible(true);
//        jta.addCaretListener(new CaretListener() {
//         public void caretUpdate(CaretEvent e){
//             JTextArea editArea=(JTextArea)e.getSource();
//             int linenum=1;
//             int columnnun=1;
//             
//             try{
//                 int caretops=editArea.getCaretPosition();
//                 linenum=editArea.getLineOfOffset(caretops);
//                 
//                 columnnun=caretops-editArea.getLineStartOffset(linenum);
//                 
//                 linenum +=1;
//             }
//             catch(Exception ex){
//                updateStatus(linenum, columnnun);  
//             }
//           //);
//        add(jta,BorderLayout.CENTER);
//          JTextField status=new JTextField();
//         add(status,BorderLayout.SOUTH);
//         updateStatus(1,1);
//                     
//         }
//            private void updateStatus(int linenum, int columnnun) {
//                          status.setText("Line: " + linenum + " Column: " + columnnun);       
//            }
//                });
                

        final JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu FileMenu = new JMenu("File");
        FileMenu.setMnemonic('F');
        menubar.add(FileMenu);
        JMenuItem NewItem = new JMenuItem("New");
        FileMenu.add(NewItem);
        NewItem.addActionListener(this);
        NewItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
//        JToolBar NewBar=new JToolBar("Ctrl");
//        NewItem.add(NewBar);
        JMenuItem OpenItem = new JMenuItem("Open_");
        FileMenu.add(OpenItem);
        OpenItem.addActionListener(this);
        OpenItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        JMenuItem SaveItem = new JMenuItem("Save");
        FileMenu.add(SaveItem);
        SaveItem.addActionListener(this);
        SaveItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        FileMenu.addSeparator();
        JMenuItem PrintItem = new JMenuItem("Print");
        FileMenu.add(PrintItem);
        PrintItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        FileMenu.addSeparator();
        PrintItem.addActionListener(this);
        JMenuItem ExitItem = new JMenuItem("Exit");
        FileMenu.add(ExitItem);
        ExitItem.addActionListener(this);

        //-------------------------
        JMenu EditMenu = new JMenu("Edit");
        EditMenu.setMnemonic('E');
        menubar.add(EditMenu);
        final JMenuItem CutItem = new JMenuItem("Cut");
        EditMenu.add(CutItem);
        CutItem.addActionListener(this);
        CutItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        final JMenuItem CopyItem = new JMenuItem("Copy");
        CopyItem.setMnemonic('C');
        EditMenu.add(CopyItem);
        CopyItem.addActionListener(this);
        CopyItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        JMenuItem PasteItem = new JMenuItem("Paste");
        PasteItem.setMnemonic('P');
        EditMenu.add(PasteItem);
        PasteItem.addActionListener(this);
        PasteItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        final JMenuItem DeleteItem = new JMenuItem("Delete");
        EditMenu.add(DeleteItem);
        EditMenu.addSeparator();
        final JMenuItem GoToItem = new JMenuItem("Go To");
        GoToItem.setMnemonic('G');
        EditMenu.add(GoToItem);
        GoToItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        GoToItem.addActionListener(this);
        EditMenu.addSeparator();
        final JMenuItem SelectAllItem = new JMenuItem("Select All");
        EditMenu.add(SelectAllItem);
        SelectAllItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        SelectAllItem.addActionListener(this);
        JMenuItem TimeDateItem = new JMenuItem("TimeDate");
        EditMenu.add(TimeDateItem);
        TimeDateItem.addActionListener(this);

        JMenu FormatMenu = new JMenu("Format");
        FormatMenu.setMnemonic('F');
        menubar.add(FormatMenu);
        JCheckBoxMenuItem WordWrapMenuItem = new JCheckBoxMenuItem("Word Wrap");
        WordWrapMenuItem.setMnemonic(KeyEvent.VK_W);
        FormatMenu.add(WordWrapMenuItem);
        WordWrapMenuItem.addActionListener(this);
        JMenuItem FontItem = new JMenuItem("Font_");
        FontItem.setMnemonic(KeyEvent.VK_F);
        FormatMenu.add(FontItem);
        FontItem.addActionListener(this);
        FormatMenu.addSeparator();
        JMenuItem SetTextItem = new JMenuItem("Set Text color_");
        SetTextItem.setMnemonic(KeyEvent.VK_T);
        FormatMenu.add(SetTextItem);
        SetTextItem.addActionListener(this);
        JMenuItem SetPadItem = new JMenuItem("Set Pad color_");
        SetPadItem.setMnemonic(KeyEvent.VK_P);
        FormatMenu.add(SetPadItem);
        SetPadItem.addActionListener(this);

        final JMenu ViewMenu = new JMenu("View");
        ViewMenu.setMnemonic('V');
        menubar.add(ViewMenu);
         final JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Status Bar");
        cbMenuItem.setMnemonic(KeyEvent.VK_S);
        ViewMenu.add(cbMenuItem);
        cbMenuItem.addActionListener(this);
//        cbMenuItem.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if(cbMenuItem.isSelected()){
//                  final JLabel d=new JLabel();
//                  jta.addKeyListener(new KeyAdapter() {
//                      public  void keyPressed(KeyEvent e){
//                          try{
//                           int y=jta.getCaretPosition()-jta.getLineStartOffset(jta.getLineOfOffset(jta.getCaretPosition())); 
//                           String labelText = "row:"+jta.getLineCount()+" Column:"+y;
//                            d.setVisible(true);
//                             d.setText(labelText);
//                              d.revalidate(); d.repaint();
//                               add(d, BorderLayout.SOUTH);
//                          } catch (BadLocationException ex) {
//                              Logger.getLogger(FileAssignment.class.getName()).log(Level.SEVERE, null, ex);
//                          }
//                      }
//});
//                }
//            }
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(cbMenuItem.isSelected()){
//                   final  JLabel d = new JLabel();
//                    jta.addKeyListener(new KeyAdapter() {
//                            @Override
//                                    public void keyPressed(KeyEvent e){
//                                try {
//                                    int y=jta.getCaretPosition()-jta.getLineStartOffset(jta.getLineOfOffset(jta.getCaretPosition()));
//                                    String labelText = "row:"+jta.getLineCount()+" Column:"+y;
//                                    d.setVisible(true);
//                    d.setText(labelText);
//                    d.revalidate(); d.repaint();
//                    add(d, BorderLayout.SOUTH);
//                                } catch (BadLocationException ex) {
//                                    Logger.getLogger(FileAssignment.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                                    }
//                    });
     //   });
                

        //--------------------------------------------------------------------------------------------------
        final JMenu lnf = new JMenu("Change Look and Feel", true);
        lnf.setMnemonic(KeyEvent.VK_C);
        ViewMenu.add(lnf);
        ButtonGroup buttonGroup = new ButtonGroup();
        final UIManager.LookAndFeelInfo[] info
                = UIManager.getInstalledLookAndFeels();
        for (int i = 0; i < info.length; i++) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(info[i].getName(), i == 0);
            final String className = info[i].getClassName();
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    try {
                        UIManager.setLookAndFeel(className);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    SwingUtilities.updateComponentTreeUI(FileAssignment_1.this);
                
                }
            });
            buttonGroup.add(item);
            lnf.add(item);
        
        }
//        JMenu optionMenu =new JMenu("Change Look and Feel");
//        optionMenu.setMnemonic(KeyEvent.VK_C);
//        ViewMenu.add(optionMenu);
//      //final ButtonGroup group = new ButtonGroup();
//        JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("Metal");
//        rbMenuItem.setMnemonic(KeyEvent.VK_M);
//        optionMenu.add(rbMenuItem);
//        JRadioButtonMenuItem NimbusMenuItem = new JRadioButtonMenuItem("Nimbus");
//        NimbusMenuItem.setMnemonic(KeyEvent.VK_N);
//        optionMenu.add(NimbusMenuItem);
//        JRadioButtonMenuItem CDEMenuItem = new JRadioButtonMenuItem("CDE/Motif");
//        CDEMenuItem.setMnemonic(KeyEvent.VK_C);
//        optionMenu.add(CDEMenuItem);
//        JRadioButtonMenuItem WindowsMenuItem = new JRadioButtonMenuItem("Windows");
//        WindowsMenuItem.setMnemonic(KeyEvent.VK_W);
//        optionMenu.add(WindowsMenuItem);
//        WindowsMenuItem.addActionListener(this);
//        JRadioButtonMenuItem ClassicMenuItem = new JRadioButtonMenuItem("Windows Classic");
//        ClassicMenuItem.setMnemonic(KeyEvent.VK_W);
//        optionMenu.add(ClassicMenuItem);
//        group.add(rbMenuItem);
//        group.add(NimbusMenuItem);
//        group.add(CDEMenuItem);
//        group.add(WindowsMenuItem);
//        group.add(ClassicMenuItem);

        JMenu HelpMenu = new JMenu("Help");
        HelpMenu.setMnemonic('H');
        menubar.add(HelpMenu);
        JMenuItem AboutNotepadItem = new JMenuItem("About Notepad");
        AboutNotepadItem.setMnemonic('A');
        HelpMenu.add(AboutNotepadItem);
        AboutNotepadItem.addActionListener(this);

        jta.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (jta.getSelectedText() == null) {
                    CutItem.setEnabled(false);
                    CopyItem.setEnabled(false);
                    DeleteItem.setEnabled(false);
                } else if (!(jta.getSelectedText() == null)) {
                    CutItem.setEnabled(true);
                    CopyItem.setEnabled(true);
                    DeleteItem.setEnabled(true);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (jta.getSelectedText() == null) {
                    CutItem.setEnabled(false);
                    CopyItem.setEnabled(false);
                    DeleteItem.setEnabled(false);
                } else if (!(jta.getSelectedText() == null)) {
                    CutItem.setEnabled(true);
                    CopyItem.setEnabled(true);
                    DeleteItem.setEnabled(true);
                }
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        jta.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent fe) {
                if (jta.getText().equals("")) {
                    SelectAllItem.setEnabled(false);
                    GoToItem.setEnabled(false);
                } else if (!(jta.getText().equals(""))) {
                    SelectAllItem.setEnabled(true);
                    GoToItem.setEnabled(true);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (jta.getText().equals("")) {
                    SelectAllItem.setEnabled(false);
                    GoToItem.setEnabled(false);
                } else if (!(jta.getText().equals(""))) {
                    SelectAllItem.setEnabled(true);
                    GoToItem.setEnabled(true);
                }
                //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//         JFrame f = new FileAssignment( );
//    f.addWindowListener(new WindowAdapter( ) {
//      public void windowClosing(WindowEvent e) { System.exit(0); }
//    });
        FileAssignment_1 ex = new FileAssignment_1();
        ex.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Clipboard clipboard = getToolkit().getSystemClipboard();
        String obj = ae.getActionCommand();
        if (obj.equals("Print")) {
            JOptionPane.showMessageDialog(this, "Get ur printer repaired first it seema u dont have one!", "Bad Printer", WIDTH);  //JOptionPane.WARNING_MESSAGE WIDTH
        } else if (obj.equals("Exit")) {
            Object[] options = {"Yes", "No", "Cancel"};
            int n = JOptionPane.showOptionDialog(this, "the text in Untitled file has been changed \n "
                    + "Do you want to save the changes?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (n == JOptionPane.YES_OPTION) {//.YES_OPTIO
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new File("."));
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fc.showDialog(this, "Save");
                String filename = fc.getSelectedFile().getPath();
                try {
                    FileWriter fw = new FileWriter(new File(filename));
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(jta.getText());
                    pw.close();
                    fw.close();

                } catch (IOException e1) {
                    jta.setText("Exception: " + e1);
                }
            }
            if (n == JOptionPane.NO_OPTION) {//.YES_OPTION
                System.exit(0);
            }
        } else if (obj.equals("About Notepad")) {
            JOptionPane.showMessageDialog(null, "Item is selected", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (obj.equals("Select All")) {
            jta.selectAll();
      //  } 
//        else if (obj.equals("Status Bar")) {
//           
//          if (cbMenuItem.isSelected()) {
//              jta.addCaretListener(new CaretListener() {
//                
//                  @Override
//                  public void caretUpdate(CaretEvent ce) {
//                  JPanel statusBar =new JPanel();
//                  
//                      int row =0;
//           int col=0;
//           int postion=0;
//                      try{
//                         postion=jta.getCaretPosition();
//                          row=jta.getLineOfOffset(postion);
//                          col=postion-jta.getLineStartOffset(row);
//                      }catch(Exception excp){
//                  }
//                      if(jta.getText().length()==0){
//                          row=0;
//                          col=0;
//                      }
//                      //statusBar.setText("||LN"+(row+1+",col"+(col+1)));
//                  }
//              });
//               statusBar.setVisible(true);
//             repaint();
//              revalidate();
//          }
             
          
//               final JLabel d = new JLabel();
//                jta.addKeyListener(new KeyAdapter() {
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                        try {
//                            int y = jta.getCaretPosition() - jta.getLineStartOffset(jta.getLineOfOffset(jta.getCaretPosition()));
//                            String labelText = "row:" + jta.getLineCount() + " Column:" + y;
//                            d.setVisible(true);
//                            d.setText(labelText);
//                            d.revalidate();
//                            d.repaint();
//                            add(d, BorderLayout.SOUTH);
//                        } catch (BadLocationException ex) {
//                            Logger.getLogger(FileAssignment.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//               });
//           }
//
//            // cbMenuItem.setState(true);
        } else if (obj.equals("Go To")) {

//            for(int i=0;i<10;i++){
//           final int index = i;
//         JButton button=new JButton(buttons[i]);
//          setPage(index);
//            }
            JFrame frame = new JFrame("InputDialog Example #1");
//         String name = JOptionPane.showInputDialog(frame, "Enter Line Number:");
//            jta.setCaretPosition(Integer.valueOf(name));
            int lineNumber = 0;
            try {
                lineNumber = jta.getLineOfOffset(jta.getCaretPosition()) + 1;
                String tempStr = JOptionPane.showInputDialog(frame, "Enter Line Number:", "" + lineNumber);
                if (tempStr == null) {
                    return;
                }
                lineNumber = Integer.parseInt(tempStr);
                jta.setCaretPosition(jta.getLineStartOffset(lineNumber - 1));
            } catch (Exception e) {
            }
    // get the user's input. note that if they press Cancel, 'name' will be null
            //    System.out.printf("The user's Number is '%s'.\n", name);
            //System.exit(0);

        } else if (obj.equals("Font_")) {
            JFontchoosers_1 font =new JFontchoosers_1(jta);
        
        } else if (obj.equals("Open_")) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fc.showDialog(this, "Open");
            String filename = fc.getSelectedFile().getPath();
            try {
                FileReader fr = new FileReader(new File(filename));
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    jta.append(line);
                    jta.append(" \n");
                    line = br.readLine();
                }
            } catch (IOException e1) {
                jta.setText("Exception: " + e1);
            }
        } else if (obj.equals("Save")) {
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fc.showDialog(this, "Save");
            String filename = fc.getSelectedFile().getPath();
            try {
                FileWriter fw = new FileWriter(new File(filename));
                PrintWriter pw = new PrintWriter(fw);
                pw.println(jta.getText());
                pw.close();
                fw.close();

            } catch (IOException e1) {
                jta.setText("Exception: " + e1);
            }

        } else if (obj.equals("New")) {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
        } else if (obj.equals("Cut")) {
            StringSelection data = new StringSelection(jta.getText());
            clipboard.setContents(data, data);
            jta.setText("");
        } else if (obj.equals("Copy")) {
            StringSelection data = new StringSelection(jta.getText());
            clipboard.setContents(data, data);
        } else if (obj.equals("Paste")) {
            Transferable clipData = clipboard.getContents(this);
            String s;
            try {
                s = (String) clipData.getTransferData(DataFlavor.stringFlavor);
            } catch (Exception ex) {
                s = ex.toString();
            }
            jta.setText(s);
        } else if (obj.equals("Delete")) {
            jta.setText("");
        } else if (obj.equals("TimeDate")) {
            jta.setText("TimeDate: " + new java.util.Date());
        } else if (obj.equals("Set Pad color_")) {
            final JColorChooser cchooser = new JColorChooser();
            JDialog dialog;
            dialog = JColorChooser.createDialog(this,
                    "Background Color",
                    false /* not modal */,
                    cchooser,
                    new ActionListener() // OK button listener
                    {
                        public void actionPerformed(ActionEvent event) {
                            jta.setBackground(cchooser.getColor());
                        }
                    },
                    null /* no Cancel button listener */);
            dialog.show();
        } else if (obj.equals("Set Text color_")) {
            final JColorChooser cchooser = new JColorChooser();
            JDialog dialog;
            dialog = JColorChooser.createDialog(this,
                    "Background Color",
                    false /* not modal */,
                    cchooser,
                    new ActionListener() // OK button listener
                    {
                        public void actionPerformed(ActionEvent event) {
                            jta.setForeground(cchooser.getColor());
                        }
                    },
                    null /* no Cancel button listener */);
            dialog.show();

        } else if (obj.equals("Word Wrap")) {
            jta.setLineWrap(true);
            jta.setWrapStyleWord(true);

        }
    }
}

