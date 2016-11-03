package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = null;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		int selection = 0;
		Filter filter = null;
		String fileName = "unknown";

		// prompt user for image to filter and validate input
		do {

			String imagePath = "path not set";

			// try to open the file
			try {

				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();

				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));

				picture = new Picture(imagePath);

			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}

		} while(picture == null);

		// TODO - prompt user for filter and validate input
		do{
			selection = displayFilterMenu(in);
			try{

		// TODO - pass filter ID int to getFilter, and get an instance of Filter back
		filter = getFilter(selection);
			}catch(IllegalArgumentException e){
				System.out.println("Please use a valid integer from the menu");
			}
		}while (filter == null);


		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();

		System.out.println("Image successfully filtered");

		// save image, if desired
			boolean writeFile = false;
			
			while (writeFile == false){
				System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
				fileName = in.next();
			
				String[] relPathParts = fileName.split(File.separator);
				File filePath = new File (dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts)));
			
				if (filePath.exists() == true){
					System.out.println("Are you sure you want to overwrite the file? Type 'YES' to confirm");
					String answer = in.next();
					if (answer.equals("YES")){
						String absFileName = dir + File.separator + fileName;
						processed.save(absFileName);
						System.out.println("Image saved to " + absFileName);
						writeFile = true;
						}
					else{
						writeFile = false;
						}
				}
					
			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
				else if (fileName.equals("exit")) {
					System.out.println("Image not saved");
					writeFile = true;
					}
				else {
					String absFileName = dir + File.separator + fileName;
					processed.save(absFileName);
					System.out.println("Image saved to " + absFileName);
					writeFile = true;
					}
				}
			
		
		in.close();
	}

	   private static int displayFilterMenu(Scanner in){

			System.out.println("Please select the filter you'd like to use");
			System.out.println("1. Blue Filter");
			System.out.println("2. Gray Filter");
			System.out.println("3. Red Filter");
			int selection = in.nextInt();
			return selection;
	}

	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter

	   private static Filter getFilter(int selection) {

		   // TODO - create some more filters, and add logic to return the appropriate one
		   if(selection < 1 || selection > 3){
			   throw new IllegalArgumentException();
		   }
		   else if (selection == 1){
				return new BlueFilter();
			}
			else if (selection == 2){
				return new GrayFilter();
			}
			else {
				return new RedFilter();
			}

	   }
}
