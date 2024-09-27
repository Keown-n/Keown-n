package Compaction;

public class CBR {

  // Calculate Compaction Psuedo Code
  // Calculate the MoistureContent by subtracting the DryMass from the WetMass and
  // dividing by the DryMass
  // Calculate the DryMass by calling the calculateMaterialMass method
  // Calculate the WetMass by calling the calculateMaterialMass method
  // run the calculations 2 times
  // for each of the 3 briquettes Calculate the Material Mass using the
  // calculateMaterialMass method
  // Calculate the DryDensity by timing the Average Moisture Content by 100000 and
  // dividing by the MouldVolume devide (100 + MoistureContent)
  // Calculate the PercentageCompaction by dividing the DryDensity by the
  // MaximumDryDensity and multiplying by 100

  public void calcCbr(int calcPos, double[] load, double[] depth, double minLoad, double maxLoad, double minDepth,
      double maxDepth) {
    int maxPts = load.length;

    double[] fLoad = new double[maxPts];
    double[] h = new double[maxPts];
    double[] a = new double[maxPts];
    double[] b = new double[maxPts];
    double[] c = new double[maxPts];
    double[] d = new double[maxPts];
    double[] t = new double[maxPts];
    double[] l = new double[maxPts];
    double[] v = new double[maxPts];

    for (int i = 0; i < maxPts - 1; i++) {
      h[i] = depth[i + 1] - depth[i];
    }

    for (int i = 0; i < maxPts; i++) {
      depth[i] = load[i];
    }

    int numPts = 0;
    for (int i = 0; i < maxPts; i++) {
      if (load[i] != 0) {
        numPts++;
      }
    }
  }

  // Additional logic to solve the tridiagonal matrix and other calculations can
  // be added here

  // calcCbr(calcPos, load, depth, minLoad, maxLoad, minDepth, maxDepth)
  // set maxPts = length of load array
  // create arrays fLoad, h, a, b, c, d, t, l, v of size maxPts
  // h stores the difference between depth[i+1] and depth[i]
  // a, b, c, d are used to solve the tridiagonal matrix
  // t, l, v are used to store the intermediate values
  // set depth[i] = load[i] for i in range 1 to maxPts
  // find the number of points numPts where load[i] is not equal to 0

  // DrawPenetrationGraph
  // 1. Set tempColor to the current color of the graphics object
  // 2. Set the color of the graphics object to the background color
  // 3. Fill a rectangle with the background color at the specified coordinates
  // 4. Set the color of the graphics object back to the original color
  // 5. Draw a rectangle with the specified coordinates
  // 6. Draw a rectangle with the specified coordinates
  // 7. Set the color of the graphics object to black
  // 8. Draw a line from the specified coordinates
  // 9. Draw a line from the specified coordinates
  // 10. For each point in the data set
  // 11. Calculate the x-coordinate of the point
  // 12. Draw a vertical line at the x-coordinate of the point
  // 13. For each point in the data set
  // 14. Calculate the x-coordinate of the point
  // 15. Draw the point at the calculated coordinates
  // 16. Set the color of the graphics object to blue
  // 17. Calculate the x-coordinate and y-coordinate of the first point
  // 18. Draw a line from the first point to the next point
  // 19. For each segment in the data set
  // 20. Calculate the x-coordinate and y-coordinate of the next point
  // 21. Draw a line from the current point to the next point
  // 22. Set the color of the graphics object to red
  // 23. Calculate the x-coordinate and y-coordinate of the next point
  // 24. Draw the point at the calculated coordinates
  // 25. End DrawPenetrationGraph

  public static double CbrVal(double kn, double kf) {
    double cv = kn / kf * 100;
    if (cv > 600) {
      cv = 600;
    }
    if (cv < 0.1) {
      cv = 0.1;
    }
    if (cv < 10) {
      cv = Math.round(cv * 10) / 10.0;
    } else {
      cv = Math.round(cv);
    }
    return cv;
  }

  public double interpolate(double Ly, double Hy, double Lx, double Hx, double X) {
    return Ly + (Hy - Ly) * (X - Lx) / (Hx - Lx);
  }
}
// psuedo code for interpolation
// function interpolate(Ly, Hy, Lx, Hx, X)
// return Ly + (Hy - Ly) * (X - Lx) / (Hx - Lx)
// where Ly is the lower bound of the y-axis, Hy is the upper bound of the
// y-axis,
// Lx is the lower bound of the x-axis, Hx is the upper bound of the x-axis, and
// X is the value to be interpolated.
// The function returns the interpolated value of X on the y-axis.

// psuedo code
// Calculate the CBR values for 90 to 100
// Get the CBR values from the input
// Get the compaction values from the calculate compaction values and store them
// in variables
// Calculate the average compaction value
// Calculate the average CBR value using the cup function
// Calculate the CBR values for 104, 100, 98, 97, 95, 93, 90, and 88 using the
// cup function
// Convert the CBR values to strings using the makeStr function
// Calculate the penetration values for 0.1 and 1000 using the puc function
// Set the CBR values and penetration values in the CBR table in the database
// Save the changes to the database