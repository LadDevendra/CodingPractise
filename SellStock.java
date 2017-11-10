import java.util.Arrays;

//Stock buying purchasing all sorts of problems

public class SellStock {
	//1 transaction allowed, normal method
	public int sellStock1(int[] prices){
		//base edge case
		if(prices == null || prices.length <2)
			return 0;
		int min= prices[0], maxProfit = 0;
		for(int i=1;i<prices.length;i++){
			maxProfit = Math.max(maxProfit, prices[i]-min);
			min = Math.min(min, prices[i]);
		}
		return maxProfit;
	}
	//1 transaction allowed, DP method
		public int sellStockDP1(int[] prices){
			//Base edge case
			if(prices == null || prices.length < 2)
				return 0;
			int len = prices.length, min = prices[0];
			int[] results = new int[len];
			//initialize results matrix
			results[0] = 0;
			//bottom Up DP
			for(int i=1;i<len;i++){
				min = Math.min(min, prices[i]);
				results[i] = Math.max(results[i-1], prices[i] - min);
			}
			//return best solution at last sample. 
			return results[len-1];
		}
		
		//Any number of transactions allowed, maximize the profit.
		public int sellStock2(int[] prices){
			if(prices == null || prices.length <2)
				return 0;
			//add the profit if stock price increases from last observation
			int maxProfit = 0;
			for(int i=1;i<prices.length;i++){
				if(prices[i]-prices[i-1] > 0)
					maxProfit += prices[i] - prices[i-1];
			}
			return maxProfit;
		}
		
		//Only two purchases/transactions are allowed
		public int sellStock3(int[] prices){
			if(prices == null || prices.length<2)
				return 0;
			//DP from left and from right.  max(left+right) should be the maxProfit
			int len = prices.length;
			int[] left = new int[len];
			int[] right = new int[len];
			left[0] = 0;
			int min = prices[0];
			for(int i=1;i<len;i++){
				min = Math.min(min, prices[i]);
				left[i] = Math.max(left[i-1], prices[i] - min);
			}
			right[len-1] = 0;
			int max = prices[len-1];
			for(int i = len-2; i>= 0; i--){
				max = Math.max(max, prices[i]);
				right[i] = Math.max(right[i+1], max-prices[i]);
			}
			int maxProfit = 0;
			for(int i=0;i<len;i++)
				maxProfit = Math.max(maxProfit, left[i]+right[i]);
			return maxProfit;
		}
		//maximize profit in k number of transactions
		public int sellStocks4(int[] prices, int k){
			//Base edge case
			if(prices == null || prices.length<2)
				return 0;
			int len = prices.length;
			
			//DP[transaction][day]
			int[][] DP = new int[k+1][len];
			// 0 transaction 0 profit
			for(int j=0;j<len;j++)
				DP[0][j] = 0;
			//0th day 0 profit
			for(int i=0;i<=k;i++)
				DP[i][0] = 0;
			//Bottom up fill DP
			for(int i=1; i<DP.length;i++){
				for(int j=1; j<DP[0].length;j++){
					int max = Integer.MIN_VALUE;
					for(int m=0; m<j;m++){
						max = Math.max(max, prices[j] - prices[m] + DP[i-1][m]);
					}
					//until yesterday or 1 best transaction today + past best
					DP[i][j] = Math.max(DP[i][j-1], max);
				}
			}
			return DP[k][len-1];
		}
		
		public int sellStocks4opt(int[] prices, int k){
			//Base edge case
			if(prices == null || prices.length<2)
				return 0;
			int len = prices.length;
			
			//DP[transaction][day]
			int[][] DP = new int[k+1][len];
			// 0 transaction 0 profit
			for(int j=0;j<len;j++)
				DP[0][j] = 0;
			//0th day 0 profit
			for(int i=0;i<=k;i++)
				DP[i][0] = 0;
			//Bottom up fill DP
			for(int i=1; i<DP.length;i++){
				int previousDiff = Integer.MIN_VALUE;
				for(int j=1; j<DP[0].length;j++){
					previousDiff = Math.max(previousDiff, DP[i-1][j-1] - prices[j-1]);
					//until yesterday or 1 best transaction today + past best
					DP[i][j] = Math.max(DP[i][j-1], prices[j]+previousDiff);
				}
			}
			return DP[k][len-1];
		}
}
