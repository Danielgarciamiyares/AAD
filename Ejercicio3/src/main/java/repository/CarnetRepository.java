package repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Carnet;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long>
{
	Optional<Carnet> findCarnetById(Long id);
	boolean CarnetExistsById(Long id);
	List<Carnet> findCarnetByFecha(LocalDate fecha);
	List<Carnet> findCarnetBydistanciaGreaterThan(Double distancia);
	
	
	
 
}
