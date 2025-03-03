package com.javaspring.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_id_sequence")

    @SequenceGenerator(name = "auth_id_sequence", sequenceName = "auth_id_sequence"
    )
    private Integer id;
    private Integer customerId;
    private Boolean isLoggedIn;
    private LocalDateTime loggedInAt;
}
