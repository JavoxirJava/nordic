package unv.nordic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table(indexes = {
        @Index(name = "idx_users_phone_number", columnList = "phone_number")
})
public class User {
    @Id
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;
    private String language;
}
