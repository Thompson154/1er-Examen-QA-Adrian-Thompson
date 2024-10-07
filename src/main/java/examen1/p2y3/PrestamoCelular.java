package examen1.p2y3;

public class PrestamoCelular {

    private EstaDisponible estaDisponible;
    private RegistrarPrestamo registrarPrestamo;

    public PrestamoCelular() {
        estaDisponible = new EstaDisponible();
        registrarPrestamo = new RegistrarPrestamo();
    }

    public void setEstaDisponible(EstaDisponible estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public void setRegistrarPrestamo(RegistrarPrestamo registrarPrestamo) {
        this.registrarPrestamo = registrarPrestamo;
    }

    public String prestamoCelular(String modelo, String marca, String usuario){
        if(estaDisponible.estaDisponible(modelo,marca)){
            if(registrarPrestamo.registrarPrestamo(modelo,marca,usuario)){
                return "El celular " + modelo + " de " + marca + " ha sido prestado a "+ usuario;
            } else {
                return "El celular " + modelo + " o " + marca + " o "+ usuario +
                        " no existen o no son invalidos, ingrese datos correctos";
            }
        }
        return "El celular " + modelo + " de " + marca + " no esta disponible";
    }
}
