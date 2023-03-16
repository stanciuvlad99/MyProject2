package ro.mycode.models;

public class Competition {
    private int id = 0;
    private String name = "";
    private String location = "";

    public Competition(int id, String name, String location){
        this.id=id;
        this.name=name;
        this.location=location;
    }
    public Competition(String text) {
        String[] strings = text.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.name = strings[1];
        this.location = strings[2];
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String descriere() {
        String descriere = "Id-ul concursului este " + id + ", numele este " + name + ", iar locatia este " + location;
        return descriere;
    }

    public String toSave(){
        return this.id+","+this.name+","+this.location;
    }
}
