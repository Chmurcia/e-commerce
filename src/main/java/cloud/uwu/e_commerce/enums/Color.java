package cloud.uwu.e_commerce.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Color {
    BLACK("Black"),
    WHITE("White"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    PINK("Pink"),
    BROWN("Brown"),
    GRAY("Gray"),
    CYAN("Cyan"),
    MAGENTA("Magenta"),
    LIME("Lime"),
    TEAL("Teal"),
    OLIVE("Olive"),
    MAROON("Maroon"),
    NAVY("Navy"),
    INDIGO("Indigo"),
    TURQUOISE("Turquoise"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    LIGHT_GRAY("Light Gray"),
    DARK_GRAY("Dark Gray"),
    PASTEL_PINK("Pastel Pink"),
    PASTEL_BLUE("Pastel Blue"),
    PASTEL_GREEN("Pastel Green"),
    PASTEL_YELLOW("Pastel Yellow"),
    PASTEL_ORANGE("Pastel Orange");

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }
}
