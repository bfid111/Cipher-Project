import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
public class KorTextConverter {
	private static String text;
	private static String convertedString = "";
	// Korean Alphabet
	private static char[] korList = {'げ','じ','ぇ','ぁ','さ','に','づ','ち','だ','つ',
				'け','い','し','ぉ','ぞ','で','っ','た','び','せ','ぜ','ず','そ','ば','ぬ','ぱ'};
	private static char[] engList = {'q','w','e','r','t','y','u','i','o','p',
			'a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
	public KorTextConverter(String str){
		/**
		 * Constructor for KorTextConverter
		 * @param str. a String to convert
		 * @see text 
		 */
		text = str.toLowerCase();
	}
        
	public void convert(){
		/**
		 * Converts text to a Korean ASCII 
		 * @see korList
		 * @see engList
		 * @see text
		 * @see convertedString
		 * @return void 
		 */
		char[] tempList = text.toCharArray();
		ArrayList<String> finalList = new ArrayList<String>();
		for(int i = 0; i < tempList.length; i++){
			if(StringUtils.isAlpha(String.valueOf(tempList[i])) == true){ // if a character is alphabetic
					int pos = getArrayIndex(tempList[i]);
					// Add Korean ASCII value of tempList[i] to finalList
					finalList.add(Integer.toString((int)korList[pos]));
					finalList.add(",");
			} else {
				// If a character is not alphabetic
				finalList.add(Integer.toString((int)tempList[i]));
				if(Math.abs(i-tempList.length) > 1){
					// Add comma between characters
					finalList.add(",");
				}
			}
		}
		for(int i  = 0; i < finalList.size(); i++){
			convertedString += finalList.get(i);
		}
	}
	public String returnConverted(){
		/**
		 * Returns a converted String 
		 * @return convertedString
		 */
		return convertedString;
	}
	private int getArrayIndex(char character) {
		/**
		 * Returns an index of an alphabetic char inside engList
		 * @param character. a character to find position inside engList
		 * @see engList
		 * @return i or 0 meaning none
		 */
		for(int i  = 0; i < engList.length; i++){
			if(character == engList[i]){
				return i;
			}
		}
		return 0;
	}
}
