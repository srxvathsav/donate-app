package donate.user;
import java.util.UUID;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Users")
public class User{
    @Id
    private String id;
    private int age;
    private String name, role;

    public User(){};

    public User(int age,String name, String role){
        setId(String.valueOf(UUID.randomUUID()));
        setAge(age);
        setName(name);
        setRole(role);
    }

    public static User createUser(String name, String role, int age){
        User user = new User(age, name, role);
        return user;
    }

    // Getters
    public String getId() { return id; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getRole(){ return role; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setRole(String role) { this.role = role; }

}


