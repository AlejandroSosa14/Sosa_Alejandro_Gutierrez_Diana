package dao.implementacion;

import dao.IDAO;
import modelo.Odontologo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionLocal implements IDAO<Odontologo> {
    private static final Logger LOGGER = LogManager.getLogger(ImplementacionLocal.class);
    public List<Odontologo> odontologoList = new ArrayList<>();
    private static Integer contador = 0;
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Guardando Odontologo en local...");
        contador++;
        odontologo.setId(contador);
        LOGGER.info("Asignando ID: " + contador);
        odontologoList.add(odontologo);
        LOGGER.info("Odontologo con ID: " + odontologo.getId() + " y nombre: " + odontologo.getNombre() + " ha sido guardado");
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Obteniendo lista odontologos local...");
        for (Odontologo odontologo: odontologoList) {
            LOGGER.info("ODONTOLOGO ENCONTRADO LOCAL...");
            LOGGER.info("Odontologo: " + odontologo.getNombre());
        }
        return odontologoList;
    }
}
