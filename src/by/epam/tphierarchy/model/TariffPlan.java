package by.epam.tphierarchy.model;

import by.epam.tphierarchy.model.exceptions.LogicalException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class TariffPlan {
    private int licencseFee;
    private int talkCost;
    private int smsCost;
    private int peopleUsed;

    private static final Logger LOGGER = Logger.getLogger(TariffPlan.class);

    static {
        new DOMConfigurator().doConfigure("config/log4j.xm", LogManager.getLoggerRepository());
    }

    //test commit

    public TariffPlan(int licencseFee, int talkCost, int smsCost, int peopleUsed) throws LogicalException {
        setLicencseFee(licencseFee);
        setTalkCost(talkCost);
        setSmsCost(smsCost);
        setPeopleUsed(peopleUsed);
    }

    public int getLicencseFee() {
        return licencseFee;
    }

    public void setLicencseFee(int licencseFee) throws LogicalException {
        if (licencseFee > 0) {
            this.licencseFee = licencseFee;
        } else {
            throw new LogicalException();
        }
    }

    public int getTalkCost() {
        return talkCost;
    }

    public void setTalkCost(int talkCost) throws LogicalException {
        if (talkCost > 0){
            this.talkCost = talkCost;
        } else {
            throw new LogicalException();
        }
    }

    public int getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(int smsCost) throws LogicalException {
        if (smsCost > 0){
            this.smsCost = smsCost;
        } else {
            throw new LogicalException();
        }
    }

    public int getPeopleUsed() {
        return peopleUsed;
    }

    public void setPeopleUsed(int peopleUsed) throws LogicalException {
        if (peopleUsed > 0){
            this.peopleUsed = peopleUsed;
        } else {
            throw new LogicalException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TariffPlan that = (TariffPlan) o;

        if (licencseFee != that.licencseFee) return false;
        if (talkCost != that.talkCost) return false;
        if (smsCost != that.smsCost) return false;
        return peopleUsed == that.peopleUsed;

    }

    @Override
    public int hashCode() {
        int result = licencseFee;
        result = 31 * result + talkCost;
        result = 31 * result + smsCost;
        result = 31 * result + peopleUsed;
        return result;
    }

    @Override
    public String toString() {
        return "TariffPlan{" +
                "licencseFee=" + licencseFee +
                ", talkCost=" + talkCost +
                ", smsCost=" + smsCost +
                ", peopleUsed=" + peopleUsed +
                '}';
    }
}
