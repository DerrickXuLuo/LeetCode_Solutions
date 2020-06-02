
/**
 * @Author Derrick
 * @CreateTime 6/2/2020 1:24 PM
 * @Desc
 */
public class LC166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0){
            return "0";
        }else if (denominator == 0){
            return null;
        }

        StringBuilder ans = new StringBuilder();

        //First step: "+" or "-"
        ans.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        //Integral part
        ans.append(num / den);
        num %= den;
        if (num == 0){
            return ans.toString();
        }

        //Fractional part
        ans.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, ans.length());
        while (num != 0){
            num *= 10;
            ans.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                ans.insert(index, "(");
                ans.append(")");
                break;
            }else {
                map.put(num, ans.length());
            }
        }

        return ans.toString();
    }
}
