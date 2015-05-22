package by.epam.tphierarchy.run;

import by.epam.tphierarchy.creator.Creator;
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
        new Creator();
    }
}
