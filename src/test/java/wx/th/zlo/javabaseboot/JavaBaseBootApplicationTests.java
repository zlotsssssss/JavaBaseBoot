package wx.th.zlo.javabaseboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import wx.th.zlo.javabaseboot.springboot.entity.User;
import wx.th.zlo.javabaseboot.springboot.repository.UserRepository;
import wx.th.zlo.javabaseboot.springboot.service.UserService;

import java.util.Optional;

@SpringBootTest
@EnableTransactionManagement
class JavaBaseBootApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void add() {
        userService.addMoney();
    }

}
