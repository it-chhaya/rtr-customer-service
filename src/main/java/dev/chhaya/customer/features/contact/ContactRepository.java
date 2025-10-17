package dev.chhaya.customer.features.contact;

import dev.chhaya.customer.domain.Contact;
import dev.chhaya.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends
        JpaRepository<Contact, Long> {

    void deleteByCustomer(Customer customer);

}
