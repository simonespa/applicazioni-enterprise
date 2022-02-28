package spitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spitter.dao.SpitterDao;
import spitter.dao.SpittleDao;
import spitter.dto.Spitter;
import spitter.dto.Spittle;

@Service("persistenceService")
@Transactional
public class PersistenceServiceImpl implements PersistenceService {

	@Autowired
	private SpitterDao spitterDao;
	@Autowired
	private SpittleDao spittleDao;

	@Override
	public List<Spittle> getSomething() {
		return spittleDao.getAll();
	}

	@Override
	public Long saveSpitter(Spitter spitter) {
		return spitterDao.save(spitter);
	}
	
	@Override
	public Spitter getSpitterByFirstName(String firstName) {
		return spitterDao.getByFirstname(firstName);
	}
	
}