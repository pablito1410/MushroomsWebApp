package pl.polsl.mushrooms.infrastructure.controllers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pawel_zaqkxkn on 27.06.2017.
 */
public class DateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen,
                         SerializerProvider provider) throws IOException,
            JsonProcessingException {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String dateString = dateFormat.format(value);
        jgen.writeString(dateString);
    }
}
