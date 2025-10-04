package donate;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load(); // Loads .env from the current directory
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
        // TODO: Create an adapter to switch between dbs easily
        SpringApplication.run(Main.class,args);
    }
}
