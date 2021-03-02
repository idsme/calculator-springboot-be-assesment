package nl.thk.api.services;

import nl.thk.api.model.CalcInput;
import nl.thk.api.model.Calculation;
import nl.thk.api.repositories.CalculationRepository;
import nl.thk.api.utils.CalculatorUtil;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@SpringBootTest
class CalculationServiceTest {

    //Purpose test the service and nothing, thus everything is mocked even static methods
    // Which is new in mockito see pom exclusions in relation to spring-boot-starter-test

    @Autowired
    private CalculationService service;

    @MockBean
    private CalculationRepository repo;

    @Test
    void addAndSave() {
        // Setup
        Calculation expectedInput = new Calculation("7+11=42.0");
        Calculation expectedResult = new Calculation("7+11=42.0");
        expectedResult.setId(1L);
        Mockito.when(repo.save(expectedInput)).thenReturn(expectedResult);
        Calculation result = null;

        // Instantiate a MockedStatic in a try-with-resources block
        try (MockedStatic<CalculatorUtil> calcUtil = Mockito.mockStatic(CalculatorUtil.class)) {

            // stub the static method that is called by the class under test
            calcUtil.when(() -> CalculatorUtil.add(anyInt(), anyInt()))
                    .thenReturn(42D);

            // Execute
            result = service.addAndSave(new CalcInput(7, 11));
        }

        // Verify
        Mockito.verify(repo, times(1)).save(expectedInput);
        assertEquals(expectedResult, result);
    }

    @Test
    void subtractAndSave() {
        // Setup
        Calculation expectedInput = new Calculation("7-11=42.0");
        Calculation expectedResult = new Calculation("7-11=42.0");
        expectedResult.setId(1L);
        Mockito.when(repo.save(expectedInput)).thenReturn(expectedResult);
        Calculation result = null;

        // Instantiate a MockedStatic in a try-with-resources block
        try (MockedStatic<CalculatorUtil> calcUtil = Mockito.mockStatic(CalculatorUtil.class)) {

            // stub the static method that is called by the class under test
            calcUtil.when(() -> CalculatorUtil.subtract(anyInt(), anyInt()))
                    .thenReturn(42D);

            // Execute
            result = service.subtractAndSave(new CalcInput(7, 11));
        }

        // Verify
        Mockito.verify(repo, times(1)).save(expectedInput);
        assertEquals(expectedResult, result);
    }

    @Test
    void mutiplyAndSave() {
        // Setup
        Calculation expectedInput = new Calculation("7*11=42.0");
        Calculation expectedResult = new Calculation("7*11=42.0");
        expectedResult.setId(1L);
        Mockito.when(repo.save(expectedInput)).thenReturn(expectedResult);
        Calculation result = null;

        // Instantiate a MockedStatic in a try-with-resources block
        try (MockedStatic<CalculatorUtil> calcUtil = Mockito.mockStatic(CalculatorUtil.class)) {

            // stub the static method that is called by the class under test
            calcUtil.when(() -> CalculatorUtil.multiply(anyInt(), anyInt()))
                    .thenReturn(42D);

            // Execute
            result = service.mutiplyAndSave(new CalcInput(7, 11));
        }

        // Verify
        Mockito.verify(repo, times(1)).save(expectedInput);
        assertEquals(expectedResult, result);
    }

    @Test
    void divideAndSave() {
        // Setup
        Calculation expectedInput = new Calculation("7/11=42.0");
        Calculation expectedResult = new Calculation("7/11=42.0");
        expectedResult.setId(1L);
        Mockito.when(repo.save(expectedInput)).thenReturn(expectedResult);
        Calculation result = null;

        // Instantiate a MockedStatic in a try-with-resources block
        try (MockedStatic<CalculatorUtil> calcUtil = Mockito.mockStatic(CalculatorUtil.class)) {

            // stub the static method that is called by the class under test
            calcUtil.when(() -> CalculatorUtil.divide(anyInt(), anyInt()))
                    .thenReturn(42D);

            // Execute
            result = service.divideAndSave(new CalcInput(7, 11));
        }

        // Verify
        Mockito.verify(repo, times(1)).save(expectedInput);
        assertEquals(expectedResult, result);
    }


}