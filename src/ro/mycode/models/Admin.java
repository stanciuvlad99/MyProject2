package ro.mycode.models;

public class Admin {
    private int id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    public Admin(String text){
        String []strings=text.split(",");
        this.id=Integer.parseInt(strings[0]);
        this.email=strings[1];
        this.password=strings[2];
        this.lastName=strings[3];
        this.firstName=strings[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String descriere(){
        String descrier="Id-ul adminului este " + id + " adresa de mail si parola sunt " + email + " "+ password+
                ", iar numele si prenumele sunt" + lastName +" "+ firstName;
        return descrier;
    }

    public String toSave(){
        return this.id+","+this.email+","+this.password+","+this.lastName+","+this.firstName;
    }
}
