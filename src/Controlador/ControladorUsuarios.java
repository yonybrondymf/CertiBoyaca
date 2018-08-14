package Controlador;

import Modelo.ConsultasUsuarios;
import Modelo.Usuarios;

public class ControladorUsuarios {

    private Usuarios mod;
    private ConsultasUsuarios modC;

    public ControladorUsuarios(Usuarios mod, ConsultasUsuarios modC) {
        this.mod = mod;
        this.modC = modC;
    }

    public boolean registrar(String nom, String ape, String ident, String dir, String tel, String usu, String pass, String fecha, int perfil) {

        mod.setNombres(nom);
        mod.setApellidos(ape);
        mod.setIdentificacion(ident);
        mod.setDireccion(dir);
        mod.setTelefono(tel);
        mod.setUsuario(usu);
        mod.setPassword(pass);
        mod.setFecha(fecha);
        mod.setPerfil(perfil);

        return modC.registrar(mod);

        //return mod.getPrimerNombre() + " - " + mod.getSegundoNombre() + " - " + mod.getPrimerApellido() + " - " + mod.getSegundoApellido() + " - " + mod.getIdentificacion() + " - " + mod.getDepartamento() + " - " + mod.getMunicipio() + " - " + mod.getDireccion() + " - " + mod.getCorreo()+ " - " + mod.getSisben()+ " - " + mod.getCertificadoElectoral()+ " - " + mod.getCertificadoJAC()+ " - " + mod.getOtrosSoportes();
    }
    
     public boolean actualizar(int id,String nombres, String apellidos, String identificacion, String direccion, String telefono, int perfil, String usuario, String password) {
        mod.setId(id);
        mod.setNombres(nombres);
        mod.setApellidos(apellidos);
        mod.setIdentificacion(identificacion);
        mod.setDireccion(direccion);
        mod.setTelefono(telefono);
        mod.setUsuario(usuario);
        mod.setPassword(password);
        mod.setPerfil(perfil);

        return modC.actualizar(mod);

        //return mod.getPrimerNombre() + " - " + mod.getSegundoNombre() + " - " + mod.getPrimerApellido() + " - " + mod.getSegundoApellido() + " - " + mod.getIdentificacion() + " - " + mod.getDepartamento() + " - " + mod.getMunicipio() + " - " + mod.getDireccion() + " - " + mod.getCorreo()+ " - " + mod.getSisben()+ " - " + mod.getCertificadoElectoral()+ " - " + mod.getCertificadoJAC()+ " - " + mod.getOtrosSoportes();
    }
    
    public boolean login(String usu, String pass){
        mod.setUsuario(usu);
        mod.setPassword(pass);
        if (modC.login(mod)) {
            return true;
        }else{
            return false;
        }

    }
    
    
    public boolean buscar(String identificacion){
        mod.setIdentificacion(identificacion);
        if (modC.buscar(mod)) {
            return true;
        }
        else{
            return false;
        }

    }
}
