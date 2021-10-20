package my.lilbraryorm;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class LibraryOrmApplication {

	public static void main(String[] args) {
//		try {
//			Console.main(args);
//		} catch (SQLException e) {
//			System.out.println("БД не поднялась");
//		}
		SpringApplication.run(LibraryOrmApplication.class, args);
	}

}
