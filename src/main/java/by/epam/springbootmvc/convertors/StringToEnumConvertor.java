package by.epam.springbootmvc.convertors;

import by.epam.springbootmvc.beans.Gender;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConvertor implements Converter<String, Gender> {

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public Gender convert(String source) {
        if (source.equals("Male")) {
            return Gender.MALE;
        } else if (source.equals("Female")) {
            return Gender.FEMALE;
        } else {
            return Gender.OTHER;
        }
    }
}
