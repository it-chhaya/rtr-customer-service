package dev.chhaya.customer.features.kyc;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.domain.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycRepository extends
        JpaRepository<Kyc, Long> {

    void deleteByCustomer(Customer customer);

}
