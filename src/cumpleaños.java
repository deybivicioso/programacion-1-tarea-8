import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.event.*;

public class cumpleaños extends JFrame {
    components runer = new components();

    public cumpleaños() {
        setTitle("bithday agenda");
        setVisible(true);
        setBounds(0, 0, 650, 545);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(runer);
    }
}

class components extends JPanel implements ActionListener{
    JPanel papel = new JPanel();// this is the layout to put the component except table.
    JLabel firsttitle = new JLabel("Add birthday");// header
    // title of the text field
    JLabel secondttitle = new JLabel("Name");
    JLabel thirdtitle = new JLabel("Date");
    JLabel fourthtitle = new JLabel("Massage");
    // text fields....
    JTextField firstField = new JTextField();
    JTextField secondField = new JTextField();
    JTextArea thirdField = new JTextArea();
    // scroll pane
    JScrollPane km = new JScrollPane(thirdField);// this is a scroll and the thirdfield was added into it
    // all menu element and complement
    JMenuBar menuD = new JMenuBar();
    JMenu firstopcion = new JMenu("opcion1/Guardar");
    JMenu secondoption = new JMenu("opcion2/Actualizar");
    JMenu thirdoption = new JMenu("opcion3/Borrar");
    JMenu fourthoption = new JMenu("opcion4/Buscar");
    JMenuItem save = new JMenuItem("Guardar");
    JMenuItem update = new JMenuItem("Actualizar");
    JMenuItem delete = new JMenuItem("Borrar");
    JMenuItem search = new JMenuItem("Buscar");
    //variables to database
    private Connection BBDD;
    private Statement instruction;
    

    public components() {
        setLayout(null);
        layouut();
        titlee();
        textSpace();
        menu();
       
    }

    public void menu() {// this method contains all the elements that allow me to build the menu        
        menuD.setBounds(0, 1, 650, 35);
        menuD.setBorder(BorderFactory.createRaisedBevelBorder());
        add(menuD);
        // one option code
        firstopcion.setFont(new Font("Bell MT", Font.ITALIC, 14));
        firstopcion.setBorder(BorderFactory.createEtchedBorder());
        save.addActionListener(this);
        firstopcion.add(save);
        menuD.add(firstopcion);
        // second option code
        secondoption.setFont(new Font("Bell MT", Font.ITALIC, 14));
        secondoption.setBorder(BorderFactory.createEtchedBorder());
        update.addActionListener(this);
        secondoption.add(update);
        menuD.add(secondoption);
        // third option code
        thirdoption.setFont(new Font("Bell MT", Font.ITALIC, 14));
        thirdoption.setBorder(BorderFactory.createEtchedBorder());
        delete.addActionListener(this);
        thirdoption.add(delete);
        menuD.add(thirdoption);
        // fourth option code
        fourthoption.setFont(new Font("Bell MT", Font.ITALIC, 14));
        fourthoption.setBorder(BorderFactory.createEtchedBorder());
        search.addActionListener(this);
        fourthoption.add(search);
        menuD.add(fourthoption);
        JSeparator prueba = new JSeparator(1);
        prueba.setForeground(Color.black.darker());
        menuD.add(prueba);
    }

    public void textSpace() {
        firstField.setBounds(40, 40, 100, 20);
        secondField.setBounds(285, 40, 100, 20);
        // scroll pane
        km.setBounds(65, 85, 323, 130);

    }

    public void titlee() {
        firsttitle.setBounds(5, 5, 120, 15);
        firsttitle.setFont(new Font("Bell MT", Font.BOLD, 16));
        // title of the first text field
        secondttitle.setBounds(5, 40, 90, 16);
        secondttitle.setFont(new Font("Californian FB", Font.BOLD, 12));
        // title of the second text field
        thirdtitle.setBounds(255, 40, 90, 16);
        thirdtitle.setFont(new Font("Californian FB", Font.BOLD, 12));
        // tittle of the third text field
        fourthtitle.setBounds(5, 85, 90, 16);
        fourthtitle.setFont(new Font("Californian FB", Font.BOLD, 12));
    }

    public void layouut() {
        papel.setBorder(BorderFactory.createEtchedBorder());
        papel.setBounds(5, 100, 625, 230);
        papel.setLayout(null);
        papel.add(firsttitle);
        papel.add(secondttitle);
        papel.add(firstField);
        papel.add(thirdtitle);
        papel.add(secondField);
        papel.add(fourthtitle);
        papel.add(km);
        add(papel);
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object evento=e.getSource();
       if (evento==save){
        try{
            BBDD=DriverManager.getConnection("jdbc:mysql:/localhost:3306/ programacion1tarea8","root", "");
            instruction=BBDD.createStatement();
            String nombre=firstField.getText();
            String fecha=secondField.getText();
            String comentario=thirdField.getText();
            instruction.executeUpdate("insert into agenda(nombre, fecha, mensaje) values('"+nombre+fecha+comentario+"')");
            BBDD.close();
        } catch(Exception a){
            a.printStackTrace();
        }
       
    }
}
}
