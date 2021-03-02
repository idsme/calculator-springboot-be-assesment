package nl.thk.api.services;

import nl.thk.api.model.CalcInput;
import nl.thk.api.model.Calculation;
import nl.thk.api.repositories.CalculationRepository;
import nl.thk.api.utils.CalculatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    @Autowired
    private CalculationRepository repo;

    public CalculationService() {
    }

    public Calculation addAndSave(CalcInput input) {
        double calculationResult = CalculatorUtil.add(input.a, input.b);
        Calculation calculation = new Calculation(input.a + "+" + input.b + "=" + calculationResult);
        Calculation savedResult = repo.save(calculation);
        return savedResult;
    }

    public Calculation subtractAndSave(CalcInput input) {
        double result = CalculatorUtil.subtract(input.a, input.b);
        Calculation calculation = new Calculation(input.a + "-" + input.b + "=" + result);
        Calculation savedResult = repo.save(calculation);
        return savedResult;
    }

    public Calculation mutiplyAndSave(CalcInput input) {
        double calculationResult = CalculatorUtil.multiply(input.a, input.b);
        Calculation calculation = new Calculation(input.a + "*" + input.b + "=" + calculationResult);
        Calculation savedResult = repo.save(calculation);
        return savedResult;
    }

    public Calculation divideAndSave(CalcInput input) {
        double result = CalculatorUtil.divide(input.a, input.b);
        Calculation calculation = new Calculation(input.a + "/" + input.b + "=" + result);
        Calculation savedResult = repo.save(calculation);
        return savedResult;
    }
}