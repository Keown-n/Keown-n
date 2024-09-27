package UCSClasifier;

public class UCS_Colto {
    public static String CColto(int tGCln, double tPi, double tUcs100, double tucs97, double tIts100) {
        String cgs, tColto;
        boolean cgfound;
        int cbt;
        if (tGCln < 0 || tPi < 0 || tUcs100 < 0 || tucs97 < 0 || tIts100 < 0) {
            return "Invalid input";
        } else {
            tColto = "";
            cbt = 2;
            do {
                cbt++;
                cgfound = Cpassed(tUcs100, tucs97, tIts100, tPi, tGCln, cbt);
            } while (!cgfound);
            cgs = Integer.toString(cbt);
            if (cbt < 5)
                cgs = "C" + cgs;
            else
                cgs = "-";
            tColto = cgs;
            return tColto;
        }
    }
        // Function to check if GCL (Group Classification) is passed
    private static boolean GCLPassed(int tGCln, int mxg) {
        if (tGCln <= mxg)
            return true;
        else
            return false;
    }

        // Function to check if Pi (Plasticity Index) is passed
        private static boolean PiPassed(double tPi, double mxp) {
            if (tPi <= mxp)
                return true;
            else
                return false;
        }

        // Function to check if Ucs100 (Unconfined Compressive Strength at 100% saturation) is passed
        private static boolean Ucs100Passed(double tUcs100, double mnhr, double mxhr) {
            if (tUcs100 >= mnhr && tUcs100 <= mxhr)
                return true;
            else
                return false;
        }

        // Function to check if Ucs97 (Unconfined Compressive Strength at 97% saturation) is passed
        private static boolean Ucs97Passed(double tucs97, double mnns, double mxns) {
            if (tucs97 >= mnns && tucs97 <= mxns)
                return true;
            else
                return false;
        }

        // Function to check if Its100 (Indirect Tensile Strength at 100% saturation) is passed
        private static boolean Its100Passed(double tIts100, double mnk) {
            if (tIts100 >= mnk)
                return true;
            else
                return false;
        }

        // Function to check if C (Classification) is passed
        private static boolean Cpassed(double tUcs100,double tucs97, double tIts100, double tPi, int tGCln, int c) {
            boolean passed = false;
            switch (c) {
                case 1:
                    if (GCLPassed(tGCln,2) && PiPassed(tPi, 4) && Ucs100Passed(tUcs100,6, 6) && Ucs97Passed(tucs97,4, 4))
                        passed = true;
                    break;
                case 2:
                    if (GCLPassed(tGCln,2) && PiPassed(tPi,4) && Ucs100Passed(tUcs100,3, 3) && Ucs97Passed(tucs97,2, 2))
                        passed = true;
                    break;
                case 3:
                    if (GCLPassed(tGCln, 6) && PiPassed(tPi,6) && Ucs100Passed(tUcs100,1.5, 3.0) && Ucs97Passed(tucs97,1.0, 2.0) && Its100Passed(tIts100,250))
                        passed = true;
                    break;
                case 4:
                    if (GCLPassed(tGCln,6) && PiPassed(tPi,6) && Ucs100Passed(tUcs100,0.75, 1.5) && Ucs97Passed(tucs97,0.5, 1.0) && Its100Passed(tIts100,200))
                        passed = true;
                    break;
                case 5:
                    passed = true;
                    break;
            }
            return passed;
        }

// Psuedo code
// classify soil based on the UCS-Colto classification system
// CColto takes in 5 parameters: tGCln, tPi, tUcs100, tucs97, tIts100
// CColto has 5 functions: GCLPassed, PiPassed, Ucs100Passed, Ucs97Passed, Its100Passed
// GCLPassed checks if tGCln is less than or equal to mxg
// PiPassed checks if tPi is less than or equal to mxp
// Ucs100Passed checks if tUcs100 is greater than or equal to mnhr and less than or equal to mxhr
// Ucs97Passed checks if tucs97 is greater than or equal to mnns and less than or equal to mxns
// Its100Passed checks if tIts100 is greater than or equal to mnk
// Cpassed checks if the classification is passed based on the conditions for each of the 5 helper functions
// CColto initializes cgs and tColto
// cbt is initialized to 2
// do while loop to check if classification is passed
// increment cbt
// check if classification is passed
// if cbt is less than 5, then cgs is set to "C" + cbt, else cgs is set to "-"
// tColto is set to cgs
// return tColto

    public static void main(String[] args) {
        // Example usage
        int tGCln = 4;
        double tPi = 3.5;
        double tUcs100 = 2.0;
        double tucs97 = 1.5;
        double tIts100 = 220.0;

        String result = CColto(tGCln, tPi, tUcs100, tucs97, tIts100);
        System.out.println(result);
    }
}

