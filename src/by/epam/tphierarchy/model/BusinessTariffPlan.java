package by.epam.tphierarchy.model;

import by.epam.tphierarchy.exception.LogicalException;

/**
 * Created by aterehovich on 5/20/15.
 */
public class BusinessTariffPlan extends TalkTariffPlan {
    private int freeTraffik;
    private int megabyteCost;

    public BusinessTariffPlan(String name, int licencseFee, int talkCost, int smsCost, int freeMinutes,int megabyteCost, int freeTraffik, int peopleUsed) throws LogicalException {
        super(name, licencseFee,talkCost,smsCost,freeTraffik,peopleUsed);
        setFreeTraffik(freeTraffik);
    }


    public int getFreeTraffik() {
        return freeTraffik;
    }


    public void setFreeTraffik(int freeTraffik) throws LogicalException {
        if(freeTraffik >0){
            this.freeTraffik = freeTraffik;
        } else {
            throw new LogicalException();
        }

    }

    public int getMegabyteCost() {
        return megabyteCost;
    }

    public void setMegabyteCost(int megabyteCost) throws LogicalException {
        if(megabyteCost>0){
            this.megabyteCost = megabyteCost;
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

        return freeTraffik == that.freeTraffik;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + freeTraffik;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "freeTraffik=" + freeTraffik;
    }
}
