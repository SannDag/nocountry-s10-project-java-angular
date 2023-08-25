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
@Table(name="references")
public class ReferencesEntity {

    @Id
    @Column(name="references_id")
    private String referencesId;

    @Column(name="spouses_name")
    private String spousesName;

    @Column(name="spouses_phone")
    private String spousesPhone;

    @Column(name="personal_references_name")
    private String personalReferencesName;

    @Column(name="personal_references_phone")
    private String personalReferencesPhone;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoansApplicationEntity loansApplication;
}
