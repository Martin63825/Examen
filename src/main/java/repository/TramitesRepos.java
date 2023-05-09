package repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.*;

@Repository
public interface TramitesRepos extends CrudRepository <TramitesModelo, Long> {
	
}
