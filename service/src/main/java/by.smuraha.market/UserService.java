package by.smuraha.market;

import by.smuraha.market.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    void deleteUser(String username);
    User save(User user);
    User getCurrentUser();
}
