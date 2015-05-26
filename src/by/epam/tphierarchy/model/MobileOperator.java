package by.epam.tphierarchy.model;

import by.epam.tphierarchy.exception.LogicalException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by aterehovich on 5/20/15.
 */
public class MobileOperator {

    private String name;
    private ArrayList<AbstractTariffPlan> tariffPlans = new ArrayList<>();

    public MobileOperator(String name) throws LogicalException {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws LogicalException {
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new LogicalException();
        }
    }

    public void addTariff(AbstractTariffPlan abstractTariffPlan){
        tariffPlans.add(abstractTariffPlan);
    }

    public List<AbstractTariffPlan> getTariffPlans() {
        return Collections.unmodifiableList(tariffPlans);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileOperator that = (MobileOperator) o;

        if (!name.equals(that.name)) return false;
        return !(tariffPlans != null ? !tariffPlans.equals(that.tariffPlans) : that.tariffPlans != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (tariffPlans != null ? tariffPlans.hashCode() : 0);
        return result;
    }
}
