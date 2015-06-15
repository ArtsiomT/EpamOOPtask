package by.epam.mobilecompany.creator.parser.saxhelper;

import by.epam.mobilecompany.exception.LogicalException;
import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.BusinessTariffPlan;
import by.epam.mobilecompany.model.InternetTariffPlan;
import by.epam.mobilecompany.model.TalkTariffPlan;
import org.apache.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by aterehovich on 11.6.15.
 */
public class TariffHandler extends DefaultHandler{
    private List<AbstractTariffPlan> tariffPlans;
    private AbstractTariffPlan current = null;
    private TariffEnum currentEnum = null;
    private EnumSet<TariffEnum> withText;
    private String currentTariffType = null;
    private static final Logger LOGGER = Logger.getLogger(TariffHandler.class);
    public TariffHandler(){
        tariffPlans = new ArrayList<>();
        withText = EnumSet.range(TariffEnum.NAME, TariffEnum.MEGABYTE_COST);
    }

    public List<AbstractTariffPlan> getTariffPlans(){
        return tariffPlans;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs){
        String name;
        switch (localName){
            case "talk-tariff":
                name = attrs.getValue(0);
                currentTariffType = localName;
                current = new TalkTariffPlan();
                current.setName(name);
                break;
            case "internet-tariff":
                name = attrs.getValue(0);
                currentTariffType = localName;
                current = new InternetTariffPlan();
                current.setName(name);
                break;
            case "business-tariff":
                name = attrs.getValue(0);
                currentTariffType = localName;
                current = new BusinessTariffPlan();
                current.setName(name);
                break;
            default:
                TariffEnum temp = TariffEnum.valueOf(localName.toUpperCase().replace('-', '_'));
                if(withText.contains(temp)){
                    currentEnum = temp;
                }
        }
    }

    public void endElement(String uri, String localName, String qName){
        if(("talk-tariff".equals(localName))||("internet-tariff".equals(localName))||("business-tariff".equals(localName))){
            tariffPlans.add(current);
        }
    }

    public void characters(char[] ch, int start, int length){
        String s = new String(ch, start, length).trim();
        if (currentEnum != null && !s.isEmpty()) {
            switch (currentTariffType) {
                case "talk-tariff":
                    switch (currentEnum) {
                        case LICENSE_FEE:
                            try {
                                current.setLicencseFee(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case PEOPLE_USED:
                            try {
                                current.setPeopleUsed(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case FREE_MINUTES:
                                ((TalkTariffPlan) current).setFreeMinutes(Integer.parseInt(s));
                            break;
                        case TALK_COST:
                            try {
                                ((TalkTariffPlan)current).setTalkCost(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case SMS_COST:
                            try {
                                ((TalkTariffPlan)current).setSmsCost(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                    }
                    break;
                case "internet-tariff":
                    switch (currentEnum){
                        case NAME:
                            current.setName(s);
                            break;
                        case LICENSE_FEE:
                            try {
                                current.setLicencseFee(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case PEOPLE_USED:
                            try {
                                current.setPeopleUsed(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case FREE_TRAFFIK:
                            try {
                                ((InternetTariffPlan)current).setFreeTraffik(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case MEGABYTE_COST:
                            ((InternetTariffPlan)current).setMegabyteCost(Integer.parseInt(s));
                            break;
                    }
                    break;
                case "business-tariff":
                    switch (currentEnum){
                        case NAME:
                            current.setName(s);
                            break;
                        case LICENSE_FEE:
                            try {
                                current.setLicencseFee(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case PEOPLE_USED:
                            try {
                                current.setPeopleUsed(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case FREE_MINUTES:
                            ((BusinessTariffPlan) current).setFreeMinutes(Integer.parseInt(s));
                            break;
                        case TALK_COST:
                            try {
                                ((BusinessTariffPlan)current).setTalkCost(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case SMS_COST:
                            try {
                                ((BusinessTariffPlan)current).setSmsCost(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case FREE_TRAFFIK:
                            try {
                                ((BusinessTariffPlan)current).setFreeTraffik(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }
                            break;
                        case MEGABYTE_COST:

                            try {
                                ((BusinessTariffPlan)current).setMegabyteCost(Integer.parseInt(s));
                            } catch (LogicalException e) {
                                LOGGER.error("Error with set parameter");
                            }

                            break;
                    }
                    break;
            }
        }
    }
}
