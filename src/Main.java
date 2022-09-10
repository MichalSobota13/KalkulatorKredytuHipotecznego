import model.InputData;
import model.MortgageResidual;
import model.RateAmounts;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .witchAmount(new BigDecimal(298000))
                .witchMonthsDuration(BigDecimal.valueOf(160));

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RatecalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(),
                new ResidualCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );
        mortgageCalculationService.calculate(inputData);

    }
}
