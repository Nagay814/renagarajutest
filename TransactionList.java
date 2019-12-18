package com.rewardPoint;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class TransactionList {
	ArrayList<Transaction> list = new ArrayList<Transaction>();

	List<Transaction> getLast3MonthsList() {
	
		LocalDate now = LocalDate.now();
		LocalDate threeOldDate=now.minusMonths(3);
		List<Transaction> filteredList = list.stream()
				.filter(trans -> trans.getTransactionDate().compareTo(threeOldDate) == 0).collect(Collectors.toList());

		return filteredList;

	}

	public List<Transaction> getAllTransactions() {

		Collections.sort(this.list, (o1, o2) -> o1.getTransactionDate().compareTo(o2.getLastModifiedDate()));
		return this.list;
	}

	public void addTransaction(int price,LocalDate transactionDate) {
		Transaction transaction = new Transaction(price,transactionDate);
		this.list.add(transaction);
	}

	public double getTotalRewards() {

		return this.list.stream().mapToInt(i -> i.getRewards()).sum();
	}

	public double[] rewardPerMonth() {
		double[] last3MonthRewardsInDesc = new double[3];
		AtomicInteger ordinal = new AtomicInteger(0);
		for (int i = 0; i < 3; i++) {
			ordinal.updateAndGet(n -> n + 1);
			List<Transaction> filteredList = this.list.stream().filter(trans -> trans.getTransactionDate().getMonth() == LocalDate.now().minusMonths(ordinal.get()).getMonth()).collect(Collectors.toList());
			
			last3MonthRewardsInDesc[i] = filteredList.stream().mapToInt(o -> o.getRewards()).sum();
		}
		return last3MonthRewardsInDesc;
	}
}