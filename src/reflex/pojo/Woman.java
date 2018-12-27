package reflex.pojo;

import java.io.Serializable;

public class Woman implements Serializable,Comparable {

    private String name;
    private Integer age;

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
    public int compareTo(Object o) {
        return 0;
    }

    public Woman(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
