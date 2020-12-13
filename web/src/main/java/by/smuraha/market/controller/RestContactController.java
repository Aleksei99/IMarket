package by.smuraha.market.controller;

import by.smuraha.market.ContactService;
import by.smuraha.market.dto.ContactInformationDto;
import by.smuraha.market.entity.Address;
import by.smuraha.market.entity.ContactInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContactController {
    private final ContactService contactService;

    @Autowired
    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/getContactInformation")
    public ContactInformation getContactInformation(){
        ContactInformation contact = contactService.findUserContact();
        if(contact==null){
            return contactService.getEmptyContact();
        }else
            return contact;
    }

    @PostMapping("/restEditInformation")
    public ContactInformationDto editInformation(@RequestBody ContactInformationDto contactInformation){
        Address address = new Address();
        address.setCity(contactInformation.getCity());
        address.setHouse(contactInformation.getHouse());
        address.setNumber(contactInformation.getNumber());
        address.setStreet(contactInformation.getStreet());
        contactService.saveHomeAddress(address,contactInformation.getTelephone(),contactInformation.getEmail());
        return contactInformation;
    }
}
