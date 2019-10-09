package lab.trigonometric;

import lab.AbstractFunction;
import lab.Functions;

import static java.lang.Double.NaN;
import static java.lang.Math.PI;


public class Cotangent extends AbstractFunction {
    {
        table.put(-PI, NaN);
        table.put(-PI / 2, 0.0);
        table.put(0.0, NaN);
        table.put(PI / 2, 0.0);
        table.put(PI, NaN);

        table.put(3 * PI / 4, -1.0);
        table.put(-3 * PI / 4, 1.0);
        table.put(PI / 4, 1.0);
        table.put(-PI / 4, -1.0);
        function = Functions.COTANGENT;
    }

    private Sinus sinus;
    private Cosinus cosinus;

    public Cotangent(double precision) {
        super(precision);
        sinus = new Sinus(precision);
        cosinus = new Cosinus(precision);
    }

    @Override
    public void setPrecision(double precision) {
        super.setPrecision(precision);
        sinus.setPrecision(precision);
        cosinus.setPrecision(precision);
    }

    @Override
    protected double calculate(double arg) {
        double cos = cosinus.calculate(arg);
        double sin = sinus.calculate(arg);
        if (Math.abs(sin) < DELTA) {
            return NaN;
        }
        return cos / sin;
    }

    @Override
    protected double calculateStub(double arg) {
        double cos = Math.cos(arg);
        double sin = Math.sin(arg);
        if (Math.abs(sin) < DELTA) {
            return NaN;
        }
        return cos / sin;
    }
}