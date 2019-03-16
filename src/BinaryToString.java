/**
 * Created by rbhoompally on 2/3/18.
 */
public class BinaryToString {
    public String BinaryToString(double value) {
        String error = "ERROR";
        if (value < 0 || value > 1) {
            return error;
        }

        if (value == 0 || value == 1) {
            return String.valueOf(value);
        }

        StringBuffer sb = new StringBuffer();
        sb.append("0");
        sb.append(".");

        double match  = 0;
        int power = 1;
        while (match < value) {
            double add = 1 / Math.pow(2, power);

            if ((match + add) <= value) {
                match += add;
                sb.append("1");
            } else {
                sb.append("0");
            }
            power ++;

            if (sb.length() > 32) {
                return error;
            }
        }

        if (match == value) {
            return sb.toString();
        }
        return error;
}
}
