package nl.thk.api.repositories;

import nl.thk.api.model.Calculation;
import nl.thk.api.projections.PCalculationFEOverview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "calculations", path = "calculations", excerptProjection = PCalculationFEOverview.class)
public interface CalculationRepository extends CrudRepository<Calculation, Long> {

}
