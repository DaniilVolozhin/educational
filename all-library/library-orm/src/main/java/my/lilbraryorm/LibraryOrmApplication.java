package my.lilbraryorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
