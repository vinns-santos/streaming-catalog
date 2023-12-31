package tech.ada.pw2.streaming.titles.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum CountryEnum {
    AE("AE"),
    AF("AF"),
    AL("AL"),
    AO("AO"),
    AR("AR"),
    AT("AT"),
    AU("AU"),
    BD("BD"),
    BE("BE"),
    BF("BF"),
    BG("BG"),
    BR("BR"),
    BS("BS"),
    BT("BT"),
    BY("BY"),
    CA("CA"),
    CD("CD"),
    CH("CH"),
    CL("CL"),
    CM("CM"),
    CN("CN"),
    CO("CO"),
    CU("CU"),
    CY("CY"),
    CZ("CZ"),
    DE("DE"),
    DK("DK"),
    DZ("DZ"),
    EG("EG"),
    ES("ES"),
    FI("FI"),
    FO("FO"),
    FR("FR"),
    GB("GB"),
    GE("GE"),
    GH("GH"),
    GL("GL"),
    GR("GR"),
    GT("GT"),
    HK("HK"),
    HR("HR"),
    HU("HU"),
    ID("ID"),
    IE("IE"),
    IL("IL"),
    IN("IN"),
    IO("IO"),
    IQ("IQ"),
    IR("IR"),
    IS("IS"),
    IT("IT"),
    JO("JO"),
    JP("JP"),
    KE("KE"),
    KG("KG"),
    KH("KH"),
    KN("KN"),
    KR("KR"),
    KW("KW"),
    LB("LB"),
    LEBANON("Lebanon"),
    LK("LK"),
    LT("LT"),
    LU("LU"),
    MA("MA"),
    MC("MC"),
    MT("MT"),
    MU("MU"),
    MW("MW"),
    MX("MX"),
    MY("MY"),
    NA("NA"),
    NG("NG"),
    NL("NL"),
    NO("NO"),
    NP("NP"),
    NZ("NZ"),
    PE("PE"),
    PH("PH"),
    PK("PK"),
    PL("PL"),
    PR("PR"),
    PS("PS"),
    PT("PT"),
    PY("PY"),
    QA("QA"),
    RO("RO"),
    RS("RS"),
    RU("RU"),
    SA("SA"),
    SE("SE"),
    SG("SG"),
    SN("SN"),
    SU("SU"),
    SY("SY"),
    TH("TH"),
    TN("TN"),
    TR("TR"),
    TW("TW"),
    TZ("TZ"),
    UA("UA"),
    US("US"),
    UY("UY"),
    VA("VA"),
    VE("VE"),
    VN("VN"),
    XX("XX"),
    ZA("ZA"),
    ZW("ZW"),
    UNDEFINED("");

    private static final Map<String, CountryEnum> BY_LABEL = new HashMap<>();

    static {
        for (CountryEnum e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    private String label;

    CountryEnum(String label) {
        this.label = label;
    }

    public static CountryEnum valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
