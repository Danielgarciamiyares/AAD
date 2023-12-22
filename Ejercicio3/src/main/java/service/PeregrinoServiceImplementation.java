package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Peregrino;
import repository.PeregrinoRepository;

@Service
public class PeregrinoServiceImplementation implements PeregrinoService
{

	@Autowired
	private PeregrinoRepository peregrinoRepository;
	
	@Override
	public Peregrino guardar(Peregrino entity) {
		return peregrinoRepository.save(entity);
	}

	@Override
	public Peregrino actualizar(Peregrino entity) {
		return peregrinoRepository.saveAndFlush(entity);
	}

	@Override
	public void eliminar(Peregrino entity) {
		peregrinoRepository.delete(entity);
		
	}

	@Override
	public void eliminarPorID(Long id) {
		peregrinoRepository.deleteById(id);
		
	}

	@Override
	public void eliminarVarios(List<Peregrino> entities) {
		for(Peregrino p: entities)
			peregrinoRepository.deleteById(p.getId());
		
	}

	@Override
	public Peregrino buscarPorID(Long id) {
		return peregrinoRepository.getReferenceById(id);
	}

	@Override
	public List<Peregrino> buscarTodos() {
		return peregrinoRepository.findAll();
	}

}
