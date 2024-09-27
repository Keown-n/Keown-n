
package UCSClasifier;
public class UCS_ColtoTest {

    
public static void main(String[] args) {
    // Test case 1: All conditions passed, expected output: "C3"
    int tGCln1 = 4;
    double tPi1 = 3.5;
    double tUcs1001 = 2.0;
    double tucs971 = 1.5;
    double tIts1001 = 220.0;
    String result1 = UCS_Colto.CColto(tGCln1, tPi1, tUcs1001, tucs971, tIts1001);
    System.out.println("COLTO: " + result1); // Output: C3
    result1 = UCS_TMH14.CTrh(tGCln1, tPi1, tUcs1001, tucs971, tIts1001);
    System.out.println("TRH: " + result1); // Output: C3

    // Test case 2: Only GCLPassed condition passed, expected output: "-"
    int tGCln2 = 7;
    double tPi2 = 3.5;
    double tUcs1002 = 2.0;
    double tucs972 = 1.5;
    double tIts1002 = 220.0;
    String result2 = UCS_Colto.CColto(tGCln2, tPi2, tUcs1002, tucs972, tIts1002);
    System.out.println("COLTO: " + result2); // Output: -
    result2 = UCS_TMH14.CTrh(tGCln2, tPi2, tUcs1002, tucs972, tIts1002);
    System.out.println("TRH: " + result2); // Output: -

    // Test case 3: Only PiPassed condition passed, expected output: "-"
    int tGCln3 = 4;
    double tPi3 = 5.0;
    double tUcs1003 = 2.0;
    double tucs973 = 1.5;
    double tIts1003 = 220.0;
    String result3 = UCS_Colto.CColto(tGCln3, tPi3, tUcs1003, tucs973, tIts1003);
    System.out.println("COLTO: " + result3); // Output: -
    result3 = UCS_TMH14.CTrh(tGCln3, tPi3, tUcs1003, tucs973, tIts1003);
    System.out.println("TRH: " + result3); // Output: -

    // Test case 4: Only Ucs100Passed condition passed, expected output: "-"
    int tGCln4 = 4;
    double tPi4 = 3.5;
    double tUcs1004 = 7.0;
    double tucs974 = 1.5;
    double tIts1004 = 220.0;
    String result4 = UCS_Colto.CColto(tGCln4, tPi4, tUcs1004, tucs974, tIts1004);
    System.out.println("COLTO: " + result4); // Output: -
    result4 = UCS_TMH14.CTrh(tGCln4, tPi4, tUcs1004, tucs974, tIts1004);
    System.out.println("TRH: " + result4); // Output: -

    // Test case 5: All conditions failed, expected output: "Invalid input"
    int tGCln5 = -1;
    double tPi5 = -2.0;
    double tUcs1005 = -3.0;
    double tucs975 = -4.0;
    double tIts1005 = -5.0;
    String result5 = UCS_Colto.CColto(tGCln5, tPi5, tUcs1005, tucs975, tIts1005);
    System.out.println("COLTO: " + result5); // Output: Invalid input

    // testcase 6 : expected output: "C4"
    int tGCln6 = 6;
    double tPi6 = 6.0;
    double tUcs1006 = 1.5;
    double tucs976 = 1.0;
    double tIts1006 = 250.0;
    String result6 = UCS_Colto.CColto(tGCln6, tPi6, tUcs1006, tucs976, tIts1006);
    System.out.println("COLTO: " + result6); // Output: C4
    result6 = UCS_TMH14.CTrh(tGCln6, tPi6, tUcs1006, tucs976, tIts1006);
    System.out.println("TRH: " + result6); // Output: C4

}
}