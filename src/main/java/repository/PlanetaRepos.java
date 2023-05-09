package repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.*;

@Repository
public interface PlanetaRepos extends CrudRepository <PlanetasModelo, Long> {
	
}