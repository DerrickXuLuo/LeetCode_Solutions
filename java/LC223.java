/**
 * @Author Derrick
 * @CreateTime 6/9/2020 12:58 PM
 * @Desc
 */
public class LC223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);

        //If overlap
        int overlap = 0;
        if (right > left && top > bottom){
            overlap = (right - left) * (top - bottom);
        }

        return areaA + areaB - overlap;
    }
}