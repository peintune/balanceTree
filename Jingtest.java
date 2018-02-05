/**
 * Created by tomiyo on 2018/2/5.
 */
public class Jingtest {

    public static void main(String[] args) {

        int[] array = {1, 6, 3, 4, 3};
        //int[] array = {1, 6, 3, 4, 5};
        int balancePos = array.length / 2;
        int balancePoint= getBalancePoint(array,balancePos, 0);
        System.out.println("balance position :"+balancePoint);
    }

    public static int getBalancePoint(int[] array, int balancePos, int direction) {
        if (array.length < 3 || balancePos==0 || balancePos ==array.length-1) return -1;

        int leftTotalValue = getPartitionArrayTotalValue(array, 0, balancePos - 1);
        int rightTotalValue = getPartitionArrayTotalValue(array, balancePos + 1, array.length - 1);

        if (leftTotalValue == rightTotalValue) {
            return balancePos;
        } else if (leftTotalValue - leftTotalValue > 0) {
            if((direction == -1) || (direction == 0)) {
                balancePos--;
                return getBalancePoint(array, balancePos,-1);
            }else{
                return -1;
            }
        } else {
            if((direction == 1) || (direction == 0)) {
                balancePos++;
                return getBalancePoint(array, balancePos, 1);
            }else {
                return -1;
            }
        }
    }

    public static int getPartitionArrayTotalValue(int[] array, int from, int end) {
        if (from < 0 || end > array.length - 1) return -1;

        int totalValue = 0;
        for (int i = from; i <= end; i++) {
            totalValue += array[i];
        }

        return totalValue;
    }
}
