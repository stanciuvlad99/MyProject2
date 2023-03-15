package ro.mycode.models;

public class Pet {

    private int id = 0;
    private int ownerId = 0;
    private int age = 0;
    private String race = "";
    private String name = "";

    public Pet(int id, int ownerId, int age, String race, String name) {
        this.id = id;
        this.ownerId = ownerId;
        this.age = age;
        this.race = race;
        this.name = name;
    }

    public Pet(String text) {
        String[] strings = text.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.ownerId = Integer.parseInt(strings[1]);
        this.age = Integer.parseInt(strings[2]);
        this.race = strings[3];
        this.name = strings[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String descriere() {
        String descriere = "Id-ul animalului este " + id + ", id-ul stapanului este " + ownerId + ", rasa este " + race +
                " si se numeste " + name + " si are " + age + " ani";
        return descriere;
    }
}
