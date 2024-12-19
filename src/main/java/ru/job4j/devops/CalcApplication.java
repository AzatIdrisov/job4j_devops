package ru.job4j.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main-класс приложения CalcApplication
 */
@SpringBootApplication
public class CalcApplication {

	/**
	 * Точка входа в прилоежение CalcApplication
	 * @param args - параметры старта приложения
	 */
	public static void main(String[] args) {
		SpringApplication.run(CalcApplication.class, args);
	}
}
