package learn.solar.models;

public class Panel {
    private int panelId;
    private String section;
    private int row;
    private int column;
    private int year;
    private Material material;
    private boolean isTracking;
    public Panel() {

    }

    public Panel(int id, String section, int row, int column, int year, Material material, boolean isTracking) {
        this.panelId = id;
        this.section = section;
        this.row = row;
        this.column = column;
        this.year = year;
        this.material = material;
        this.isTracking = isTracking;
    }

    public int getPanelId() {
        return panelId;
    }

    public void setPanelId(int panelId) {
        this.panelId = panelId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public boolean isTracking() {
        return isTracking;
    }

    public void setTracking(boolean tracking) {
        isTracking = tracking;
    }
}
