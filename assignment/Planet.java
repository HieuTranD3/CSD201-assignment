package assignment;
import java.util.Arrays;

class Planet {  
    String name;  
    double equatorialDiameter;  
    double mass;  
    double semiMajorAxis;  
    double orbitalPeriod;  

    Planet(String name, double equatorialDiameter, double mass, double semiMajorAxis, double orbitalPeriod) {  
        this.name = name;  
        this.equatorialDiameter = equatorialDiameter;  
        this.mass = mass;  
        this.semiMajorAxis = semiMajorAxis;  
        this.orbitalPeriod = orbitalPeriod;  
    }  
}  

// Array Implementation  
class PlanetArray {  
    private Planet[] planets;  
    private int size;  

    public PlanetArray(int capacity) {  
        planets = new Planet[capacity];  
        size = 0;  
    }  

    public void addPlanet(Planet planet) {  
        if (size < planets.length) {  
            planets[size++] = planet;  
        }  
    }  

    public void sort() {  
        Arrays.sort(planets, 0, size, (p1, p2) -> Double.compare(p1.mass, p2.mass));  
    }  

    public void display() {  
        System.out.println("Planets in Array (sorted by mass):");  
        for (int i = 0; i < size; i++) {  
            System.out.println(planets[i].name + ": " + planets[i].mass);  
        }  
    }  
}  


 

