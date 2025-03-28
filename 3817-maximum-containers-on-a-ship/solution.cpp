class Solution {
public:
    int maxContainers(int n, int w, int maxWeight) {
        return w*n*n<=maxWeight?n*n:maxWeight/w;
    }
};
