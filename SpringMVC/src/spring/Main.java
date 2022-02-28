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
package spring;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.naming.java.javaURLContextFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.collection.PersistentSet;
import org.hibernate.criterion.Restrictions;

import spring.dto.Item;
import spring.dto.User;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setEmail("email@gmail.com");
		user.setPassword("password");

		User user2 = new User();
		user2.setFirstName("Name");
		user2.setLastName("surname");
		user2.setEmail("em@vanoni.it");
		user.setPassword("pwd");

		Item item = new Item();
		item.setName("item1");
		item.setDescription("description of item1");
		item.setUser(user);
		user.addItem(item);

		Item item2 = new Item();
		item2.setName("item2");
		item.setUser(user2);
		user2.addItem(item2);

		Long id = (Long) session.save(user);
		session.save(item);

		session.save(user2);
		session.save(item2);

		transaction.commit();
		transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(User.class);
		User userClone = (User) criteria.add(Restrictions.idEq(id)).uniqueResult();
		Collections c = null;
		for (Item i : userClone.getItems() ) {
			session.delete(i);
		}
		session.delete(userClone);

		transaction.commit();
		session.close();
	}

}