package com.extras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InumberFromText {
	private List<Integer> numbers;

	public InumberFromText(String filePath) {
		numbers = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				numbers.add(Integer.parseInt(line.trim()));
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getRandomNumber() {
		if (numbers.isEmpty()) {
			System.out.println("No more numbers left.");
			return -1; // Or handle the case as per your requirement
		}
		Random random = new Random();
		int index = random.nextInt(numbers.size());
		int randomNumber = numbers.get(index);
		numbers.remove(index);
		return randomNumber;
	}

	public void printRemainingNumbers() {
		System.out.println("Numbers remaining: " + numbers.size() + "/" + numbers.size() + "]");
	}


	public static void main(String[] args) {
		InumberFromText dataProvider = new InumberFromText("src/main/resources/numbers.txt");

		while (true) {
			int randomNumber = dataProvider.getRandomNumber();
			if (randomNumber == -1) {
				break;
			}
			System.out.println("Random Number: " + randomNumber);
			dataProvider.printRemainingNumbers();
		}
	}
}
