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
package aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Aspect
public class Audience {

	@Pointcut("execution(* aop.annotation.Performer.perform(..)")
	public void performance() {

	}

	@Before("performance()")
	public void takeSeats() {
		System.out.println("The audience is taking their seats");
	}

	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their mobiles");
	}

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinpoint) {
		long start = 0;
		long end = 0;
		try {
			System.out.println("The audience is taking their seats");
			System.out.println("The audience is turning off their mobiles");
			start = System.nanoTime();
			joinpoint.proceed();
			end = System.nanoTime();
			System.out.println("CLAP CLAP CLAP CLAP");
		} catch (Throwable e) {
			end = System.nanoTime();
			System.out.println("Boooh! We want our money back!");
		} finally {
			System.out.println("The performance took " + (end - start) + " nanoseconds");
		}
	}

	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boooh! We want our money back!");
	}

}