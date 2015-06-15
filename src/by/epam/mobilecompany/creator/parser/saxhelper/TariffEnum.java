package by.epam.mobilecompany.creator.parser.saxhelper;

/**
 * Created by aterehovich on 11.6.15.
 */
public enum TariffEnum {
    TARIFFS("tariffs"),
    TARIFF("tariff"),
    NAME("name"),
    LICENSE_FEE("license-fee"),
    PEOPLE_USED("people-used"),
    TALK_COST("talk-cost"),
    FREE_MINUTES("free-minutes"),
    SMS_COST("sms-cost"),
    FREE_TRAFFIK("free-traffik"),
    MEGABYTE_COST("megabyte-cost");

    private String value;
    private TariffEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
