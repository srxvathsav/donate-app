package donate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        // TODO: Create an adapter to switch between dbs easily
        SpringApplication.run(Main.class,args);
    }
}
