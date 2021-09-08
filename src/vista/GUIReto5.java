package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.ChoferDAO;
import Model.Chofer;

public class GUIReto5 extends JFrame {
    //
    private JPanel contenedor;
    private JButton lTemporadas, habilitar, eliminar;
    private JComboBox<String> opciones;
    private JScrollPane scrollPane;
    private List<Chofer> listChofer;
    private ChoferDAO conexion;
    private mouse m;
    private GUIReto5 my = this;
    Object[][] data;
    // array de String's con los t�tulos de las columnas
    String[] columnNames = {"Licencia", "Nombre", "Especie", "Masivo"};
    //
    public GUIReto5(){
        addCompone();

        this.setTitle("Reto5 Mision Tic");
        this.setSize(570, 390);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void addCompone() {

        contenedor = new JPanel();
        conexion = new ChoferDAO();
        m = new mouse();

		/*
		JPanel table = new JPanel();
		table.setBackground(Color.red);
		table.setPreferredSize(new Dimension(480, 290));
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(490, 300));*/

        crearTabla();

        lTemporadas = new JButton("Actualizar");
        lTemporadas.setPreferredSize(new Dimension(150, 30));
        lTemporadas.addActionListener(m);
        habilitar = new JButton("Agregar");
        habilitar.setPreferredSize(new Dimension(100, 30));
        habilitar.addActionListener(m);
        opciones = new JComboBox<String>();
        opciones.setPreferredSize(new Dimension(60, 30));
        for( int i = 0; i < listChofer.size(); i++ ) {
            opciones.addItem(""+listChofer.get(i).getnLicencia());
        }
        eliminar = new JButton("Eliminar");
        eliminar.setPreferredSize(new Dimension(100, 30));
        eliminar.addActionListener(m);



        //
        contenedor.add(lTemporadas);
        contenedor.add(opciones);
        contenedor.add(eliminar);
        contenedor.add(habilitar);
        contenedor.add(scrollPane);
        add(contenedor);
    }

    private void crearTabla() {
        //se crea la Tabla
        listChofer = conexion.getAll();
        data = new Object[listChofer.size()][0];
        for( int i = 0; i < listChofer.size(); i++ ) {
            String[] d = {""+listChofer.get(i).getnLicencia(), listChofer.get(i).getNombre(), listChofer.get(i).getEspecie(), listChofer.get(i).getMasivo()+""};
            data[i] = d;
        }
        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(510, 280));
        //Creamos un JscrollPane y le agregamos la JTable
        scrollPane = new JScrollPane(table);
        //Agregamos el JScrollPane al contenedor
    }

    private Chofer buscar() {
        Chofer rest = null;
        for( int i = 0; i < listChofer.size(); i++ ) {
            if(opciones.getSelectedItem().equals(""+listChofer.get(i).getnLicencia())){
                rest = listChofer.get(i);
            }
        }
        return rest;
    }

    private class mouse implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if( e.getSource() == lTemporadas ) {
                new GUIReto5();
                my.dispose();
            }
            if( e.getSource() == eliminar ) {
                conexion.delete(buscar());
            }
            if( e.getSource() == habilitar ) {
                new addChofer();
            }
        }

    }
}
