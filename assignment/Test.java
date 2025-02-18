package assignment;  

import java.util.Arrays;  

public class Test {  

    public static void main(String[] args) {  
        Planet[] planets = {  
            new Planet("Mercury", 0.383, 0.056, 0.39, 0.24),  
            new Planet("Venus", 0.949, 0.815, 0.72, 0.62),  
            new Planet("Earth", 1.000, 1.000, 1.00, 1.00),  
            new Planet("Mars", 0.532, 0.107, 1.52, 1.88),  
            new Planet("Jupiter", 11.209, 317.83, 5.20, 11.86),  
            new Planet("Saturn", 9.449, 95.16, 9.54, 29.45),  
            new Planet("Uranus", 4.007, 14.54, 19.19, 84.02),  
            new Planet("Neptune", 3.883, 17.15, 30.07, 164.79)  
        };  

        // Array Implementation  
        PlanetArray planetArray = new PlanetArray(planets.length);  
        for (Planet p : planets) {  
            planetArray.addPlanet(p);  
        }  
        planetArray.sort();  
        planetArray.display();  

        
    }  
}  