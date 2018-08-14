package Controlador;

import Modelo.Ciudadanos;
import Modelo.ConsultasCiudadanos;
import javax.swing.JOptionPane;

public class ControladorCiudadanos {

    private Ciudadanos mod;
    private ConsultasCiudadanos modC;
    

    public ControladorCiudadanos(Ciudadanos mod, ConsultasCiudadanos modC) {
        this.mod = mod;
        this.modC = modC;
    }

    public boolean registrar(String pn, String sn, String pa, String sa, String ident, int dep, int mun, String dir, String correo, int sisben, int certificadoE, int certificadoJAC, int otros, int tramite,String observacion, String user) {

        mod.setPrimerNombre(pn);
        mod.setSegundoNombre(sn);
        mod.setPrimerApellido(pa);
        mod.setSegundoApellido(sa);
        mod.setDireccion(dir);
        mod.setCorreo(correo);
        mod.setDepartamento(dep);
        mod.setMunicipio(mun);
        mod.setIdentificacion(ident);
        mod.setCertificadoElectoral(certificadoE);
        mod.setCertificadoJAC(certificadoJAC);
        mod.setSisben(sisben);
        mod.setOtrosSoportes(otros);
        mod.setTramite(tramite);
        mod.setObservacion(observacion);
        mod.setUsuario(Integer.parseInt(user));


        return modC.registrar(mod);

        //return mod.getPrimerNombre() + " - " + mod.getSegundoNombre() + " - " + mod.getPrimerApellido() + " - " + mod.getSegundoApellido() + " - " + mod.getIdentificacion() + " - " + mod.getDepartamento() + " - " + mod.getMunicipio() + " - " + mod.getDireccion() + " - " + mod.getCorreo()+ " - " + mod.getSisben()+ " - " + mod.getCertificadoElectoral()+ " - " + mod.getCertificadoJAC()+ " - " + mod.getOtrosSoportes();
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
