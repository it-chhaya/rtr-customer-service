package dev.chhaya.customer.features.contact;

import dev.chhaya.customer.domain.Contact;
import dev.chhaya.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ContactRepository extends
        JpaRepository<Contact, Long> {

    @Modifying
    @Query("DELETE FROM Contact AS a WHERE a.customer.id = ?1")
    void deleteContactByCustomerId(Long customerId);
}
