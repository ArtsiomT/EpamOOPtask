package by.epam.tphierarchy.model;

import by.epam.tphierarchy.exception.LogicalException;

/**
 * Created by aterehovich on 5/20/15.
 */
public class InternetTariffPlan extends AbstractTariffPlan {
    private int freeTraffik;
    private int megabyteCost;

    public InternetTariffPlan(String name, int licencseFee, int megabyteCost, int freeTraffik, int peopleUsed) throws LogicalException {
        super(name,licencseFee,peopleUsed);
        setFreeTraffik(freeTraffik);
        setMegabyteCost(megabyteCost);
    }

    public int getFreeTraffik() {
        return freeTraffik;
    }

    public void setFreeTraffik(int freeTraffik) throws LogicalException {
        if (freeTraffik>0){
            this.freeTraffik = freeTraffik;
        } else {
            throw new LogicalException();
        }
    }

    public int getMegabyteCost() {
        return megabyteCost;
    }

    public void setMegabyteCost(int megabyteCost) {
        this.megabyteCost = megabyteCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        InternetTariffPlan that = (InternetTariffPlan) o;

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
        return super.toString()  +
                ", freeTraffik=" + freeTraffik;
    }
}
