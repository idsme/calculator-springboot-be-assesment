package nl.thk.api.controllers;

import nl.thk.api.model.CalcInput;
import nl.thk.api.model.Calculation;
import nl.thk.api.repositories.CalculationRepository;
import nl.thk.api.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This layer adds in this case as rest translation service.
 */

@RestController
public class CalculationManualController {

    @Autowired
    private CalculationService service;

    @Autowired
    private CalculationRepository repo;

    /**
     * Finder returning pure entity object.. We can use @JsonIgnore to return less but this might not be exceptable
     * in all cases.
     * Thus I also provided a version of get all following the dto practice, where I use composable object parts using which make up a projection on the
     * raw Entity object. See PCalculation and PCalculationFeOverview two different views on same underlying object.
     * @return all calculations stored in DB
     */
    @GetMapping("/manual/fe/calculations")
    public ResponseEntity<Iterable<Calculation>> getAll()
    {
        // Making this go through the service and the call the repo adds nothing as method will call repo.
        // Be keen to hear your opinion on this.
        // But generally I go for, Less code, less test, more transparency.
        Iterable<Calculation> calculations = repo.findAll();
        return new ResponseEntity<Iterable<Calculation>>(
                calculations,
                HttpStatus.OK);
    }

    @PostMapping("manual/fe/calculations/add")
    public ResponseEntity<Calculation> add(@RequestBody CalcInput input)
    {
        Calculation calculation = service.addAndSave(input);

        return ResponseEntity.ok(calculation);
    }

    private Calculation addAndSave(CalcInput input) {
        return service.addAndSave(input);
    }

    @PostMapping("manual/fe/calculations/subtract")
    public ResponseEntity<Calculation> subtract(@RequestBody CalcInput input)
    {
        Calculation calculation = service.subtractAndSave(input);

        return ResponseEntity.ok(calculation);
    }

    private Calculation subtractAndSave(CalcInput input) {
        return service.subtractAndSave(input);
    }

    @PostMapping("manual/fe/calculations/multiply")
    public ResponseEntity<Calculation> multiply(@RequestBody CalcInput input)
    {
        Calculation calculation = service.mutiplyAndSave(input);

        return ResponseEntity.ok(calculation);
    }

    private Calculation mutiplyAndSave(CalcInput input) {
        return service.mutiplyAndSave(input);
    }

    @PostMapping("manual/fe/calculations/divide")
    public ResponseEntity<Calculation> divide(@RequestBody CalcInput input)
    {
        Calculation calculation = service.divideAndSave(input);

        return ResponseEntity.ok(calculation);
    }

    private Calculation divideAndSave(CalcInput input) {
        return service.divideAndSave(input);
    }
}