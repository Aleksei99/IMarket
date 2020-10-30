package by.smuraha.market;

import by.smuraha.market.entity.Address;
import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.User;
import by.smuraha.market.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final UserService userService;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, UserService userService) {
        this.contactRepository = contactRepository;
        this.userService = userService;
    }

    @Override
    public void saveHomeAddress(Address homeAddress, String telephone, String email) {
        User user = userService.getCurrentUser();
        ContactInformation contact = getOrCreateContact();
        contact.setUser(user);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setHomeAddress(homeAddress);
        contactRepository.save(contact);
    }

    @Override
    public void forTestSaveHomeAddress(Address homeAddress, String telephone, String email, User user) {
        ContactInformation contact = new ContactInformation();
        contact.setUser(user);
        contact.setTelephone(telephone);
        contact.setEmail(email);
        contact.setHomeAddress(homeAddress);
        contactRepository.save(contact);
    }

    @Override
    public void saveAnotherAddress(Address anotherAddress) {
        User user = userService.getCurrentUser();
        ContactInformation contact = getOrCreateContact();
        contact.setUser(user);
        contact.setOtherAddress(anotherAddress);
        contact.setAnotherAddress(true);
        contactRepository.save(contact);
    }

    @Override
    public void changeAddress() {
        User user = userService.getCurrentUser();
        ContactInformation contact = getOrCreateContact();
        contact.setUser(user);
        contact.setAnotherAddress(false);
        contactRepository.save(contact);
    }

    @Override
    public void deleteContactInformation(User user) {
        contactRepository.deleteContactInformationByUser(user);
    }

    @Override
    public void deleteByUsername(String username) {
        contactRepository.deleteByUserUsername(username);
    }

    @Override
    public void deleteByID(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public ContactInformation findByUser(User user) {
        return contactRepository.findByUser(user);
    }

    @Override
    public Optional<ContactInformation> findById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactInformation findUserContact() {
        User user = userService.getCurrentUser();
        return contactRepository.findByUser(user);
    }

    private ContactInformation getOrCreateContact() {
        return findUserContact() == null ? new ContactInformation() : findUserContact();
    }

    @Override
    public ContactInformation getEmptyContact() {
        ContactInformation empty = new ContactInformation();
        Address address = new Address();
        address.setCity("");
        address.setHouse("");
        address.setNumber("");
        address.setStreet("");
        empty.setTelephone("");
        empty.setEmail("");
        empty.setHomeAddress(address);
        return empty;
    }
}
