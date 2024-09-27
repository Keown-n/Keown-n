package Compaction;

import helpers.Calculators;
import helpers.Reuse;
import helpers.Calculators;
import helpers.Reuse;


public class UCS {

    private double load;
    private double radius;
    private double diameter;
    private double length;
    private double[] UCSValues;
    private double[] ITSValues;
    private double[] compactionValues;
    private double[] UCSmoistureContentValues;
    private double[] ITSmoistureContentValues;
    private double[] HygroscopicMoistureContentValues;
    private double[] materialMassValues;
    private double[] dryDensityValues;
    private double[] averageUCSValues;
    private double[] averageITSValues;
    private double[] averageCompactionValues;
    private double[] averageMoistureContentValues;
    private double[] averageMaterialMassValues;
    private double[] averageDryDensityValues;
    private double[] interpolatedUCSValues;
    private double[] interpolatedITSValues;
    private double[] blowCompactionValues;
    private double[] averageBlowCompactionValues;
    private double[] interpolatedBlowCompactionValues;

    public UCS(double load, double radius, double diameter, double length) {
        this.load = load;
        this.radius = radius;
        this.diameter = diameter;
        this.length = length;
        this.UCSValues = new double[3];
        this.ITSValues = new double[3];
        this.compactionValues = new double[3];
        this.UCSmoistureContentValues = new double[3];
        this.ITSmoistureContentValues = new double[3];
        this.HygroscopicMoistureContentValues = new double[2];
        this.materialMassValues = new double[3];
        this.dryDensityValues = new double[3];
        this.averageUCSValues = new double[3];
        this.averageITSValues = new double[3];
        this.averageCompactionValues = new double[3];
        this.averageMoistureContentValues = new double[3];
        this.averageMaterialMassValues = new double[3];
        this.averageDryDensityValues = new double[3];
        this.interpolatedUCSValues = new double[3];
        this.interpolatedITSValues = new double[3];
        this.blowCompactionValues = new double[22];
        this.averageBlowCompactionValues = new double[22];
        this.interpolatedBlowCompactionValues = new double[22];
    }

    // Get 2 Tin Mass, 2 Dry Tin Mass, and 2 Wet Tin Mass values from the input and calculate the moisture content of each and give the average
    public void calculateUCSMoistureContent(double tinMass1, double dryTinMass1, double wetTinMass1, double tinMass2, double dryTinMass2, double wetTinMass2) {
        double[] moistureContent1 = Reuse.calculateMoistureContent(tinMass1, dryTinMass1, wetTinMass1);
        double[] moistureContent2 = Reuse.calculateMoistureContent(tinMass2, dryTinMass2, wetTinMass2);
        UCSmoistureContentValues[0] = moistureContent1[2];
        UCSmoistureContentValues[1] = moistureContent2[2];
        averageMoistureContentValues[0] = Calculators.ave2(moistureContent1[2], moistureContent2[2], 0);
    }

    // Get 3 Tin Mass, 3 Dry Tin Mass, and 3 Wet Tin Mass values from the input and calculate the moisture content of each and give the average for the UCS
    public void calculateUCSMoistureContent(double tinMass1, double dryTinMass1, double wetTinMass1, double tinMass2, double dryTinMass2, double wetTinMass2, double tinMass3, double dryTinMass3, double wetTinMass3) {
        double[] moistureContent1 = Reuse.calculateMoistureContent(tinMass1, dryTinMass1, wetTinMass1);
        double[] moistureContent2 = Reuse.calculateMoistureContent(tinMass2, dryTinMass2, wetTinMass2);
        double[] moistureContent3 = Reuse.calculateMoistureContent(tinMass3, dryTinMass3, wetTinMass3);
        UCSmoistureContentValues[0] = moistureContent1[2];
        UCSmoistureContentValues[1] = moistureContent2[2];
        UCSmoistureContentValues[2] = moistureContent3[2];
        averageMoistureContentValues[0] = Calculators.Ave3(moistureContent1[2], moistureContent2[2], moistureContent3[2], 0);
    }

     // Get 3 Tin Mass, 3 Dry Tin Mass, and 3 Wet Tin Mass values from the input and calculate the moisture content of each and give the average for the ITS

     public void calculateITSMoistureContent(double tinMass1, double dryTinMass1, double wetTinMass1, double tinMass2, double dryTinMass2, double wetTinMass2, double tinMass3, double dryTinMass3, double wetTinMass3) {
        double[] moistureContent1 = Reuse.calculateMoistureContent(tinMass1, dryTinMass1, wetTinMass1);
        double[] moistureContent2 = Reuse.calculateMoistureContent(tinMass2, dryTinMass2, wetTinMass2);
        double[] moistureContent3 = Reuse.calculateMoistureContent(tinMass3, dryTinMass3, wetTinMass3);
        ITSmoistureContentValues[0] = moistureContent1[2];
        ITSmoistureContentValues[1] = moistureContent2[2];
        ITSmoistureContentValues[2] = moistureContent3[2];
        averageMoistureContentValues[1] = Calculators.Ave3(moistureContent1[2], moistureContent2[2], moistureContent3[2], 0);
     }

    

    // Get the maximum dry density from the input and calculate the compaction for each dry density
    
    


}


    
    // psuedo code
    // caclulate the 55 blow compaction values
    // get 3 tin mass values from the input
    // get 3 dry tin mass values from the input
    // get 3 wet tin mass values from the input
    // calculate the moisture content of each using the calculateMoistureContent method from the Reuse class
    // get the average of the 3 moisture content values
    // get 3 mould mass values from the input
    // get 3 mould volume values from the input
    // get 3 test specimen mass values from the input
    // calculate the material mass for each using the calculateMaterialMass method from the Reuse class
    // get the dry density from the calculateDryDensity method from the Reuse class
    // get the maximum dry density from the input
    // calculate the compaction for each dry density using the calculateCompaction method from the Calculators class
    // get the load values from the input
    // get the radius values from the input
    // calculate the UCS for each load and radius using the calculateUCS method from the Calculators class
    // get the average of the 3 UCS values
    // repeat the above steps till before the get radius values from the input
    // get the diameter values from the input
    // get the length values from the input
    // calculate the ITS for each load, diameter, and length using the calculateITS method from the Calculators class
    // calculate the 22 blow compaction values using the same steps as above
    // interpolate the 100% and 97% UCS and ITS values using the interpolate method from the Calculators class
