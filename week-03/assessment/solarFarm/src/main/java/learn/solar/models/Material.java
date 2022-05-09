package learn.solar.models;

public enum Material {
    MULTICRYSTALLINE_SILICON("MUS"),
    MONOCRYSTALLINE_SILICON("MOS"),
    AMORPHOUS_SILICON("AS"),
    CADMIUM_TELLURIDE("CT"),
    COPPER_INDIUM_GALLIUM_SELENIDE("CIGS");

    private final String abbreviation;

    Material(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
}
