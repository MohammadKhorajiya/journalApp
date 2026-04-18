package journalApplication.Service;

import journalApplication.Entity.User;
import journalApplication.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;


public class UserDetailsServiceImplTests
{
    @InjectMocks
    private UserDetailsServiceimpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest()
    {
       when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("Mohammad").password("Mohammad@2006").role(new ArrayList<>()).build());
       UserDetails user =userDetailsServiceImpl.loadUserByUsername("Mohammad");
       Assertions.assertNotNull(user);
    }
}
