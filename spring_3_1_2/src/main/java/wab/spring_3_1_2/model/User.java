package wab.spring_3_1_2.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id_")//, nullable = false
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_")
    @NotEmpty(message =  "Напишите имя")
    @Size(min = 2, max = 30, message = "Имя короткое или длинное")
    private String name;
    @Column(name = "age_", nullable = false)
    @Min(value = 0, message = "Возраст должен быть больше чем 0")
    public Integer age;

    public User() {
    }

    public User (Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
