package dev.chhaya.customer.features.address;

import dev.chhaya.customer.domain.Address;
import dev.chhaya.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends
        JpaRepository<Address, Long> {

    void deleteByCustomer(Customer customer);

}
