package dao;

import java.util.List;

public interface IDAO<T> {
    //Crear registros en bd H2
    T guardar (T t);

    //Consultar todos registros los T de H2
    List<T> listarTodos();
}
