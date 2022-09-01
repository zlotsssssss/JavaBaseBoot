package wx.th.zlo.javabaseboot.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import wx.th.zlo.javabaseboot.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Modifying
    @Query(value = "update t_user set money = money + ?1 where id = ?2")
    public  void addMoneyById(Integer money ,Long id);

    @Modifying
    @Query(value = "update t_user set money = money - ?1 where id = ?2")
    public  void reduceMoneyById(Integer money ,Long id);
}
