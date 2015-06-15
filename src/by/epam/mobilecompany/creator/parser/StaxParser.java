package by.epam.mobilecompany.creator.parser;

import by.epam.mobilecompany.exception.LogicalException;
import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.BusinessTariffPlan;
import by.epam.mobilecompany.model.InternetTariffPlan;
import by.epam.mobilecompany.model.TalkTariffPlan;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aterehovich on 14.6.15.
 */
public class StaxParser {
    private List<AbstractTariffPlan> tariffs = new ArrayList<>();
    private XMLInputFactory inputFactory;

    public StaxParser(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<AbstractTariffPlan> getTariffs(){
        return tariffs;
    }

    public void buildListStudents(String fileName) throws LogicalException {
        FileInputStream inputStream;
        XMLStreamReader reader;
        String name;

        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            //StAX parsing
            while (reader.hasNext()){
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    switch (name){
                        case "talk-tariff":
                            AbstractTariffPlan talkTariff = buildTalkTariff(reader);
                            tariffs.add(talkTariff);
                            break;
                        case "internet-tariff":
                            AbstractTariffPlan interntetTariff = buildInternetTariff(reader);
                            tariffs.add(interntetTariff);
                            break;
                        case "business-tariff":
                            AbstractTariffPlan businessTariff = buildBusinessTariff(reader);
                            tariffs.add(businessTariff);
                            break;
                        default:
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private AbstractTariffPlan buildTalkTariff(XMLStreamReader reader) throws XMLStreamException, LogicalException{
        TalkTariffPlan tariffPlan = new TalkTariffPlan();
        tariffPlan.setName(reader.getAttributeValue(null, "name"));

        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "license-fee":
                            tariffPlan.setLicencseFee(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "people-used":
                            tariffPlan.setPeopleUsed(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "free-minutes":
                            tariffPlan.setFreeMinutes(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "talk-cost":
                            tariffPlan.setTalkCost(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "sms-cost":
                            tariffPlan.setSmsCost(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("talk-tariff")){
                        return tariffPlan;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Talk-Tariff");
    }

    private AbstractTariffPlan buildInternetTariff(XMLStreamReader reader) throws XMLStreamException, LogicalException{
        InternetTariffPlan tariffPlan = new InternetTariffPlan();
        tariffPlan.setName(reader.getAttributeValue(null, "name"));

        String name = "";
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "license-fee":
                            tariffPlan.setLicencseFee(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "people-used":
                            tariffPlan.setPeopleUsed(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "free-traffik":
                            tariffPlan.setFreeTraffik(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "megabyte-cost":
                            tariffPlan.setMegabyteCost(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("internet-tariff")){
                        return tariffPlan;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Internet-Tariff: " + name);
    }

    private AbstractTariffPlan buildBusinessTariff(XMLStreamReader reader) throws XMLStreamException, LogicalException{
        BusinessTariffPlan tariffPlan = new BusinessTariffPlan();
        tariffPlan.setName(reader.getAttributeValue(null, "name"));

        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "license-fee":
                            tariffPlan.setLicencseFee(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "people-used":
                            tariffPlan.setPeopleUsed(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "free-minutes":
                            tariffPlan.setFreeMinutes(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "talk-cost":
                            tariffPlan.setTalkCost(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "sms-cost":
                            tariffPlan.setSmsCost(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "free-traffik":
                            tariffPlan.setFreeTraffik(Integer.parseInt(getXMLText(reader)));
                            break;
                        case "megabyte-cost":
                            tariffPlan.setMegabyteCost(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if(name.equals("business-tariff")){
                        return tariffPlan;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Talk-Tariff");
    }

    private String getXMLText(XMLStreamReader reader)throws XMLStreamException{
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return  text;
    }
}
