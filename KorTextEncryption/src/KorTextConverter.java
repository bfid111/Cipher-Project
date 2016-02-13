/*
 * Copyright (C) 2016 Youngmin ybs5050@psu.edu
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

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
	private static char[] korList = {'げ','じ','ぇ','ぁ','さ','に','づ','ち','だ','つ',
				'け','い','し','ぉ','ぞ','で','っ','た','び','せ','ぜ','ず','そ','ば','ぬ','ぱ'};
	private static char[] engList = {'q','w','e','r','t','y','u','i','o','p',
			'a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        private static char[] specialList = {'~','`','!','@','#','$','%','^','&','*','(',')','_','-','=','+','{','[','}',']',
            '|','"',':',';',',','<','>','.','?','/',' '};
        private static int[] specialAscii = {12000,12001,12002,12003,12004,12005,12006,12007,12008,12009,12010,12011,12012,12013,12014,
        12015,12016,12017,12018,12019,12020,12021,12022,12023,12024,12025,12026,12027,12028,12029,12030};
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
		ArrayList<String> finalList = new ArrayList<>();
		for(int i = 0; i < tempList.length; i++){
			if(StringUtils.isAlpha(String.valueOf(tempList[i])) == true){ // if a character is alphabetic
					int pos = getArrayIndex(tempList[i]);
					// Add Korean ASCII value of tempList[i] to finalList
					finalList.add(Integer.toString((int)korList[pos]));
                                        if(Math.abs(i-tempList.length) > 1){
					//finalList.add(",");
                                        }   
			} else {
				// If a character is not alphabetic
				finalList.add(Integer.toString((int)tempList[i]));
				if(Math.abs(i-tempList.length) > 1){
					// Add comma between characters
					//finalList.add(",");
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
