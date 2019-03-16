/**
 * Created by rbhoompally on 1/6/18.
 */
public class InsertMIntoN {
    public int insertMintoN(int N, int M, int i, int j) {
        int all1sUptoJ = -1 << (j + 1);
        int all1sFromI = (1 << i) - 1;
        int clearIToJ = all1sUptoJ | all1sFromI;
        int moveM = M << i;
        int clearBits = N & clearIToJ;
        return moveM | clearBits;
    }
}
