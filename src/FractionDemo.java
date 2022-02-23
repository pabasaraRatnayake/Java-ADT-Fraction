public class FractionDemo {
    public static void main (String[] args){
        ADTFraction f1 = new ADTFraction();
        f1.display();
        f1.set(12,30);
        f1.display();
        ADTFraction f2 = new ADTFraction(3,7);
        f2.display();
        ADTFraction f3 = f1.plus(f2);
        f3.display();
        f3.refine();
        f3.display();
        ADTFraction f4 = f1.times(3);
        f4.display();
        f4.refine();
        f4.display();
        ADTFraction f5 = f1.times(f2);
        f5.display();
        f5.refine();
        f5.display();
        ADTFraction f6 = f1.reciprocal();
        f6.display();
        float value = f1.value();
        System.out.println("Fraction value = " + value);
    }
}

class ADTFraction {
    private int n; //numerator
    private int d; //denomenator

    public ADTFraction() {//default constructor
        this.n = 0;
        this.d = 1;
    }

    public ADTFraction(int a, int b) {//parameter constructor
        set(a, b);
    }

    public void set(int a, int b) {//set numerator and denomenator
        if(b!=0){
            this.n = a;
            this.d = b;
        }else {
            this.n = 0;
            this.d = 1;
            System.out.println("Invalid denominator");
        }
    }

    public ADTFraction plus(ADTFraction x) {//add two fractions
        int neu, comDen, max;
        if(this.d>x.d){
            max = this.d;
        } else {
            max = x.d;
        }
        comDen = max;
        while (true) {
            if (comDen % this.d == 0 && comDen % x.d == 0) {
                break;
            } else {
                comDen = comDen + max;
            }
        }
        neu = comDen/this.d*this.n + comDen/x.d*x.n;
        ADTFraction ans = new ADTFraction(neu,comDen);
        return ans;
    }

    public ADTFraction times(int a) {//multiply fraction by a number
        int neu, den;
        neu = this.n*a;
        den = this.d;
        return new ADTFraction(neu,den);
    }

    public ADTFraction times(ADTFraction x) {//multiply two fractions
        int neu, den;
        neu = this.n*x.n;
        den = this.d*x.d;
        return new ADTFraction(neu,den);
    }

    public ADTFraction reciprocal() {//reciprocal of a fraction
        return new ADTFraction(this.d,this.n);
    }

    public float value() {//numerical value of a fraction
        return  (float) this.n / this.d;
    }

    public void display() {//display the fraction in the format n/d
        System.out.println("Fraction = " + this.n + "/" + this.d);
    }

    public void refine() {//set the instance to its minimum fraction
        int min;
        if (this.n > this.d){
            min = this.d;
        } else {
            min = this.n;
        }

        for (int i=min; i>=2 ; i--){
            if(this.n%i == 0 && this.d%i == 0){
                this.n = this.n/i;
                this.d = this.d/i;
            }
        }
    }
}