package org.viqueen.javazone;

import org.junit.Test;

import java.util.Map;

import static java.lang.String.format;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class EnhancedMapsTest {

    /**
     * Exercise 1: introducing a javascript like dictionary definition
     * Map empty = {};
     *
     * Hints :
     * - we need to identify the syntax, LBRACE RBRACE
     * - and convert it to an equivalent statement : Map.ofEntries()
     * - this statement is essentially a variable initialization expression
     * - have a look around {@code com.sun.tools.javac.parser.JavacParser} to see if anything sparks up ideas.
     * - ok fine, it's similar to an array initialization.
     * - so basically you need to modify the variable init method to take into account the "type" being initialized
     * - also {@code com.sun.tools.javac.tree.TreeMaker} is where you create equivalent statements
     */
    @Test
    public void testEmptyMapDefinition() {
        final Map empty  = {};
        assertThat(empty.size(), is(0));
    }

    /**
     * Exercise 2: introducing a single entry map with a String key value pair ... baby steps
     * Map singleton = {
     *     "key": "value"
     * }
     *
     * Hints:
     * - now we need to identify a key value entry syntax :  LBRACE
     *      STRINGLITERAL COLON STRINGLITERAL
     *   RBRACE
     * - you can use token.kind and peekToken to determine if you have a valid syntax, or else you should fail the
     * compilation with an "illegal" error statement
     * - you have a utility method "illegal" you can use for that matter.
     * - you may use {@code com.sun.tools.javac.util.Pair} to hold the key value literals you are parsing
     */
    @Test
    public void testSingletonMapDefinition () {
        final Map singleton = {
              "name": "Hasnae R"
        };
        assertThat(singleton.size(), is(1));
    }

    /**
     * Exercise 3: introducing a multi entry map with String key value pairs
     * Map data = {
     *     "keyOne": "valueOne",
     *     "keyTwo": "valueTwo"
     * };
     *
     * Hints:
     * - now we need to identify the following syntax: LBRACE
     *          (
     *              STRINGLITERAL COLON STRINGLITERAL
     *              COMMA ? (optional)
     *          ) +
     *      RBRACE
     *
     * - we need to modify our map entry parsing to consume entries as long as we did not hit a right brace
     * - in the TreeMaker we now have to construct a new Map, for simplicity purposes let us use a HashMap impl.
     * - for every entry we parsed we should invoke the HashMap#put method
     * - in a way we need to replicate the following java syntax :
     *      Map data = new HashMap()
     *      for (Pair entry : entries) {
     *          data.put(entry.first, entry.second);
     *      }
     *
     *      OR
     *
     *      Map data = new HashMap() {
     *          {
     *              this.put(entry.first, entry.second);
     *          }
     *      }
     * - let's attempt the second syntax as it is essentially just one statement
     * - have a look around AnonymousClassDef
     * - if you feel like a good citizen, let's ensure our new map syntax is actually immutable
     *     java.util.Collections.unmodifiableMap(theNewMap)
     */
    @Test
    public void testMultiEntryMapDefinition () {
        final Map data = {
                "name": "Hasnae R.",
                "age": "mind your own business FFS",
                "city": "Sydney"
        };
        assertThat(data.size(), is(3));
    }

    /**
     * Exercise 4.1: introducing a multi entry type bound map with (String, String) key value pairs
     * Map<String, String> data = {
     *     "keyOne": "valueOne",
     *     "keyTwo": "valueTwo"
     * };
     *
     * Hints:
     * - the way we identify if it is a map initialization is not comprehensive
     * - we need to test if type parameters apply.
     * - if you need to debug/log you may use the following
     *
     * log.rawWarning(
     *    token.pos,
     *    String.format(
     *      "type : %s, class : %s",
     *      type, type != null ? type.getClass() : "oops"
     *    )
     * );
     *
     *
     */
    @Test
    public void testTypeBoundMapDefinition_1 () {
        // Strings for simplicity
        final Map<String, String> capitals = {
                "Norway" : "Oslo",
                "Australia" : "Canberra"
        };
        assertThat(capitals.size(), is(2));
        assertThat(capitals, allOf(
                hasEntry("Norway", "Oslo"),
                hasEntry("Australia", "Canberra")
        ));
    }

    /**
     * Exercise 4.2: introducing a multi entry type bound map with (String,Primitive) key value pairs
     * Map<String, Boolean> data = {
     *     "keyOne": true,
     *     "keyTwo": false
     * };
     *
     * Hints:
     * - now we need to identify the following syntax: LBRACE
     *                (
     *                    STRINGLITERAL COLON EXPRESSION
     *                    COMMA ? (optional)
     *                ) +
     *            RBRACE
     *
     * - you may rely on the method "parseExpression" available to you in JavacParser
     */
    @Test
    public void testTypeBoundMapDefinition_2 () {
        // please something other than strings
        final Map<String, Boolean> supported  = {
                "strings" : true,
                "boolean" : true,
                "anytype" : false
        };
        assertThat(supported.size(), is(3));
        assertThat(supported, allOf(
                hasEntry("strings", true),
                hasEntry("boolean", true),
                hasEntry("anytype", false)
        ));
    }


    /**
     * Exercise 4.3: introducing a multi entry type bound map with (String, OBJECT_TYPE) key value pairs
     *
     * Hints:
     * - this should work out of the box with the work done on 4.2
     * - should it fail, holler at me with intrigued looks and questions
     */
    @Test
    public void testTypeBoundMapDefinition_3 () {
        final Map<String, Joke> jokes = {
            "sql": new Joke("a query walks into a bar and joins two tables"),
            "computers": new Joke("before computers, a mouse pad was where a mouse lived"),
            "hardware": new Joke("aircon and laptops are both useless ... when you open windows")
        };
        assertThat(jokes.size(), is(3));
        assertThat(jokes.keySet(), hasItems("sql", "computers", "hardware"));
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
