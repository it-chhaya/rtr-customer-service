package dev.chhaya.customer.init;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.domain.CustomerSegment;
import dev.chhaya.customer.features.customer.CustomerRepository;
import dev.chhaya.customer.features.segment.CustomerSegmentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final CustomerSegmentRepository customerSegmentRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init() {
        if (customerSegmentRepository.count() == 0) {

            CustomerSegment regular = new CustomerSegment();
            regular.setName("REGULAR");
            regular.setCode("REGULAR");

            CustomerSegment silver = new CustomerSegment();
            silver.setName("SILVER");
            silver.setCode("SILVER");

            CustomerSegment gold = new CustomerSegment();
            gold.setName("GOLD");
            gold.setCode("GOLD");

            customerSegmentRepository.saveAll(
                    List.of(regular, silver, gold)
            );

            Customer customer = new Customer();
            customer.setCustomerNumber("CUS01-2025-08-18");
            customer.setEmail("test@gmail.com");
            customer.setFirstName("Chea");
            customer.setLastName("Tola");
            customer.setCreatedAt(LocalDateTime.now());
            customer.setUpdatedAt(LocalDateTime.now());
            customer.setCustomerSegment(regular);

            Customer customer2 = new Customer();
            customer2.setCustomerNumber("CUS02-2025-08-18");
            customer2.setEmail("test2@gmail.com");
            customer2.setFirstName("Chan");
            customer2.setLastName("Chhaya");
            customer2.setCreatedAt(LocalDateTime.now());
            customer2.setUpdatedAt(LocalDateTime.now());
            customer2.setCustomerSegment(gold);

            Customer customer3 = new Customer();
            customer3.setCustomerNumber("CUS03-2025-08-18");
            customer3.setEmail("test3@gmail.com");
            customer3.setFirstName("Chan");
            customer3.setLastName("Chhaya");
            customer3.setCreatedAt(LocalDateTime.now());
            customer3.setUpdatedAt(LocalDateTime.now());
            customer3.setCustomerSegment(gold);

            customerRepository.save(customer);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
        }
    }
}
