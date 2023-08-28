package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="personal_reference")
public class PersonalReferenceEntity {

    @Id
    @Column(name = "personal_reference_id")
    private String personalReferenceId;

    @Column(name="personal_reference_name")
    private String personalReferenceName;

    @Column(name="personal_reference_phone")
    private String personalReferencePhone;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoanApplicationEntity loansApplication;

}
