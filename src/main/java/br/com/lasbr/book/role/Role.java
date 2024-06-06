package br.com.lasbr.book.role;

import br.com.lasbr.book.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @CreatedDate
    @Column(nullable = false , updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;
}
