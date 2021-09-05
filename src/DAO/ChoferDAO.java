package DAO;

import Model.Chofer;
import utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ChoferDAO {

    public List<Chofer> getAll(){
        List<Chofer> list = new ArrayList<Chofer>();
        String query = "Select * From Chofer";
        Connection con = Utils.getConnection();
        if(con != null){
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    list.add(new Chofer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                }
                con.close();
                return list;
            }catch(Exception ex){
                System.out.println("Error en la consulta: " + ex.getMessage());
            }

        }

        return list;
    }

    public boolean insert(Chofer chofer){
        String query = String.format("insert into Chofer values ( '%d', '%s', '%s', '%d')", chofer.getnLicencia(), chofer.getNombre(), chofer.getEspecie(), chofer.getMasivo());
        Connection con = Utils.getConnection();

        if (con != null) {
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                con.close();
                return true;
            }catch(Exception ex){
                System.out.println("Error en la insercion: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean delete(Chofer chofer){
        String query = String.format("delete from Chofer where c_licencia = %d", chofer.getnLicencia());
        Connection con = Utils.getConnection();

        if (con != null) {
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                con.close();
                return true;
            }catch(Exception ex){
                System.out.println("Error en el borrado: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean update(Chofer chofer){
        String query = String.format("update chofer set c_nombre = '%s', c_especie = '%s' , c_masivo = %d where  c_licencia = %d", chofer.getNombre(), chofer.getEspecie(), chofer.getMasivo(), chofer.getnLicencia());
        Connection con = Utils.getConnection();

        if (con != null) {
            try{
                PreparedStatement ps = con.prepareStatement(query);
                ps.execute();
                con.close();
                return true;
            }catch(Exception ex){
                System.out.println("Error en la actualizacion: " + ex.getMessage());
            }
        }
        return false;
    }

    public Chofer read(int nLicencia) {
        String query = String.format("select * from chofer where c_licencia = %d", nLicencia);
        Connection con = Utils.getConnection();
        ResultSet rs;
        Chofer chofer;
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(query);
                rs = ps.executeQuery();

                rs.next();
                chofer = new Chofer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                con.close();
                return chofer;

            } catch (Exception ex) {
                System.out.println("Error en la lectura: " + ex.getMessage());
            }
        }
        return null;
    }


}
