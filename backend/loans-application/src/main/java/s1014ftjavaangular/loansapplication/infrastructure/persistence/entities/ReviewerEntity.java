package s1014ftjavaangular.loansapplication.infrastructure.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviewer")
public class ReviewerEntity {

    @Id
    @Column(name="loan_appication_id")
    private String loanApplicationId;

    @Column(name="reviewer_id", nullable = false)
    private String reviewerId;

    @Column(name="init_date", nullable = false)
    private LocalDate initDate;

    @JsonIgnore
    @ToString.Exclude
    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_application_id", referencedColumnName = "loan_application_id")
    private LoansApplicationEntity loansApplication;
}
