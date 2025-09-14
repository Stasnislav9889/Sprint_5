package utils;

import constants.AnimalGender;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public final class RandomGenerator {

    public static Stream<String> getRandomString() {
        return Stream.of("", "123456453", "+", "string", " ");
    }

    public static String getRandomGender(){
        List<String> listGender = List.of(AnimalGender.FEMALE.getGender(),
                AnimalGender.MALE.getGender());
        int number = new Random().nextInt(listGender.size());
        return listGender.get(number);
    }
}