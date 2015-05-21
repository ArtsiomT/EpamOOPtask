package by.epam.tphierarchy.model;

import by.epam.tphierarchy.model.exceptions.LogicalException;

import java.util.ArrayList;

/**
 * Created by aterehovich on 5/20/15.
 */
public class MobileOperator {

    private String name;

    ArrayList<TariffPlan> tariffPlans;

    public MobileOperator(String name) throws LogicalException {
        setName(name);
        tariffPlans = new ArrayList<TariffPlan>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws LogicalException {
        if (!name.equals("") && !name.equals(null)){
            this.name = name;
        } else {
            throw new LogicalException();
        }
    }

    public void addTariff(TariffPlan tariffPlan){
        tariffPlans.add(tariffPlan);
    }

    public ArrayList<TariffPlan> getTariffPlans() {
        return tariffPlans;
    }
}
