
/**
 * Created by rbhoompally on 2/12/18.
 */
public class RoundRobin {
//    public float getAverageWaitingTime(int[] burstTimes, int[] arrivalTimes, int quantum) {
//        if (arrivalTimes.length != burstTimes.length) {
//            return -1;
//        }
//
//        if (burstTimes.length == 0) {
//            return 0;
//        }
//
//        int[] waitingTimes = getWaitingTimes(burstTimes, arrivalTimes, quantum);
//        int waitingSum = 0;
//        for (int i = 0; i < waitingTimes.length; i++) {
//            waitingSum += waitingTimes[i];
//        }
//
//        return waitingSum / waitingTimes.length;
//    }

//    private int[] getWaitingTimes(int[] burstTimes, int[] arrivalTimes, int quantum) {
//        int[] waitingTimes = new int[burstTimes.length];
//        int[] remainingBurstTimes = Arrays.copyOf(burstTimes, burstTimes.length);
//        int currentTime = 0;
//
//        while (true) {
//            boolean done = true;
//            for (int i = 0; i < burstTimes.length; i++) {
//                if (remainingBurstTimes[i] > 0) {
//                    // Still processing
//                    done = false;
//
//                    if (remainingBurstTimes[i] > quantum) {
//                        remainingBurstTimes[i] -= quantum;
//                        currentTime += quantum;
//                    } else {
//                        // Last step. Process is about to finish
//                        currentTime += remainingBurstTimes[i];
//                        waitingTimes[i] = currentTime - burstTimes[i] - arrivalTimes[i];
//                        remainingBurstTimes[i] = 0;
//                    }
//                }
//            }
//            if (done) {
//                break;
//            }
//        }
//
//        return waitingTimes;
//    }
}
