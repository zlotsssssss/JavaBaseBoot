package wx.th.zlo.javabaseboot.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wx.th.zlo.javabaseboot.springboot.repository.UserRepository;

@Service

public class UserService {
    @Autowired
    UserRepository userRepository;

    public  void addMoney(){
        userRepository.addMoneyById(10,1L);
        userRepository.reduceMoneyById(10,2L);
    }
}
