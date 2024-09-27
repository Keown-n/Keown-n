package helpers;
public class Calculators {

  // Calculate the Dry Density (DDen)
  public static int DDen(double ws, double vo, double w) {
    double d;
    if (ws > 0 && vo > 0) {
      d = (ws * 100000 / vo) / (100 + w);
    } else {
      d = 0;
    }
    return (int) Math.round(d);
  }

  // if wet density and volume are known
  // Calculate the Dry Density (DDen)
  // dry density = (wet density * 100000 / volume) / (100 + water added)
  // else dry density = 0


  // Calculate the Compaction (Comp)
  public static double Comp(double den, double md) {
    double c;
    if (den > 0 && md > 0) {
      c = (den / md * 100);
    } else {
      c = 0;
    }
    return Math.round(c * 10) / 10.0;
  }

  // if dry density and maximum density are known
  // Calculate the Compaction (Comp)
  // compaction = (dry density / maximum density) * 100
  // else compaction = 0
  // return a rounded compaction value

  // Calculate the Average of three values (Ave3)
  public static double Ave3(double r1, double r2, double r3, int d) {
    int n = 0;
    if (r1 > 0) {
      n++;
    }
    if (r2 > 0) {
      n++;
    }
    if (r3 > 0) {
      n++;
    }
    double ans, r;
    if (n > 0) {
      r = (r1 + r2 + r3) / n;
      switch (d) {
        case 0:
          ans = Math.round(r);
          break;
        case 1:
          ans = Math.round(r * 10) / 10.0;
          break;
        case 2:
          ans = Math.round(r * 100) / 100.0;
          break;
        case 3:
          ans = Math.round(r * 1000) / 1000.0;
          break;
        case 4:
          ans = Math.round(r * 10000) / 10000.0;
          break;
        default:
          ans = 0;
      }
    } else {
      ans = 0;
    }
    return ans;
  }

public static double PMC(double wm, double dm, double cm) {
    double ans;
    if (wm > 0 && dm > 0) {
      ans = Math.round((wm - dm) / (dm - cm) * 1000) / 10.0;
    } else {
      ans = 0;
    }
    return ans;
  }

  public static double interpolate(double Ly, double Hy, double Lx, double Hx, double X) {
    return Ly + (Hy - Ly) * (X - Lx) / (Hx - Lx);
}
  public static double cup(byte d, double minl, double maxl, double minp, double maxp, double v) {
    double ans;
    ans = Math.log(minl) + (Math.log(maxl) - Math.log(minl)) * (v - minp) / (maxp - minp);

    ans = Math.exp(ans * Math.log(10));
    return ans;
  }
    public static double puc(double minl, double maxl, double minp, double maxp, double v) {
    double ans;

    if (minl == maxl) {
      ans = 88;
    } else {
      ans = minp + (Math.log(v) - Math.log(minl)) * (maxp - minp) / (Math.log(maxl) - Math.log(minl));
    }

    return ans;
  }
  // Calculate the Average of three values (Ave3)
  // set n to 0
  // if r1 > 0, increment n
  // if r2 > 0, increment n
  // if r3 > 0, increment n
  // if n > 0, 
  // average = (r1 + r2 + r3) / n
  // case 0: round the average
  // case 1: round the average to one decimal place
  // case 2: round the average to two decimal places
  // case 3: round the average to three decimal places
  // case 4: round the average to four decimal places
  // else average = 0
  // return the average

  // Calculate the Unconfined Compressive Strength (UCS)
  public static double UCS(double Lo, double Ra) {
    double u;
    if (Lo > 0 && Ra > 0) {
      u = (1000 * Lo) / (Math.PI * Ra * Ra);
      u = Math.round(u * 100) / 100.0;
    } else {
      u = 0;
    }
    return u;
  }
  // Calculate the Unconfined Compressive Strength (UCS)
  // if the load and radius are greater than 0
  // ucs = (1000 * load) / (PI * radius * radius)
  // calculate the unconfined compressive strength
  // else unconfined compressive strength = 0
  // return the unconfined compressive strength

  // Calculate the Indirect Tensile Strength (ITS)
  public static double ITS(double Lo, double di, double le) {
    double i;
    if (Lo > 0 && di > 0 && le > 0) {
      i = (2 * Lo) / (Math.PI * (le / 1000) * (di / 1000));
      i = Math.round(i);
    } else {
      i = 0;
    }
    return i;
  }

  // Calculate the Indirect Tensile Strength (ITS)
  // if the load, diameter, and length are greater than 0
  // its = (2 * load) / (PI * (length / 1000) * (diameter / 1000))
  // else indirect tensile strength = 0
  // return the indirect tensile strength
 
  // calculate moisture content

  // round method
  public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();
    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
  }

public static double ave2(double r1, double r2, int d) {
    int n = 0;
    if (r1 > 0) {
      n++;
    }
    if (r2 > 0) {
      n++;
    }
    double ans, r;
    if (n > 0) {
      r = (r1 + r2) / n;
      switch (d) {
        case 0:
          ans = Math.round(r);
          break;
        case 1:
          ans = Math.round(r * 10) / 10.0;
          break;
        case 2:
          ans = Math.round(r * 100) / 100.0;
          break;
        case 3:
          ans = Math.round(r * 1000) / 1000.0;
          break;
        case 4:
          ans = Math.round(r * 10000) / 10000.0;
          break;
        default:
          ans = 0;
      }
    } else {
      ans = 0;
    }
    return ans;
  }

  public static double ave4(double r1, double r2, double r3, double r4, int d) {
    int n = 0;
    if (r1 > 0) {
      n++;
    }
    if (r2 > 0) {
      n++;
    }
    if (r3 > 0) {
      n++;
    }
    if (r4 > 0) {
      n++;
    }
    double ans, r;
    if (n > 0) {
      r = (r1 + r2 + r3 + r4) / n;
      switch (d) {
        case 0:
          ans = Math.round(r);
          break;
        case 1:
          ans = Math.round(r * 10) / 10.0;
          break;
        case 2:
          ans = Math.round(r * 100) / 100.0;
          break;
        case 3:
          ans = Math.round(r * 1000) / 1000.0;
          break;
        case 4:
          ans = Math.round(r * 10000) / 10000.0;
          break;
        default:
          ans = 0;
      }
    } else {
      ans = 0;
    }
    return ans;
  }

public static double calculateCompaction(double d, double maximumDryDensity) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateCompaction'");
}

public static double calculateUCS(double d, double e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'calculateUCS'");
}
}