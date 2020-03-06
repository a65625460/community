package life.majiang.community.mapper;


import life.majiang.community.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper mapper;

    @Test
    public void insert(){
        User user = new User();
        user.setToken("1");
        user.setName("1");
        user.setAccountId("1");
        user.setGmtModified(1L);
        user.setGmtCreate(1L);
        mapper.insert(user);
        System.err.println("OK");
    }
}
