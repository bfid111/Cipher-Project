

/**
 *
 * @author Youngmin ybs5050@psu.edu
 */
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
public class KorTextConverter {
	private static String text;
	private static String convertedString = "";
	// Korean Alphabet
	private static final char[] korList = {'げ','じ','ぇ','ぁ','さ','に','づ','ち','だ','つ',
				'け','い','し','ぉ','ぞ','で','っ','た','び','せ','ぜ','ず','そ','ば','ぬ','ぱ'};
	private static final char[] engList = {'q','w','e','r','t','y','u','i','o','p',
			'a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        private static final char[] specialList = {'~','`','!','@','#','$','%','^','&','*','(',')','_','-','=','+','{','[','}',']',
            '|','"',':',';',',','<','>','.','?','/',' '};
        private static final char[] numList = {'0','1','2','3','4','5','6','7','8','9'};
        private static final int[] specialAscii = {12000,22001,32002,42003,82004,62005,52006,42007,32008,22009,92010,62011,52012,52013,42014,
        22015,22016,72017,62018,22019,52020,52021,12022,22023,72024,62025,22026,82027,52028,42029,82030};
        private static final int[] numAscii = {52031,82032,83033,52034,32035,22036,12037,12038,62039,42040};
    
	public KorTextConverter(String str){
		/**
		 * Constructor for KorTextConverter
		 * @param str. a String to convert
		 * @see text 
		 */
		text = str.toLowerCase();
	}
        public static void changeText(String str){
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
		ArrayList<String> finalList = new ArrayList<>();
		for(int i = 0; i < tempList.length; i++){
			if(StringUtils.isAlpha(String.valueOf(tempList[i])) && Character.isLowerCase(tempList[i])){ // if a character is alphabetic lowercase
                            int pos1 = getArrayIndex(tempList[i], 1);
                            // Add Korean ASCII value of tempList[i] to finalList
                            finalList.add(Integer.toString((int)korList[pos1]));
                            if(Math.abs(i-tempList.length) > 1){
                            //finalList.add(",");
                            }   
			} else if(StringUtils.isNumeric(String.valueOf(tempList[i]))) { //if numeric 
                            int pos2 = getArrayIndex(tempList[i], 2);
                            finalList.add(Integer.toString((int)numAscii[pos2]));
                            if(Math.abs(i-tempList.length) > 1){
                            // Add comma between characters
                            //finalList.add(",");
                            }
			} else { // special characters
                            int pos3 = getArrayIndex(tempList[i], 3);
                            finalList.add(Integer.toString((int)specialAscii[pos3]));
                            if(Math.abs(i-tempList.length) > 1){
                            //finalList.add(",");
                            }   
                        }
		}
                finalList.stream().forEach((temp) -> {
                    convertedString += temp;
            });
	}
        public String devert(String text1){
                String alpha = "";
                for(int c = 0; c < korList.length; c++) {
                    if(text1.equals(Integer.toString((int)korList[c]))){
                       return Character.toString(Character.toUpperCase(engList[c]));
                    }
                }
                for(int a = 0; a < numAscii.length; a++) {
                    if(text1.equals(Integer.toString(numAscii[a]))) {
                        return Character.toString((char)numList[a]);
                    }
                }
                for(int b = 0; b < specialAscii.length; b++) {
                    if(text1.equals(Integer.toString(specialAscii[b]))) {
                        return Character.toString((char)specialList[b]);
                    }
                }
                return "";
        }
	public String returnConverted(){
		/**
		 * Returns a converted String 
		 * @return convertedString
		 */
                String a = convertedString;
                convertedString = "";
		return a;   
	}
	private int getArrayIndex(char character, int mode) {
		/**
		 * Returns an index of an alphabetic char inside engList
		 * @param character. a character to find position inside engList
		 * @see engList
		 * @return i or 0 meaning none
		 */
                switch(mode){
                    case 1:
                        for(int i  = 0; i < engList.length; i++){
                            if(character == engList[i]){
				return i;
                            }
                        }
                    break;
                    case 3:
                        for(int i = 0; i < specialList.length; i++){
                            if(character == specialList[i]){
                                return i;
                            }
                        }
                    break;
                    case 2:
                        for(int i = 0; i < numList.length; i++){
                            if(character == numList[i]){
                                return i;
                            }
                        }
                    break;
                    default :
                        break;
                }
            return 0; 
        }
}
