class Solution {
    public long flowerGame(int petals, int players) {
        long upperHalfPetals = (petals + 1) / 2;
        long upperHalfPlayers = (players + 1) / 2;
        long lowerHalfPetals = petals / 2;
        long lowerHalfPlayers = players / 2;

        return upperHalfPetals * lowerHalfPlayers + lowerHalfPetals * upperHalfPlayers;
    }
}
