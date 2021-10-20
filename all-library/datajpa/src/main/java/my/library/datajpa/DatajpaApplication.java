package my.library.datajpa;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatajpaApplication.class, args);
		try {
			Console.main(args);
		} catch (SQLException e) {
			System.out.println("БД не поднялась");
		}
	}

}
