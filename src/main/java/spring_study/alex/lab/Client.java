package spring_study.alex.lab;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client {
    private String id;
    private String FullName;

    public Client(String id, String fullName) {
        this.id = id;
        FullName = fullName;
    }
}
