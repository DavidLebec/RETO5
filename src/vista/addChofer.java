package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.ChoferDAO;
import Model.Chofer;

public class addChofer extends JFrame {
    private JTextField licencia, nombre, especie, masivo;
    private JLabel lLic, lNom, lEsp, lMas;
    private JPanel contenedor;
    private JButton agregar;
    private ChoferDAO conexion;
    private addChofer my = this;

    public addChofer() {
        addCompone();

        this.setTitle("Reto5 Mision Tic");
        this.setSize(300, 180);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void addCompone() {

        conexion = new ChoferDAO();
        contenedor = new JPanel();

        lLic = new JLabel("Licencia");
        licencia = new JTextField(20);
        lNom = new JLabel("Nombre");
        nombre = new JTextField(20);
        lEsp = new JLabel("Especie");
        especie = new JTextField(20);
        lMas = new JLabel("Masivo");
        masivo = new JTextField(20);

        agregar = new JButton("add");
        agregar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Chofer c = new Chofer(Integer.parseInt(licencia.getText()), nombre.getText(), especie.getText(), Integer.parseInt(masivo.getText()));
                conexion.insert(c);
                my.dispose();
            }

        });

        contenedor.add(lLic);
        contenedor.add(licencia);
        contenedor.add(lNom);
        contenedor.add(nombre);
        contenedor.add(lEsp);
        contenedor.add(especie);
        contenedor.add(lMas);
        contenedor.add(masivo);
        contenedor.add(agregar);

        add(contenedor);
    }
}


