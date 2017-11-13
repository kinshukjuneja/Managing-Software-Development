package team.awesome.pet.Controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import team.awesome.pet.controller.UserController;
import team.awesome.pet.model.User;
import team.awesome.pet.service.UserService;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class UserControllerTest {
    UserController userController;

    @Mock
    private UserService mockUserService;
    private User user;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(mockUserService);
        user = User.builder().
                userID(10).
                userName("Kinsh").
                address("Seattle").
                email("askkinsh@gmail.com").
                firstName("Kinshuk").
                lastName("Juneja").
                password("S3cret").
                phone(2066040324).
                build();
    }

    @Test
    public void testGetAllUsers() {
        Collection<User> expected = new ArrayList<>();
        expected.add(user);
        Mockito.when(mockUserService.getAllUsers()).thenReturn(expected);
        assertEquals(expected, userController.getAllUsers());
        Mockito.verify(mockUserService, Mockito.times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() {
        User expected = user;
        Mockito.when(mockUserService.getUserById(10)).thenReturn(expected);
        assertEquals(expected, userController.getUserById(10));
        Mockito.verify(mockUserService, Mockito.times(1)).getUserById(10);
    }

    @Test
    public void testUpdateUser() {
        userController.updateUser(user);
        Mockito.verify(mockUserService, Mockito.times(1)).updateUser(user);
    }

    @Test
    public void testInsertUser() {
        userController.insertUser(user);
        Mockito.verify(mockUserService, Mockito.times(1)).insertUser(user);
    }

    @Test
    public void testDeleteUserById() {
        userController.deleteUserById(10);
        Mockito.verify(mockUserService, Mockito.times(1)).removeUserById(10);
    }
}