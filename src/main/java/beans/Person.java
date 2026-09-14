package beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Component
@Setter
public class Person {
    private String name = "Ella";
    private final Parrot parrot;

    public Person(Parrot parrot2) {
        this.parrot = parrot2;
    }

}
