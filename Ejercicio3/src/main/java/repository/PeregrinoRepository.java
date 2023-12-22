package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Peregrino;

@Repository
public interface PeregrinoRepository extends JpaRepository<Peregrino, Long>
{

}
