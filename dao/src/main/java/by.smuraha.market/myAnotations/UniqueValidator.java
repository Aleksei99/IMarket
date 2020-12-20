package by.smuraha.market.myAnotations;

import by.smuraha.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class UniqueValidator implements ConstraintValidator<Unique, String> {


    private UserRepository userRepository;

    @Autowired
    public UniqueValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UniqueValidator() {
    }

    @Override
    public void initialize(Unique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return userRepository.findByUsername(s) == null;
        } catch (NullPointerException e) {
            return true;
        }
    }
}
