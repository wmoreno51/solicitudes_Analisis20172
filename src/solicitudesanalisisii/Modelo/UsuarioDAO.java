package solicitudesanalisisii.Modelo;

import solicitudesanalisisii.Conexion.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO extends conexionBD{
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public boolean registrarUsuario(String nombres,String apellidos,String usuario,
            String contrasena){
        boolean bandera = false;
        try {
            String query = "INSERT INTO usuario (nombres,apellidos,usuario,contrasena) values (?, ?, ?, ?)";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, usuario);
            ps.setString(4, contrasena);
            
            if(ps.executeUpdate() == 1){
                bandera = true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally { try {
                rs.close();
            } catch (Exception e) {
            }
        }
        return bandera;
    }
    
    public boolean verificarInicioSesion(String Usuario,String contrasena){
        boolean bandera = false;
        
        try {
            String query = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, Usuario);
            ps.setString(2, contrasena);
            rs = ps.executeQuery();
            
            if(rs.absolute(1)){
                return bandera = true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally { try {
                rs.close();
            } catch (Exception e) {
            }
        }
        
        return bandera;
    }
    
    public boolean verificarUsuario(String Usuario){
        boolean bandera = false;
        
        try {
            String query = "SELECT * FROM usuario WHERE usuario = ?";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();
            
            if(rs.absolute(1)){
                return bandera = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally { try {
                rs.close();
            } catch (Exception e) {
            }
        }
        
        return bandera;
    }
    
    public String recuperarContrasena(String usuario, String nombre){
        String contrasena = "";
        
        try {
            String query = "SELECT contrasena FROM usuario WHERE nombres = ? AND usuario = ?";
            ps = getConexion().prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return contrasena = rs.getString("contrasena");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally { try {
                rs.close();
            } catch (Exception e) {
            }
        }
        
        return contrasena;
    }
    
}
