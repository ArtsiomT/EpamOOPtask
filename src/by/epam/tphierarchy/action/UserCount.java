package by.epam.tphierarchy.action;

import by.epam.tphierarchy.model.MobileOperator;
import by.epam.tphierarchy.model.AbstractTariffPlan;

import java.util.List;

/**
 * Created by aterehovich on 5/20/15.
 */
public class UserCount {

    public static int Counter(MobileOperator operator){
        List<AbstractTariffPlan> abstractTariffPlans = operator.getTariffPlans();
        int count = 0;
        for (int i = 0; i < abstractTariffPlans.size()-1; i++){
            count+= abstractTariffPlans.get(i).getPeopleUsed();
        }
        return count;
    }
}
