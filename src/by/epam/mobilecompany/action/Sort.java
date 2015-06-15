package by.epam.mobilecompany.action;

import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.MobileOperator;


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
