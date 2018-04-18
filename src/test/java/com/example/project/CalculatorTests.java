/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import com.example.project.hello.Application;
import com.example.project.hello.MessagePrinter;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class CalculatorTests {

	@Test
	void add() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	void add2() {
            ApplicationContext context = 
                new AnnotationConfigApplicationContext(Application.class);
            MessagePrinter printer = context.getBean(MessagePrinter.class);
            System.out.println(printer.getMessage());
            assertEquals("Hello World!", printer.getMessage());
	}
}
