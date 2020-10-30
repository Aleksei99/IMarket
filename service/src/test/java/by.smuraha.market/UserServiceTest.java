package by.smuraha.market;

import by.smuraha.market.entity.Address;
import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.Role;
import by.smuraha.market.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest extends InitDbTest{

    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void addInformation(){
        userService.save(new User("Alexandr","Jirik","jir","Jirik2000",Role.USER));
    }

    @Test
    public void saveUserTest(){
        User user = userService.save(new User("ads","ad","adsdaf","sdf", Role.ADMIN));
        Assert.assertNotNull(user);
    }

    @Test
    public void findUserByUserNameTest(){
        Assert.assertNotNull(userService.findByUsername("alex"));
    }

    @Test
    public void loadUserByUsernameTest(){
        UserDetails user = userService.loadUserByUsername("alex");
        Assert.assertNotNull(user);
    }

    @Test
    public void bCryptPasswordEncoderTest(){
        User user = userService.findByUsername("jir");
        Assert.assertNotEquals(user.getPassword(),"Jirik2000");
    }

    @Test
    public void deleteUserTest(){
        Optional<ContactInformation> inf = contactService.findById(1L);
        boolean ex = inf.isPresent();
        Assert.assertTrue(ex);
        userService.deleteUser("alex");
        Optional<ContactInformation> information = contactService.findById(1L);
        boolean present = information.isPresent();
        Assert.assertFalse(present);
        Assert.assertNull(userService.findByUsername("alex"));

    }
}
