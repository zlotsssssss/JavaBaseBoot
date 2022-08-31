package wx.th.zlo.javabaseboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wx.th.zlo.javabaseboot.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
