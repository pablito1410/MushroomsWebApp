package pl.polsl.mushrooms.infrastructure.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pl.polsl.mushrooms.application.model.*;
import pl.polsl.mushrooms.infrastructure.dto.*;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by pawel_zaqkxkn on 10.07.2017.
 */
public class EntityMapperDefault implements EntityMapper {

    private final ModelMapper modelMapper;

    private static Map<Class<?>, Type> objectMapping = new HashMap<Class<?>, Type>() {
        {
            put(User.class, UserDto.class);
            put(Mushroomer.class, MushroomerDto.class);
            put(Trip.class, TripDto.class);
            put(Score.class, ScoreDto.class);
            put(Notification.class, NotificationDto.class);
            put(MushroomSpecies.class, MushroomSpeciesDto.class);
            put(Discovery.class, DiscoveryDto.class);
            put(Comment.class, CommentDto.class);
        }
    };

    private static Map<Type, Type> collectionMapping = new HashMap<Type, Type>() {
        {
            put(User.class, new TypeToken<HashSet<UserDto>>() {}.getType());
            put(Mushroomer.class, new TypeToken<HashSet<MushroomerDto>>() {}.getType());
            put(Trip.class, new TypeToken<HashSet<TripDto>>() {}.getType());
            put(Score.class, new TypeToken<HashSet<ScoreDto>>() {}.getType());
            put(Notification.class, new TypeToken<HashSet<NotificationDto>>() {}.getType());
            put(MushroomSpecies.class, new TypeToken<HashSet<MushroomSpeciesDto>>() {}.getType());
            put(Discovery.class, new TypeToken<HashSet<DiscoveryDto>>() {}.getType());
            put(Comment.class, new TypeToken<HashSet<CommentDto>>() {}.getType());
        }
    };

    private interface TripSet extends Set<Trip> { }

    public EntityMapperDefault(final ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    @Override
    public <T, R> Set<R> map(final Collection<T> set) {
        if (set.size() == 0) {
            return new HashSet();
        } else {
            final Class<?> genericType = set.iterator().next().getClass();
            final Type dtoType = collectionMapping.get(genericType);
            return modelMapper.map(set, dtoType);
        }
    }

    @Override
    public <R> R map(final Object obj) {
        final Class<?> genericType = obj.getClass();
        final Type dtoType = objectMapping.get(genericType);
        return modelMapper.map(obj,  dtoType);
    }

}
