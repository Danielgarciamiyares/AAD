package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Parada;

@Repository
public interface ParadaRepository extends JpaRepository<Parada, Long>
{

}
