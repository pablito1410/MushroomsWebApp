package pl.polsl.mushrooms.infrastructure.tools.deserializers;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by pawel_zaqkxkn on 22.05.2017.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final ObjectCodec codec = jsonParser.getCodec();
        final TextNode node = codec.readTree(jsonParser);
        final String dateString = node.textValue();
        final LocalDateTime dateTime = LocalDateTime.parse(dateString.substring(0, dateString.length() - 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return dateTime;
    }
}
