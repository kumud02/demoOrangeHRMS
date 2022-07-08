package utility;//package io.carrier.abound.utility;
//
//import org.assertj.core.api.SoftAssertions;
//import org.joda.time.DateTime;
//import org.joda.time.format.DateTimeFormat;
//
//import java.util.List;
//
//
//public class AssertionUtils {
//    public static void assertTextInList(List<String> list, String text) {
//        assertThat(list).isNotEmpty().allMatch(e -> e.contains(text));
//    }
//
//    private static <SELF> org.assertj.core.api.AbstractFileAssert<SELF> assertThat(List<String> list) {
//    }
//
//    public static void assertTextInListIgnoreCase(List<String> list, String text) {
//        if (!list.isEmpty()) {
//            for (String listItem : list) {
//                assertThat(listItem).containsIgnoringCase(text);
//            }
//        }
//    }
//
//    public static void compareDateValues(SoftAssertions softAssert, String message, String dateFormat, DateTime expectedDate, String actualDateStr) {
//        try {
//            DateTime actualDate = DateTime.parse(actualDateStr, DateTimeFormat.forPattern(dateFormat));
//            softAssert.assertThat(actualDate)
//                    .as(message)
//                    .isBetween(expectedDate.minusMinutes(1), expectedDate.plusMinutes(1));
//        } catch (Exception e) {
//            softAssert.fail("Can't compare dates due the error: " + e + "\n Actual date: "
//                    + actualDateStr + "\nExpected date: " + expectedDate.toString());
//        }
//    }
//}
