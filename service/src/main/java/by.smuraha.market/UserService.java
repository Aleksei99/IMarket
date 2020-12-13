package by.smuraha.market;

import by.smuraha.market.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    void deleteUser(String username);
    User findUserById(Long id);
    User save(User user);
    User setErrorJSONUser(Errors errors);
    User getCurrentUser();
}
