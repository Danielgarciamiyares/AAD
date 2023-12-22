package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Carnet;
import repository.CarnetRepository;

@Service
public class CarnetServiceImplementation implements CarnetService 
{

	@Autowired
	private CarnetRepository carnetRepository; 
	
	@Override
	public Carnet guardar(Carnet entity) {
		return carnetRepository.save(entity);
	}

	@Override
	public Carnet actualizar(Carnet entity) {
		return carnetRepository.saveAndFlush(entity);
	}

	@Override
	public void eliminar(Carnet entity) {
		carnetRepository.delete(entity);
		
	}

	@Override
	public void eliminarPorID(Long id) {
		carnetRepository.deleteById(id);
		
	}

	@Override
	public void eliminarVarios(List<Carnet> entities) {
		for(Carnet c:entities) 
		{
			carnetRepository.deleteById(c.getId());
		}
	}

	@Override
	public Carnet buscarPorID(Long id) {
		return carnetRepository.getReferenceById(id);
	}

	@Override
	public List<Carnet> buscarTodos() {
		return carnetRepository.findAll();
	}

}
