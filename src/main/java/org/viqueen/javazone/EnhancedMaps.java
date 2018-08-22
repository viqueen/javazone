package org.viqueen.javazone;

import java.util.Map;

import static java.lang.String.format;

public class EnhancedMaps {



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
