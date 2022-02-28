/*
 * This file is part of SpringMVC.
 * 
 * <brief description of the project>
 * Copyright (C) 2012 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.dto.Item;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Long save(Item item) {
		return (Long) session().save(item);
	}

	@Override
	public void update(Item item) {
		session().update(item);
	}

	@Override
	public void delete(Item item) {
		session().delete(item);
	}

	@Override
	public Item findById(Long id) {
		Criteria criteria = session().createCriteria(Item.class);
		criteria.add(Restrictions.idEq(id));
		return (Item) criteria.uniqueResult();
	}

	@Override
	public List<Item> findAll() {
		Criteria criteria = session().createCriteria(Item.class);
		return criteria.list();
	}

	@Override
	public Item findByName(String name) {
		Criteria criteria = session().createCriteria(Item.class);
		criteria.add(Restrictions.eq("name", name));
		return (Item) criteria.uniqueResult();
	}

}