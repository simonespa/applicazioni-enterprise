/*
 * This file is part of SpringExampleFromTheBook.
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
package aop;

import org.springframework.stereotype.Component;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 *
 */
@Component
public class Volunteer implements Thinker {

	private String thoughts;
	
	@Override
	public void thinkOfSomething(String thoughts) {
		this.thoughts = thoughts;
	}
	
	public String getThoughts() {
		return thoughts;
	}

}