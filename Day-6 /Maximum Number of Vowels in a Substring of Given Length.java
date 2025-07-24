class Solution {
    public int maxVowels(String s, int k) {
        // Define a set for quick vowel lookup
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int currentVowelCount = 0;
        // Calculate initial vowel count for the first window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowelCount++;
            }
        }

        int maxVowelCount = currentVowelCount;

        // Slide the window
        for (int i = k; i < s.length(); i++) {
            // Remove the character leaving the window
            if (vowels.contains(s.charAt(i - k))) {
                currentVowelCount--;
            }
            // Add the character entering the window
            if (vowels.contains(s.charAt(i))) {
                currentVowelCount++;
            }
            // Update the maximum vowel count
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }

        return maxVowelCount;
    }
}         
