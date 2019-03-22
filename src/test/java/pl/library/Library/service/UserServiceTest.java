//package pl.library.Library.service;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import pl.library.Library.model.User;
//import pl.library.Library.repository.RoleRepository;
//import pl.library.Library.repository.UserRepository;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import static org.junit.Assert.*;
//
//public class UserServiceTest {
//
//    @Mock
//    private UserRepository mockUserRepository;
//    @Mock
//    private RoleRepository mockRoleRepository;
//    @Mock
//    private BCryptPasswordEncoder mockBCryptPasswordEncoder;
//
//    private UserService userServiceUnderTest;
//    private User user;
//
//    @Before
//    public void setUp() {
//        initMocks(this);
//        userServiceUnderTest = new UserService(mockUserRepository,
//                mockRoleRepository,
//                mockBCryptPasswordEncoder);
//        user = User.builder()
//                .id(1)
//                .name("Gustavo")
//                .lastName("Ponce")
//                .email("test@test.com")
//                .build();
//
//        Mockito.when(mockUserRepository.save(any()))
//                .thenReturn(user);
//        Mockito.when(mockUserRepository.findByEmail(anyString()))
//                .thenReturn(user);
//    }
//
//
//    @Test
//    public void testFindUserByEmail() {
//        // Setup
//        final String email = "test@test.com";
//
//        // Run the test
//        final User result = userServiceUnderTest.findUserByEmail(email);
//
//        // Verify the results
//        assertEquals(email, result.getEmail());
//    }
//
//    @Test
//    public void testSaveUser() {
//        // Setup
//        final String email = "test@test.com";
//
//        // Run the test
//        User result = userServiceUnderTest.saveUser(User.builder().build());
//
//        // Verify the results
//        assertEquals(email, result.getEmail());
//    }
//}
//
