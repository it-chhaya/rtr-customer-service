package dev.chhaya.customer.features.kyc;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.domain.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface KycRepository extends
        JpaRepository<Kyc, Long> {

    @Modifying
    @Query("DELETE FROM Kyc AS a WHERE a.customer.id = ?1")
    void deleteKycByCustomerId(Long customerId);
}
