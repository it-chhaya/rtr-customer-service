package dev.chhaya.customer.features.customer;

import dev.chhaya.customer.domain.Customer;
import dev.chhaya.customer.domain.CustomerSegment;
import dev.chhaya.customer.features.address.AddressRepository;
import dev.chhaya.customer.features.contact.ContactRepository;
import dev.chhaya.customer.features.customer.dto.CreateCustomerRequest;
import dev.chhaya.customer.features.customer.dto.CustomerResponse;
import dev.chhaya.customer.features.customer.dto.CustomerSyncDto;
import dev.chhaya.customer.features.kyc.KycRepository;
import dev.chhaya.customer.features.segment.CustomerSegmentRepository;
import dev.chhaya.customer.mapper.CustomerMapper;
import dev.chhaya.customer.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service(value = "customerServiceImpl")
@RequiredArgsConstructor
public class CustomerServiceImpl implements
        CustomerService {

    private final CustomerSegmentRepository customerSegmentRepository;
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final KycRepository kycRepository;
    private final CustomerMapper customerMapper;

    @Override
    public void syncUpdateCustomer(CustomerSyncDto customerSyncDto) {

        Customer customer = customerRepository
                .findById(Long.valueOf(customerSyncDto.getId()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

        CustomerSegment customerSegment =
                customerSegmentRepository.findById(Integer.parseInt(customerSyncDto.getSegmentId()))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer segment is invalid"));
        customer.setCustomerSegment(customerSegment);

        if (customerSyncDto.getDateOfBirth() != null) {
            customer.setDateOfBirth(DateTimeUtil.toLocalDate(customerSyncDto.getDateOfBirth()));
        }

        if (customerSyncDto.getUpdatedAt() != null) {
            customer.setUpdatedAt(DateTimeUtil.toLocalDateTime(customerSyncDto.getUpdatedAt()));
        }

        if (customerSyncDto.getAddresses() != null) {
            addressRepository.deleteByCustomer(customer);
            customer.getAddresses().forEach(address -> address.setCustomer(customer));
        }

        if (customer.getContacts() != null) {
            contactRepository.deleteByCustomer(customer);
            customer.getContacts().forEach(contact -> contact.setCustomer(customer));
        }

        if (customer.getKyc() != null) {
            kycRepository.deleteByCustomer(customer);
            customer.getKyc().forEach(kyc -> kyc.setCustomer(customer));
        }

        customerRepository.save(customer);

    }


    @Override
    public void deletedById(Long id) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        customerRepository.delete(customer);

    }


    @Override
    public void syncCustomer(CustomerSyncDto customerSyncDto) {
        Customer customer = customerMapper.toCustomer(customerSyncDto);

        if (customer.getAddresses() != null) {
            customer.getAddresses().forEach(address -> address.setCustomer(customer));
        }

        if (customer.getContacts() != null) {
            customer.getContacts().forEach(contact -> contact.setCustomer(customer));
        }

        if (customer.getKyc() != null) {
            customer.getKyc().forEach(kyc -> kyc.setCustomer(customer));
        }

        CustomerSegment customerSegment =
                customerSegmentRepository.findById(Integer.parseInt(customerSyncDto.getSegmentId()))
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer segment is invalid"));
        customer.setCustomerSegment(customerSegment);

        if (customerSyncDto.getDateOfBirth() != null) {
            customer.setDateOfBirth(DateTimeUtil.toLocalDate(customerSyncDto.getDateOfBirth()));
        }

        if (customerSyncDto.getCreatedAt() != null) {
            customer.setCreatedAt(DateTimeUtil.toLocalDateTime(customerSyncDto.getCreatedAt()));
        }

        if (customerSyncDto.getUpdatedAt() != null) {
            customer.setUpdatedAt(DateTimeUtil.toLocalDateTime(customerSyncDto.getUpdatedAt()));
        }

        customerRepository.save(customer);
    }


    @Override
    public CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest) {

        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        customer.setCustomerNumber(UUID.randomUUID().toString());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        // Insert into database
        customer = customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }

    @Override
    public List<CustomerResponse> getCustomers() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdAt");
        List<Customer> customers = customerRepository.findAll(sort);

        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }

    @Override
    public CustomerResponse getCustomerByNo(String customerNo) {
        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return customerMapper.fromCustomer(customer);
    }

    @Override
    public void deleteCustomerByNo(String customerNo) {
        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        customerRepository.delete(customer);
    }

    @Override
    public CustomerResponse updateCustomerByNo(String customerNo, CreateCustomerRequest createCustomerRequest) {

        Customer customer = customerRepository
                .findByCustomerNumber(customerNo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        customerMapper.toCustomerPartially(createCustomerRequest, customer);
        customer.setUpdatedAt(LocalDateTime.now());

        customer = customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }
}
