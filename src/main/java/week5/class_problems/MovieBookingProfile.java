package week5.class_problems;

class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    boolean isConfirmed() {
        return confirmed;
    }

    void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    void setOtp(String otp) {
        this.otp = "HASH:" + otp.hashCode();
    }
}

public class MovieBookingProfileDemo {
    public static void main(String[] args) {
        System.out.println(new MovieBookingProfile("Rahul Dev").getName());

        MovieBookingProfile p = new MovieBookingProfile("Rahul Dev");
        p.setConfirmed(true);
        System.out.println(p.isConfirmed());

        p.setOtp("4471");
    }
}