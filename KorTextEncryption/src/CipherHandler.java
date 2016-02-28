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
public class CipherHandler {
        private static String plainText; 
        private static String encryptText = "";
        private static String decryptText = "";
        private static String keyText;
        private static String[] splitted; 
        public CipherHandler(String str, String key){
            CipherHandler.plainText = str;
            CipherHandler.keyText = key;
        }
        public static void encrypt(){
            int keySum = 0;
            for(int i = 0; i < keyText.length(); i++){
                keySum += (int)keyText.charAt(i);
            }
            System.out.println(keySum);
            CipherHandler.splitted = stringSplitter(plainText,5);
            for(int a = 0; a < splitted.length; a++){
                int tempConverted = Integer.valueOf(splitted[a]) + (keySum);
                System.out.print( splitted[a]);
                splitted[a] = Integer.toString(tempConverted);
            }
            for (String splitted1 : splitted) {
                encryptText += splitted1;
            }
            System.out.println();
        }
        public static void decrypt(){
            int keySum = 0;
            for(int i = 0; i < keyText.length(); i++){
                keySum += (int)keyText.charAt(i);
            }
            System.out.println(keySum);
            CipherHandler.splitted = stringSplitter(plainText,5);
            for(int a = 0; a < splitted.length; a++){
                int tempConverted = Integer.valueOf(splitted[a]) - (keySum); // shift decrypt 
             //   System.out.println( splitted[a]);
                splitted[a] = Integer.toString(tempConverted);
            }
            for (String splitted1 : splitted) {
                decryptText += splitted1;
            }
        }
        public static void changeKey(String str){
            keyText = str;
        }
        public static void changeText(String str){
            plainText = str;
        }
        private static String[] stringSplitter(String s, int interval) {
            String[] result = new String[s.length()/interval];
            int j = 0;
            int lastIndex = result.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                result[i] = s.substring(j, j + interval);
                j += interval;
            } //Add the last bit
            result[lastIndex] = s.substring(j);
            return result;
        }
        public String returnEncrypted(){
            String a = encryptText;
            encryptText = "";
            return a;
        }
        public String returnDecrypted(){
            String b = decryptText;
            decryptText = "";
            return b;
        }
}
