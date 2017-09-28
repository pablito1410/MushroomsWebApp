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


@Configuration
public class MapperConfig {

    @Bean
    public InitializingBean entityMapperInitializer(
            EntityMapperRegistry registry) {
        return () -> {
            registry.registerObject(User.class, UserDto.class);
            registry.registerObject(Admin.class, MushroomerDto.class);
            registry.registerObject(Mushroomer.class, MushroomerDto.class);
            registry.registerObject(Trip.class, TripDto.class);
            registry.registerObject(Score.class, ScoreDto.class);
            registry.registerObject(Notification.class, NotificationDto.class);
            registry.registerObject(Discovery.class, DiscoveryDto.class);
            registry.registerObject(Comment.class, CommentDto.class);
            registry.registerObject(Tag.class, TagDto.class);
            registry.registerObject(MushroomClass.class, MushroomClassDto.class);
            registry.registerObject(MushroomOrder.class, MushroomOrderDto.class);
            registry.registerObject(MushroomFamily.class, MushroomFamilyDto.class);
            registry.registerObject(MushroomGenus.class, MushroomGenusDto.class);
            registry.registerObject(MushroomSpecies.class, MushroomSpeciesDto.class);
            registry.registerObject(UsersTrips.class, UsersTripsDto.class);

            registry.registerCollection(User.class, new TypeToken<HashSet<UserDto>>() {}.getType());
            registry.registerCollection(Mushroomer.class, new TypeToken<HashSet<MushroomerDto>>() {}.getType());
            registry.registerCollection(Trip.class, new TypeToken<HashSet<TripDto>>() {}.getType());
            registry.registerCollection(Score.class, new TypeToken<HashSet<ScoreDto>>() {}.getType());
            registry.registerCollection(Notification.class, new TypeToken<HashSet<NotificationDto>>() {}.getType());
            registry.registerCollection(Discovery.class, new TypeToken<HashSet<DiscoveryDto>>() {}.getType());
            registry.registerCollection(Comment.class, new TypeToken<HashSet<CommentDto>>() {}.getType());
            registry.registerCollection(Tag.class, new TypeToken<HashSet<TagDto>>() {}.getType());
            registry.registerCollection(MushroomClass.class, new TypeToken<HashSet<MushroomClassDto>>() {}.getType());
            registry.registerCollection(MushroomOrder.class, new TypeToken<HashSet<MushroomOrderDto>>() {}.getType());
            registry.registerCollection(MushroomFamily.class, new TypeToken<HashSet<MushroomFamilyDto>>() {}.getType());
            registry.registerCollection(MushroomGenus.class, new TypeToken<HashSet<MushroomGenusDto>>() {}.getType());
            registry.registerCollection(MushroomSpecies.class, new TypeToken<HashSet<MushroomSpeciesDto>>() {}.getType());
            registry.registerCollection(UsersTrips.class, new TypeToken<HashSet<UsersTripsDto>>() {}.getType());
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
