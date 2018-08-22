package org.viqueen.javazone;

import java.util.Map;

import static java.lang.String.format;

public class EnhancedMaps {
    /**
     * Exercise 1: introducing a javascript like dictionary definition
     * Map empty = {};
     *
     * Hints :
     * - we need to identify the syntax, and convert it to an equivalent statement : Collections.emptyMap()
     * - this statement is essentially a variable initialization expression
     * - have a look around {@code com.sun.tools.javac.parser.JavacParser} to see if anything sparks up ideas.
     * - ok fine, it's similar to an array initialization.
     * - so basically you need to modify the variable init method to take into account the "type" being initialized
     * - also {@code com.sun.tools.javac.tree.TreeMaker} is where you create equivalent statements
     */
    private static void emptyMapDefinition () {
//        final Map empty  = {};
//        System.out.println(format("empty map : %s", empty));
    }

    /**
     * Exercise 2: introducing a single entry map with a String key value pair ... baby steps
     * Map singleton = {
     *     "key": "value"
     * }
     *
     * Hints:
     * - now we need to identify a key value entry syntax ( keyStringLiteral colon valueStringLiteral )
     * - you can use token.kind and peekToken to determine if you have a valid syntax, or else you should fail the
     * compilation with an "illegal" error statement
     * - you may use {@code com.sun.tools.javac.util.Pair} to hold the key value literals you are parsing
     */
    private static void singletonMapDefinition () {
//        final Map singleton = {
//              "name": "Hasnae R"
//        };
//        System.out.println(format("singleton map : %s", singleton));
    }

    /**
     * Exercise 3: introducing a multi entry map with String key value pairs
     */
    private static void multiEntryMapDefinition () {
//        final Map data = {
//                "name": "Hasnae R.",
//                "age": "mind your own business FFS",
//                "city": "Sydney",
//        };
//        System.out.println(format("all the relevant info : %s", data));
    }

    /**
     * Exercise 4.1: introducing a multi entry type bound map with (String, String) key value pairs
     */
    private static void typeBoundMapDefinition_1 () {
        // Strings for simplicity
//        final Map<String, String> capitals = {
//                "Norway" : "Oslo",
//                "Australia" : "Canberra"
//        };
//        System.out.println(format("some capitals : %s", capitals));
    }

    /**
     * Exercise 4.2: introducing a multi entry type bound map with (String,Primitive) key value pairs
     */
    private static void typeBoundMapDefinition_2 () {
        // please something other than strings
//        final Map<String, Boolean> supported  = {
//                "strings" : true,
//                "boolean" : true,
//                "anytype" : false
//        };
//        System.out.println(format("are booleans supported ? : %s", supported));
    }

    /**
     * Exercise 4.3: introducing a multi entry type bound map with (String, OBJECT_TYPE) key value pairs
     */
    private static void typeBoundMapDefinition_3 () {
//        final Map<String, Joke> jokes = {
//            "sql": new Joke("a query walks into a bar and joins two tables"),
//            "computers": new Joke("before computers, a mouse pad was where a mouse lived"),
//        };
//        System.out.println(format("jokes : %s", jokes));
    }

    public static void main (String... args) {
        emptyMapDefinition();
        singletonMapDefinition();
        multiEntryMapDefinition();
        typeBoundMapDefinition_1();
        typeBoundMapDefinition_2();
        typeBoundMapDefinition_3();
    }

    @SuppressWarnings("unused")
    public static class Joke {
        private final String notFunny;

        Joke(final String notFunny) {
            this.notFunny = notFunny;
        }

        @Override
        public String toString() {
            return format("terrible joke : %s", notFunny);
        }
    }

}
