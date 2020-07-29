package com.tandem.message.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Tuple;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomObjectMapper {

    public static List<Map<String, Object>> convertToMap(List<Object[]> input, Map<Integer, String> mappings) {
        List<Map<String, Object>> returnValue = new ArrayList<>();
        for (Object[] val : input) {
            int i = 0;
            Map<String, Object> temp = new HashMap<>();
            for (Object innerVal : val) {
                if (mappings.containsKey(i)) {
                    temp.put(mappings.get(i), innerVal);
                }
                i++;
            }
            returnValue.add(temp);
        }
        return returnValue;
    }

    public static <U> List<U> convertToEntity(List<Tuple> input, Class<U> dtoClass) {
        List<U> arrayList = new ArrayList<>();
        input.forEach(tuple -> {
            Map<String, Object> temp = new HashMap<>();

            tuple.getElements().
                    forEach(tupleElement ->
                            temp.put(tupleElement.getAlias().toLowerCase(),
                                    tuple.get(tupleElement.getAlias())));
            ObjectMapper map = new ObjectMapper();

            map.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
                //converting to json
                String mapToString = map.writeValueAsString(temp);
                //converting json to entity
                arrayList.add(map.readValue(mapToString, dtoClass));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        return arrayList;
    }
}
