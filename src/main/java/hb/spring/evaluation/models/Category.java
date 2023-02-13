package hb.spring.evaluation.models;

public class Category {

    private String name;

    private Integer idUser;

    public Category() {

    }

    public Category(String name, Integer idUser) {
        this.name = name;
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }


}
