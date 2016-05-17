package state;

import java.io.IOException;
import java.sql.SQLException;

import interfacesGraficas.VentanaLogin;

public interface Estado {
    
    public void ejecutar(VentanaLogin v) throws SQLException, IOException;
}