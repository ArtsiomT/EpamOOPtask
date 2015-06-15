package by.epam.mobilecompany.action;

import by.epam.mobilecompany.model.AbstractTariffPlan;
import by.epam.mobilecompany.model.TalkTariffPlan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aterehovich on 5/26/15.
 */
public class Search {


    public static List<AbstractTariffPlan> searchByFee(List<AbstractTariffPlan> tariffPlans, int maxFee){
        List<AbstractTariffPlan> filteredTariffPlans;

        filteredTariffPlans = tariffPlans
                .stream()
                .filter(tariffPlan -> tariffPlan.getLicencseFee()<maxFee)
                .collect(Collectors.toList());

        return filteredTariffPlans;
    }

    public static List<TalkTariffPlan> searchByMinuteCost(List<AbstractTariffPlan> tariffPlans, int maxCost){
        List<TalkTariffPlan> filteredTariffPlans;

        filteredTariffPlans = tariffPlans
                .stream()
                .filter(tariffPlan -> tariffPlan instanceof TalkTariffPlan)
                .map(tariffPlan -> (TalkTariffPlan)tariffPlan )
                .collect(Collectors.toList());

        filteredTariffPlans = filteredTariffPlans
                .stream()
                .filter(tariffPlan -> tariffPlan.getTalkCost()<maxCost)
                .collect(Collectors.toList());

        return filteredTariffPlans;
    }

    public static List<TalkTariffPlan> searchBySmsCost(List<AbstractTariffPlan> tariffPlans, int maxCost){
        List<TalkTariffPlan> filteredTariffPlans;


        filteredTariffPlans = tariffPlans
                .stream()
                .filter(tariffPlan -> tariffPlan instanceof TalkTariffPlan)
                .map(tariffPlan -> (TalkTariffPlan)tariffPlan )
                .collect(Collectors.toList());

        filteredTariffPlans = filteredTariffPlans
                .stream()
                .filter(talkTariffPlan -> talkTariffPlan.getSmsCost()<maxCost)
                .collect(Collectors.toList());

        return filteredTariffPlans;
    }

}
