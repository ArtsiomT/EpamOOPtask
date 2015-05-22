package by.epam.tphierarchy.model;

import java.util.ArrayList;

/**
 * Created by aterehovich on 5/20/15.
 */
public class MobileOperator {

    private String name;
    private ArrayList<AbstractTariffPlan> abstractTariffPlans;

    public MobileOperator(String name) throws LogicalException {
        setName(name);
        abstractTariffPlans = new ArrayList<>();
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
        abstractTariffPlans.add(abstractTariffPlan);
    }

    public ArrayList<AbstractTariffPlan> getAbstractTariffPlans() {
        return abstractTariffPlans;
    }
}
