package br.com.triangleresolver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleResolver {

	private static final String SEPARATOR = ",";
	private int[][] triangle;
	private int triangleHeight;

	public TriangleResolver(String triangle) throws Exception {
		this(getTriangleFromArgs(triangle));
	}

	public TriangleResolver(int[][] triangle) throws Exception {
		validTrianglePattern(triangle);
		this.triangle = triangle;
		this.triangleHeight = this.triangle.length;
	}

	public long maxTotal() {
		return resolveRow(0, 0);
	}

	private void validTrianglePattern(int[][] triangle) throws Exception {

		int lastRowWidth = 0;

		for (int row = 0; row < triangle.length; row++) {

			int rowWidth = triangle[row].length;

			if ((row == 0 && rowWidth > 1) || (row > 0 && lastRowWidth >= rowWidth)) {
				throw new Exception("Wrong triangle pattern for this program!");
			}

			lastRowWidth = rowWidth;

		}
	}

	private long resolveRow(int rowIndex, int startRowElementIndex) {

		int[] row = triangle[rowIndex];
		boolean haveMoreLines = (rowIndex + 1) < triangleHeight;

		if (row.length == 1) {

			long maxTotal = 0;

			if (haveMoreLines) {
				maxTotal = row[startRowElementIndex] + resolveRow(++rowIndex, startRowElementIndex);
			} else {
				maxTotal = row[startRowElementIndex];
			}

			return maxTotal;
		}

		int valueA = row[startRowElementIndex];
		int valueB = row[startRowElementIndex + 1];

		int maxValue = 0;

		if (valueA >= valueB) {
			maxValue = valueA;
		} else {
			maxValue = valueB;
			startRowElementIndex++;
		}

		return haveMoreLines ? maxValue + resolveRow(++rowIndex, startRowElementIndex) : maxValue;

	}

	public static void main(String[] args) throws Exception {

		int[][] triangle = getTriangleFromArgs(args[0]);

		TriangleResolver triangleResolver = new TriangleResolver(triangle);

		System.out.println(triangleResolver.maxTotal());

	}

	private static int[][] getTriangleFromArgs(String arg) {

		arg = arg.replaceAll("\\s+", "");

		arg = getContent(arg);

		String rowPattern = "\\[(.*?)\\]";

		Pattern pattern = Pattern.compile(rowPattern);
		Matcher matcher = pattern.matcher(arg);

		List<String> triangleRows = new LinkedList<>();

		while (matcher.find()) {
			triangleRows.add(matcher.group(1));
		}

		int[][] triangle = new int[triangleRows.size()][];

		for (int rowIndex = 0; rowIndex < triangleRows.size(); rowIndex++) {

			int[] rowValues = Arrays.asList(triangleRows.get(rowIndex).split(SEPARATOR)).stream().mapToInt(value -> {
				return Integer.parseInt(value.trim());
			}).toArray();

			triangle[rowIndex] = rowValues;

		}

		return triangle;
	}

	private static String getContent(String arg) {
		return arg.substring(arg.indexOf("[") + 1, arg.lastIndexOf("]"));
	}

}
