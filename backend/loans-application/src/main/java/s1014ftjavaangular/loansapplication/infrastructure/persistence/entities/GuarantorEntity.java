package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import s1014ftjavaangular.loansapplication.domain.model.entity.Guarantor;
import s1014ftjavaangular.loansapplication.domain.model.enums.IdentificationType;

import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="guarantor")
public class GuarantorEntity {

    @Id
    @Column(name="loan_application_id")
    private String loanApplicationId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="lastname", nullable = false)
    private String lastname;

    @Column(name="identification_type", nullable = false)
    private IdentificationType identificationType;

    @Column(name="identification", nullable = false)
    private String identification;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="state", nullable = false)
    private String state;

    @Column(name="address", nullable = false)
    private String address;
    @Column(name="apartment")
    private String apartment;

    @Column(name="phone", nullable = false)
    private String phone;

    @Column(name = "zipcode", nullable = false)
    private String zipcode;

    @JsonIgnore
    @ToString.Exclude
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoanApplicationEntity loansApplicationId;

    public static final Function<Guarantor, GuarantorEntity> modelToEntity = (model) -> {
        GuarantorEntity entity = new GuarantorEntity();
        entity.setLoanApplicationId(model.getLoanApplicationId());
        entity.setName(model.getName());
        entity.setLastname(model.getLastname());
        entity.setIdentificationType(model.getIdentificationType());
        entity.setIdentification(model.getIdentification());
        entity.setCity(model.getCity());
        entity.setState(model.getState());
        entity.setAddress(model.getAddress());
        entity.setApartment(model.getApartment());
        entity.setPhone(model.getPhone());
        entity.setZipcode(model.getZipcode());

        return entity;

    };
}
