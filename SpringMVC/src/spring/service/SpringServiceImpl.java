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
package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.ItemDao;
import spring.dao.UserDao;
import spring.dto.Item;
import spring.dto.User;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Service
@Transactional
public class SpringServiceImpl implements SpringService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ItemDao itemDao;

	@Override
	public Long createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public void addItem(String email, Item item) {
		User user = userDao.findByEmail(email);
		user.addItem(item);
		item.setUser(user);
		itemDao.save(item);
	}

	@Override
	public void removeItem(String name) {
		Item item = itemDao.findByName(name);
		User user = item.getUser();
		user.removeItem(item);
		itemDao.delete(item);
	}

	@Override
	public void deleteUser(User user) {
		List<Item> items = (List<Item>) user.getItems();
		for (Item item : items) {
			user.removeItem(item);
			itemDao.delete(item);
		}
		userDao.delete(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}