package dev.chhaya.customer.features.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.features.customer.dto.CustomerSyncDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventConsumer {

    private final ObjectMapper objectMapper;
    private final CustomerService customerService;

    @KafkaListener(topics = "customerDeletedEventTopic",
            groupId = "${spring.application.name}")
    public void consumeCustomerDeletedEvent(ConsumerRecord<String, Object> record) throws JsonProcessingException {
        // Hard delete
        customerService.deletedById(Long.valueOf(record.key()));
    }

    @KafkaListener(topics = "customerUpdatedEventTopic",
            groupId = "${spring.application.name}")
    public void consumeCustomerUpdatedEvent(ConsumerRecord<String, Object> record) throws JsonProcessingException {
        CustomerSyncDto customerSyncDto = objectMapper
                .readValue(record.value().toString(), CustomerSyncDto.class);
        customerService.syncCustomer(customerSyncDto);
    }

    @KafkaListener(topics = "customerCreatedEventTopic",
        groupId = "${spring.application.name}")
    public void consumeCustomerCreatedEvent(ConsumerRecord<String, Object> record) throws JsonProcessingException {
        CustomerSyncDto customerSyncDto = objectMapper
                .readValue(record.value().toString(), CustomerSyncDto.class);
        customerService.syncCustomer(customerSyncDto);
    }

}
