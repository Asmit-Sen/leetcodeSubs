class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        if (mass < asteroids[0]) return false;
        long planet = mass;
        for(int i=0; i<asteroids.length-1; i++){
            if (planet + asteroids[i] < asteroids[i+1] ) return false;
            planet += asteroids[i];
        }
        return true;
    }
}
