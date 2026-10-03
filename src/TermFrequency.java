import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TermFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File stopwords = new File("../stop_words.txt");
		Scanner scanner;
		File inputFile = new File(args[0]);
		Scanner scannerInput;
		try {
			scanner = new Scanner(stopwords);
			scanner.useDelimiter(",");
			ArrayList<String> stopwordsArray = new ArrayList<>();
			
			scannerInput = new Scanner(inputFile);
			scannerInput.useDelimiter("[^a-zA-Z0-9]+");
			ArrayList<String> inputFileArray = new ArrayList<>();
			
			
			while(scanner.hasNext()) {
				stopwordsArray.add(scanner.next());
			}
			
//			for(int i = 0; i<stopwordsArray.size();i++) {
//				System.out.println(stopwordsArray.get(i));
//			}
			
			while(scannerInput.hasNext()) {
				String in = scannerInput.next();//.trim();
//				String clean = in.replaceAll("[^a-zA-Z0-9\\s]", "");
				if(in.length() >= 2) {
					inputFileArray.add(in.toLowerCase());
				}
					
			}
//			for(int i = 0; i<inputFileArray.size();i++) {
//				System.out.println(inputFileArray.get(i));
//			}
			ArrayList<String> inputFileArray2 = new ArrayList<>();
			int t = 0;
			for(int i = 0; i < inputFileArray.size(); i++) {
				for(int j = 0; j < stopwordsArray.size(); j++) {
					if(inputFileArray.get(i).equals(stopwordsArray.get(j))) {
						t = 1;
						break;
					}
				}
				if(t == 0) {
					inputFileArray2.add(inputFileArray.get(i));
				}
				t = 0;
				
			}
			ArrayList<Integer> number = new ArrayList<>();
			ArrayList<String> fInput = new ArrayList<>();
			for(int i = 0 ; i < inputFileArray2.size(); i++) {
				if(fInput.contains(inputFileArray2.get(i))) {
					number.set(fInput.indexOf(inputFileArray2.get(i)), number.get(fInput.indexOf(inputFileArray2.get(i)))+1);
				}else {
					fInput.add(inputFileArray2.get(i));
					number.add(1);
				}
			}
			
			ArrayList<Integer> Pnumber = new ArrayList<>();
			ArrayList<String> PInput = new ArrayList<>();
			Pnumber.add(number.get(0));
			PInput.add(fInput.get(0));
			for(int i = 1; i < fInput.size();i++) {
				for (int j = 0; j <Pnumber.size(); j++) {
					if(Pnumber.get(j)<= number.get(i)) {
						Pnumber.add(j, number.get(i));
						PInput.add(j, fInput.get(i));
						break;
					}else {
						continue;
						}
				}
			}
			for(int i = 0; i<PInput.size();i++) {
				System.out.println(PInput.get(i)+", "+Pnumber.get(i));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
