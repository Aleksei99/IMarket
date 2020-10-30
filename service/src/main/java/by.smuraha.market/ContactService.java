package by.smuraha.market;

import by.smuraha.market.entity.Address;
import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.User;

import java.util.Optional;

public interface ContactService {
    void saveHomeAddress(Address homeAddress, String telephone, String email);
    void forTestSaveHomeAddress(Address homeAddress, String telephone, String email,User user);
    void saveAnotherAddress(Address anotherAddress);
    void changeAddress();
    void deleteContactInformation(User user);
    void deleteByUsername(String username);
    void deleteByID(Long id);


    ContactInformation findByUser(User user);

    Optional<ContactInformation> findById(Long id);

    ContactInformation findUserContact();

    ContactInformation getEmptyContact();
}
