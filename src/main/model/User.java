package main.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter @Setter
@ToString(of = {"id","username","balance","orders"})
@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=4, max=8,message = "Username must be between {min} and {max} characters")
    @Column(name = "username")
    private String username;

    @Size(min = 4, message = "Password has to be at least 4 characters")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "balance")
    private BigDecimal balance;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id") )
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Order> orders;

}
