public class Balloon {

    private String color;
    private double psi;

    public Balloon(String color, double psi) {
        this.color = color;
        this.psi = psi;
    }

    public String getColor() {
        return color;
    }

    public double getPsi() {
        if (this.psi > 16.0) {
            return Double.POSITIVE_INFINITY;
        } else {
            return psi;
        }
    }

    public void inflate() {
        this.psi = this.psi + Math.random() * 5;
    }

    public boolean isExploded() {
        if (this.psi > 16.0) {
            return true;
        } else {
            return false;
        }
    }
}
