package examen1.p2y3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PrestamoCelularTestMock {
    EstaDisponible estaDisponible = Mockito.mock(EstaDisponible.class);
    RegistrarPrestamo registrarPrestamo = Mockito.mock(RegistrarPrestamo.class);


    //Probamos un caso donde todo es true y se realiza el prestamo con exito
    @Test
    public void testEstaDisponibleTrue() {
        Mockito.when(estaDisponible.estaDisponible("iPhone 13","Apple")).thenReturn(true);
        Mockito.when(registrarPrestamo.registrarPrestamo("iPhone 13","Apple","Maria Lopez")).thenReturn(true);


        PrestamoCelular prestamoCelular = new PrestamoCelular();

        prestamoCelular.setEstaDisponible(estaDisponible);
        prestamoCelular.setRegistrarPrestamo(registrarPrestamo);

        Assertions.assertEquals("El celular iPhone 13 de Apple ha sido prestado a Maria Lopez",
                prestamoCelular.prestamoCelular("iPhone 13","Apple","Maria Lopez"),
                "ERROR en prestamoCelular");

        Mockito.verify(registrarPrestamo).registrarPrestamo("iPhone 13","Apple","Maria Lopez");
        Mockito.verify(estaDisponible).estaDisponible("iPhone 13","Apple");
    }

    @Test
    public void testEstaDisponibleFalse() {
        Mockito.when(estaDisponible.estaDisponible("iPhone 13","Apple")).thenReturn(false);
//        Mockito.when(registrarPrestamo.registrarPrestamo("iPhone 13","Apple","Maria Lopez")).thenReturn(true);


        PrestamoCelular prestamoCelular = new PrestamoCelular();

        prestamoCelular.setEstaDisponible(estaDisponible);
        prestamoCelular.setRegistrarPrestamo(registrarPrestamo);

        Assertions.assertEquals("El celular iPhone 13 de Apple no esta disponible",
                prestamoCelular.prestamoCelular("iPhone 13","Apple","Maria Lopez"),
                "ERROR en prestamoCelular");

        Mockito.verify(estaDisponible).estaDisponible("iPhone 13","Apple");
//        Mockito.verify(registrarPrestamo).registrarPrestamo("iPhone 13","Apple","Maria Lopez");
    }

    @Test
    public void testEstaDisponibleWrongUser() {
        Mockito.when(estaDisponible.estaDisponible("iPhone 13","Apple")).thenReturn(true);
        Mockito.when(registrarPrestamo.registrarPrestamo("iPhone 14","Apple","Maria Lopez")).thenReturn(false);


        PrestamoCelular prestamoCelular = new PrestamoCelular();

        prestamoCelular.setEstaDisponible(estaDisponible);
        prestamoCelular.setRegistrarPrestamo(registrarPrestamo);

        Assertions.assertEquals("Maria Lopez no existe, ingrese uno valido",
                prestamoCelular.prestamoCelular("iPhone 13","Apple","Maria Lopez"),
                "ERROR en prestamoCelular");

        Mockito.verify(registrarPrestamo).registrarPrestamo("iPhone 13","Apple","Maria Lopez");
        Mockito.verify(estaDisponible).estaDisponible("iPhone 13","Apple");
    }
}
