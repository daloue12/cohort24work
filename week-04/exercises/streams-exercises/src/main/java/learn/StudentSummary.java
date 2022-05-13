package learn;

public class StudentSummary {
    private String country;
    private String major;
    private double iq;

    public StudentSummary(String country, String major, double iq) {
        this.country = country;
        this.major = major;
        this.iq = iq;
    }

    public String getCountry() {
        return country;
    }

    public String getMajor() {
        return major;
    }

    public double getIq() {
        return iq;
    }

    @Override
    public String toString() {
        return "StudentSummary{" +
                "country='" + country + '\'' +
                ", major='" + major + '\'' +
                ", iq=" + iq +
                '}';
    }
}
