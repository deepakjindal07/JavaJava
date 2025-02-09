
package stockPrice;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleFinanceScraper1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		String[] tickers = { "LTFOODS", "TIMETECHNO", "NATCOPHARM" };
		int[] quantities = { 1245, 762, 115 };

		while (true)
		{
			clearConsole(); // Clear the console for real-time update
			System.out.println("Fetching stock prices at " + getCurrentTime() + "...");
			int grandTotal = 0;

			for (int i = 0; i < tickers.length; i++)
			{
				int totalValue = GetValueofTicker(tickers[i], quantities[i]);
				grandTotal += totalValue;
			}

			String formattedTotal = NumberFormat.getInstance(Locale.of("en", "IN")).format(grandTotal);
			System.out.println("\nGrand Total Value of All Stocks: Rs." + formattedTotal);
			System.out.println("----------------------------------");

			Thread.sleep(60000); // Pause for 5 seconds before the next update
		}
	}

	private static int GetValueofTicker(String ticker, int quantity) throws IOException {
		String url = "https://www.google.com/finance/quote/" + ticker + ":NSE";
		try
		{
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			Elements priceElement = doc.select(".YMlKec.fxKbKc");


			if (!priceElement.isEmpty())
			{
				String price = priceElement.text().replaceAll("[^\\d.]", "");
				double priceDouble = Double.parseDouble(price);
				int priceInt = (int) Math.round(priceDouble);
				int totalValue = priceInt * quantity;

				String formattedTotalValue = NumberFormat.getInstance(Locale.of("en", "IN")).format(totalValue);
				System.out.println("Current Price of " + ticker + ": Rs. " + priceInt + " | Quantity: " + quantity
						+ " | Total Value: Rs. " + formattedTotalValue);
				return totalValue;
			} else
			{
				System.out.println("Price not found for " + ticker);
			}
		} catch (Exception e)
		{
			System.out.println("Failed to fetch price for " + ticker + ": " + e.getMessage());
		}
		return 0;
	}

	private static String getCurrentTime() {
		LocalTime time = LocalTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
		return time.format(formatter);
	}

	private static void clearConsole() {
		System.out.print("\033[H\033[2J"); // ANSI escape code to clear the console and move the cursor to the top
		System.out.flush();
	}
}
