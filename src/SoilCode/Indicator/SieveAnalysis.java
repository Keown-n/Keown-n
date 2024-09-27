package Indicator;

// weigh the soil sample before sieveing store it as SampleMass
// ask user if reduction is required
// if yes 

// sieve the soil through the {"100.0";"75.0";"63.0";"50,0";"37.5";"28,0";"20,0"} sieves
// weigh the soil retained on each sieve and store it in RetainedMass[]
// weigh the soil passing the 20.0 sieve and store it as Passing20Mass


// then riffle the soild passing the 20.0 sieve to get the fines
// weigh the fines and store it as RifflingMass
// calculate the ReductionFactor by dividing the RifflingMass by the Passing20Mass
// sieve the reduced soil through the {"14,0";"5,00";"2.00";"0.425";-0.425} sieves


// calculate the reduced mass for the course fraction by multiplying the RetainedMass by the ReductionFactor
// store the reduced mass in ReducedMass[]
// weigh the soil retained on each sieve and store it in ReducedMass[]

// calculate the TotalReducedMass by adding all the ReducedMass[]

// calculate the percentageretained for each sieve by dividing the ReducedMass by the TotalReducedMass store it as PercentRetained[]
// calculate the CumanlativePercentPassing for each sieve by subtracting the PercentRetained from 100 then the next percentRetained from the previous CumanlativePercentPassing


// take 50g of the soil passing the 0.425 sieve and store it as finesUsed
// dry the finesUsed and weigh it as DryFines
// calculate the PercentPassing075 with formula (SF(A-B)/A)*100
// SF = CumulativePercentPassing of the 0.425 sieve
// A = 50
// B = DryFines

// calculate the Grading Modulas with the last 3 values of the CumulativePercentPassing subtractring 100 from each then get the sum and devide by 100


// else sieve all the soil through all the sieves
// weigh the soil retained on each sieve and store it as RetainedMass
// calculate the PercentRetained for each sieve by dividing the RetainedMass by the SampleMass
// calculate the CumanlativePercentPassing for each sieve by subtracting the PercentRetained from 100 then the next percentRetained from the previous CumanlativePercentPassing

// take 50g of the soil passing the 0.425 sieve and store it as finesUsed
// dry the finesUsed and weigh it as DryFines
// calculate the PercentPassing075 with formula (SF(A-B)/A)*100
// SF = CumulativePercentPassing of the 0.425 sieve
// A = 50
// B = DryFines

// calculate the Grading Modulas with the last 3 values of the CumulativePercentPassing subtractring 100 from each then get the sum and devide by 100

