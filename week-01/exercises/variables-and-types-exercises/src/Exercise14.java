public class Exercise14 {
    public static void main(String[] args) {
        int gradeLevel = 3;
        boolean isSenior = false;
        boolean isInterestedInVolunteering = false;
        boolean shouldSendVolunteerInfo = isSenior == true && isInterestedInVolunteering == true;
        System.out.print(shouldSendVolunteerInfo);
    }
}
