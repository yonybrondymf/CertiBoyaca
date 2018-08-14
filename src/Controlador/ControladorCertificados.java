package Controlador;

import Modelo.Certificados;
import Modelo.ConsultasCertificados;

public class ControladorCertificados {

    private Certificados mod;
    private ConsultasCertificados modC;

    public ControladorCertificados(Certificados mod, ConsultasCertificados modC) {
        this.mod = mod;
        this.modC = modC;
    }
    
    public boolean registrar(int ciudadano, String fecha, int estado,String fechaRevision, String num, int userRegistro) {

        mod.setCiudadano(ciudadano);
        mod.setFecha(fecha);
        mod.setEstado(estado);
        mod.setNum(num);
        mod.setFechaRevision("NULL");
        mod.setUserRegistro(userRegistro);

        return modC.registrar(mod);

        //return mod.getPrimerNombre() + " - " + mod.getSegundoNombre() + " - " + mod.getPrimerApellido() + " - " + mod.getSegundoApellido() + " - " + mod.getIdentificacion() + " - " + mod.getDepartamento() + " - " + mod.getMunicipio() + " - " + mod.getDireccion() + " - " + mod.getCorreo()+ " - " + mod.getSisben()+ " - " + mod.getCertificadoElectoral()+ " - " + mod.getCertificadoJAC()+ " - " + mod.getOtrosSoportes();
    }

}
