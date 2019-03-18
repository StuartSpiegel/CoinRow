import java.util.Scanner;

/**
 * 
 * @author Stuart Spiegel 
 * Date: 11/29/2018
 *
 */
public class CoinRow {

	private static int length;
	private static int totalValue; //candy attainable from n houses 
	private static int[] theStreet;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		length = input.nextInt();
		String toRead = input.nextLine();

		for (int j = 0; j < toRead.length(); j++) {
			totalValue = totalValue + Integer.parseInt(toRead);
		}
		
		CoinRow toSolve = new CoinRow(); //calling object
		toSolve.solveCoinRow(theStreet, 0, length); //call recursion 

		System.out.println();
		System.out.print(totalValue);
		System.out.println();
		
		for (int k = 0; k < length; k++) {
			System.out.print(theStreet[k] + " ");
		}
		
	}

	public CoinRow() {
		theStreet = new int[length];

	}

	public int solveCoinRow(int[] theStreet, int index, int end) {
		if (index >= length) // beyond last coin
		{
			return 0;
		}

		int value = theStreet[index];

		if (index >= length - 1) // last coin
		{
			return value;
		} 
		
		else if (index >= length - 2) // second last coin
		{
			return Math.max(value, coinRowHelper(theStreet, index + 1));
		}

		return Math.max(value + coinRowHelper(theStreet, index + 2), coinRowHelper(theStreet, index + 1));
	}

	public static int coinRowHelper(int[] searchStreet, int n) {

		theStreet[0] = 0;
		theStreet[1] = searchStreet[1];

		for (int i = 2; i <= n; i++) {
			theStreet[i] = Math.max(searchStreet[i] + theStreet[i - 2], theStreet[i - 1]);
		}

		return theStreet[n];

	}

}
