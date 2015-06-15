package by.epam.mobilecompany.creator;

import by.epam.mobilecompany.creator.parser.DomParser;
import by.epam.mobilecompany.creator.parser.SaxParser;
import by.epam.mobilecompany.creator.parser.StaxParser;
import by.epam.mobilecompany.exception.LogicalException;
import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.MobileOperator;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by aterehovich on 11.6.15.
 */
public class XmlCreator {

    final static Logger LOGGER = Logger.getLogger(XmlCreator.class);

    public XmlCreator()  {
        System.out.println("DOM PARSER:");
        DomParser domParser = new DomParser();
        try {
            domParser.buildListTariffs("input/tariffs-ext.xml");
            MobileOperator operator = new MobileOperator("Velcom", domParser.getTariffPlans());
            for(AbstractTariffPlan tariffPlan : operator.getTariffPlans()){
                System.out.println(tariffPlan.toString());
            }
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        }
        System.out.println("\nSTAX PARSER");
        StaxParser staxParser = new StaxParser();
        try {
            staxParser.buildListStudents("input/tariffs-ext.xml");
            MobileOperator operator = new MobileOperator("Velcom", staxParser.getTariffs());
            for (AbstractTariffPlan tariffPlan: operator.getTariffPlans()){
                System.out.println(tariffPlan.toString());
            }
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        }

        System.out.println("\nSAX PARSER");
        SaxParser saxParser = new SaxParser();

        MobileOperator operator;
        try {
            saxParser.buildListTariffs("input/tariffs-ext.xml");
            operator = new MobileOperator("Velcom", saxParser.getTariffs());
            for (AbstractTariffPlan tariffPlan: operator.getTariffPlans()){
                System.out.println(tariffPlan.toString());
            }
        } catch (LogicalException e) {
            LOGGER.error("Can't create a Mobile Operator or one of tariff plans");
        }

    }
}
