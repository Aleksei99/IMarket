package by.smuraha.market;

import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ContactInformationTest extends InitDbTest{

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;

    @Test
    public void getContactInformationTest(){
        User user = userService.findByUsername("alex");
        Assert.assertNotNull(contactService.findByUser(user));
    }

    @Test
    public void deleteContactInformationTest(){
        User user = userService.findByUsername("alex");
        Optional<ContactInformation> inf = contactService.findById(1L);
        Assert.assertFalse(inf.isPresent());
        contactService.deleteContactInformation(user);
        Optional<ContactInformation> inf2 = contactService.findById(1L);
        Assert.assertFalse(inf2.isPresent());
        Assert.assertNotNull(userService.findByUsername("alex"));
    }
}
