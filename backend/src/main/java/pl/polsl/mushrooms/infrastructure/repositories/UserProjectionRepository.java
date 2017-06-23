//package pl.polsl.mushrooms.infrastructure.repositories;
//
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.jdbc.core.JdbcTemplate;
//import pl.polsl.mushrooms.application.dao.ProjectionDao;
//import pl.polsl.mushrooms.application.dao.UserProjectionDao;
//import pl.polsl.mushrooms.application.model.Admin;
//import pl.polsl.mushrooms.application.model.Mushroomer;
//import pl.polsl.mushrooms.application.model.User;
//import pl.polsl.mushrooms.infrastructure.dto.AdminDto;
//import pl.polsl.mushrooms.infrastructure.dto.MushroomerDto;
//import pl.polsl.mushrooms.infrastructure.dto.UserDto;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.*;
//
///**
// * Created by pawel_zaqkxkn on 26.04.2017.
// */
//
//public class UserProjectionRepository {
//
//    private JdbcTemplate jdbcTemplate;
//    private final UserRepository userRepository;
//    private final ModelMapper modelMapper = new ModelMapper();
//
//    private Map<UserProjectionDao.Projection, String> projections = new HashMap<>();
//    {
//        projections.put(UserProjectionDao.Projection.BASIC, " USERNAME, EMAIL");
//        projections.put(
//                UserProjectionDao.Projection.FULL,
//                " U.USER_ID::varchar as        \"id\", " +
//                " U.USERNAME as       \"username\"," +
//                " U.FIRST_NAME as     \"firstName\"," +
//                " U.LAST_NAME as      \"lastName\"," +
//                " U.EMAIL as          \"email\"," +
//                " U.BIRTH_DATE as     \"birthDate\"," +
//                " U.GENDER as         \"gender\"," +
//                " U.ROLE as           \"role\"," +
//                " U.LEVEL as          \"level\"," +
//                " U.PHOTO as          \"photo\"");
//    };
//
//    public UserProjectionRepository(final JdbcTemplate jdbcTemplate, final UserRepository userRepository) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userRepository = userRepository;
//    }
//
//    public UserDto findOne(long id, ProjectionDao.Projection projection) {
//        final Optional<User> user = Optional.of(userRepository.findOne(id));
//        if (user.isPresent()) {
//            return mapUserToDto(user.get());
//        }
//        return null;
//    }
//
//    public UserDto findOneByUsername(String username, ProjectionDao.Projection projection) {
//        final Optional<User> user = Optional.of(userRepository.findOneByUsername(username));
//        if (user.isPresent()) {
//            return mapUserToDto(user.get());
//        }
//        return null;
//    }
//
//    public long getId(String username) {
//        final User user = Optional.of(
//                userRepository.findOneByUsername(username))
//                    .orElseThrow(EntityNotFoundException::new);
//
//        return user.getId();
//    }
//
//    public Set<MushroomerDto> findAll(long id, ProjectionDao.Projection projection) {
//        final User user = Optional.of(
//                userRepository.findOne(id))
//                    .orElseThrow(EntityNotFoundException::new);
//
//        switch(user.getRole()) {
//            case MUSHROOMER:
//                final Set<Mushroomer> friends = ((Mushroomer)user).getFriends();
//                return modelMapper.map(friends, new TypeToken<HashSet<MushroomerDto>>() {}.getType());
//
//            case ADMIN:
//                throw new UnsupportedOperationException(String.format("User type %s has no friends.", user.getRole()));
//
//                default:
//                    throw new RuntimeException(String.format("Unhandled switch exception - %s", user.getRole()));
//        }
//    }
//
//
//    public List<Map<String,Object>> search(String value, ProjectionDao.Projection projection) {
//
//        List<Map<String, Object>> users = jdbcTemplate.queryForList(
//                "SELECT " + projections.get(projection)
//                        + " FROM USERS U\n"
//                        + " WHERE "
//                        + " U.USERNAME LIKE ?"
//                        + " OR U.FIRST_NAME LIKE ?",
//                "%" + value + "%", "%" + value + "%");
//
//        return users;
//    }
//
//    private UserDto mapUserToDto(final User user) {
//        Objects.requireNonNull(user);
//
//        if (user instanceof Mushroomer) {
//            return modelMapper.map((Mushroomer)user, MushroomerDto.class);
//        } else if (user instanceof Admin) {
//            return modelMapper.map((Admin)user, AdminDto.class);
//        } else {
//            throw new IllegalStateException("Unknown instanceof User class - " + user.getClass());
//        }
//    }
//}
