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
@Table(name="parents_references")
public class ParentsReferencesEntity {

    @Id
    @Column(name="loan_application_id")
    private String loansApplicationId;

    @Column(name="spouses_name")
    private String spousesName;

    @Column(name="spouses_phone")
    private String spousesPhone;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "family_phone")
    private String familyPhone;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoanApplicationEntity loansApplication;
}
