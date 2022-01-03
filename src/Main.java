import static java.lang.String.format;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		var winnerNumbers = new ArrayList<Integer>();
		for (int i = 0; i < args.length; i++) {
			try {
				Integer number = Integer.valueOf(args[i]);
				if (0 > number || number > 99 || winnerNumbers.contains(number)) {
					throw new NumberFormatException();
				}
				winnerNumbers.add(number);
			} catch (NumberFormatException ex) {
				System.out.println("use valid unique Integers between 0-99");
			}

		}
		LottoScanner lottoScanner = new LottoScanner();
		var results = lottoScanner.scan(winnerNumbers);
		System.out.println("the winning numbers are: " + winnerNumbers);
		System.out.println(format("5 hits :%s" , results.getFives().size()));
		System.out.println(format("4 hits :%s" , results.getFours().size()));
		System.out.println(format("3 hits :%s" , results.getThirds().size()));
		System.out.println(format("2 hits :%s" , results.getTwos().size()));
	}
}