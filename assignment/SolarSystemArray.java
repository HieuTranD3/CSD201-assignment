/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

/**
 *
 * @author ADMIN
 */
public class SolarSystemArray {
    public static void main(String[] args) {
      
        SolarSystemObject[] solarSystem = new SolarSystemObject[8];

       
        solarSystem[0] = new SolarSystemObject("Mercury", 0.383, 0.06, 0.39, 0.24);
        solarSystem[1] = new SolarSystemObject("Venus", 0.949, 0.81, 0.72, 0.62);
        solarSystem[2] = new SolarSystemObject("Earth", 1.000, 1.00, 1.00, 1.00);
        solarSystem[3] = new SolarSystemObject("Mars", 0.552, 0.11, 1.52, 1.88);
        solarSystem[4] = new SolarSystemObject("Jupiter", 11.209, 317.83, 5.20, 11.86);
        solarSystem[5] = new SolarSystemObject("Saturn", 9.449, 95.16, 9.54, 29.45);
        solarSystem[6] = new SolarSystemObject("Uranus", 4.007, 14.54, 19.19, 84.02);
        solarSystem[7] = new SolarSystemObject("Neptune", 3.883, 17.15, 30.07, 164.79);

      
        System.out.println("Solar System Objects:");
        System.out.println("--------------------------------------------------------------");
        for (SolarSystemObject obj : solarSystem) {
            System.out.println(obj);
        }

        // Step 6: Access a specific object by index
        System.out.println("\nAccessing object at index 4 (Jupiter):");
        System.out.println(solarSystem[4]);

        // Step 7: Sort the array by mass (optional, if required)
        java.util.Arrays.sort(solarSystem, (a, b) -> Double.compare(a.mass, b.mass));
        System.out.println("\nSolar System Objects Sorted by Mass:");
        System.out.println("--------------------------------------------------------------");
        for (SolarSystemObject obj : solarSystem) {
            System.out.println(obj);
        }
    }
}