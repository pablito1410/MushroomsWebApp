//package pl.polsl.mushrooms.application.services;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
//import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
//import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
//import pl.polsl.mushrooms.application.enums.UserRole;
//import pl.polsl.mushrooms.application.exceptions.EntityAlreadyExistException;
//import pl.polsl.mushrooms.application.exceptions.NoRequiredPermissions;
//import pl.polsl.mushrooms.application.model.Admin;
//import pl.polsl.mushrooms.application.model.Mushroomer;
//import pl.polsl.mushrooms.application.model.User;
//import pl.polsl.mushrooms.infrastructure.repositories.UserRepository;
//import javax.persistence.EntityNotFoundException;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // TODO usunąć i resetować bazę przed każdą metodą
//public class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    private BCryptPasswordEncoder encoder;
//
//
//    @Before
//    public void setUp() throws Exception {
//        encoder = new BCryptPasswordEncoder();
//    }
//
//    @Test
//    public void createUserCommandHandle() throws Exception {
//
//        // Create user
//        final CreateUserCommand command = UserServiceTestUtil.createUserCommand(
//                "user@email.com",
//                "username"
//        );
//        final long id = userService.handle(command);
//
//        final User user = userRepository.findOne(id);
//        Assert.assertEquals(user.getRole(), UserRole.MUSHROOMER);
//        final Mushroomer mushroomer = (Mushroomer)user;
//        Assert.assertEquals(mushroomer.getUsername(), command.getUsername());
//        Assert.assertEquals(mushroomer.getEmail(), command.getEmail());
//        Assert.assertTrue(encoder.matches(command.getPassword(), mushroomer.getPassword()));
//        Assert.assertEquals(mushroomer.getFirstName(), command.getFirstName());
//        Assert.assertEquals(mushroomer.getLastName(), command.getLastName());
//        Assert.assertTrue(mushroomer.getBirthDate().toInstant().equals(command.getBirthDate().toInstant()));
//        Assert.assertEquals(mushroomer.getGender(), command.getGender());
//    }
//
//    @Test(expected = EntityAlreadyExistException.class)
//    public void createUserDuplicateEmail() {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "user@email.com",
//                "userA"
//        );
//        userService.handle(userA);
//
//        final CreateUserCommand userB = UserServiceTestUtil.createUserCommand(
//                "user@email.com",
//                "userB"
//        );
//        userService.handle(userB);
//    }
//
//    @Test(expected = EntityAlreadyExistException.class)
//    public void createUserDuplicateUserName() {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "userA@email.com",
//                "userA"
//        );
//        userService.handle(userA);
//
//        final CreateUserCommand userB = UserServiceTestUtil.createUserCommand(
//                "userB@email.com",
//                "userA"
//        );
//        userService.handle(userB);
//    }
//
//    @Test
//    public void updateUserCommandHandle() throws Exception {
//
//        // Create user
//        final CreateUserCommand createUserCommand =
//                UserServiceTestUtil.createUserCommand("user2@email.com", "username2");
//        final long id = userService.handle(createUserCommand);
//
//        // Update user
//        final UpdateUserCommand updateUserCommand =
//                UserServiceTestUtil.updateUserCommand(createUserCommand.getUsername());
//        userService.handle(updateUserCommand);
//
//        final User user = userRepository.findOne(id);
//        Assert.assertEquals(user.getRole(), UserRole.MUSHROOMER);
//        final Mushroomer mushroomer = (Mushroomer)user;
//        Assert.assertEquals(mushroomer.getEmail(), updateUserCommand.getEmail());
//        Assert.assertEquals(mushroomer.getFirstName(), updateUserCommand.getFirstName());
//        Assert.assertEquals(mushroomer.getLastName(), updateUserCommand.getLastName());
//        Assert.assertTrue(mushroomer.getBirthDate().toInstant().equals(updateUserCommand.getBirthDate().toInstant()));
//        Assert.assertEquals(mushroomer.getGender(), updateUserCommand.getGender());
//        Assert.assertEquals(mushroomer.getCity(), updateUserCommand.getCity());
//        Assert.assertEquals(mushroomer.getCountry(), updateUserCommand.getCountry());
//    }
//
//    @Test(expected = EntityNotFoundException.class)
//    public void updateNotExistingUser() {
//        final UpdateUserCommand updateUserCommand =
//                UserServiceTestUtil.updateUserCommand("notExistingUserName");
//        userService.handle(updateUserCommand);
//    }
//
//    @Test
//    public void deleteUsersCommandHandle() throws Exception {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "userA@email.com",
//                "userA"
//        );
//
//        final CreateUserCommand userB = UserServiceTestUtil.createUserCommand(
//                "userB@email.com",
//                "userB"
//        );
//
//        final CreateUserCommand userC = UserServiceTestUtil.createUserCommand(
//                "userC@email.com",
//                "userC"
//        );
//
//        final long userAId = userService.handle(userA);
//        final long userBId = userService.handle(userB);
//        final long userCId = userService.handle(userC);
//
//        final User admin = new Admin("admin", "admin@email.com", "admin1");
//        userRepository.save(admin);
//
//        final DeleteUsersCommand deleteUsersCommand = UserServiceTestUtil.deleteUsersCommand(
//                admin.getUsername(),
//                admin.getPassword(),
//                userAId,
//                userBId,
//                userCId
//        );
//        userService.handle(deleteUsersCommand);
//
//        Assert.assertNull(userRepository.findOne(userAId));
//        Assert.assertNull(userRepository.findOne(userBId));
//        Assert.assertNull(userRepository.findOne(userCId));
//    }
//
//    @Test(expected = NoRequiredPermissions.class)
//    public void deleteUsersWrongAdminPassword() {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "userA@email.com",
//                "userA"
//        );
//        final long userAId = userService.handle(userA);
//
//        final User admin = new Admin("admin", "admin@email.com", "admin1");
//        userRepository.save(admin);
//
//        final DeleteUsersCommand deleteUsersCommand = UserServiceTestUtil.deleteUsersCommand(
//                admin.getUsername(),
//                "wrongPassword",
//                userAId
//        );
//        userService.handle(deleteUsersCommand);
//    }
//
//    @Test(expected = NoRequiredPermissions.class)
//    public void deleteUsersNoAdminRole() {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "userA@email.com",
//                "userA"
//        );
//        final long userAId = userService.handle(userA);
//
//        final CreateUserCommand userB = UserServiceTestUtil.createUserCommand(
//                "userB@email.com",
//                "userB"
//        );
//        final long userBId = userService.handle(userB);
//
//        final DeleteUsersCommand deleteUsersCommand = UserServiceTestUtil.deleteUsersCommand(
//                userB.getUsername(),
//                userB.getPassword(),
//                userAId
//        );
//        userService.handle(deleteUsersCommand);
//    }
//
//    @Test
//    public void getUserByEmail() throws Exception {
//        final CreateUserCommand userA = UserServiceTestUtil.createUserCommand(
//                "userA@email.com",
//                "userA"
//        );
//        userService.handle(userA);
//
//        final User user = userService.getUserByEmail(userA.getEmail())
//                .orElseThrow(EntityNotFoundException::new);
//
//        Assert.assertEquals(user.getRole(), UserRole.MUSHROOMER);
//        final Mushroomer mushroomer = (Mushroomer)user;
//        Assert.assertEquals(mushroomer.getEmail(), userA.getEmail());
//        Assert.assertEquals(mushroomer.getFirstName(), userA.getFirstName());
//        Assert.assertEquals(mushroomer.getLastName(), userA.getLastName());
//        Assert.assertTrue(mushroomer.getBirthDate().toInstant().equals(userA.getBirthDate().toInstant()));
//        Assert.assertEquals(mushroomer.getGender(), userA.getGender());
//    }
//
//    @Test
//    public void updateProfileImageHandle() throws Exception {
//
//    }
//
//}