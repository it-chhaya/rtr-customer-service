package dev.chhaya.customer.features.address;

import dev.chhaya.customer.domain.Address;
import dev.chhaya.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends
        JpaRepository<Address, Long> {

    @Modifying
    @Query("DELETE FROM Address AS a WHERE a.customer.id = ?1")
    void deleteAddressByCustomerId(Long customerId);

}
