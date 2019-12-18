package com.rewardPoint;

import java.time.LocalDate;
import java.util.List;

public class CallerReward {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now();
		LocalDate lastMonth =now.minusMonths(1);
		Transaction t1 = new Transaction(120,lastMonth);// Transaction 1 spent input 120
		System.out.println("Reward  Point" + t1.getRewards());// Output :rewards 90

		LocalDate lastMonthBeforeMonth =now.minusMonths(2);
		Transaction t2 = new Transaction(150,lastMonthBeforeMonth);// Transaction 1 spent input 120
		System.out.println("Reward  Point" + t2.getRewards());// Output :rewards 150

		
		LocalDate thirdMonth =now.minusMonths(3);
		Transaction t3 = new Transaction(200,thirdMonth);// Transaction 1 spent input 120
		System.out.println("Reward  Point" + t3.getRewards());// Output :rewards 150

		
		TransactionList list = new TransactionList();

		List<Transaction> transactionList = list.getAllTransactions();

		/** adding t1 and t2 transactions to list iterate it */
		System.out.println("******************list of transactions **************");
		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t3);
		//transactionList.forEach((o) -> System.out.println(o.getRewards()));

		/** adding t1 and t2 transactions to list iterate it */
		System.out.println("******************Reward Points per the last three months **************");
		double[] rewardPointsPerMonth = list.rewardPerMonth();

		for (double rewardPoints : rewardPointsPerMonth) {
			System.out.println(rewardPoints);
		}
	}

}
