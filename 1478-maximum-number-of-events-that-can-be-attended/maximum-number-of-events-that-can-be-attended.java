class Solution {
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        
        int days = events[0][0];
        int i = 0;
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(!pq.isEmpty() || i < n)
        {
            // Add all events starting on the current day
            while (i < n && events[i][0] == days) {
                pq.add(events[i][1]);
                i++;
            }
            // Remove all events that have already ended
            while (!pq.isEmpty() && pq.peek() < days) {
                pq.poll();
            }

            days++;

            // Attend the event that ends earliest
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

        }

        return count;
    }
}