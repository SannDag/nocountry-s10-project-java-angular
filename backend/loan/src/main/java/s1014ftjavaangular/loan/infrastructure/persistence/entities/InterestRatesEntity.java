package s1014ftjavaangular.loan.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account")
public class InterestRatesEntity {
    @Id
    private String interestRatesUuid;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "annual_percentage", nullable = false)
    private Double annualPercentage;
    @Column(name = "status", nullable = false)
    private Boolean status;
}
