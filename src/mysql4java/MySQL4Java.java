/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql4java;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author Telematica-2-0
 */
public final class MySQL4Java extends JFrame {

    private final SQL sql;
    private final NanosoftLayOut ns;
    private final funciones fnc;

    public MySQL4Java() {
        this.fnc = new funciones();
        this.ns = new NanosoftLayOut(350, 300, 4);
        this.sql = new SQL();
        initComponents();
    }

    public void initComponents() {
        JButton btn = new JButton();
        JTextField txt_username = new JTextField();
        JButton btn2 = new JButton();

        txt_username.setBounds(ns.getRectangle(100, 40));

        setTitle("Clase 1 Progamación 3");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setPreferredSize(ns.getJFrameDimension());

        btn.setBounds(ns.getRectangle(200, 40));
        btn2.setBounds(ns.getRectangle(200, 40));

        btn.setText("Parte2---QUIZ2");
        btn2.setText("Parte1 ----QUIZ");
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                btnMouseClicked();
            }
        });

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                btn2MouseClicked(txt_username.getText(), txt_username.getText());
            }
        });

        add(btn);

        add(btn2);
        add(txt_username);
        pack();
    }
//btn

    public void btn2MouseClicked(String _buscar, String _buscar2) {
        System.out.println("arriba");
        try {

            ArrayList<Object> arr = new ArrayList<>();
            arr.addAll(Arrays.asList(_buscar, _buscar2));

            HashMap<String, Object> result = sql.SELECT("SELECT `id`, `Nombre_product`FROM `Mario_QuizInventario` WHERE `id`=? OR `Nombre_product`=? ", arr);

            if (result.containsKey("id") || result.containsKey("Nombre_product")) {
                System.out.println("Su producto es: " + result.get("id") + " " + result.get("Nombre_product"));

            } else {
                JOptionPane.showMessageDialog(null, "El producto no existe");

            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Missing Fields");
        }

    }
//btn2

    public void btnMouseClicked() {
        try {
            ArrayList<Object> arr = new ArrayList<>();
            arr.addAll(Arrays.asList());

            HashMap<String, Object> result = sql.SELECT("SELECT `id`,`Nombre_product`,`Cantidad`,`Precio_unitario` FROM `Mario_QuizInventario`", arr);

       

        } catch (Exception e) {
            System.out.println("Su programa no sirve");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()
                -> {
            MySQL4Java mySQL4Java = new MySQL4Java();
            mySQL4Java.setVisible(true);
        });

    }

}
//Que es una llave primaria y para que funciona?

//Es un campo , el cual no se puede repetir, identifica un campo unico 
