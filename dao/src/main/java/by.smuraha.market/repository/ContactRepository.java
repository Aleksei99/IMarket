package by.smuraha.market.repository;

import by.smuraha.market.entity.ContactInformation;
import by.smuraha.market.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ContactRepository extends CrudRepository<ContactInformation,Long> {
    ContactInformation findByUser(User user);
    void deleteByUserUsername(String username);
    void deleteContactInformationByUser(User user);
}
