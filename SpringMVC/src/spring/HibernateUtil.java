/*
 * This file is part of "U Turismu" project. 
 * 
 * U Turismu is an enterprise application in support of calabrian tour operators.
 * This system aims to promote tourist services provided by the operators
 * and to develop and improve tourism in Calabria.
 *
 * Copyright (C) 2012 "LagrecaSpaccarotella" team.
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import spring.dto.Item;
import spring.dto.User;

/**
 * @author "LagrecaSpaccarotella" team.
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Item.class);
			configuration.configure("mysql.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}
