package pl.polsl.mushrooms.application.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import pl.polsl.mushrooms.application.commands.comment.CreateCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.DeleteCommentCommand;
import pl.polsl.mushrooms.application.commands.comment.UpdateCommentCommand;
import pl.polsl.mushrooms.application.commands.discovery.DeleteDiscoveryCommand;
import pl.polsl.mushrooms.application.commands.discovery.UpdateDiscoveryCommand;
import pl.polsl.mushrooms.infrastructure.repositories.CommentRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
/**
 * Created by Artur on 2017-06-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @MockBean
    private CreateCommentCommand createCommentCommand;

    @MockBean
    private UpdateCommentCommand updateCommentCommand;

    @MockBean
    private DeleteCommentCommand deleteCommentCommand;

    @Before
    public void setCreateCommentCommand(){
        LocalDateTime localDateTime = LocalDateTime.now();
        createCommentCommand = Mockito.mock(CreateCommentCommand.class);
        Mockito.when(createCommentCommand.getContents()).thenReturn("tekst");
        Mockito.when(createCommentCommand.getDateTime()).thenReturn(localDateTime);
        Mockito.when(createCommentCommand.getTargetId()).thenReturn(Long.valueOf(1));
    }

    @Before
    public void setUpdateCommentCommand() {
        updateCommentCommand = Mockito.mock(UpdateCommentCommand.class);
        Mockito.when(updateCommentCommand.getContents()).thenReturn("tekst");
        Mockito.when(updateCommentCommand.getId()).thenReturn(Long.valueOf(1));
    }


    @Test(expected = NullPointerException.class)
    public void handle() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.handle(createCommentCommand);

    }

    @Test(expected = NullPointerException.class)
    public void handle1() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.handle(updateCommentCommand);
    }

    @Test(expected = NullPointerException.class)
    public void handle2() throws Exception {
        //SecurityContextHolder.getContext().getAuthentication().getName();
        deleteCommentCommand = Mockito.mock(DeleteCommentCommand.class);
        Mockito.when(deleteCommentCommand.getId()).thenReturn(Long.valueOf(1));
        commentService.handle(deleteCommentCommand);
    }

}