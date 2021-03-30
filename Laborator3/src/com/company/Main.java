package com.company;

import java.util.Objects;

abstract class CandyBox {
     String flavor;
     String origin;
    CandyBox() {
        System.out.println("CandyBox with no params");
                }
    CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }
    public abstract int getVolume();

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor='" + flavor + '\'' +
                ", origin=" + origin +
                '}';
    }
}

class Lindt extends CandyBox {
    private Integer length;
    private Integer width;
    private Integer height;
    @Override
    public int getVolume() {
        return this.length*this.height*this.width;
    }
    Lindt() {
        System.out.println("Merci with no params");
    }
    Lindt(String flavor, String origin, Integer length, Integer width, Integer height){
        super(flavor, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString() {
        return "The " + origin + " " + flavor + " has volume " + getVolume();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lindt lindt = (Lindt) o;
        return flavor.equals(lindt.flavor) && origin.equals(lindt.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, origin);
    }
}

class Milka extends CandyBox {
    Integer radius;
    Integer height;
    @Override
    public int getVolume() {
        return this.radius*this.height;
    }
    Milka() {
        System.out.println("Milka with no params");
    }
    Milka(String flavor, String origin, Integer radius, Integer height){
        super(flavor, origin);
        this.radius = radius;
        this.height = height;
    }
    @Override
    public String toString() {
        return "The " + origin + " " + flavor + " has volume " + getVolume();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milka milka = (Milka) o;
        return radius.equals(milka.radius) && height.equals(milka.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, height);
    }
}

class Merci extends CandyBox {
    Integer length;
    @Override
    public int getVolume() {
        return this.length*this.length*this.length;
    }
    Merci() {
        System.out.println("Merci with no params");
    }
    Merci(String flavor, String origin, Integer length){
        super(flavor, origin);
        this.length = length;
    }
    @Override
    public String toString() {
        return "The " + origin + " " + flavor + " has volume " + getVolume();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merci merci = (Merci) o;
        return length.equals(merci.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}

class CandyBag {
    CandyBox cutii[] = new CandyBox[3];

    CandyBag()
    {
    }

    CandyBag(CandyBox cutii2[]){
        cutii = new CandyBox[cutii2.length];
        for (int i=0; i<cutii2.length; i++) {
            this.cutii[i] = cutii2[i];
        }
    }

    @Override
    public String toString()
    {
        String continut = "";
        for (int i = 0; i < cutii.length; i++) {
            continut = continut + '\n' + this.cutii[i].toString();
        }
        return continut;
    }

}

class Area {
    CandyBag obj;
    int number;
    String street;

    Area() {
        System.out.println("Area with no params");
    }
    Area( CandyBag obj, int number, String street){
        this.obj = obj;
        this.number = number;
        this.street = street;
    }

    void printAdress () {
        System.out.println(this.street + " " + this.number);
        System.out.println(this.obj.toString());

    }
    public static void main(String[] args) {

        CandyBox[]cutie= new CandyBox[5];
        cutie[0] = new Milka("capsuni", "origin", 3, 5);
        cutie[4] = new Milka("capsuni", "origin", 3, 5);
        cutie[1] = new Merci("cacao", "origin", 4);
        cutie[2] = new Lindt("milk", "origin", 3, 6, 9);
        cutie[3] = new Lindt("milk", "origin", 4, 6, 9);
        CandyBag bag = new CandyBag(cutie);
        Area area = new Area(bag, 20, "Str Eroilor");
       // area.printAdress();
        System.out.println(cutie[2].equals(cutie[3]));
    }

}
