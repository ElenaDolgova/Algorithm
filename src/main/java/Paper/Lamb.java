package Paper;

import java.lang.invoke.LambdaConversionException;

public class Lamb implements Comparable {
    public double freq;
    public String mode;

    Lamb(double freq, String mode) {
        this.freq = freq;
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "freq: " + freq + " mode:" + mode;
    }


    @Override
    public int compareTo(Object o) {
        if (((Lamb) o).freq - this.freq < 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
