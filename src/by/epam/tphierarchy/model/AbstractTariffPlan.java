package by.epam.tphierarchy.model;

import org.apache.log4j.Logger;

/**
 * Created by aterehovich on 5/20/15.
 */


//TODO abstract class
public abstract class AbstractTariffPlan implements Comparable {
    private int licencseFee;
    private int talkCost;
    private int smsCost;
    private int peopleUsed;
    private String name;


    private static final Logger LOGGER = Logger.getLogger(AbstractTariffPlan.class);


    //test commit

    public AbstractTariffPlan(String name, int licencseFee, int talkCost, int smsCost, int peopleUsed) throws LogicalException {
        setName(name);
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
        if (talkCost > 0) {
            this.talkCost = talkCost;
        } else {
            throw new LogicalException();
        }
    }

    public int getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(int smsCost) throws LogicalException {
        if (smsCost > 0) {
            this.smsCost = smsCost;
        } else {
            throw new LogicalException();
        }
    }

    public int getPeopleUsed() {
        return peopleUsed;
    }

    public void setPeopleUsed(int peopleUsed) throws LogicalException {
        if (peopleUsed > 0) {
            this.peopleUsed = peopleUsed;
        } else {
            throw new LogicalException();
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractTariffPlan that = (AbstractTariffPlan) o;

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
    public int compareTo(Object o) {
        AbstractTariffPlan entry = (AbstractTariffPlan) o;

        int result = this.getLicencseFee() - ((AbstractTariffPlan) o).getLicencseFee();
        if (result != 0) {
            return result / Math.abs(result);
        }
        return 0;

    }

    @Override
    public String toString() {
        return "AbstractTariffPlan{" +
                "licencseFee=" + licencseFee +
                ", talkCost=" + talkCost +
                ", smsCost=" + smsCost +
                ", peopleUsed=" + peopleUsed +
                '}';
    }
}
