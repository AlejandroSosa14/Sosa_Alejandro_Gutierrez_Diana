import dao.BD;

import modelo.Odontologo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import servicio.OdontologoServicio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
    INTEGRANTES:
    DIANA GUTIERREZ
    ALEJANDRO SOSA
 */
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Inicializando Clase Main...");
        LOGGER.info("CREANDO TABLAS...");
        BD.createTable();
        LOGGER.info("Creando servicio odontolgos...");
        OdontologoServicio odontologoServicio = new OdontologoServicio();

        LOGGER.info("Creando odontologos...");
        Odontologo odontologo1 = new Odontologo(123456, "Carlos", "Lopez");
        Odontologo odontologo2 = new Odontologo(321654, "Diana", "Gutierrez");
        Odontologo odontologo3 = new Odontologo(456123, "Alejandro", "Sosa");

        LOGGER.info("Guardando odontologos en H2...");
        odontologoServicio.guardarH2(odontologo1);
        odontologoServicio.guardarH2(odontologo2);
        odontologoServicio.guardarH2(odontologo3);

        LOGGER.info("Guardando odontologos en Local...");
        odontologoServicio.guardarLocal(odontologo1);
        odontologoServicio.guardarLocal(odontologo2);
        odontologoServicio.guardarLocal(odontologo3);

        LOGGER.info("Listando odontologos de H2...");
        odontologoServicio.listarTodosH2();

        LOGGER.info("Listando odontologos de Local...");
        odontologoServicio.listarTodosLocal();
    }
}