import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LottoScanner {
	private FileInputStream inputStream = null;
	private Scanner sc = null;
	private Results results = new Results();

	Results scan(ArrayList<Integer> winnerNumbers) throws IOException {
		try {
			inputStream = new FileInputStream("lotto/src/resources/input.txt");
			sc = new Scanner(inputStream, "UTF-8");

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				var numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).boxed().toList();
				var similar = new ArrayList<>(numbers);
				similar.retainAll(winnerNumbers);
				switch (similar.size()) {
				case 5 -> results.getFives().add(numbers);
				case 4 -> results.getFours().add(numbers);
				case 3 -> results.getThirds().add(numbers);
				case 2 -> results.getTwos().add(numbers);

				}
			}
			if (sc.ioException() != null) {
				throw sc.ioException();
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (sc != null) {
				sc.close();
			}
		}
		return results;
	}
}
