package service;

import model.InputData;
import model.Rate;

import java.util.List;

public class PrintingServiceImpl implements PrintingService {

    @Override
    @SuppressWarnings("RedundantExplicitVariableType")
    public void printingInputDataInfo(InputData inputData) {
        StringBuilder msg = new StringBuilder(NEW_LINE);
        msg.append(MORTGAGE_AMOUNT).append(inputData.getAmount()).append(CURRENCY);
        msg.append(NEW_LINE);
        msg.append(MORTGAGE_PERIOD).append(inputData.getMonthsDuration()).append(MONTHS);
        msg.append(NEW_LINE);
        msg.append(INTEREST).append(inputData.getInterestDisplay()).append(PERCENT);
        msg.append(NEW_LINE);

        printMessage(msg.toString());
    }

    @Override
    public void printRates(List<Rate> rates) {
        String format = "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s " +
                "%s %s ";

        for (Rate rate : rates){
            String message = String.format(format,
                    RATE_NUMBER, rate.getRateNumber(),
                    DATE, rate.getTimePoint().getDate(),
                    YEAR, rate.getTimePoint().getYear(),
                    MONTH, rate.getTimePoint().getMonth(),
                    RATE, rate.getRateAmounts().getRateAmount(),
                    INTEREST, rate.getRateAmounts().getInterestAmount(),
                    CAPITAL, rate.getRateAmounts().getCapitalAmount(),
                    LEFT, rate.getMortgageResidual().getAmount(),
                    MONTHS, rate.getMortgageResidual().getDuration()
            );
            printMessage(message);
        }
    }

    private void printMessage(String sb) {
        System.out.println(sb);
    }
}
