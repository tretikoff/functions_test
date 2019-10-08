package lab.logarithmic;

import lab.AbstractFunction;
import lab.Functions;

import static java.lang.Double.*;


public class LogN extends AbstractFunction {

    private boolean isStub = true;
    Ln ln;

    public LogN(double precision) {
        super(precision);
        ln = new Ln(precision);
    }
    @Override
    protected double calculate(double arg) {
        return 0;
    }

    @Override
    public void setFuncIsStub(boolean funcIsStub) {
        super.setFuncIsStub(funcIsStub);
        this.isStub = funcIsStub;
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        ln.setPrecision(precision);
    }

    protected double log(double arg, int base) {
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }

        if (Math.abs(arg - base) < DELTA) {
            return 1d;
        }

        if (Math.abs(arg - 1d) < DELTA) {
            return 0d;
        }

        if (arg == 0.0) {
            return NEGATIVE_INFINITY;
        }
        return ln.calc(arg) / ln.calc(base);
    }
}