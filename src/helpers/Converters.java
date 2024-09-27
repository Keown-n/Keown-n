package helpers;
public class Converters {


// Convert an integer to a 3-digit string
public static String IntToStr3(int n) {
  String s3;
  if (n < 10) {
    s3 = "00" + Integer.toString(n);
  } else if (n < 100) {
    s3 = "0" + Integer.toString(n);
  } else if (n < 1000) {
    s3 = Integer.toString(n);
  } else {
    s3 = "...";
  }
  return s3;
}

// Psuedo code
// IntToStr3(n) converts an integer to a 3-digit string
// if n is less than 10, then s3 is equal to '00' + n
// else if n is less than 100, then s3 is equal to '0' + n
// else if n is less than 1000, then s3 is equal to n
// else s3 is equal to '...'
// return s3

// Convert an integer to a 2-digit string
public static String IntToStr2(int n) {
  String s2;
  if (n < 10) {
    s2 = "0" + Integer.toString(n);
  } else if (n < 100) {
    s2 = Integer.toString(n);
  } else {
    s2 = "..";
  }
  return s2;
}

// Psuedo code
// IntToStr2(n) converts an integer to a 2-digit string
// if n is less than 10, then s2 is equal to '0' + n
// else if n is less than 100, then s2 is equal to n
// else s2 is equal to '..'
// return s2

public static double[] calculateMoistureContent(double tinMass, double dryTinMass, double wetTinMass) {
  double dryMass = calculateMaterialMass(tinMass, dryTinMass);
  double wetMass = calculateMaterialMass(tinMass, wetTinMass);
  double moistureContent = (wetMass - dryMass) / dryMass * 100;

  return new double[] { dryMass, wetMass, moistureContent };
}
// pseuodocode
// Calculate the MoistureContent
// Call the calculateMaterialMass method to get the DryMass
// Call the calculateMaterialMass method to get the WetMass
// Subtract the DryMass from the WetMass and divide by the DryMass to get the MoistureContent
// Return the DryMass, WetMass and MoistureContent as an array

// Divide the MoistureMass by the DryTinMass to get the MoistureContent
//Calculate the MaterialMass by subtracting SampleMass from the ContainerMass
public static double calculateMaterialMass(double containerMass, double sampleMass) {
  return sampleMass - containerMass;
}

//calculateMaterialMass method
//Subtract the ContainerMass from the SampleMass to get the MaterialMass and return it

//Calculate the WetDensity by dividing the MaterialMass by the MouldVolume
public static double calculateWetDensity(double materialMass, double mouldVolume) {
  return materialMass / mouldVolume;
}

//calculateWetDensity method
//Divide the MaterialMass by the MouldVolume to get the WetDensity and return it

//Calculate the DryDensity by dividing the WetDensity by 1 + MoistureContent
public static double calculateDryDensity(double wetDensity, double moistureContent) {
  return wetDensity / (1 + moistureContent / 100);
}

//calculateDryDensity method
//Divide the WetDensity by 1 + MoistureContent to get the DryDensity and return it

//Calculate the correction factor by subtracting the MoistureContent from the moisture added then that makes an average
public static double calculateCorrectionFactor(double moistureAdded, double moistureContent) {
  return moistureAdded - moistureContent;
}

//calculateCorrectionFactor method
//Subtract the MoistureContent from the MoistureAdded to get the CorrectionFactor and return it
}