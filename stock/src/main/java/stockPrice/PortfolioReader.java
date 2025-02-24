package stockPrice;

import java.io.*;
import java.util.*;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PortfolioReader {
    private static String[] tickers;
    private static int[] quantities;

    public static void main(String[] args) throws IOException, InterruptedException {
        getPortfolioData();

        while (true) {
            clearConsole(); // Clear the console for real-time update
            System.out.println("Fetching stock prices at " + getCurrentTime() + "...");
            int grandTotal = 0;

            for (int i = 0; i < tickers.length; i++) {
                int totalValue = getValueOfTicker(tickers[i], quantities[i]);
                grandTotal += totalValue;
            }

            String formattedTotal = NumberFormat.getInstance(new Locale("en", "IN")).format(grandTotal);
            System.out.println("\nGrand Total Value of All Stocks: Rs." + formattedTotal);
            System.out.println("----------------------------------");

            Thread.sleep(60000); // Pause for 60 seconds before the next update
        }
    }

    private static void getPortfolioData() {
        List<String> tickersList = new ArrayList<>();
        List<Integer> quantitiesList = new ArrayList<>();
        
        File file = new File("portfolio.txt");
        System.out.println("Looking for: " + file.getAbsolutePath());
        System.out.println("Exists? " + file.exists());

        // Read data from portfolio.txt
        try (BufferedReader br = new BufferedReader(new FileReader("portfolio.txt"))) {
        	
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" "); // Split by space
                if (parts.length == 2) {
                    tickersList.add(parts[0]);
                    quantitiesList.add(Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Convert lists to arrays
        tickers = tickersList.toArray(new String[0]);
        quantities = quantitiesList.stream().mapToInt(i -> i).toArray();

        // Display the values for verification
        System.out.println("Tickers: " + Arrays.toString(tickers));
        System.out.println("Quantities: " + Arrays.toString(quantities));
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static String getCurrentTime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return time.format(formatter);
    }

    private static int getValueOfTicker(String ticker, int quantity) {
        String url = "https://www.google.com/finance/quote/" + ticker + ":NSE";
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
            Elements priceElement = doc.select(".YMlKec.fxKbKc");

            if (!priceElement.isEmpty()) {
                String price = priceElement.text().replaceAll("[^\\d.]", "");
                double priceDouble = Double.parseDouble(price);
                int priceInt = (int) Math.round(priceDouble);
                int totalValue = priceInt * quantity;

                String formattedTotalValue = NumberFormat.getInstance(new Locale("en", "IN")).format(totalValue);
                System.out.println("Current Price of " + ticker + ": Rs. " + priceInt + " | Quantity: " + quantity
                        + " | Total Value: Rs. " + formattedTotalValue);
                return totalValue;
            } else {
                System.out.println("Price not found for " + ticker);
            }
        } catch (Exception e) {
            System.out.println("Failed to fetch price for " + ticker + ": " + e.getMessage());
        }
        return 0;
    }
}