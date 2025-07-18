class RandomizedSet {
    HashMap<Integer, Integer> mpp;
    ArrayList<Integer> list;
    Random rand;

    public RandomizedSet() {
        mpp = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(mpp.containsKey(val)){
            return false;
        }else{
            mpp.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(mpp.containsKey(val))
        {
           int idx = mpp.get(val);
           int last = list.get(list.size() - 1);

           list.set(idx, last);
           mpp.put(last, idx);

           list.remove(list.size() - 1);
           mpp.remove(val);

           return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */