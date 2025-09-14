public class Sep014 {

    public int startStation(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        return (totalGas >= totalCost) ? startIndex : -1;
    }

    public static void main(String[] args) {
        Sep014 solution = new Sep014();

        int[] gas = {4, 5, 7, 4};
        int[] cost = {6, 6, 3, 5};
        int result = solution.startStation(gas, cost);

        System.out.println("Starting Station Index: " + result);
    }
}
