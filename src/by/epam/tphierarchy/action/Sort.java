package by.epam.tphierarchy.action;

import by.epam.tphierarchy.model.AbstractTariffPlan;
import by.epam.tphierarchy.model.MobileOperator;


import java.util.*;

/**
 * Created by aterehovich on 5/26/15.
 */
public class Sort{


    public static List<AbstractTariffPlan> sortByFee(MobileOperator operator){
        List<AbstractTariffPlan> sortedList = new ArrayList<>();
        Iterator<AbstractTariffPlan> iterator = operator.getTariffPlans().iterator();
        while (iterator.hasNext()){
            sortedList.add(iterator.next());
        }
        Collections.sort(sortedList, new CompareTariff());
        return sortedList;
    }


}
