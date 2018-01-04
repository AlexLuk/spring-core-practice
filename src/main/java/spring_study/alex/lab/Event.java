package spring_study.alex.lab;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Random;

@Data
@NoArgsConstructor
@ToString
public class Event {
    private static Random random;
    private int id;
    private String message;
    private Date date;

    static {
        random = new Random();
    }

    public Event(Date date) {
        id = random.nextInt();
        this.date = date;
    }
}
