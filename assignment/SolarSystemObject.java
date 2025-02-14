
package assignment;

class SolarSystemObject {
    String name;
    double equatorialDiameter;
    double mass;
    double semiMajorAxis;
    double orbitalPeriod;

 
    public SolarSystemObject(String name, double equatorialDiameter, double mass, double semiMajorAxis, double orbitalPeriod) {
        this.name = name;
        this.equatorialDiameter = equatorialDiameter;
        this.mass = mass;
        this.semiMajorAxis = semiMajorAxis;
        this.orbitalPeriod = orbitalPeriod;
    }


    @Override
    public String toString() {
        return String.format("%-8s | Diameter: %-6.3f | Mass: %-6.2f | Semi-Major Axis: %-6.2f | Orbital Period: %-6.2f",
                name, equatorialDiameter, mass, semiMajorAxis, orbitalPeriod);
    }
}
