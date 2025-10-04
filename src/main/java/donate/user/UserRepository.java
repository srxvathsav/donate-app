package donate.user;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {
    @Override
    <S extends User> S save(S entity);
}
