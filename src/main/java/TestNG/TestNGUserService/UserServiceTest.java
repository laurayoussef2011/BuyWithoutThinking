package TestNG.TestNGUserService;

import com.SWEProject.Entities.Store;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import com.SWEProject.service.userService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    UserRepository userRep;

    @InjectMocks
    userService userService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddUserSuccess() {
        User user = new User("fady", "fady","fady","Admin","fady","",1000000);
        when(userRep.exists(user.getUsername())).thenReturn(false);
        Assert.assertEquals(true,userService.addUser(user));
    }

    @Test
    public void testAddUserFailure() {
        User user = new User("fady", "fady","fady","Admin","fady","",1000000);
        when(userRep.exists(user.getUsername())).thenReturn(true);
        Assert.assertEquals(false,userService.addUser(user));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testCheckAvailableSuccess() {
        User user = new User("fady", "fady","fady","Admin","fady","",1000000);
        when(userRep.exists(user.getUsername())).thenReturn(true);
        when(userRep.findOne(user.getUsername())).thenReturn(user);
        Assert.assertEquals(user,userService.checkAvailable(user));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testGetStoreListSuccess() {
        List<User> userList = new ArrayList<>();
        when(userRep.findAll()).thenReturn(userList);
        Assert.assertEquals(userList, userService.showCollaborators("Apple"));
    }

}