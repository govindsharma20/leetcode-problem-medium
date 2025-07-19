
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(new ArrayList<>(), target, candidates, 0);
        
        return result;
    }

    private void backtrack(List<Integer> currentCombination, int remainingTarget, int[] candidates, int startIndex) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (remainingTarget < 0) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainingTarget) {
                break; 
            }

            currentCombination.add(candidates[i]);
            
            backtrack(currentCombination, remainingTarget - candidates[i], candidates, i);
            
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
