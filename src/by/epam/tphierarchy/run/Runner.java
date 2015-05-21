package by.epam.tphierarchy.run;

import by.epam.tphierarchy.model.*;
import by.epam.tphierarchy.model.exceptions.LogicalException;
import by.epam.tphierarchy.util.UserCount;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class Runner {

     public static final Logger LOGGER = Logger.getLogger(Runner.class);

    static {
        new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {

        try {
            MobileOperator velcom = new MobileOperator("Velcom");
            TariffPlan slovoZaSlovo = new TariffPlan(19900, 389, 350, 43000);
            TariffPlan vseGovoryat = new TalkTariffPlan(37700, 399, 350, 100, 56000);
            TariffPlan smart1 = new BusinessTariffPlan(109900, 365, 350, 200, 1024, 104000);
            TariffPlan paket1500 = new InternetTariffPlan(69900, 288, 350, 1500, 24000);
            velcom.addTariff(slovoZaSlovo);
            velcom.addTariff(vseGovoryat);
            velcom.addTariff(smart1);
            velcom.addTariff(paket1500);

            LOGGER.info("There are " + UserCount.Counter(velcom) + " of people uses " + velcom.getName());
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        }
    }
}
