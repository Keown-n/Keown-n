package Indicator;

public class SieveTrial {

    public class sieves {
        // initialize the arrays
        // met = mass retained
        private int[] met = new int[13];
        // med = mass reduced
        private int[] med = new int[13];
        // pet = percentage retained
        private int[] pet = new int[13];
        // pep = percentage passing
        private int[] pep = new int[13];
        private int MaxSieves = 13;

        public sieves(){
            for (int j = 0; j < MaxSieves; j++) {
                met[j] = 0;
                med[j] = 0;
                pet[j] = 0;
                pep[j] = 100;
            }
        }

        public void setMet(int index, int value){
            met[index] = value;
        }

        public void setMed(int index, int value){
            med[index] = value;
        }

        public void setPet(int index, int value){
            pet[index] = value;
        }

        public void setPep(int index, int value){
            pep[index] = value;
        }

        public int getMet(int index){
            return met[index];
        }
        
        public int getMed(int index){
            return med[index];
        }

        public int getPet(int index){
            return pet[index];
        }

        public int getPep(int index){
            return pep[index];
        }

        // calculate the reduction factor
        public double ReductionFactor(double rs, double ts) {
            double rf;
            if (rs > 0 && ts > 0) {
                rf = (rs / ts);
            } else {
                rf = 0;
            }
            return Math.round(rf * 10) / 10.0;
        }

        // calculate the mass Percentage retained
        public double MassPerRetained(double mr, double tm) {
            double m;
            if (mr > 0 && tm > 0) {
                m = (mr / tm * 100);
            } else {
                m = 0;
            }
            return Math.round(m * 10) / 10.0;
        }

        // calculate the mass Reduced
        public double MassReduced(double mr, double rf) {
            double m;
            if (mr > 0) {
                m = mr * rf;
            } else {
                m = 0;
            }
            return Math.round(m * 10) / 10.0;
        }

        // add the reduced mass to the med array
        
        // add 
        // calculate the percentage passing
        public double PercentagePassing0075(double a, double b, double sf) {
            double p;
            if (a > 0 && b > 0) {
                p = (sf * (a - b) / a);
            } else {
                p = 0;
            }
            return Math.round(p * 10) / 10.0;
        }

        // calculate the grading modulus
        public double GradingModulus(double a, double b, double c) {
            double gm = (300 - (a + b + c)) / 100;
            return Math.round(gm * 10) / 10.0;
        }

        // calculate the cumulative percent passing for each sieve size
        public void CumulativePercentPassing(int pc100) {
            for (int k = pc100 - 2; k >= 1; k--) {
                pep[k] = pep[k + 1] - pet[k];
            }
        }

        // calculate the percent finer than each sieve size
        public void PercentFiner(int pc100, double totMass) {
            for (int j = 0; j < pc100 - 1; j++) {
                pet[j] = (int) (Math.round(med[j] / totMass * 1000) / 10);
            }
        }

        // calculate the total mass of the reduced soil
        public double TotalReducedMass(int pc100) {
            double tm = 0;
            for (int j = 0; j < pc100 - 1; j++) {
                tm += med[j];
            }
            return tm;
        }

    }
}