package dev.chhaya.customer.features.customer.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerSyncDto {

    private String id;

    private String customerNumber;

    private String firstName;

    private String lastName;

    private String email;

    private String segmentId;

    private String status;

    private Long createdAt;

    private Long updatedAt;

    private String createdBy;

    private String updatedBy;

    private List<AddressDto> addresses;

    private List<ContactDto> contacts;

    private List<KycDto> kyc;
}
