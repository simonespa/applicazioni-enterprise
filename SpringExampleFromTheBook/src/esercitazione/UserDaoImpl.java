package esercitazione;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDAO {

	/*
	 * Per le operazioni più semplici si può utilizzare Hibernate Template.
	 * Questo oggetto Hibernate Template comporta che il livello di persistenza
	 * sia dipendente dal livello di logica.
	 * 
	 * Nelle ultime versioni, gli sviluppatori consigliano di non utilizzare
	 * questo template, ma è preferibile non utilizzarlo per tenere separati i
	 * due livelli.
	 * 
	 * Una delle cose che garantiva questo template, manteneva una sola sessione
	 * per ogni transazione. Nell'ultima versione di HIbernate, questo è già
	 * garantito dal framework.
	 */

	@Override
	public void save(User user) {

	}

	@Override
	public void delete(User user) {
	}

	@Override
	public void findById(Long id) {
	}

	@Override
	public User findByExample(User user) {
		return null;
	}

	@Override
	public List<User> findByName(String name) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

}
