package spitter.service;

import java.util.List;

import spitter.dto.Spitter;
import spitter.dto.Spittle;

public interface PersistenceService {


	public List<Spittle> getSomething();
	public Long saveSpitter(Spitter spitter);
	public Spitter getSpitterByFirstName(String firstName);

}
