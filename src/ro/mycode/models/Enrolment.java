package ro.mycode.models;

public class Enrolment {
    private int id=0;
    private int ownerId=0;
    private int petId=0;

    public Enrolment(String text){
        String []strings=text.split(",");
        this.id=Integer.parseInt(strings[0]);
        this.ownerId=Integer.parseInt(strings[1]);
        this.petId=Integer.parseInt(strings[2]);
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setOwnerId(int id){
        this.ownerId=ownerId;
    }

    public int getOwnerId(){
        return ownerId;
    }

    public void setPetId(int petId){
        this.petId=petId;
    }

    public int getPetId(){
        return petId;
    }

    public String descriere(){
        String descriere="Id=ul inscrierii este " + id + ", id-ul stapanului este " + ownerId +
                ", iar id-ul animalului este " + petId;
        return descriere;
    }
}
