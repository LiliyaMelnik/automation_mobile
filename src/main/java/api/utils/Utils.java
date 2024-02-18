package api.utils;

import com.google.gson.Gson;

public class Utils {

    private Utils() {
        throw new IllegalArgumentException("This is utility class");
    }

    public static <T> String toJson(T object) {
        return new Gson().toJson(object);
    }

}
