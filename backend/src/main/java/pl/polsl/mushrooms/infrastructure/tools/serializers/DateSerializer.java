package pl.polsl.mushrooms.infrastructure.tools.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator jgen,
                         SerializerProvider provider) throws IOException {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String dateString = dateFormat.format(value);
        jgen.writeString(dateString);
    }
}
