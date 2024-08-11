package exercise.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "guests")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class User implements BaseEntity, UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String passwordDigest;

    @CreatedDate
    private LocalDate createdAt;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    // BEGIN
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return passwordDigest;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // END
}
