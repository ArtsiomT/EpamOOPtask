package by.epam.mobilecompany.run;

import by.epam.mobilecompany.creator.Creator;
import by.epam.mobilecompany.creator.XmlCreator;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class Runner {


    static {
        new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        new XmlCreator();
    }
}
