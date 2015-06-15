package by.epam.mobilecompany.action;

import by.epam.mobilecompany.model.AbstractTariffPlan;

import java.util.Comparator;

/**
 * Created by aterehovich on 5/25/15.
 */
public class CompareTariff implements Comparator<AbstractTariffPlan> {


    @Override
    public int compare(AbstractTariffPlan o1, AbstractTariffPlan o2) {
        if (o1 == null || o2 == null){
            return -1;
        }

        int result = o1.getLicencseFee() - o2.getLicencseFee();
        if(result!=0){
            return result/Math.abs(result);
        }
        return 0;
    }
}
