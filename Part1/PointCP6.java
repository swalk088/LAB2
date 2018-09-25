
public interface PointCP6 {
	
	double getX();
	double getY();
	double getRho();
	double getTheta();
	PointCP2 convertStorageToPolar();
	PointCP3 convertStorageToCartesian();
	double getDistance(PointCP3 pointB);
	PointCP6 rotatePoint(double rotation);
}
