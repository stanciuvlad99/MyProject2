package ro.mycode.models;

public class Owner {
    private int id = 0;
    private String lastName = "";
    private String firstName = "";
    private int age = 0;
    private String email = "";
    private String password = "";

    public Owner(String text) {
        String[] strings = text.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.lastName = strings[1];
        this.firstName = strings[2];
        this.age = Integer.parseInt(strings[3]);
        this.email = strings[4];
        this.password = strings[5];

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String descriere() {
        String descriere = "Id-ul stapanului este " + id + ", numele si prenumele sunt " + lastName + " " + firstName
                + " varsta este " + age + " de ani" + ", iar adresa de email si parola sunt " + email + " " + password;
        return descriere;
    }
}
