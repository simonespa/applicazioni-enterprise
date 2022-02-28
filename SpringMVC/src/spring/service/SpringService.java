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

import spring.dto.Item;
import spring.dto.User;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 *
 */
public interface SpringService {

	public Long createUser(User user);
	public void addItem(String email, Item item);
	public void removeItem(String name);
	public void deleteUser(User user);
	public List<User> getAllUsers();
	
}
