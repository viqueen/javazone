package org.viqueen.javazone;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class EnhancedStringsTest {

    /**
     * Exercise 1: support multi line strings
     * " blah
     *   blah
     *   blah
     * "
     *
     * Hints:
     * - Strings are referred to as STRINGLITERAL
     * - you may poke around {@code com.sun.tools.javac.parser.TokenKind} to see the usages of STRINGLITERAL
     * - fine, you will have to look at how tokens are read in {@code com.sun.tools.javac.parser.JavaTokenizer}
     * - this is a one line change to continue parsing STRINGLITERAL despite encountering CR LF line break chars
     */
    @Test
    public void testMultiLineStrings() {
//        final String poem = "
//                When you want to fill your code with beauty
//                But all these \\n and +s make it look ugly
//        ";
//        assertThat(poem, allOf(
//                containsString("beauty\n"),
//                containsString("ugly\n")
//        ));
    }

    /**
     * Exercise 2: support string templates
     *
     * Hints:
     */
    @Test
    public void testStringTemplates() {
//        final String poem = "
//            POEM
//        ";
//        final String output = `No strings attached poem : ${poem}`;
//        assertThat(output, allOf(
//                startsWith("No strings attached poem :"),
//                containsString("POEM\n"),
//        ));
    }

    /**
     * Exercise 3: support string templates with nested properties
     *
     * Hints:
     */
    @Test
    public void testStringTemplatesWithNestedProperties() {
//        final User author = new User("Hasnae", "R.");
//        final String output = `Author Fullname : ${author.firstName} ${author.lastName}`;
//        assertThat(output, is("Author Fullname : Hasnae R."));
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
