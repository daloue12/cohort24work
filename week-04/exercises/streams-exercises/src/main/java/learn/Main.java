package learn;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
        for (Student student : students) {
            System.out.println(student);
        }

        // stream solution
        students.stream().forEach(System.out::println);

        // 1. Print students from Argentina
        /*Stream<Student> allStudents = ds.all().stream();
        Stream<Student> allStudentsFromArgentina = allStudents.filter(student -> student.getCountry().equalsIgnoreCase("Argentina"));
        allStudentsFromArgentina.forEach(System.out::println);*/

        // 2. Print students whose last names starts with 'T'.
        /*Stream<Student> allStudents = ds.all().stream();
        Stream<Student> allStudentsWithLastNameStartsWithT = allStudents.filter(student -> student.getLastName().startsWith("T"));
        allStudentsWithLastNameStartsWithT.forEach(System.out::println);*/

        // 3. Print students from Argentina, ordered by GPA
        /*      students.stream()
                .filter(student -> student.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa))
                .forEach(System.out::println);*/

        // 4. Print the bottom 10% (100 students) ranked by GPA.
        /*students.stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .limit(100)
                .forEach(System.out::println);*/

        // 5. Print the 4th - 6th ranked students by GPA from Argentina
        /* students.stream()
                .filter(student -> student.getCountry().equalsIgnoreCase("Argentina"))
                .sorted(Comparator.comparing(Student::getGpa))
                .skip(3)
                .limit(3)
                .forEach(System.out::println);*/

        // 6. Is anyone from Maldives?
        /*students.stream()
                .filter(student -> student.getCountry().equalsIgnoreCase("Maldives"))
                .forEach(System.out::println);*/


        // 7. Does everyone have a non-null, non-empty email address?
        /*students.stream()
                .filter(student -> student.getEmailAddress() != null || student.getEmailAddress() != "")
                .forEach(System.out::println);*/

        // 8. Print students who are currently registered for 5 courses.
        /*students.stream()
                .filter(student -> student.getRegistrations().size() == 5)
                .forEach(System.out::println);*/

        // 9. Print students who are registered for the course "Literary Genres".
        /*students.stream()
                .filter(student -> student.getRegistrations().stream()
                        .anyMatch(registration -> registration.getCourse().equalsIgnoreCase("Literary Genres")))
                .forEach(System.out::println);*/

        // 10. Who has the latest birthday? Who is the youngest?
        /*students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate).reversed())
                .limit(1)
                .forEach(System.out::println);

        students.stream()
                .sorted(Comparator.comparing(Student::getBirthDate))
                .limit(1)
                .forEach(System.out::println);*/

        // 11. Who has the highest GPA? There may be a tie.
        /*students.get(500).setGpa(new BigDecimal("4.0"));
        BigDecimal studentsWithTheHighestGPA = students.stream()
                .map(Student::getGpa)
                .sorted(Comparator.<BigDecimal>naturalOrder().reversed())
                .findFirst().orElse(BigDecimal.ZERO);
        students.stream()
                .filter(student -> student.getGpa().setScale(2).equals(studentsWithTheHighestGPA.setScale(2)))
                .forEach(System.out::println);*/

        // 12. Print every course students are registered for, including repeats.
        /*students.stream()
                .flatMap(student -> student.getRegistrations().stream())
                .forEach(System.out::println);*/

        // 13. Print a distinct list of courses students are registered for.
        /*students.stream()
                .flatMap(student -> student.getRegistrations().stream().map(Registration::getCourse))
                .distinct()
                .forEach(System.out::println);*/

        // 14. Print a distinct list of courses students are registered for, ordered by name.
        /*students.stream()
                .flatMap(student -> student.getRegistrations().stream().map(Registration::getCourse))
                .distinct().sorted()
                .forEach(System.out::println);*/

        // 15. Count students per country.
        /*Map<String, Long> studentsByCountry = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));

        for (Map.Entry<String, Long> entrySet : studentsByCountry.entrySet()) {
            System.out.printf("%s: %s%n", entrySet.getKey(), entrySet.getValue());
        }*/

        // 16. Count students per country. Order by most to fewest students.
        /*Map<String, Long> studentsByCountry = students.stream()
                .collect(Collectors.groupingBy(Student::getCountry, Collectors.counting()));

        for (Map.Entry<String, Long> entrySet : studentsByCountry.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toList())) {
            System.out.printf("%s: %s%n", entrySet.getKey(), entrySet.getValue());
        }*/

        // 17. Count registrations per course.
        /*Map<String, Long> registrationsByCourse = students.stream()
                .flatMap(student -> student.getRegistrations().stream())
                .collect(Collectors.groupingBy(Registration :: getCourse, Collectors.counting()));
                for (Map.Entry entry : registrationsByCourse.entrySet()) {
                    System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
                }*/

        // 18. How many registrations are not graded (GradeType == AUDIT)?
        /*List<Registration> auditedRegistrations = students.stream()
                .flatMap(student -> student.getRegistrations().stream())
                .filter(registration -> registration.getGradType() == GradeType.AUDIT)
                .collect(Collectors.toList());

        System.out.println(auditedRegistrations.size());*/

        // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).

        // 20. What is the average GPA per country (remember, it's random fictional data).

        // 21. What is the maximum GPA per country?

        // 22. Print average IQ per Major ordered by IQ ascending.

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
    }
}