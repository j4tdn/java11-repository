package bt03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.FileUtils;

public class Bt03 {

	private static final String pathin = "input.txt";
	private static final String pathout = "output.txt";

	public static void main(String[] args) {

		// create write file input and file output
		File filein = new File(pathin);
		File fileout = new File(pathout);

		FileWriter fwin = null;
		BufferedWriter bwin = null;

		FileWriter fwout = null;
		BufferedWriter bwout = null;

		int i = 0;

		try {
			// write to file input
			Scanner ip = new Scanner(System.in);
			int n = Integer.parseInt(ip.nextLine());
			fwin = new FileWriter(filein, true);
			bwin = new BufferedWriter(fwin);
			bwin.write(n + "\n");

			fwout = new FileWriter(fileout, true);
			bwout = new BufferedWriter(fwout);
			List<String> strs = new ArrayList<String>();
			while (i++ < n) {
				System.out.print("Enter str " + i + ": ");
				strs.add(ip.nextLine() + "\n");
			}
			bwin.write(strs + "");
			// write to file output
			for (String str : strs) {
				System.out.println(sortNumber(str));
				bwout.write(sortNumber(str) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bwin, fwin);
			FileUtils.close(bwout, fwout);
		}
		System.out.println("Successfully!!!");
		FileUtils.open(fileout);
	}

	// sort number in String 
	public static List<String> sortNumber(String str) {
		List<Integer> numbers = new ArrayList<>();
		List<String> result = new ArrayList<>();
		Pattern patt = Pattern.compile("[\\d]+");
		Matcher matcher = patt.matcher(str);

		while (matcher.find()) {
			numbers.add(Integer.parseInt(str.substring(matcher.start(), matcher.end())));
			Collections.sort(numbers);
		}
		String s = String.valueOf(numbers);
		result.add(s);
		return result;
	}
}
