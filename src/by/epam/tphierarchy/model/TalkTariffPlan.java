package by.epam.tphierarchy.model;

import by.epam.tphierarchy.exception.LogicalException;

/**
 * Created by aterehovich on 5/20/15.
 */
public class TalkTariffPlan extends AbstractTariffPlan {

    private int freeMinutes;
    private int talkCost;
    private int smsCost;

    public TalkTariffPlan(String name, int licencseFee, int talkCost, int smsCost, int freeMinutes, int peopleUsed) throws LogicalException {
        super(name, licencseFee, peopleUsed);
        setFreeTraffik(freeMinutes);
        setTalkCost(talkCost);
        setSmsCost(smsCost);
    }

    public int getFreeTraffik() {
        return freeMinutes;
    }

    public void setFreeTraffik(int freeMinutes) throws LogicalException {
        if (freeMinutes>0) {
            this.freeMinutes = freeMinutes;
        } else {
            throw new LogicalException();
        }
    }

    public int getTalkCost() {
        return talkCost;
    }

    public void setTalkCost(int talkCost) throws LogicalException {
        if (talkCost>0){
            this.talkCost = talkCost;
        } else {
            throw new LogicalException();
        }
    }

    public int getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(int smsCost) throws LogicalException {
        if (smsCost>0){
            this.smsCost = smsCost;
        } else {
            throw new LogicalException();
        }
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
        return super.toString()  +
                ", talkCost=" + talkCost +
                ", smsCost=" + smsCost+
                ", freeMinutes=" + freeMinutes;
    }
}
