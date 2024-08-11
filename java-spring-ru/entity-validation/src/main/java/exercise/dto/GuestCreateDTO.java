package exercise.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.time.LocalDate;

// BEGIN
@Getter
public class GuestCreateDTO {
    @NotNull
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;

    @Pattern(regexp = "^\\d{4}$")
    private String clubCard;

    @FutureOrPresent
    private LocalDate cardValidUntil;
}
// END
