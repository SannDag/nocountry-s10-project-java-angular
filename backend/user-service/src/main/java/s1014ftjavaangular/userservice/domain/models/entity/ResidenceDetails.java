package s1014ftjavaangular.userservice.domain.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResidenceDetails {
    private UUID id;
    private String housingStatus;
    private Integer yearsInHouse;
    private Integer monthsInHouse;
    private String city;
    private String state;
    private String address1;
    private String address2;
    private String zipCode;
    private User user;
}
