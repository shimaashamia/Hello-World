/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author hp15 ac
 */
public class JFontchoosers_1 {

    protected static final String fontSize[] = {"10", "12", "14", "16", "18","20", "22", "24", "26", "28", "30", "32", "34", "36","38","40","42","44","46","48","50","52","54","56","58","60"};

    int[] FontStyle = {Font.ROMAN_BASELINE,Font.ITALIC, Font.BOLD, Font.PLAIN, Font.TYPE1_FONT};

    protected String fontFamily[];
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    JFrame frame = new JFrame();

    JButton ok = new JButton("Ok");
    JButton cancel = new JButton("Cancel");
    
    JPanel buttonPanel = new JPanel();

    JPanel container = new JPanel(new GridLayout(2, 1));
    JPanel panelText = new JPanel(new GridLayout(1, 3));

    JPanel textAreaPanel = new JPanel(new GridLayout(1, 1));
    JTextArea exampleText = new JTextArea( "\n A Quick brown fox jumps over the lazy dog.\n 012345678909 \n -=+@+-/-=#!$%~");  
    
    JLabel Font1 = new JLabel("Font");
    JLabel style = new JLabel("Font Style");
    JLabel size = new JLabel("Size");

    JPanel panelList = new JPanel(new GridLayout(1, 3));

    JList<String> fontSizeList = new JList<>();
    JList<String> fontStyleList = new JList<>();
    List fontFamilyList = new List();
   // fontFamilyList.
    DefaultListModel<String> l1 = new DefaultListModel<>();
    DefaultListModel<String> listStyle = new DefaultListModel<>();

    public JFontchoosers_1(final Component c) {
        for (int i = 0; i < fontSize.length; i++) {
            l1.addElement(fontSize[i]);
        }
        fontSizeList = new JList<>(l1);

        listStyle.addElement("plain");
        listStyle.addElement("Bold");
        listStyle.addElement("Italic");
        listStyle.addElement("Bold Italic");

        fontStyleList = new JList<>(listStyle);
        fontStyleList.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        fontFamily = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        for (int i = 0; i < fontFamily.length; i++) {
            fontFamilyList.add(fontFamily[i]);
        }
        fontFamilyList.select(0);

        JScrollPane listScrollPane = new JScrollPane(fontSizeList);

        panelText.add(Font1);
        panelText.add(style);
        panelText.add(size);

        panelList.add(fontFamilyList);
        panelList.add(fontStyleList);
        panelList.add(listScrollPane);

        exampleText.setSize(80, 30);
        exampleText.setBackground(Color.white);
        textAreaPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 30, 20));
        textAreaPanel.add(exampleText);

        container.add(panelList);
        container.add(textAreaPanel);

        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        frame.add(panelText, BorderLayout.NORTH);
        frame.add(container);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Object source = e.getSource();
                if (source == fontFamilyList || source == fontStyleList || source == fontSizeList) {
                    exampleText.setFont(new Font(fontFamilyList.getSelectedItem(),
                            fontStyleList.getSelectedIndex(),
                            Integer.parseInt(fontSizeList.getSelectedValue())));
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
        fontStyleList.addMouseListener(mouseListener);
        fontFamilyList.addMouseListener(mouseListener);
        fontSizeList.addMouseListener(mouseListener);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == cancel) {
                    //System.exit(0);
                    frame.dispose();
                } else if (source == ok) {
                    c.setFont(new Font(fontFamilyList.getSelectedItem(),
                            fontStyleList.getSelectedIndex(),
                            Integer.parseInt(fontSizeList.getSelectedValue())));
                    frame.dispose();

                }
            }
        };

        cancel.addActionListener(actionListener);
        ok.addActionListener(actionListener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 400);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        JFontchoosers_1 fontChooser = new JFontchoosers_1(new JLabel());

    }

}


