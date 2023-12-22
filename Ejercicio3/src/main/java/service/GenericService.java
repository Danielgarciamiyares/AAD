package service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface GenericService<T extends Object> {

	T guardar(T entity);
    
    T actualizar(T entity);
  
    void eliminar(T entity);
  
    void eliminarPorID(Long id);
    
    void eliminarVarios(List<T> entities);
  
    T buscarPorID(Long id);
  
    List<T> buscarTodos();
}
