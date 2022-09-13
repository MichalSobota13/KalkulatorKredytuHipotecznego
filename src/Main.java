import model.*;
import service.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .witchAmount(new BigDecimal("298000"))
                .witchMonthsDuration(BigDecimal.valueOf(360))
                .witchRateType(RateType.CONSTANT)
                .witchOverpaymentReduceWay(Overpayment.REDUCE_RATE);

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RatecalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(
                        new ConstantAmountsCalculationServiceImpl(),
                        new DecreasingAmountsCalculationServiceImpl()
                ),
                new OverpaymentCalculationServiceImpl(),
                new ResidualCalculationServiceImpl(),
                new ReferenceCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService,
                SummaryServiceFactory.create()
        );

        mortgageCalculationService.calculate(inputData);

    }
}
