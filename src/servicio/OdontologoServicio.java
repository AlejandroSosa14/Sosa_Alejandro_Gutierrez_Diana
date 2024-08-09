package servicio;

import dao.IDAO;
import dao.implementacion.ImplementacionDAOH2;
import dao.implementacion.ImplementacionLocal;
import modelo.Odontologo;

import java.util.List;

public class OdontologoServicio {
    private IDAO<Odontologo> interfazDAO;

    private IDAO<Odontologo> interfazLocal;

    public OdontologoServicio() {
        this.interfazDAO = new ImplementacionDAOH2();
        this.interfazLocal = new ImplementacionLocal();
    }

    public Odontologo guardarH2(Odontologo odontologo) {
        return interfazDAO.guardar(odontologo);
    }

    public List<Odontologo> listarTodosH2() {
        return interfazDAO.listarTodos();
    }

    public Odontologo guardarLocal(Odontologo odontologo) {return interfazLocal.guardar(odontologo);}

    public List<Odontologo> listarTodosLocal() {
        return interfazLocal.listarTodos();
    }
}
