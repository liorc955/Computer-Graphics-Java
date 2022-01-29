package Primitives;

public class Coordinate {
	private double coordinate;
	
	public Coordinate() {  // default constructor
		this.coordinate = 0;
	}
	
	public Coordinate(double coordinate) { // constructor with arguments
		this.coordinate = coordinate;
	}
	
	public Coordinate(Coordinate coordinate) { // copy constructor
		this.coordinate = coordinate.coordinate;
	}
	/*get and set methods */
	public double getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(double coordinate) {
		this.coordinate = coordinate;
	}
	
	 public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null) return false;
	        if (!(obj instanceof Coordinate)) return false;
	        return coordinate - ((Coordinate)obj).coordinate==0;
	    //    return isZero(_coord - ((Coordinate))._coord);
	    }
	
	public String toString() {return Double.toString(coordinate);}
}
