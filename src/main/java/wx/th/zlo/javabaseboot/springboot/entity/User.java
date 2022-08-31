package wx.th.zlo.javabaseboot.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String avatarPath;

    @Column()
    private String name;

    @Column()
    private String password;

    @Column()
    private String phone;
}
