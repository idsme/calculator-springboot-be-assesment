package nl.thk.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;

/**
 * Keeping things like created and updated helps debug problems during development and prod.
 * And thus might actually save you time while developing as you can see when data was created
 * and updated especially when more complicated scenarios are added.
 */
@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractBaseEntity {
    @CreationTimestamp
    @Column(updatable = false) // , columnDefinition = "date default current_date")
    private Date created;
}
