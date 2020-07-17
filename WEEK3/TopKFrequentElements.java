public class TopKFrequentElements {

    class Solution {

        class Item {
            int data;
            int freq;
            Item(int data, int freq) {
                this.data = data;
                this.freq = freq;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            PriorityQueue<Item> q = new PriorityQueue<>(freqMap.size(), (a, b) -> {
                return b.freq - a.freq;
            });

            for (int key : freqMap.keySet())
                q.add(new Item(key, freqMap.get(key)));

            int[] topKFrequent = new int[k];

            int index = 0;
            while (k-- > 0) {
                topKFrequent[index++] = q.poll().data;
            }

            return topKFrequent;
        }
    }
}
