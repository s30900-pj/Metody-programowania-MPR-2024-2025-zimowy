package org.example;

public class User {
    public int id;

    public User(int ID) {
        this.id = ID;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getId() {
        return id;
    }
    private User temporaryOwner;
    public void setTemporaryOwner(User temporaryOwner) {
        this.temporaryOwner = temporaryOwner;
    }

    public User getTemporaryOwner() {
        return temporaryOwner;
    }

}
