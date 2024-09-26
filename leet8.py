class Solution:
    def intToRoman(self, num: int) -> str:
        # Mapping of integer values to Roman numerals
        roman_map = [
            (1000, "M"),
            (900, "CM"),
            (500, "D"),
            (400, "CD"),
            (100, "C"),
            (90, "XC"),
            (50, "L"),
            (40, "XL"),
            (10, "X"),
            (9, "IX"),
            (5, "V"),
            (4, "IV"),
            (1, "I")
        ]
        
        result = ""
        
        # Iterate over the roman_map, from largest to smallest value
        for value, symbol in roman_map:
            # While we can subtract value from num, append the symbol
            while num >= value:
                result += symbol
                num -= value
                
        return result
