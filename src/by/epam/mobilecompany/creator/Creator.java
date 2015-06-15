package by.epam.mobilecompany.creator;

import by.epam.mobilecompany.action.Search;
import by.epam.mobilecompany.action.Sort;
import by.epam.mobilecompany.exception.LogicalException;
import by.epam.mobilecompany.model.*;
import by.epam.mobilecompany.out.PrintResult;
import by.epam.mobilecompany.action.UserCount;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

/**
 * Created by aterehovich on 5/22/15.
 */
public class Creator {

    final static Logger LOGGER = Logger.getLogger(Creator.class);

    private MobileOperator mobileOperator;
    private AbstractTariffPlan tp1;
    private AbstractTariffPlan tp2;
    private AbstractTariffPlan tp3;

    public Creator(){
        try {
            mobileOperator = new MobileOperator("Velcom");
            tp1 = new TalkTariffPlan("Все говорят", 37700, 399, 350, 100, 56000);
            tp2 = new BusinessTariffPlan("Smart 1", 109900, 365, 350, 200, 30, 1024, 104000);
            tp3 = new InternetTariffPlan("Пакет 1500", 69900, 288, 1500, 24000);
            mobileOperator.addTariff(tp1);
            mobileOperator.addTariff(tp2);
            mobileOperator.addTariff(tp3);

            doAndWrite();
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        }
    }

    private void doAndWrite(){
        try {
            PrintResult printResult = new PrintResult();
            String searchByFeeResult = "Search by license Fee: "+ Search.searchByFee(mobileOperator.getTariffPlans(), 50000).toString();
            String searchByMinuteCostResult = "Search by minute cost: "
                    + Search.searchByMinuteCost(mobileOperator.getTariffPlans(), 370).toString();
            String searchBySmsCostResult = "Search by SMS cost: "
                    + Search.searchBySmsCost(mobileOperator.getTariffPlans(), 340).toString();
            String sortResult = "Sorted by License Fee: \n" + Sort.sortByFee(mobileOperator).toString();
            String userCountResult = "There are " + UserCount.Counter(mobileOperator) + " of people uses " + mobileOperator.getName();
            printResult.write(userCountResult);
            printResult.write(searchByFeeResult);
            printResult.write(searchByMinuteCostResult);
            printResult.write(searchBySmsCostResult);
            printResult.write(sortResult);
        } catch (FileNotFoundException e){
            LOGGER.error("File "+PrintResult.getOutputFilePath() + " not found!");
        } catch (LogicalException e) {
            LOGGER.error("Some of results is null");
        }

    }
}
