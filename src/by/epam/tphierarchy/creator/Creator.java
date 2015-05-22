package by.epam.tphierarchy.creator;

import by.epam.tphierarchy.model.*;
import by.epam.tphierarchy.out.PrintResult;
import by.epam.tphierarchy.action.UserCount;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

/**
 * Created by aterehovich on 5/22/15.
 */
public class Creator {

    final static Logger LOGGER = Logger.getLogger(Creator.class);

    public Creator(){
        try {
            MobileOperator mobileOperator = new MobileOperator("Velcom");
            AbstractTariffPlan tp1 = new TalkTariffPlan("Все говорят",37700, 399, 350, 100, 56000);
            AbstractTariffPlan tp2 = new BusinessTariffPlan("Smart 1", 109900, 365, 350, 200, 1024, 104000);
            AbstractTariffPlan tp3 = new InternetTariffPlan("Пакет 1500", 69900, 288, 350, 1500, 24000);
            mobileOperator.addTariff(tp1);
            mobileOperator.addTariff(tp2);
            mobileOperator.addTariff(tp3);

            String result = "There are " + UserCount.Counter(mobileOperator) + " of people uses " + mobileOperator.getName();
            new PrintResult().write(result);
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        } catch (FileNotFoundException e){
            LOGGER.error("File "+PrintResult.getOutputFilePath() + " not found!");
        }
    }
}
