package Indicator;

public class AtterbergLimitFactors {
// get the Liquid Limit factor according to the number of taps
public static double getLL(int taps) {
  double LiqLim;
  if (taps < 20)
    LiqLim = 0.974;
  else if (taps > 30)
    LiqLim = 1.022;
    else {
      LiqLim = 0.974 + (0.005 * (taps - 20));
    }
  return LiqLim;
}

// psuedo code for the above function
// get the Liquid Limit factor according to the number of taps
// if the number of taps is less than 20, then the Liquid Limit factor is 0.974
// if the number of taps is greater than 30, then the Liquid Limit factor is 1.022
// if the number of taps is between 20 and 30, then the Liquid Limit factor is calculated based on the number of taps
// the Liquid Limit factor is calculated based on the following formula:
// Liquid Limit factor = 0.974 + (0.005 * (taps - 20))
// where taps is the number of taps used in the test
// return the Liquid Limit factor


// get the Linear shrinkage factor according to the number of taps
public static double getLS(int taps) {
  double LinShrink;
  if (taps < 15)
    LinShrink = 0.60;
  else if (taps > 35)
    LinShrink =0.74;
  else {
    switch (taps) {
      case 15:
        LinShrink =0.60;
        break;
      case 16:
        LinShrink =0.61;
        break;
      case 17:
        LinShrink =0.61;
        break;
      case 18:
        LinShrink =0.62;
        break;
      case 19:
        LinShrink =0.62;
        break;
      case 20:
        LinShrink =0.63;
        break;
      case 21:
        LinShrink =0.64;
        break;
      case 22:
        LinShrink =0.65;
        break;
      case 23:
        LinShrink =0.66;
        break;
      case 24:
        LinShrink =0.66;
        break;
      case 25:
        LinShrink =0.67;
        break;
      case 26:
        LinShrink =0.67;
        break;
      case 27:
        LinShrink =0.68;
        break;
      case 28:
        LinShrink =0.69;
        break;
      case 29:
        LinShrink =0.69;
        break;
      case 30:
        LinShrink =0.70;
        break;
      case 31:
        LinShrink =0.71;
        break;
      case 32:
        LinShrink =0.72;
        break;
      case 33:
        LinShrink =0.72;
        break;
      case 34:
        LinShrink =0.73;
        break;
      case 35:
        LinShrink =0.74;
        break;
      default:
        LinShrink =0.0;
        break;
    }
  }
  return LinShrink;
}
}
// psuedo code for the above function
// get the Linear shrinkage factor according to the number of taps
// if PI is 24 then use the following values for the linear shrinkage factors
// if the number of taps is less than 15, then the Linear shrinkage factor is 0.60
// if the number of taps is greater than 35, then the Linear shrinkage factor is 0.74
// if the number of taps is between 15 and 35, then the Linear shrinkage factor is calculated based on the number of taps
// the Linear shrinkage factor is calculated based on the following formula:
// Linear shrinkage factor = 0.60 for 15 taps, 0.61 for 16 taps, 0.61 for 17 taps, 0.62 for 18 taps, 0.62 for 19 taps, 0.63 for 20 taps, 0.64 for 21 taps, 0.65 for 22 taps, 0.66 for 23 taps, 0.66 for 24 taps, 0.67 for 25 taps, 0.67 for 26 taps, 0.68 for 27 taps, 0.69 for 28 taps, 0.69 for 29 taps, 0.70 for 30 taps, 0.71 for 31 taps, 0.72 for 32 taps, 0.72 for 33 taps, 0.73 for 34 taps, 0.74 for 35 taps
// if pi is between 24 and 30 use the following values for the linear shrinkage factors
// if the number of taps is less than 15, then the Linear shrinkage factor is 0.64
// if the number of taps is greater than 35, then the Linear shrinkage factor is 0.70
// Linear shrinkage factor = 0.64 for 15 taps, 0.64 for 16 taps, 0.64 for 17 taps, 0.65 for 18 taps, 0.65 for 19 taps, 0.65 for 20 taps, 0.66 for 21 taps, 0.66 for 22 taps, 0.66 for 23 taps, 0.67 for 24 taps, 0.67 for 25 taps, 0.67 for 26 taps, 0.67 for 27 taps, 0.68 for 28 taps, 0.68 for 29 taps, 0.68 for 30 taps, 0.69 for 31 taps, 0.69 for 32 taps, 0.69 for 33 taps, 0.69 for 34 taps, 0.70 for 35 taps
// where taps is the number of taps used in the test
// return the Linear shrinkage factor