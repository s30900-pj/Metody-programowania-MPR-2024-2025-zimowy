package org.example;

public enum Type {
    Suv(3),
    Sedan(4),
    Kombi(6);
    public final int standardValue;

    private Type(int standardValue){
        this.standardValue = standardValue;
    }

    public int getStandardValue() {
        return standardValue;
    }
}
