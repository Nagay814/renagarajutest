package com.rewardPoint;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class Transaction {

	private int price;
	private int rewards;
	private LocalDate transactionDate;
	private LocalDate lastModifiedDate;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	Transaction(int price,LocalDate transactionDate) {
		this.price = price;
		this.rewards = calculateRewards(price);
		this.transactionDate = transactionDate;
	}

	/** calculate reward points*/
	static int calculateRewards(int price) {
		if (price >= 50 && price < 100) {
			return price - 50;
		} else if (price > 100) {
			return (2 * (price - 100) + 50);
		}
		return 0;
	}
}
