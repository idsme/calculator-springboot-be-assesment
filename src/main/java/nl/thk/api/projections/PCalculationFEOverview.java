package nl.thk.api.projections;

import nl.thk.api.model.Calculation;
import nl.thk.api.model.parts.ICalculation;
import nl.thk.api.model.parts.IId;
import org.springframework.data.rest.core.config.Projection;

// Show only directly needed for an fe overview page say only the calculations
@Projection(name = "calculationfeoverview", types = { Calculation.class })
public interface PCalculationFEOverview extends ICalculation {
}
