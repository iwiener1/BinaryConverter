import java.util.*;

public class DecimalToBinary {
	public static void main (String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Would you like to convert to or from binary? (Enter to or from) ");
		String toOrFrom = kb.next();
		System.out.print("Enter a number to convert: ");
		String userNum = kb.next();
		
		if (toOrFrom.equals("to")) {
			if (userNum.equals("0")) {
				System.out.println("0");
			}
			else {
				Stack<Integer> remainders = new Stack<Integer>();
				while (!userNum.equals("0")){
					int lastDigit = Integer.parseInt(""+userNum.charAt(userNum.length()-1));
					remainders.push(lastDigit%2);
					Long userLong = Long.parseLong(userNum);
					userLong/=2;
					userNum = Long.toString(userLong);
				}
				String binaryNum="";
				while (!remainders.empty()) {
					binaryNum+=remainders.pop();
				}
				System.out.println(binaryNum);
			}
		}
		
		if (toOrFrom.equals("from")){
			int numLength = userNum.length();
			long decimalNum = 0;
			for (int i=0;i<numLength;i++) {
				char toAdd = userNum.charAt(userNum.length()-1);
				if (toAdd=='1') {
					decimalNum+=(long) Math.pow(2,i);
				}
				userNum=userNum.substring(0,userNum.length()-1);
			}
			System.out.println(decimalNum);
		}
	}
}
