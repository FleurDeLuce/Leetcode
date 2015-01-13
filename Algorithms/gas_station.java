/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/
public class Solution {
    // The solution is guaranteed to be unique.
    // At most one starting station would statisfy
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null 
            || cost.length == 0 || gas.length != cost.length) return -1;
        int len = gas.length;
        
        int startIndex = 0; // starting gas station index
        int curRemain = 0; // current gas balance
        int afterLoopRemain = 0; // gas balance after touring all gas stations
        for (int i = 0; i < len; i++) {
            if (curRemain >= 0) {
                // if there's still gas, keep moving
                curRemain += gas[i] - cost[i]; 
            }
            else {
                // now it means starting from any station before i would be out of 
                // gas after traveling for a certain distance
                // thus we can start no earlier than i
                // (the tour can be divided into two steps:
                // 1. from a valid starting point to the nth
                // 2. from the end to the starting point
                // if afterLoopRemain is above 0, which means a solution
                // and step 1 ensures we can travel from start station to the nth)
                // otherwise restart from this point
                curRemain = gas[i] - cost[i]; 
                startIndex = i;
            }
            afterLoopRemain += gas[i] - cost[i];
        }
        return afterLoopRemain >= 0 ? startIndex : -1;
    }
}


/*
Solution: 
 
This question is pretty like the longest consecutive sequence problem. 
To check if car can go through the gas stations, we have to check two things,
first, if total gas is enough for total cost, this point can be easily checked by sum all gas[i]-cost[i]. second point, what is the start point? it is a little bit harder to finish in O (n).
However, we can consider this problem in another angel which is if the gas[i]-cost[i]<0 which means the i cannot be an start point. 
 
So we assume start point at 0, and we also declare two varibles which are sum and total, sum is used to record the total from gas[i]-cost[i], 0<=i<=n, unitl  i position. If sum < 0, which means before i can not be start point, then we move start point forward by one and sum reset to 0. 
 
However, in the end, if the final start point is what we want? maybe, it is also decided by the total valuable. total is the sum of all gas[i]-cost[i]. our final start point is valid only when total >= 0,  or we should return -1;
*/
public class Solution {
    // The solution is guaranteed to be unique.
    // At most one starting station would statisfy
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null 
            || cost.length == 0 || gas.length != cost.length) return -1;
        int len = gas.length;
        
        int stationIndex = -1, sum = 0, start = 0, total = 0; 
        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }
}


