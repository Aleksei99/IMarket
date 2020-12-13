package by.smuraha.market.repository;

import by.smuraha.market.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findUserById(Long id);
    void deleteByUsername(String username);
}
