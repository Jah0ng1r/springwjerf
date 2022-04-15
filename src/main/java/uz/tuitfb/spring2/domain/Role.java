package uz.tuitfb.spring2.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {
    @Id
    private Long name;

    public void setName(Long name) {
        this.name = name;
    }

    public Long getName() {
        return name;
    }
}
