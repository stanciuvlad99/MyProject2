package ro.mycode.models;

public class Enrolment {
    private int id = 0;
    private int ownerId = 0;
    private int competitionId = 0;

    public Enrolment(int id, int ownerId, int competitionId){
        this.id=id;
        this.ownerId=ownerId;
        this.competitionId=competitionId;
    }
    public Enrolment(String text) {
        String[] strings = text.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.ownerId = Integer.parseInt(strings[1]);
        this.competitionId = Integer.parseInt(strings[2]);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOwnerId(int id) {
        this.ownerId = ownerId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public String descriere() {
        String descriere = "Id-ul inscrierii este " + id + ", id-ul stapanului este " + ownerId +
                ", iar id-ul concursului este " + competitionId;
        return descriere;
    }

    public String toSave(){
        return this.id+","+this.ownerId+","+this.competitionId;
    }
}
