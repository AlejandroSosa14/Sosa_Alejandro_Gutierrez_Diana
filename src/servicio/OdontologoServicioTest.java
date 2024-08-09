package servicio;

import dao.BD;
import modelo.Odontologo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServicioTest {
    @Test
    void GuardarOdontologosH2() {
        BD.createTable();
        OdontologoServicio odontologoServicio = new OdontologoServicio();
        List<Odontologo> listaOdontologosH2 = new ArrayList<>();
        Integer expected = 3;

        Odontologo odontologo1 = new Odontologo(123456, "Carlos", "Lopez");
        Odontologo odontologo2 = new Odontologo(321654, "Diana", "Gutierrez");
        Odontologo odontologo3 = new Odontologo(456123, "Alejandro", "Sosa");

        odontologoServicio.guardarH2(odontologo1);
        odontologoServicio.guardarH2(odontologo2);
        odontologoServicio.guardarH2(odontologo3);

        listaOdontologosH2 = odontologoServicio.listarTodosH2();

        assertEquals(expected, listaOdontologosH2.size());
    }

    @Test
    void GuardarOdontologosLocal() {
        OdontologoServicio odontologoServicio = new OdontologoServicio();
        List<Odontologo> listaOdontologosLocal = new ArrayList<>();
        Integer expected = 3;


        Odontologo odontologo1 = new Odontologo(123456, "Carlos", "Lopez");
        Odontologo odontologo2 = new Odontologo(321654, "Diana", "Gutierrez");
        Odontologo odontologo3 = new Odontologo(456123, "Alejandro", "Sosa");

        odontologoServicio.guardarLocal(odontologo1);
        odontologoServicio.guardarLocal(odontologo2);
        odontologoServicio.guardarLocal(odontologo3);

        listaOdontologosLocal = odontologoServicio.listarTodosLocal();

        assertEquals(expected, listaOdontologosLocal.size());


    }
}