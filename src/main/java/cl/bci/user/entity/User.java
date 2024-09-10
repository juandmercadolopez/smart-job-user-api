package cl.bci.user.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    private String uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Phone> phones;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    @Column(nullable = false)
    private Boolean isActive;

}
