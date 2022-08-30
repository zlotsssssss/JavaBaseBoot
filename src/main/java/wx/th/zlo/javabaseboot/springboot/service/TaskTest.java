package wx.th.zlo.javabaseboot.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/*
    springboot配置springTask框架：
    1.启动类加上 @EnableScheduling
    2.实例化TaskBean
 */
@Component
public class TaskTest {
    private static final Logger log = LoggerFactory.getLogger(TaskTest.class);
    private static int count;

    @Scheduled(cron = "0/10 * * * * ?")
    public void cron() {
        log.info("spring anno task execute times {}", count++);
        System.out.println("1");
    }
}
