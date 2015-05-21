package by.epam.tphierarchy.util;

import by.epam.tphierarchy.model.MobileOperator;
import by.epam.tphierarchy.model.TariffPlan;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aterehovich on 5/20/15.
 */
public class UserCount {

    public static int Counter(MobileOperator operator){
        ArrayList<TariffPlan> tariffPlans = operator.getTariffPlans();
        int count = 0;
        Iterator iterator = tariffPlans.iterator();
        for (int i = 0; i < tariffPlans.size()-1; i++){
            count+= tariffPlans.get(i).getPeopleUsed();
        }
        return count;
    }
}
