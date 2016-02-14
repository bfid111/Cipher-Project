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
public class KorText {
	
	public static void main(String[] args){
		KorTextConverter sample = new KorTextConverter("SooooooooasfdsaaxvzcvxzadsFFsadfAFASFasdfSDAFSdfADFSGDFSAGADSGFADSFADSFADSFASDooo");
                // output= 
                //1261312631126251259682030126251259682030126098203012613125991259612613820301259612613125931262512636126228203012636126291264112640125991259382030520348203782030820048200482004820048203052034820372203682030126091259612615126011264312627126231260912596126151264312601126431260912615125961262312627
		sample.convert();
                String temp = "";
		String a = sample.returnConverted();
                String[] b = splitStringEvery(a,5);
                System.out.println("Original Text : " + "Soo");
                System.out.println("Converted : " + a);
                String keyText = "key";
                int keySum = 0;
                 for(int i = 0; i < keyText.length(); i++){
                     keySum += (int)keyText.charAt(i);
                }
                System.out.println("Sum = " + keySum);
                CipherHandler cipher = new CipherHandler(a,"keywithlongcharat");
                cipher.encrypt();
                String en = cipher.returnEncrypted();
                System.out.println("Encrypted = " + en);
                b = splitStringEvery( cipher.returnEncrypted(),5);
                int bsum = 0;
                CipherHandler decipher = new CipherHandler(en,"keywithlongcharat");
                decipher.decrypt();
                System.out.println("Decrypted = " + decipher.returnDecrypted());
                boolean he = a.equals(decipher.returnDecrypted());
                System.out.println(he);
                
              
	}
        public static String[] splitStringEvery(String s, int interval) {
            int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
            String[] result = new String[s.length()/5];
            int j = 0;
            int lastIndex = result.length - 1;
            for (int i = 0; i < lastIndex; i++) {
                result[i] = s.substring(j, j + interval);
                j += interval;
            } //Add the last bit
            result[lastIndex] = s.substring(j);
            return result;
        }
}