package nl.thk.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * As past calc only need to be retieved... as a whole to show on page.
 * And no sub parts are needed for any other fuc where are just storing a string.
 */
@Data
@Entity
@NoArgsConstructor
@Table
public class Calculation extends AbstractBaseEntity {

    // When debugging looking in the DB none schemantic naming of sequence number does not help.
    // Thus I find naming my sequences handy especially during debugging
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calculationSequenceGenerator")
    @SequenceGenerator(name = "calculationSequenceGenerator", sequenceName = "calculation_SEQ", allocationSize = 1)
    private Long id;

    public Calculation(String calculation) {
        this.calculation = calculation;
    }

    @Column
    protected String calculation = "";

}
