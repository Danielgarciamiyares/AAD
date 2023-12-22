package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Estancia;
import repository.EstanciaRepository;

@Service
public class EstanciaServiceImplementation implements EstanciaService
{

	@Autowired
	private EstanciaRepository estanciaRepository;
	
	@Override
	public Estancia guardar(Estancia entity) {
		return estanciaRepository.save(entity);
	}

	@Override
	public Estancia actualizar(Estancia entity) {
		return estanciaRepository.saveAndFlush(entity);
	}

	@Override
	public void eliminar(Estancia entity) {
		estanciaRepository.delete(entity);
		
	}

	@Override
	public void eliminarPorID(Long id) {
		estanciaRepository.deleteById(id);
		
	}

	@Override
	public void eliminarVarios(List<Estancia> entities) {
		for(Estancia e: entities)
			estanciaRepository.deleteById(e.getId());
		
	}

	@Override
	public Estancia buscarPorID(Long id) {
		return estanciaRepository.getReferenceById(id);
	}

	@Override
	public List<Estancia> buscarTodos() {
		return estanciaRepository.findAll();
	}

}
