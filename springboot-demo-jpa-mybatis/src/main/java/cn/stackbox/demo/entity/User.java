package cn.stackbox.demo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "idGenerator", strategy = "UUID")
    @GeneratedValue(generator = "idGenerator")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @Column(name = "email", nullable = false)
    private String email;
}
