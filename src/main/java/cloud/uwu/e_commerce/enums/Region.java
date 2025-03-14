package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Region {
    EUROPE("Europe"),
    ASIA("Asia"),
    NORTH_AMERICA("North America");

    private final String regionName;

    Region(String regionName) {
        this.regionName = regionName;
    }

    @JsonValue
    public String getName() {
        return regionName;
    }

    @JsonCreator
    public static Region fromName(String regionName) {
        for (Region region : values()) {
            if (region.regionName.equalsIgnoreCase(regionName)) {
                return region;
            }
        }
        throw new IllegalArgumentException("Unknown region: " + regionName);
    }
}
