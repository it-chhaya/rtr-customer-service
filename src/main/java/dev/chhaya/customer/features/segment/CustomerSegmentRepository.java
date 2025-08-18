package dev.chhaya.customer.features.segment;

import dev.chhaya.customer.domain.CustomerSegment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSegmentRepository extends JpaRepository<CustomerSegment, Integer> {
}
