package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Parada;
import repository.ParadaRepository;

@Service
public class ParadaServiceImplementation implements ParadaService
{
	@Autowired
	private ParadaRepository paradaRepository;

	@Override
	public Parada guardar(Parada entity) 
	{
		return paradaRepository.save(entity);
	}

	@Override
	public Parada actualizar(Parada entity) 
	{
		return paradaRepository.saveAndFlush(entity);
	}

	@Override
	public void eliminar(Parada entity)
	{
		paradaRepository.delete(entity);
		
	}

	@Override
	public void eliminarPorID(Long id) 
	{
		paradaRepository.deleteById(id);
		
	}

	@Override
	public void eliminarVarios(List<Parada> entities)
	{
		for(Parada p: entities)
			paradaRepository.deleteById(p.getId());
		
	}

	@Override
	public Parada buscarPorID(Long id)
	{
		return paradaRepository.getReferenceById(id);
	}

	@Override
	public List<Parada> buscarTodos() 
	{
		return paradaRepository.findAll();
	}

}
