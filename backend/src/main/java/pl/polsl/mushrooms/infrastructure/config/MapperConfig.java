package pl.polsl.mushrooms.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.model.*;
import pl.polsl.mushrooms.infrastructure.dto.*;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapper;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapperDefault;
import pl.polsl.mushrooms.infrastructure.mapper.EntityMapperRegistry;

import java.util.HashSet;

/**
 * Created by pawel_zaqkxkn on 12.07.2017.
 */
@Configuration
public class MapperConfig {

    @Bean
    public InitializingBean entityMapperInitializer(
            EntityMapperRegistry registry) {
        return () -> {
            registry.registerObject(User.class, UserDto.class);
            registry.registerObject(Mushroomer.class, MushroomerDto.class);
            registry.registerObject(Trip.class, TripDto.class);
            registry.registerObject(Score.class, ScoreDto.class);
            registry.registerObject(Notification.class, NotificationDto.class);
            registry.registerObject(MushroomSpecies.class, MushroomSpeciesDto.class);
            registry.registerObject(Discovery.class, DiscoveryDto.class);
            registry.registerObject(Comment.class, CommentDto.class);
            registry.registerObject(Tag.class, TagDto.class);

            registry.registerCollection(User.class, new TypeToken<HashSet<UserDto>>() {}.getType());
            registry.registerCollection(Mushroomer.class, new TypeToken<HashSet<MushroomerDto>>() {}.getType());
            registry.registerCollection(Trip.class, new TypeToken<HashSet<TripDto>>() {}.getType());
            registry.registerCollection(Score.class, new TypeToken<HashSet<ScoreDto>>() {}.getType());
            registry.registerCollection(Notification.class, new TypeToken<HashSet<NotificationDto>>() {}.getType());
            registry.registerCollection(MushroomSpecies.class, new TypeToken<HashSet<MushroomSpeciesDto>>() {}.getType());
            registry.registerCollection(Discovery.class, new TypeToken<HashSet<DiscoveryDto>>() {}.getType());
            registry.registerCollection(Comment.class, new TypeToken<HashSet<CommentDto>>() {}.getType());
            registry.registerCollection(Tag.class, new TypeToken<HashSet<TagDto>>() {}.getType());
        };
    }

    @Bean
    public EntityMapperRegistry entityMapperRegistry() {
        return new EntityMapperRegistry();
    }

    @Bean
    public EntityMapper entityMapper(final ModelMapper modelMapper, final EntityMapperRegistry registry) {
        return new EntityMapperDefault(modelMapper, registry);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
