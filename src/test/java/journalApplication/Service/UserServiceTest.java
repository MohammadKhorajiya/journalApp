package journalApplication.Service;

import journalApplication.Entity.User;
import journalApplication.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user)
    {
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "3,1,4",
            "3,3,6"
    })
    public void test(int a,int b,int expected)
    {
        assertEquals(expected,a+b);
    }
}
