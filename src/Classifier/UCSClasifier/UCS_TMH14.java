package UCSClasifier;

public class UCS_TMH14 {
    public static String CTrh(int tGCln,  double tPi, double tUcs100, double tucs97, double tIts100) {
        String cgs, tTrh;
        boolean cgfound;
        int tbt;

        tTrh = "";
        tbt = 2;
        do {
            tbt++;
            cgfound = Cpassed(tUcs100, tucs97, tIts100, tPi, tGCln, tbt);
        } while (!cgfound);
        cgs = Integer.toString(tbt);
        if (tbt < 5)
            cgs = "C" + cgs;
        else
            cgs = "-";
        tTrh = cgs;
        return tTrh;
    }

        // Check if GCL (Group Classification) is passed
        private static boolean GCLPassed(int tGCln, int mxg) {
            if (tGCln <= mxg)
                return true;
            else
                return false;
        }

        // Check if Pi is passed
        private static boolean PiPassed(double tPi, double mxp) {
            if (tPi <= mxp)
                return true;
            else
                return false;
        }

        // Check if Ucs100 (Unconfined Compressive Strength) is passed
        private static boolean Ucs100Passed(double tUcs100, double mnhr, double mxhr) {
            if (tUcs100 >= mnhr && tUcs100 <= mxhr)
                return true;
            else
                return false;
        }

        // Check if Its100 (Indirect Tensile Strength) is passed
        private static boolean Its100Passed(double tIts100, double mnk) {
            if (tIts100 >= mnk)
                return true;
            else
                return false;
        }

        private static boolean Ucs97Passed(double tucs97, int mn97, int mx97) {
            if (tucs97 >= mn97 && tucs97 <= mx97)
                return true;
            else
                return false;
        }

        // Check if C (Classification) is passed
        private static boolean Cpassed(double tUcs100, double tUcs97, double tIts100, double tPi, int tGCln, int c) {
            boolean passed = false;
            switch (c) {
                case 1:
                    if (GCLPassed(tGCln,2) && PiPassed(tPi,4) && Ucs100Passed(tUcs100,0,6) && Ucs97Passed(tUcs97,0,4))
                        passed = true;
                    break;
                case 2:
                    if (GCLPassed(tGCln,2) && PiPassed(tPi,4) && Ucs100Passed(tUcs100,0,3) && Ucs97Passed(tUcs97,0,2))
                        passed = true;
                    break;
                case 3:
                    if (GCLPassed(tGCln, 6) && PiPassed(tPi,6) && Ucs100Passed(tUcs100,1.5, 3.0) && Its100Passed(tIts100,250))
                        passed = true;
                    break;
                case 4:
                    if (GCLPassed(tGCln, 6) && PiPassed(tPi,6) && Ucs100Passed(tUcs100,0.75, 1.5) && Its100Passed(tIts100,200))
                        passed = true;
                    break;
                case 5:
                    passed = true;
                    break;
            }
            return passed;
        }

    //psuedo code
    //Classify the soil based on the TRH14 classification system
    //CTrh takes in 5 parameters: tGCln, tPi, tUcs100, tucs97, tIts100
    //CTrh has 5 functions: GCLPassed, PiPassed, Ucs100Passed, Ucs97Passed, Its100Passed
    //CTrh has a variable tTrh which is initialized to an empty string
    //CTrh has a variable tbt which is initialized to 2
    //CTrh has a variable cgfound which is initialized to false
    //CTrh has a variable cgs which is initialized to an empty string
    //GCLPassed checks if the Group Classification is passed
    //PiPassed checks if Pi is passed
    //Ucs100Passed checks if Ucs100 is passed by checking if it is within the range of mnhr and mxhr
    //Its100Passed checks if Its100 is passed by checking if it is greater than or equal to mnk
    //Cpassed checks if the classification is passed based on the conditions
    //tTrh is set to an empty string
    //tbt is initialized to 2
    //do increment tbt and check if classification is passed
    //if tbt is less than 5, then cgs is set to "C" + tbt, else cgs is set to "-"
    //tTrh is set to cgs
    //return tTrh



    public static void main(String[] args) {
        // Example usage
        int tGCln = 4;
        double tPi = 3.5;
        double tUcs100 = 2.0;
        double tucs97 = 3.0;
        double tIts100 = 150.0;

        String result = CTrh(tGCln, tPi, tUcs100, tucs97, tIts100);
        System.out.println(result);
    }
}