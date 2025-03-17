class TimeMap {
    HashMap<String, TreeMap<Integer, String>> mpp;
    public TimeMap() {
        mpp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp)
    {
        TreeMap<Integer, String> timeMap;
        if (mpp.containsKey(key)) 
        {
           timeMap = mpp.get(key);
        }else{
            timeMap = new TreeMap<>();
            mpp.put(key, timeMap);
        }
        timeMap.put(timestamp, value);
    }
    public int stamp(HashMap<Integer, String> demo, int time)
    {
        int left = 0;
        int right = time;
        int ans = -1;

        while(left <= right)
        {
            int mid = left + (right - left) / 2;

            if(demo.containsKey(mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;

    }
    public String get(String key, int timestamp)
    {
     if(mpp.containsKey(key)){
        TreeMap<Integer, String> timeMap = mpp.get(key);
        Integer floorKey = timeMap.floorKey(timestamp);
         if (floorKey != null) {
                return timeMap.get(floorKey);
            }
     }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */