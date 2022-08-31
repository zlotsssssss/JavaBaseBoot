package wx.th.zlo.javabaseboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wx.th.zlo.javabaseboot.springboot.entity.User;
import wx.th.zlo.javabaseboot.springboot.repository.UserRepository;

import java.util.Optional;

@SpringBootTest
class JavaBaseBootApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
        Optional<User> user = userRepository.findById(1l);

        System.out.println(user.get().getName());
    }

}
