package spring_study.alex.lab;

import lombok.Data;

@Data
public class Client {
    private String id;
    private String FullName;

    public Client(String id, String fullName) {
        this.id = id;
        FullName = fullName;
    }
}
