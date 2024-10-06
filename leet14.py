class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        # Split the sentences into lists of words
        words1 = sentence1.split()
        words2 = sentence2.split()
        
        # Ensure words1 is the shorter or equal-length list for simplicity
        if len(words1) > len(words2):
            words1, words2 = words2, words1

        # Check if the smaller list is a prefix or suffix of the larger list
        left = 0
        right = len(words1) - 1
        
        # Move `left` from the start while matching words
        while left < len(words1) and words1[left] == words2[left]:
            left += 1
            
        # Move `right` from the end while matching words
        while right >= 0 and words1[right] == words2[len(words2) - len(words1) + right]:
            right -= 1
            
        # If the two pointers cross, all words matched as a prefix or suffix
        return left > right

# Usage example
solution = Solution()
print(solution.areSentencesSimilar("My name is Haley", "My Haley"))  # Output: True
print(solution.areSentencesSimilar("of", "A lot of words"))         # Output: False
print(solution.areSentencesSimilar("Eating right now", "Eating"))   # Output: True
