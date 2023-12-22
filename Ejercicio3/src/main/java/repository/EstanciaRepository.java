package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Estancia;

@Repository
public interface EstanciaRepository extends JpaRepository<Estancia, Long> 
{

}
