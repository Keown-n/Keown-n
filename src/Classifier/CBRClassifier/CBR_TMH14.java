package CBRClassifier;
// import helper round function
import helpers.Calculators;
public class CBR_TMH14 {
    // Private Variables
    
    // GTrh function to classify the soil according to the CBR-TRH14 classification
    public static String GTrh(double[] Pp, double Gm, double aLL, double aPI, double aLS, double c90, double c93, double c95, double c98, double mdSw) {
        String tgs = "";

        // Check if S63Passed condition is met
        if (S63Passed(Pp)) {
            tgs = "G1";
        } else if (S50Passed(Pp)) {
            tgs = "G2";
        } else if (S37Passed(Pp)) {
            tgs = "G3";
        } else if (S28Passed(Pp)) {
            tgs = "G4";
        } else if (S2Passed(Pp)) {
            tgs = "G5";
        } else {
            int tbt = 4;
            boolean cgfound = false;
            do {
                tbt++;
                cgfound = Gpassed(tbt, Pp, Gm, aLL, aPI, aLS, c90, c93, c95, c98, mdSw);
            } while (!cgfound);
            if (tbt > 10) {
                tgs = "-";
            } else {
                tgs = "G" + tbt;
            }
        }
        return tgs;
    }

        // Check if S63Passed condition is met
    private static boolean S63Passed(double[] Pp) {
            return (Pp[8] > 99.5 && Pp[8] < 100.5);
        }

        // Check if S50Passed condition is met
    private static boolean S50Passed(double[] Pp) {
            return (Pp[0] > 4.5 && Pp[0] < 15.5 && Pp[1] > 9.5 && Pp[1] < 30.5 && Pp[2] > 19.5 && Pp[2] < 50.5 && Pp[3] > 29.5 && Pp[3] < 65.5 && Pp[5] > 59.5 && Pp[5] < 90.5 && Pp[7] > 84.5 && Pp[7] < 100.5);
        }

        // Check if S37Passed condition is met
    private static boolean S37Passed(double[] Pp) {
            return (Pp[0] > 3.5 && Pp[0] < 12.5 && Pp[1] > 10.5 && Pp[1] < 24.5 && Pp[2] > 22.5 && Pp[2] < 40.5 && Pp[3] > 35.5 && Pp[3] < 53.5 && Pp[4] > 58.5 && Pp[4] < 75.5 && Pp[5] > 70.5 && Pp[5] < 84.5 && Pp[6] > 83.5 && Pp[6] < 94.5 && Pp[7] > 99.5 && Pp[7] < 100.5);
        }

        // Check if S28Passed condition is met
    private static boolean S28Passed(double[] Pp) {
            return (Pp[0] > 4.5 && Pp[0] < 12.5 && Pp[1] > 12.5 && Pp[1] < 27.5 && Pp[2] > 26.5 && Pp[2] < 45.5 && Pp[3] > 41.5 && Pp[3] < 60.5 && Pp[4] > 70.5 && Pp[4] < 84.5 && Pp[5] > 84.5 && Pp[5] < 95.5 && Pp[6] > 99.5 && Pp[6] < 100.5);
        }

        // Check if S2Passed condition is met
    private static boolean S2Passed(double[] Pp) {
            return (Pp[2] > 19.5 && Pp[2] < 70.5);
        }

        // Check if GmtPassed condition is met
    private static boolean GmtPassed(double gr, double Gm) {
            return (Gm >= gr);
        }

        // Check if SaPassed condition is met
    private static boolean SaPassed(int gc, double[] Pp) {
            boolean SaPass = false;
            switch (gc) {
                case 1:
                case 2:
                    SaPass = S37Passed(Pp);
                    break;
                case 3:
                    SaPass = (S28Passed(Pp) || S37Passed(Pp));
                    break;
                case 4:
                    SaPass = (S50Passed(Pp) || S28Passed(Pp) || S37Passed(Pp));
                    break;
                case 5:
                    SaPass = S2Passed(Pp);
                    break;
            }
            return SaPass;
        }

        // Check if AttPassed condition is met
        private static boolean AttPassed(double mxLL, double mxPI, double mxLS, double aLL, double aPI, double aLS) {
            boolean AttPass;
            AttPass = (LlPassed(mxLL,aLL) && PiPassed(mxPI,aPI) && LsPassed(mxLS,aLS));
            return AttPass;
        }

        
        private static boolean LlPassed(double mxLL,double aLL) {
            boolean LlPass;
            if (mxLL < 0) {
                LlPass = true;
            } else {
                LlPass = (aLL <= mxLL);
            }
            return LlPass;
        }

        private static boolean PiPassed(double mxPI, double aPI) {
            return (aPI <= mxPI);
        }

        private static boolean LsPassed(double mxLS, double aLS) {
            boolean LsPass;
            if (mxLS < 0) {
                LsPass = true;
            } else {
                LsPass = (aLS <= mxLS);
            }
            return LsPass;
        }


        // Check if CbrPassed condition is met
        private static boolean CbrPassed(int p, double mnC, double c) {
            boolean CbrPass;
            switch (p) {
                case 90:
                    CbrPass = (c >= mnC);
                    break;
                case 93:
                    CbrPass = (c >= mnC);
                    break;
                case 95:
                    CbrPass = (c >= mnC);
                    break;
                case 98:
                    CbrPass = (c >= mnC);
                    break;
                default:
                    CbrPass = false;
                    break;
            }
            return CbrPass;
        }

        // Check if SwPassed condition is met
        private static boolean SwPassed(double mxS, double mdSw) {
            return (mdSw <= mxS);
        }

        // Check if Gpassed condition is met
        private static boolean Gpassed(int g, double[] Pp, double Gm, double aLL, double aPI, double aLS, double c90, double c93, double c95, double c98, double mdSw) {
            boolean Gpassed = false;
        c90 = Calculators.round(c90, 0);
        c93 = Calculators.round(c93, 0);
        c95 = Calculators.round(c95, 0);
        c98 = Calculators.round(c98, 0);
            switch (g) {
                case 5:
                    Gpassed = (SaPassed(g,Pp) && GmtPassed(1.5,Gm) && AttPassed(30, 10, 5,aLL,aPI,aLS) && CbrPassed(95, 45,c95) && SwPassed(0.5,mdSw));
                    break;
                case 6:
                    Gpassed = (GmtPassed(1.2,Gm) && AttPassed(-1, Math.max(12, (int) (3 * Gm + 10)), -1,aLL,aPI,aLS) && CbrPassed(93, 25,c93) && SwPassed(1.0,mdSw));
                    break;
                case 7:
                    Gpassed = (GmtPassed(0.75,Gm) && AttPassed(-1, Math.max(12, (int) (3 * Gm + 10)), -1,aLL,aPI,aLS) && CbrPassed(93, 15, c93) && SwPassed(1.5,mdSw));
                    break;
                case 8:
                    Gpassed = (CbrPassed(90, 10,c90) && SwPassed(1.5,mdSw));
                    break;
                case 9:
                    Gpassed = (CbrPassed(90, 7,c90) && SwPassed(1.5,mdSw));
                    break;
                case 10:
                    Gpassed = (CbrPassed(90, 3,c90) && SwPassed(1.5,mdSw));
                    break;
                case 11:
                    Gpassed = true;
                    break;
            }
            return Gpassed;

 
    }

    public static void main(String[] args) {
        // Test the GTrh function
        double[] Pp = { 100, 20, 40, 60, 80, 90, 95, 99, 100 };
        double Gm = 1.5;
        double aLL = 30;
        double aPI = 10;
        double aLS = 5;
        double c90 = 90;
        double c93 = 93;
        double c95 = 95;
        double c98 = 98;
        double mdSw = 0.5;

        String result = GTrh(Pp, Gm, aLL, aPI, aLS, c90, c93, c95, c98, mdSw);
        System.out.println(result);
    }
}

// pseudo code
// classify the soil according to the CBR-TRH14 classification
// The function GTrh takes 9 parameters and returns the soil classification
// The function GTrh has 10 helper functions to check the conditions for each soil classification
// these helper functions are S63Passed, S50Passed, S37Passed, S28Passed, S2Passed, GmtPassed, SaPassed, CSRPass, AttPassed, CbrPassed, SwPassed, Gpassed
// S63Passed checks if the values of Pp[8] are between 99.5 and 100.5 and returns a boolean value
// S50Passed checks if the values of Pp[0] are between 4.5 and 15.5, Pp[1] are between 9.5 and 30.5, Pp[2] are between 19.5 and 50.5, Pp[3] are between 29.5 and 65.5, Pp[5] are between 59.5 and 90.5, Pp[7] are between 84.5 and 100.5 and returns a boolean value
// S37Passed checks if the values of Pp[0] are between 3.5 and 12.5, Pp[1] are between 10.5 and 24.5, Pp[2] are between 22.5 and 40.5, Pp[3] are between 35.5 and 53.5, Pp[4] are between 58.5 and 75.5, Pp[5] are between 70.5 and 84.5, Pp[6] are between 83.5 and 94.5, Pp[7] are between 99.5 and 100.5 and returns a boolean value
// S28Passed checks if the values of Pp[0] are between 4.5 and 12.5, Pp[1] are between 12.5 and 27.5, Pp[2] are between 26.5 and 45.5, Pp[3] are between 41.5 and 60.5, Pp[4] are between 70.5 and 84.5, Pp[5] are between 84.5 and 95.5, Pp[6] are between 99.5 and 100.5 and returns a boolean value
// S2Passed checks if the values of Pp[2] are between 19.5 and 70.5 and returns a boolean value
// GmtPassed checks if the value of Gm is greater than or equal to the given parameter gr and returns a boolean value
// SaPassed checks the conditions for each soil classification based on the given parameter gc and returns a boolean valu
// AttPassed has 3 helper functions LlPassed, PiPassed, LsPassed to check the conditions for each soil classification based on the given parameters mxLL, mxPI, mxLS and returns a boolean value
   // LlPassed checks if the value of aLL is less than or equal to mxLL and returns a boolean value
    // PiPassed checks if the value of aPI is less than or equal to mxPI and returns a boolean value
    // LsPassed checks if the value of aLS is less than or equal to mxLS and returns a boolean value
// CbrPassed checks the conditions for each soil classification based on the given parameters p, mnC and returns a boolean value
// SwPassed checks if the value of mdSw is less than or equal to mxS and returns a boolean value
// Gpassed checks the conditions for each soil classification based on the given parameter g and returns a boolean value
// RndCbr function is used to round the values of c90, c93, c95, c98
// The main function tests the GTrh function with sample input values and prints the result
// if the soil classification is not found, it returns "-" else it returns the soil classification


