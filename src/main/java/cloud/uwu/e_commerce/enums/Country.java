package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Country {
    ALBANIA("Albania"),
    ANDORRA("Andorra"),
    AUSTRIA("Austria"),
    BELARUS("Belarus"),
    BELGIUM("Belgium"),
    BOSNIA_AND_HERZEGOVINA("Bosnia and Herzegovina"),
    BULGARIA("Bulgaria"),
    CROATIA("Croatia"),
    CYPRUS("Cyprus"),
    CZECH_REPUBLIC("Czech Republic"),
    DENMARK("Denmark"),
    ESTONIA("Estonia"),
    FINLAND("Finland"),
    FRANCE("France"),
    GERMANY("Germany"),
    GREECE("Greece"),
    HUNGARY("Hungary"),
    ICELAND("Iceland"),
    IRELAND("Ireland"),
    ITALY("Italy"),
    LATVIA("Latvia"),
    LIECHTENSTEIN("Liechtenstein"),
    LITHUANIA("Lithuania"),
    LUXEMBOURG("Luxembourg"),
    MALTA("Malta"),
    MOLDOVA("Moldova"),
    MONACO("Monaco"),
    MONTENEGRO("Montenegro"),
    NETHERLANDS("Netherlands"),
    NORTH_MACEDONIA("North Macedonia"),
    NORWAY("Norway"),
    POLAND("Poland"),
    PORTUGAL("Portugal"),
    ROMANIA("Romania"),
    SAN_MARINO("San Marino"),
    SERBIA("Serbia"),
    SLOVAKIA("Slovakia"),
    SLOVENIA("Slovenia"),
    SPAIN("Spain"),
    SWEDEN("Sweden"),
    SWITZERLAND("Switzerland"),
    UKRAINE("Ukraine"),
    UNITED_KINGDOM("United Kingdom"),
    VATICAN_CITY("Vatican City"),
    CANADA("Canada"),
    MEXICO("Mexico"),
    UNITED_STATES("United States");

    private final String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }

    @JsonValue
    public String getName() {
        return countryName;
    }

    @JsonCreator
    public static Country fromName(String countryName) {
        for (Country country : values()) {
            if (country.countryName.equalsIgnoreCase(countryName)) {
                return country;
            }
        }
        throw new IllegalArgumentException("Unknown country: " + countryName);
    }
}
