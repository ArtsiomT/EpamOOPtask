package by.epam.tphierarchy.model;

import by.epam.tphierarchy.model.exceptions.LogicalException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class BusinessTariffPlan extends InternetTariffPlan{
    private int freeMinutes;

    public BusinessTariffPlan(int licencseFee, int talkCost, int smsCost, int freeMinutes, int freeTraffik,  int peopleUsed) throws LogicalException {
        super(licencseFee,talkCost,smsCost,freeTraffik,peopleUsed);
        setFreeMinutes(freeMinutes);
    }


    public int getFreeMinutes() {
        return freeMinutes;
    }


    public void setFreeMinutes(int freeMinutes) throws LogicalException {
        if(freeMinutes>0){
            this.freeMinutes = freeMinutes;
        } else {
            throw new LogicalException();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BusinessTariffPlan that = (BusinessTariffPlan) o;

        return freeMinutes == that.freeMinutes;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + freeMinutes;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "BusinessTariffPlan{" +
                "freeMinutes=" + freeMinutes +
                '}';
    }
}
