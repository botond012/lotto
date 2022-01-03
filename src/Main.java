import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		var result = new ArrayList<String>();
		FileWriter writer = new FileWriter("output.txt");
		for (long l = 0L; l < 10000000L; l++) {
			String line = "";
			for (int c = 0; c < 5; c++) {
				line = line + "," + rand.nextInt(100);
			}
			line = line.substring(1) ;
			writer.write(line + System.lineSeparator());
			result.add(line);
		}
		writer.close();
	}
}
