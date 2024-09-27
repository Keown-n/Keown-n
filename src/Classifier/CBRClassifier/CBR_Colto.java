package CBRClassifier;

public class CBR_Colto {
    public static String classifySoil(double[] Pp, double Gm, double Sw, boolean calcrete, double c90, double c93, double c95, double c98, int aLL, int aPI, double aLS, int mxL) {
        String grade = "";
        for (int i = 1; i <= 9; i++) {
            if (Gpassed(i, Pp, Gm, Sw, calcrete, c90, c93, c95, c98, aLL, aPI, aLS, mxL) != "") {
                grade = Gpassed(i, Pp, Gm, Sw, calcrete, c90, c93, c95, c98, aLL, aPI, aLS, mxL);
            }
        }
        return grade;
    }

    public static String Gpassed(int g, double[] Pp, double Gm, double Sw, boolean calcrete, double c90, double c93, double c95, double c98, int aLL, int aPI, double aLS, int mxL) {
        switch (g) {
            // case 1:
            //     if (SaPassed(g,Pp) && AttPassed(g, 25, 5, 2, calcrete)){
            //     }
            // case 2:
            //     if (SaPassed(g,Pp) && AttPassed(g, 25, 6, 3, calcrete)) {
            //         return "Class " + g;
            //     }
            // case 3:
            //     if (SaPassed(g,Pp) && AttPassed(g, 25, 6, 3, calcrete)) {
            //         return "Class " + g;
            //     }
            //     break;
            case 4:
                if (SaPassed(g,Pp) && AttPassed(g, 25, 6, 3,calcrete) && CbrPassed(98, 80,c98) && SwPassed(Sw, 0.2)) {
                    return "Class " + g;
                }
                break;
            case 5:
                if (SaPassed(g,Pp) && GmPassed(Gm, 1.5, 2.5) && AttPassed(g, 30, 10, 5,calcrete) && CbrPassed(95, 45, c95) && SwPassed(Sw, 0.5)) {
                    return "Class " + g;
                }
                break;
            case 6:
                if (GmPassed(Gm, 1.2, 2.6) && AttPassed(g, -1, Math.max(12, (int) (2 * Gm + 10)), 5,calcrete) && CbrPassed(95, 25,c95) && SwPassed(Sw,1.0)) {
                    return "Class " + g;
                }
                break;
            case 7:
                if (GmPassed(Gm, 0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7,calcrete) && CbrPassed(93, 15, c93) && SwPassed(Sw,1.5)) {
                    return "Class " + g;
                }
                break;
            case 8:
                if (GmPassed(Gm, 0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7,calcrete) && CbrPassed(93, 10, c93) && SwPassed(Sw, 1.5)) {
                    return "Class " + g;
                }
                break;
            case 9:
                if (GmPassed(Gm, 0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7,calcrete) && CbrPassed(93, 7, c93) && SwPassed(Sw, 1.5)) {
                    return "Class " + g;
                }
                break;
        }
        return "-";
    }

    public static boolean S63Passed(double[] Pp) {
        return Pp[8] >= 99.5 && Pp[8] <= 100.5;
    }

    public static boolean S50Passed(double[] Pp) {
        return Pp[0] >= 4.5 && Pp[0] <= 15.5 && Pp[1] >= 9.5 && Pp[1] <= 30.5 && Pp[2] >= 19.5 && Pp[2] <= 50.5 && Pp[3] >= 29.5 && Pp[3] <= 65.5 && Pp[5] >= 59.5 && Pp[5] <= 90.5 && Pp[7] >= 84.5 && Pp[7] <= 100.5;
    }

    public static boolean S37Passed(double[] Pp) {
        return Pp[0] >= 3.5 && Pp[0] <= 12.5 && Pp[1] >= 10.5 && Pp[1] <= 24.5 && Pp[2] >= 22.5 && Pp[2] <= 40.5 && Pp[3] >= 35.5 && Pp[3] <= 53.5 && Pp[4] >= 58.5 && Pp[4] <= 75.5 && Pp[5] >= 70.5 && Pp[5] <= 84.5 && Pp[6] >= 83.5 && Pp[6] <= 94.5 && Pp[7] >= 99.5 && Pp[7] <= 100.5;
    }

    public static boolean S28Passed(double[] Pp) {
        return Pp[0] >= 4.5 && Pp[0] <= 12.5 && Pp[1] >= 12.5 && Pp[1] <= 27.5 && Pp[2] >= 26.5 && Pp[2] <= 45.5 && Pp[3] >= 41.5 && Pp[3] <= 60.5 && Pp[4] >= 70.5 && Pp[4] <= 84.5 && Pp[5] >= 84.5 && Pp[5] <= 95.5 && Pp[6] >= 99.5 && Pp[6] <= 100.5;
    }

    public static boolean S2Passed(double[] Pp) {
        return Pp[2] >= 19.5 && Pp[2] <= 70.5;
    }

    public static boolean GmPassed(double Gm, double min, double max) {
        return Gm >= min && Gm <= max;
    }

    public static boolean SaPassed(int g, double[] Pp) {
        switch (g) {
            case 1:
                return S63Passed(Pp);
            case 2:
                return S50Passed(Pp);
            case 3:
                return S37Passed(Pp);
            case 4:
                return S28Passed(Pp);
            case 5:
                return S2Passed(Pp);
            default:
                return false;
        }
    }

    public static boolean AttPassed(int g, int aLL, int aPI, double aLS, boolean calcrete) {
        return LlPassed(aLL) && PiPassed(g, aPI, calcrete) && LsPassed(g, aLS, calcrete);
    }

    public static boolean LlPassed(int aLL) {
        return aLL <= 15 || aLL <= 17;
    }

    public static boolean PiPassed(int g, double aPI, boolean calcrete) {
        return !calcrete && g < 7 && (aPI <= 15 || aPI <= 17);
    }

    public static boolean LsPassed(int g, double aLS,boolean calcrete) {
        return !calcrete && g < 7 && (aLS <= 6 || aLS <= 7);
    }

    public static boolean CbrPassed(int CBR, double mnC, double c) {
        switch (CBR) {
            case 90:
                return c >= mnC;
            case 93:
                return c >= mnC;
            case 95:
                return c >= mnC;
            case 98:
                return c >= mnC;
            default:
                return false;
        }
    }

    public static boolean SwPassed(double Sw, double mxS) {
        return Sw <= mxS;
    }
}


    // classify the soil according to the CBR-Colto classification
    // fuction gColto takes 10 parameters and returns a classification string
    // the function has 5 helper functions to check if the soil grade is passed
    // these helper functions are called: S63Passed, S50Passed, S37Passed, S28Passed, S2Passed
    // S63Passed returns true if the value of Pp[8] is between 99.5 and 100.5
    // S50Passed returns true if the value of Pp[0] is between 4.5 and 15.5, Pp[1] is between 9.5 and 30.5, Pp[2] is between 19.5 and 50.5, Pp[3] is between 29.5 and 65.5, Pp[5] is between 59.5 and 90.5, and Pp[7] is between 84.5 and 100.5
    // S37Passed returns true if the value of Pp[0] is between 3.5 and 12.5, Pp[1] is between 10.5 and 24.5, Pp[2] is between 22.5 and 40.5, Pp[3] is between 35.5 and 53.5, Pp[4] is between 58.5 and 75.5, Pp[5] is between 70.5 and 84.5, Pp[6] is between 83.5 and 94.5, and Pp[7] is between 99.5 and 100.5
    // S28Passed returns true if the value of Pp[0] is between 4.5 and 12.5, Pp[1] is between 12.5 and 27.5, Pp[2] is between 26.5 and 45.5, Pp[3] is between 41.5 and 60.5, Pp[4] is between 70.5 and 84.5, Pp[5] is between 84.5 and 95.5, and Pp[6] is between 99.5 and 100.5
    // S2Passed returns true if the value of Pp[2] is between 19.5 and 70.5
    // the function also has 5 helper functions to check if the soil grade is passed
    // these helper functions are called: GmPassed, SaPassed, AttPassed, CbrPassed, SwPassed
    // GmPassed checks if the grading modulus Gm is passed
    // SaPassed checks if the soil grade Sa is passed
    // AttPassed has 3 helper functions to check if the liquid limit (aLL), plasticity index (aPI), and liquid limit (aLS) are passed
    // these helper functions are called: LlPassed, PiPassed, LsPassed
    // LlPassed checks aLL value is less than or equal to 15 or 17
    // PiPassed checks first if the soil contains calcrete, then checks if the Class value is less than 7 and if the aPI value is less than or equal to 15 or 17
    // LsPassed checks first if the soil contains calcrete, then checks if the Class value is less than 7 and if the aLS value is less than or equal to 6 or 7
    // CbrPassed checks if the CBR value is passed by comparing it to the specified value mnC
    // swPassed checks if the Sw value is passed by comparing it to the specified value mxS
    // using a switch statement, the function checks if the soil grade G is passed
    // for Classes
    // 1 to 3, the function checks if SaPassed(g) && AttPassed(g, 25, 5, 2) && CbrPassed(98, 80)
    // 4, the function checks if SaPassed(g) && AttPassed(g, 25, 6, 3) && CbrPassed(98, 80) && SwPassed(0.2)
    // 5, the function checks if SaPassed(g) && GmPassed(1.5, 2.5) && AttPassed(g, 30, 10, 5) && CbrPassed(95, 45) && SwPassed(0.5)
    // 6, the function checks if GmPassed(1.2, 2.6) && AttPassed(g, -1, Math.max(12, (int) (2 * Gm + 10)), 5) && CbrPassed(95, 25) && SwPassed(1.0)
    // 7, the function checks if GmPassed(0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7) && CbrPassed(93, 15) && SwPassed(1.5)
    // 8, the function checks if GmPassed(0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7) && CbrPassed(93, 10) && SwPassed(1.5)
    // 9, the function checks if GmPassed(0.75, 2.7) && AttPassed(g, -1, Math.max(12, (int) (3 * Gm + 10)), 7) && CbrPassed(93, 7) && SwPassed(1.5)
    // 10, if none of the above conditions are met, the function returns grade 10
    // else grade 10 is passed
    // the function initializes the soil grade to an empty string and the counter to 4
    // the function loops through the possible grades and calls the Gpassed function to check if the grade is passed
    // if the grade is passed, the function returns the grade as a string
    // the function returns the final soil grade as a string by calling the helper function Gpassed to loop through the possible grades and find the first valid grade
    // if no valid grade is found, the function returns "-"
    