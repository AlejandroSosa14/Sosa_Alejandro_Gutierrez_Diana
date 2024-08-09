package dao.implementacion;

import dao.BD;
import dao.IDAO;
import modelo.Odontologo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDAOH2 implements IDAO<Odontologo> {
    private static final Logger LOGGER = LogManager.getLogger(ImplementacionDAOH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Guardando Odontologo en H2...");
        Connection connection = null;

        try {

            connection = BD.getConnection();
            LOGGER.info("PREPARANDO STATEMENT...");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS (" +
                            "NUMERO_MATRICULA, NOMBRE, APELLIDO) VALUES " +
                            "(?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setInt(1, odontologo.getNumero_matricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            preparedStatement.execute();
            LOGGER.info("ODONTOLOGO GUARDADO...");

            ResultSet rs = preparedStatement.getGeneratedKeys();


            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                LOGGER.info("ODONTOLOGO->Nombre:..." + odontologo.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        LOGGER.info("GENERANDO LISTA ODONTOLOGOS...");
        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            LOGGER.info("PREPARANDO CONSULTA...");
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                LOGGER.info("ODONTOLOGO ENCONTRADO...");
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4));

                odontologoList.add(odontologo);
                LOGGER.info("ODONTOLOGO: " + odontologo.getNombre());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologoList;
    }
}
