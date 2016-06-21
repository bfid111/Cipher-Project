
/**
 *
 * @author ybs5050
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
                //int tempConverted = Integer.valueOf(splitted[a]) + (keySum);
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
               // int tempConverted = Integer.valueOf(splitted[a]) - (keySum); // shift decrypt 
                int tempConverted = Integer.valueOf(splitted[a]) + (-keySum);
             //   System.out.println( splitted[a]);
                splitted[a] = Integer.toString(tempConverted);
            }
            for (String splitted1 : splitted) {
                decryptText += splitted1;
            }
            String splittedDeText[] = stringSplitter(decryptText, 5);
            for(int i = 0; i < splittedDeText.length; i++){
                System.out.println(splittedDeText[i]);
            }
            KorTextConverter dec = new KorTextConverter(decryptText);
            String decryptFinal = "";
            for(int i = 0; i < splittedDeText.length; i++){
                decryptFinal += dec.devert(splittedDeText[i]);
            }
            decryptText = decryptFinal;
            if("".equals(decryptText)){
                decryptText = "Wrong key! or Cannot be decrypted with this key!";
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
