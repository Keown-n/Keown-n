package Indicator;

public class HRB {
    public static String PraClas(double p0p075, double p0p425, double p2p0, double LiquidLimit, double plastIndex) {
        String Pra, z1, z2, z3, z4, y7s;
        double y1, y2, y3, y4, y5;
        int y6;

        Pra = "";
        z1 = "";
        z2 = "";
        z3 = "";
        z4 = "";

        // Check conditions for classification
        if ((plastIndex <= 6) && (p2p0 <= 50) && (p0p425 <= 30) && (p0p075 <= 15)) {
            Pra = "A-1-a(0)";
        } else if ((plastIndex <= 6) && (p0p425 <= 50) && (p0p075 <= 25)) {
            Pra = "A-1-b(0)";
        } else if ((plastIndex == 0) && (p0p075 <= 10)) {
            Pra = "A-3(0)";
        } else {
            // Calculate z1
            if (p0p075 <= 35) {
                z1 = "A-2-";
            } else {
                z1 = "A-";
            }

            // Calculate z2 and z3 based on LiquidLimit
            if (LiquidLimit <= 40) {
                z2 = "4";
                z3 = "6";
            } else {
                z2 = "5";
                z3 = "7";
            }

            // Calculate z4 based on plastIndex
            if (plastIndex <= 10) {
                z4 = z1 + z2;
            } else {
                z4 = z1 + z3;
            }

            // Check additional condition for z4 = "A-7"
            if (z4.equals("A-7")) {
                if (plastIndex <= LiquidLimit - 30) {
                    z4 = z4 + "-5";
                } else {
                    z4 = z4 + "-6";
                }
            }

            // Calculate y1
            if ((p0p075 > 35) && (p0p075 <= 75)) {
                y1 = p0p075 - 35;
            } else {
                if (p0p075 > 75) {
                    y1 = 40;
                } else {
                    y1 = 0;
                }
            }

            // Calculate y2
            if ((p0p075 > 15) && (p0p075 <= 55)) {
                y2 = p0p075 - 15;
            } else {
                if (p0p075 > 55) {
                    y2 = 40;
                } else {
                    y2 = 0;
                }
            }

            // Calculate y3
            if ((LiquidLimit > 40) && (LiquidLimit <= 60)) {
                y3 = LiquidLimit - 40;
            } else {
                if (LiquidLimit > 60) {
                    y3 = 20;
                } else {
                    y3 = 0;
                }
            }

            // Calculate y4
            if ((plastIndex > 10) && (plastIndex <= 30)) {
                y4 = plastIndex - 10;
            } else {
                if (plastIndex > 30) {
                    y4 = 20;
                } else {
                    y4 = 0;
                }
            }

            // Calculate y5
            y5 = 0.2 * y1 + 0.005 * y1 * y3 + 0.01 * y2 * y4;

            // Round y5 to the nearest integer
            y6 = (int) Math.round(y5);

            // Convert y6 to string
            y7s = Integer.toString(y6);

            // Construct HRB class
            Pra = z4 + "(" + y7s + ")";
        }

        return Pra;
    }

    public static void main(String[] args) {
        // Example usage
        double p0p075 = 20;
        double p0p425 = 40;
        double p2p0 = 30;
        double LiquidLimit = 50;
        double plastIndex = 5;

        String classification = PraClas(p0p075, p0p425, p2p0, LiquidLimit, plastIndex);
        System.out.println("Classification: " + classification);
    }
}

// Psuedo code
// classify soil based on the HRB classification system
// PraClas takes in 5 parameters: p0p075, p0p425, p2p0, LiquidLimit, plastIndex
// Pra is initialized to an empty string
// z1, z2, z3, z4 are initialized to empty strings
// Check conditions for classification
// if plastIndex is less than or equal to 6 and p2p0 is less than or equal to 50 and p0p425 is less than or equal to 30 and p0p075 is less than or equal to 15, then Pra is set to "A-1-a(0)"
// else if plastIndex is less than or equal to 6 and p0p425 is less than or equal to 50 and p0p075 is less than or equal to 25, then Pra is set to "A-1-b(0)"
// else if plastIndex is equal to 0 and p0p075 is less than or equal to 10, then Pra is set to "A-3(0)"
// if none of the above conditions are met, then calculate z1, z2, z3, z4 based on conditions
// if p0p075 is less than or equal to 35, then z1 is set to "A-2-", else z1 is set to "A-"
// if LiquidLimit is less than or equal to 40, then z2 is set to "4" and z3 is set to "6", else z2 is set to "5" and z3 is set to "7"
// if plastIndex is less than or equal to 10, then z4 is set to z1 + z2, else z4 is set to z1 + z3
// if z4 is equal to "A-7", then check additional condition
// if plastIndex is less than or equal to LiquidLimit - 30, then z4 is set to z4 + "-5", else z4 is set to z4 + "-6"
// Calculate y1, y2, y3, y4 based on p0p075, LiquidLimit, plastIndex
// if p0p075 is greater than 35 and less than or equal to 75, then y1 is set to p0p075 - 35, else if p0p075 is greater than 75, then y1 is set to 40, else y1 is set to 0
// if p0p075 is greater than 15 and less than or equal to 55, then y2 is set to p0p075 - 15, else if p0p075 is greater than 55, then y2 is set to 40, else y2 is set to 0
// if LiquidLimit is greater than 40 and less than or equal to 60, then y3 is set to LiquidLimit - 40, else if LiquidLimit is greater than 60, then y3 is set to 20, else y3 is set to 0
// if plastIndex is greater than 10 and less than or equal to 30, then y4 is set to plastIndex - 10, else if plastIndex is greater than 30, then y4 is set to 20, else y4 is set to 0
// Calculate y5 based on y1, y2, y3, y4
// y5 is set to 0.2 * y1 + 0.005 * y1 * y3 + 0.01 * y2 * y4
// Round y5 to the nearest integer
// Convert y5 to string
// Construct Pra based on z4 and y7s
// return Pra