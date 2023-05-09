package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.PlanetaRepos;

@Service
public class PlanetaService {
	@Autowired
	PlanetaRepos planetaRepository;
}
