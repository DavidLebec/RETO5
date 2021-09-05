import DAO.ChoferDAO;
import Model.Chofer;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Entry {
    public static void main(String[] args){
        //ChoferDAO.getAll().forEach(c -> System.out.println(c));
        ChoferDAO cf = new ChoferDAO();
        Chofer chofer = new Chofer(1002,"Jango Fett","Mandaloriano",6);
        System.out.println(cf.read(1002).toString());
    }

}
