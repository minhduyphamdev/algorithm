from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        sum = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                sum += prices[i] - prices[i-1]

        return sum

    # way 2
    def maxProfit2(self, prices: List[int]) -> int:
        cur_hold, cur_not_hold = float('-inf'), 0
        for stock in prices:
            prev_hold, prev_not_hold = cur_hold, cur_not_hold
            cur_hold = max(prev_hold, prev_not_hold - stock)
            cur_not_hold = max(prev_not_hold, prev_hold + stock)

        return cur_not_hold


solution = Solution()
print(solution.maxProfit([7, 1, 5, 3, 6, 4]))
print(solution.maxProfit([1, 2, 3, 4, 5]))

print(solution.maxProfit2([7, 1, 5, 3, 6, 4]))
print(solution.maxProfit2([1, 2, 3, 4, 5]))
