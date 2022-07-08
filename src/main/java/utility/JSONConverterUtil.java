package utility;//package utility;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.databind.ser.FilterProvider;
//import com.fasterxml.jackson.databind.ser.PropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//import com.fasterxml.jackson.datatype.joda.JodaModule;
//
//import java.util.*;
//
//public class JSONConverterUtil {
//
//    public static final String FILTER = "Filter";
//
//    public static String objectToJsonWithoutNulls(Object object) {
//        return objectToJson(object, JsonInclude.Include.NON_NULL, null);
//    }
//
//    public static String objectToJsonWithNulls(Object object) {
//        return objectToJson(object, JsonInclude.Include.ALWAYS, null);
//    }
//
//    public static String objectToJsonWithoutNullsAndFilter(Object object, FilterProvider filterProvider) {
//        return objectToJson(object, JsonInclude.Include.NON_NULL, filterProvider);
//    }
//
//    public static String objectToJsonWithNullsAndFilter(Object object, FilterProvider filterProvider) {
//        return objectToJson(object, JsonInclude.Include.ALWAYS, filterProvider);
//    }
//
//    private static String objectToJson(Object object, JsonInclude.Include include, FilterProvider filterProvider) {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JodaModule());
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        try {
//            mapper.setSerializationInclusion(include);
//            if (filterProvider != null) {
//                mapper.setFilterProvider(filterProvider);
//            } else {
//                mapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
//            }
//            return mapper.writeValueAsString(object);
//        } catch (Exception ex) {
//            Log.error("Can't convert object to json due error: " + ex.getMessage());
//            return null;
//        }
//    }
//
//    public enum JsonFilterMode {
//        INCLUDE_FIELD_MODE, EXCLUDE_FIELD_MODE
//    }
//
//    public static FilterProvider getFilterProvider(Map<String, PropertyFilter> filters) {
//        if (filters == null || filters.isEmpty()) {
//            throw new IllegalArgumentException("You should pass at least one element");
//        }
//        SimpleFilterProvider filterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
//        filters.forEach(filterProvider::addFilter);
//        return filterProvider;
//    }
//
//    public static SimpleBeanPropertyFilter getIncludeFilter(final List<String> fields) {
//        return getFilter(JsonFilterMode.INCLUDE_FIELD_MODE, fields.toArray(new String[0]));
//    }
//
//    public static SimpleBeanPropertyFilter getIncludeFilter(final String... fields) {
//        return getFilter(JsonFilterMode.INCLUDE_FIELD_MODE, fields);
//    }
//
//    public static SimpleBeanPropertyFilter getExcludeFilter(final List<String> fields) {
//        return getFilter(JsonFilterMode.EXCLUDE_FIELD_MODE, fields.toArray(new String[0]));
//    }
//
//    public static SimpleBeanPropertyFilter getExcludeFilter(final String... fields) {
//        return getFilter(JsonFilterMode.EXCLUDE_FIELD_MODE, fields);
//    }
//
//    public static SimpleBeanPropertyFilter getFilter(final JsonFilterMode mode, final String... fields) {
//        if (fields == null || fields.length == 0) {
//            throw new IllegalArgumentException("You should pass at least one field");
//        }
//        return getFilter(mode, new HashSet<>(Arrays.asList(fields)));
//    }
//
//    public static SimpleBeanPropertyFilter getFilter(final JsonFilterMode mode, Set<String> fields) {
//        if (fields == null || fields.isEmpty()) {
//            throw new IllegalArgumentException("You should pass at least one filter");
//        }
//        return switch (mode) {
//            case EXCLUDE_FIELD_MODE -> SimpleBeanPropertyFilter.serializeAllExcept(fields);
//            case INCLUDE_FIELD_MODE -> SimpleBeanPropertyFilter.filterOutAllExcept(fields);
//            default -> null;
//        };
//    }
//}
