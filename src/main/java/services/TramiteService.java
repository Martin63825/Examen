package services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.TramitesRepos;

@Service
public class TramiteService {
	@Autowired
	TramitesRepos tramiteRepository;
}
