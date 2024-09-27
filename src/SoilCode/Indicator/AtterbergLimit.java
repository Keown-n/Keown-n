// steps for AtterBerg Limit

// 1. Get the weight of the empty container (W1)
// 2. Get the weight of the container with wet soil (W2)
// 3. Get the weight of the container with dry soil (W3)
// 4. Calculate the weight of the wet soil (W2 - W1)
// 5. Calculate the weight of the dry soil (W3 - W1)
// 6. Calculate the moisture content (Wet soil weight - Dry soil weight) / Dry soil weight * 100
// do this for all the samples
// for the liquid limit use the number of taps to determine the LiquidLimitFactor according to the table
// times the LiquidLimitFactor by the moisture content to get the liquid limit
// calculate the average of the liquid limits
// for the plastic limit get the average of the 2 moistures
// get the Plastic Index by subtracting the plastic limit from the liquid limit
// get the % linear shrinkage by deviding the mm shrinkage by the length of the sample
// if the plastic index is less than 24 use the Linear Shrinkage Factor in table 2 to get the Linear Shrinkage
// if the plastic index is greater than 24 use the Linear Shrinkage Factor in table 3 to get the Linear Shrinkage

package Indicator;

import helpers.Calculators;

public class AtterbergLimit {

	private double weightOfEmptyContainer;
	private double weightOfContainerWithWetSoil;
	private double weightOfContainerWithDrySoil;
	private double numberOfTaps;
	private double mmShrinkage;
	private double lengthOfSample;

	public AtterbergLimit(double weightOfEmptyContainer, double weightOfContainerWithWetSoil, double weightOfContainerWithDrySoil, double numberOfTaps, double mmShrinkage, double lengthOfSample) {
		this.weightOfEmptyContainer = weightOfEmptyContainer;
		this.weightOfContainerWithWetSoil = weightOfContainerWithWetSoil;
		this.weightOfContainerWithDrySoil = weightOfContainerWithDrySoil;
		this.numberOfTaps = numberOfTaps;
		this.mmShrinkage = mmShrinkage;
		this.lengthOfSample = lengthOfSample;
	}

    public double getLiquidLimit() {
        double wetSoilWeight = weightOfContainerWithWetSoil - weightOfEmptyContainer;
        double drySoilWeight = weightOfContainerWithDrySoil - weightOfEmptyContainer;
        double moistureContent = ((wetSoilWeight - drySoilWeight) / drySoilWeight) * 100;
        double liquidLimitFactor = AtterbergLimitFactors.getLL((int) numberOfTaps);
        return liquidLimitFactor * moistureContent;
    }

    public double getPlasticLimit() {
        double wetSoilWeight = weightOfContainerWithWetSoil - weightOfEmptyContainer;
        double drySoilWeight = weightOfContainerWithDrySoil - weightOfEmptyContainer;
        double moistureContent = ((wetSoilWeight - drySoilWeight) / drySoilWeight) * 100;
        return Calculators.ave2(drySoilWeight, moistureContent, 0);
    }

    public double getPlasticIndex() {
        return getLiquidLimit() - getPlasticLimit();
    }

    public double getLinearShrinkage() {
        double linearShrinkageFactor = AtterbergLimitFactors.getLS((int) numberOfTaps);
        if (getPlasticIndex() < 24) {
            return linearShrinkageFactor;
        } else {
            return linearShrinkageFactor;
        }
    }

    public double getPercentLinearShrinkage() {
        return mmShrinkage / lengthOfSample;
    }

    public double getPlasticityIndex() {
        return getLiquidLimit() - getPlasticLimit();
    }

}

