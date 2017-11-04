/*
 * package team.awesome.pet.Controller;
 * 
 * import org.junit.Before; import org.junit.Test; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.MockitoAnnotations; import
 * team.awesome.pet.controller.UserController; import team.awesome.pet.model.User; import
 * team.awesome.pet.service.UserService; import java.util.Collection; import java.util.HashSet;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * public class UserControllerTest { UserController userController; Collection<User> expected;
 * 
 * @Mock private UserService mockUserService;
 * 
 * @Before public void init() { userController = new UserController(); expected = new HashSet<>();
 * MockitoAnnotations.initMocks(this); }
 * 
 * @Test public void testGetAllPets() { expected.add(new User(1, "Kinshuk", "Awesome1"));
 * Mockito.when(mockUserService.getAllUsers()).thenReturn(expected); assertEquals(expected,
 * userController.getAllUsers()); } }
 * 
 */
