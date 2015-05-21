package by.epam.tphierarchy.model;

import by.epam.tphierarchy.model.exceptions.LogicalException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class TalkTariffPlan extends TariffPlan {

    private int freeMinutes;

    public TalkTariffPlan(int licencseFee, int talkCost, int smsCost, int freeMinutes, int peopleUsed) throws LogicalException {
        super(licencseFee,talkCost,smsCost, peopleUsed);
        this.freeMinutes = freeMinutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TalkTariffPlan that = (TalkTariffPlan) o;

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
        return super.toString() + "TalkTariffPlan{" +
                "freeMinutes=" + freeMinutes +
                '}';
    }
}
