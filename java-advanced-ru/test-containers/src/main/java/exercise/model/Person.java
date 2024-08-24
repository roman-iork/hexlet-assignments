package exercise.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "people")
@ToString
@EqualsAndHashCode
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

}
