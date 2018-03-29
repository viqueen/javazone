package org.viqueen.javazone;

public class EnhancedStrings {

    public static void main (final String... args) {

//        // multi line strings
//        final String poem = "
//                When you want to fill your code with beauty
//                But all these \\n and +s make it look ugly
//        ";
//        System.out.println(poem);

//        // string template
//        final String output = `No strings attached poem : ${poem}`;
//        System.out.println(output);

//        // string template with property selection
//        final User attendee = new User("Hasnae", "R.");
//        System.out.println(`Attendee Fullname : ${attendee.firstName} ${attendee.lastName}`);
    }


    public static class User {

        final String firstName;
        final String lastName;

        User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

    }
}
