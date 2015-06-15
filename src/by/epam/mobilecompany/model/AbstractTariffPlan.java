package by.epam.mobilecompany.model;

import by.epam.mobilecompany.exception.LogicalException;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.*;

/**
 * Created by aterehovich on 5/20/15.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tariff", propOrder = {
        "licencseFee", "peopleUsed", "name"
})

public abstract class AbstractTariffPlan implements Comparable<AbstractTariffPlan> {
    @XmlElement(required = true)
    private int licencseFee;
    @XmlElement(required = true)
    private int peopleUsed;
    @XmlID
    private String name;

    public AbstractTariffPlan(){}
    public AbstractTariffPlan(String name, int licencseFee, int peopleUsed) throws LogicalException {
        setName(name);
        setLicencseFee(licencseFee);
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

        if (licencseFee != that.licencseFee){
            return false;
        }

        return peopleUsed == that.peopleUsed;

    }

    @Override
    public int hashCode() {
        int result = licencseFee;
        result = 31 * result + peopleUsed;
        return result;
    }

    @Override
    public int compareTo(AbstractTariffPlan o) {
        if (o==null){
            return -1;
        }
        int result = this.getLicencseFee() - o.getLicencseFee();

        if (result != 0) {
            return result / Math.abs(result);
        }
        return 0;

    }

    @Override
    public String toString() {
        return "TariffPlan: " +
                "name=" + name +
                ", licencseFee=" + licencseFee +
                ", peopleUsed=" + peopleUsed;
    }
}
