
public interface PointCP6 {
	
	double getX();
	double getY();
	double getRho();
	double getTheta();
	void convertStorageToPolar();
	void convertStorageToCartesian();
	double getDistance(PointCP3 pointB);
	PointCP3 rotatePoint(double rotation);
}
