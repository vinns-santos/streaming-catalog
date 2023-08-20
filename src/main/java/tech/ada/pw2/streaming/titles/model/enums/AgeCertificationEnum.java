package tech.ada.pw2.streaming.titles.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum AgeCertificationEnum {
    G("G"),
    NC_17("NC-17"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    TV_14("TV-14"),
    TV_G("TV-G"),
    TV_MA("TV-MA"),
    TV_PG("TV-PG"),
    TV_Y("TV-Y"),
    TV_Y7("TV-Y7"),
    UNDEFINED("");

    private static final Map<String, AgeCertificationEnum> BY_LABEL = new HashMap<>();

    static {
        for (AgeCertificationEnum e: values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    private String label;

    AgeCertificationEnum(String label) {
        this.label = label;
    }

    public static AgeCertificationEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
