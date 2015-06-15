package by.epam.mobilecompany.creator.parser;

import by.epam.mobilecompany.exception.LogicalException;
import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.BusinessTariffPlan;
import by.epam.mobilecompany.model.InternetTariffPlan;
import by.epam.mobilecompany.model.TalkTariffPlan;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aterehovich on 11.6.15.
 */
public class DomParser {
    private List<AbstractTariffPlan> tariffPlans;
    private DocumentBuilder docBuilder;

    private static final Logger LOGGER = Logger.getLogger(DomParser.class);

    public DomParser(){
        this.tariffPlans = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.error("Error of parser configuration");
        }
    }

    public List<AbstractTariffPlan> getTariffPlans(){
        List<AbstractTariffPlan> cloned = new ArrayList<>(tariffPlans);
        return cloned;
    }

    public void buildListTariffs(String fileName) throws LogicalException {
        Document document;
        try {
            document = docBuilder.parse(fileName);
            Element rootElement = document.getDocumentElement();
            NodeList talkList = rootElement.getElementsByTagName("talk-tariff");
            for (int i = 0; i < talkList.getLength(); i++){
                Element talkTariffElement = (Element) talkList.item(i);
                AbstractTariffPlan talkTariffPlan = buildTalkTariff(talkTariffElement);
                tariffPlans.add(talkTariffPlan);
            }
            NodeList internetList = rootElement.getElementsByTagName("internet-tariff");
            for (int i = 0; i < internetList.getLength(); i++){
                Element internetTariffElement = (Element) internetList.item(i);
                AbstractTariffPlan internetTariffPlan = buildInternetTariff(internetTariffElement);
                tariffPlans.add(internetTariffPlan);
            }
            NodeList businessList = rootElement.getElementsByTagName("business-tariff");
            for (int i = 0; i < businessList.getLength(); i++){
                Element businessTariffElement = (Element) businessList.item(i);
                AbstractTariffPlan businessTariffPlan = buildBusinessTariff(businessTariffElement);
                tariffPlans.add(businessTariffPlan);
            }
        } catch (SAXException e) {
            LOGGER.error("Error of file parsing");
        } catch (IOException e) {
            LOGGER.error("Error of file reading");
        }
    }

    private AbstractTariffPlan buildTalkTariff(Element talkTariffElement) throws LogicalException {
        AbstractTariffPlan talkTariffPlan;
        String name = talkTariffElement.getAttribute("name");
        int licenseFee = Integer.parseInt(getElementTextContent(talkTariffElement, "license-fee"));
        int peopleUsed = Integer.parseInt(getElementTextContent(talkTariffElement, "people-used"));
        int freeMinutes = Integer.parseInt(getElementTextContent(talkTariffElement, "free-minutes"));
        int talkCost = Integer.parseInt(getElementTextContent(talkTariffElement, "talk-cost"));
        int smsCost = Integer.parseInt(getElementTextContent(talkTariffElement, "sms-cost"));
        talkTariffPlan = new TalkTariffPlan(name,licenseFee,talkCost,smsCost,freeMinutes,peopleUsed);
        return talkTariffPlan;
    }
    private AbstractTariffPlan buildInternetTariff(Element internetTariffElement) throws LogicalException {
        AbstractTariffPlan internetTariffPlan;
        String name =  internetTariffElement.getAttribute("name");
        int licenseFee = Integer.parseInt(getElementTextContent( internetTariffElement, "license-fee"));
        int peopleUsed = Integer.parseInt(getElementTextContent( internetTariffElement, "people-used"));
        int freeTraffik = Integer.parseInt(getElementTextContent( internetTariffElement, "free-traffik"));
        int megabyteCost = Integer.parseInt(getElementTextContent( internetTariffElement, "megabyte-cost"));
        internetTariffPlan = new InternetTariffPlan(name,licenseFee,megabyteCost,freeTraffik,peopleUsed);
        return internetTariffPlan;
    }
    private AbstractTariffPlan buildBusinessTariff(Element businessTariffElement) throws LogicalException {
        AbstractTariffPlan businessTariffPlan;
        String name = businessTariffElement.getAttribute("name");
        int licenseFee = Integer.parseInt(getElementTextContent(businessTariffElement, "license-fee"));
        int peopleUsed = Integer.parseInt(getElementTextContent(businessTariffElement, "people-used"));
        int freeMinutes = Integer.parseInt(getElementTextContent(businessTariffElement, "free-minutes"));
        int talkCost = Integer.parseInt(getElementTextContent(businessTariffElement, "talk-cost"));
        int smsCost = Integer.parseInt(getElementTextContent(businessTariffElement, "sms-cost"));
        int freeTraffik = Integer.parseInt(getElementTextContent( businessTariffElement, "free-traffik"));
        int megabyteCost = Integer.parseInt(getElementTextContent( businessTariffElement, "megabyte-cost"));
        businessTariffPlan = new BusinessTariffPlan(name,licenseFee,talkCost,smsCost,freeMinutes,megabyteCost,freeTraffik,peopleUsed);
        return businessTariffPlan;
    }
    private static String getElementTextContent(Element element, String elementName){
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }



}
