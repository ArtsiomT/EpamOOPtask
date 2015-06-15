package by.epam.mobilecompany.creator.parser;

import by.epam.mobilecompany.creator.parser.saxhelper.TariffHandler;
import by.epam.mobilecompany.model.AbstractTariffPlan;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by aterehovich on 11.6.15.
 */
public class SaxParser {

    private List<AbstractTariffPlan> tariffs;
    private TariffHandler th;
    private XMLReader reader;

    public SaxParser(){
        th = new TariffHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(th);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public List<AbstractTariffPlan> getTariffs(){
        return tariffs;
    }

    public void buildListTariffs(String fileName){
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tariffs = th.getTariffPlans();
    }
}
