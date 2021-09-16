package manipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import common.Trader;
import utils.DataUtils;
import utils.FileUtils;

public class Ex03 {
	private static final String TRADER_PATH = "trader.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(TRADER_PATH);
		List<Trader> traders = DataUtils.getTraders();
		FileUtils.writeObjects(file, traders);
		FileUtils.open(file);
		System.out.println("=======");
		Path path = Paths.get("data/ex03-input.txt");
		List<String> lines = Files.readAllLines(path);
		List<Trader> traderss = FileUtils.readObject(file);
		System.out.println(traderss);
	}
}
