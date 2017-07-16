package pl.polsl.mushrooms.infrastructure.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.commands.discovery.AddScoreToDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.CreateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.friend.AcceptInvitationToFriendsCommand;
import pl.polsl.mushrooms.application.commands.friend.AddFriendCommand;
import pl.polsl.mushrooms.application.commands.friend.DeleteFriendsCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.CreateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.DeleteMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.clazz.UpdateMushroomClassCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.CreateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.DeleteMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.genus.UpdateMushroomGenusCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.CreateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.DeleteMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.order.UpdateMushroomOrderCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.CreateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.DeleteMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.mushroom.species.UpdateMushroomSpeciesCommand;
import pl.polsl.mushrooms.application.commands.notification.DeleteNotificationCommand;
import pl.polsl.mushrooms.application.commands.score.AddScoreCommand;
import pl.polsl.mushrooms.application.commands.score.DeleteScoreCommand;
import pl.polsl.mushrooms.application.commands.score.UpdateScoreCommand;
import pl.polsl.mushrooms.application.commands.trip.*;
import pl.polsl.mushrooms.application.commands.user.CreateUserCommand;
import pl.polsl.mushrooms.application.commands.user.DeleteUsersCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateProfileImageCommand;
import pl.polsl.mushrooms.application.commands.user.UpdateUserCommand;
import pl.polsl.mushrooms.application.services.*;
import pl.polsl.mushrooms.infrastructure.commands.CommandHandlerRegistry;

/**
 * Created by pawel_zaqkxkn on 12.03.2017.
 */
@Configuration
public class MushroomsServerConfig {

    @Bean
    public InitializingBean mushroomsServerInitializer(
            UserService userService,
            FriendService friendService,
            TripService tripService,
            DiscoveryService discoveryService,
            CommentService commentService,
            ScoreService scoreService,
            NotificationService notificationService,
            MushroomClassService mushroomClassService,
            MushroomOrderService mushroomOrderService,
            MushroomGenusService mushroomGenusService,
            MushroomSpeciesService mushroomSpeciesService,
            CommandHandlerRegistry registry) {
        return () -> {
            registry.register(userService::handle, CreateUserCommand.class);
            registry.register(userService::handle, UpdateUserCommand.class);
            registry.register(userService::handle, DeleteUsersCommand.class);
            registry.register(userService::handle, UpdateProfileImageCommand.class);

            registry.register(friendService::handle, AddFriendCommand.class);
            registry.register(friendService::handle, DeleteFriendsCommand.class);
            registry.register(friendService::handle, AcceptInvitationToFriendsCommand.class);


            registry.register(tripService::handle, CreateTripCommand.class);
            registry.register(tripService::handle, UpdateTripCommand.class);
            registry.register(tripService::handle, DeleteTripCommand.class);
            registry.register(tripService::handle, JoinTripCommand.class);
            registry.register(tripService::handle, InviteToTripCommand.class);

            registry.register(discoveryService::handle, CreateDiscoveryCommand.class);
            registry.register(discoveryService::handle, UpdateDiscoveryCommand.class);
            registry.register(discoveryService::handle, DeleteDiscoveryCommand.class);
            registry.register(discoveryService::handle, AddScoreToDiscoveryCommand.class);

            registry.register(commentService::handle, CreateCommentCommand.class);
            registry.register(commentService::handle, UpdateCommentCommand.class);
            registry.register(commentService::handle, DeleteCommentCommand.class);

            registry.register(scoreService::handle, AddScoreCommand.class);
            registry.register(scoreService::handle, UpdateScoreCommand.class);
            registry.register(scoreService::handle, DeleteScoreCommand.class);

            registry.register(notificationService::handle, DeleteNotificationCommand.class);

            registry.register(mushroomClassService::handle, CreateMushroomClassCommand.class);
            registry.register(mushroomClassService::handle, UpdateMushroomClassCommand.class);
            registry.register(mushroomClassService::handle, DeleteMushroomClassCommand.class);
            
            registry.register(mushroomOrderService::handle, CreateMushroomOrderCommand.class);
            registry.register(mushroomOrderService::handle, UpdateMushroomOrderCommand.class);
            registry.register(mushroomOrderService::handle, DeleteMushroomOrderCommand.class);

            registry.register(mushroomGenusService::handle, CreateMushroomGenusCommand.class);
            registry.register(mushroomGenusService::handle, UpdateMushroomGenusCommand.class);
            registry.register(mushroomGenusService::handle, DeleteMushroomGenusCommand.class);

            registry.register(mushroomSpeciesService::handle, CreateMushroomSpeciesCommand.class);
            registry.register(mushroomSpeciesService::handle, UpdateMushroomSpeciesCommand.class);
            registry.register(mushroomSpeciesService::handle, DeleteMushroomSpeciesCommand.class);
        };
    }
}
