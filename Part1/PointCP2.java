

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. Thus class stores Polar coordinates,
 * and computes cartesian coords on command
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */

public class PointCP2 implements PointCP6
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  private PointCP3 myCP3Point;
	
  private char typeCoord;
  
  /**
   * Contains the current value of RHO 
   */
  private double rho;
  
  /**
   * Contains the current value of THETA
   */
  private double theta;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCP2(char type, double rho, double theta)
  {
    if(type != 'C' && type != 'P')
      throw new IllegalArgumentException();
    if(type=='C') {
    	this.myCP3Point = new PointCP3('P',rho,theta);
    }
    else {
	    this.rho = rho;
	    this.theta = theta;
    }
    typeCoord = type;
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
	  if(typeCoord=='C') {
		  return myCP3Point.getX();
	  }
			
	  else {
		  return (Math.cos(Math.toRadians(theta)) * rho);
	  }
  }
  
  public double getY()
  {
	if(typeCoord=='C') {
		return myCP3Point.getY();
	}
		
	else {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}
  }
  
  public double getRho()
  {
	return rho;
  }
  
  public double getTheta()
  {
    return theta;
  }
  
	
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    if(typeCoord != 'P')
    {      
      typeCoord = 'P';  //Change coord type identifier
    }
  }
	
  /**
   * Converts Polar coordinates to Cartesian coordinates.
   */
  public void convertStorageToCartesian()
  {
    if(typeCoord != 'C')
    {
      myCP3Point = new PointCP3('P',getX(),getY());
      typeCoord = 'C';	//Change coord type identifier
    }
  }

  /**
   * Calculates the distance in between two points using the Pythagorean
   * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
   *
   * @param pointA The first point.
   * @param pointB The second point.
   * @return The distance between the two points.
   */
  public double getDistance(PointCP3 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP3 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointCP3('C',
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as " + (typeCoord == 'C' 
       ? "Cartesian  (" + getX() + "," + getY() + ")"
       : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
  }
}