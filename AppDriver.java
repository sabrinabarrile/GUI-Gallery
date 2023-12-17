import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AppDriver {

		 public static void main(String[] args) throws FileNotFoundException 
		 {
			 //Create my picture list
			 
			 System.out.println("-------------1. Create my picture list: ");
			 ArrayList<Picture> pictureList;
			 pictureList = createPictureList();
			 
			 for (Picture item: pictureList) 
			 {
		    	 System.out.println("\t" + item.getName());
		     }
			 
			 //Create GUI
			 
			 System.out.println("\n-------------2. Create a GUI to show my hobbies, with a \"Next\" and \"Previous\" button for navigation");
		     new GUI(pictureList);
		     
		     //Create and display my hobby list.
		     
		     System.out.println("\n-------------3. Create my hobby list:\n");
		     ArrayList<String> myHobbies = new ArrayList<String>();
		     myHobbies.add("roller skating");
		     myHobbies.add("watching baseball");
		     myHobbies.add("harp");
		     myHobbies.add("sudoku");
		     hobbiesArray(myHobbies);
		     
		     //Create a list of students by reading from student_hobby.txt and display the list.
	     
		     System.out.println("\n-------------4. Create a Student list by reading from student_hobby.txt\n");
		     ArrayList<Students> students = readFile("src/student_hobby.txt");
		         
		     //Sort the Student list by ascending order of student names
		     
		     System.out.println("\n-------------5. Sort the Student list by ascending order of student names\n");
		     Collections.sort(students);
		     for (Students student : students) 
		        {
		            System.out.println(student);
		        }
		     
		     //Go through my hobby list to show how many students share the same hobby with me 
		     
		     System.out.println("\n-------------6. Go through my hobby list to show how many students share the same hobby\n");
		     compareHobbies(myHobbies, students);
		     
		 }//end main()
		        
		 
		 /**
		  * createPictureList(): create and return an ArrayList of Picture-type objects.
		  * @return	an ArrayList of Picture-type objects.
		  */
		 public static ArrayList<Picture> createPictureList() 
		 {
			 
	    	 ArrayList<Picture> pics = new ArrayList<Picture>();
	         
	    	 pics.add(new Picture("Mocha", "Images/mochabun.jpeg"));
	    	 pics.add(new Picture("Rollerskating", "Images/skating.jpeg"));
	    	 pics.add(new Picture("Daycare Job", "Images/daycare.jpeg"));
	    	 pics.add(new Picture("Color Guard", "Images/colorguard.jpeg"));
	    	 pics.add(new Picture("Beach", "Images/beach.jpeg"));
	    	 pics.add(new Picture("NYC", "Images/nyc.jpeg"));
	    	 pics.add(new Picture("California", "Images/california.jpeg"));
	    	 pics.add(new Picture("Scotland", "Images/scotland.jpeg"));
	    	 pics.add(new Picture("Food", "Images/food.jpeg"));
	    	 pics.add(new Picture("Phillies", "Images/phillies.jpeg"));
	                 
	         return pics;
	         
	    }//end createPictureList()
		 
		public static void hobbiesArray(ArrayList<String> myHobbies)
		{
		     int i = 1;
		     for(String str : myHobbies)
				{
					System.out.print(i + ". ");
					System.out.println(str);
					i++;
				}
		     
		}//end hobbiesArray()
		
		public static ArrayList<Students> readFile(String fileName) throws FileNotFoundException 
		{
			ArrayList<Students> students = new ArrayList<Students>();
			
	            File file = new File("src/student_hobby.txt");
	            Scanner scanner = new Scanner(file);

	            while (scanner.hasNextLine()) 
	            {
	                String line = scanner.nextLine();
	                String[] slice = line.split(": ");

	                String name = slice[0];
	                String[] hobbiesArr = slice[1].split(", ");
	                ArrayList<String> hobbies = new ArrayList<String>();

	                for (int i = 0; i < hobbiesArr.length; i++) 
	                {
	                    hobbies.add(hobbiesArr[i]);
	                }

	                Students student = new Students(name, hobbies);
	                students.add(student);
	            }

	        for (Students student : students) 
	        {
	            System.out.println(student);
	        }
	        
			return students;
		} //end readFile()
		
		public static void compareHobbies(ArrayList<String> myHobbies, ArrayList<Students> students)
		{
			ArrayList<Integer> studentCounts = new ArrayList<Integer>();

			  for (String hobby : myHobbies) 
			  {
			      int count = 0;
			      for (Students student : students) 
			      {
			          if (student.hasHobby(hobby))
			          {
			              count++;
			          }
			      }
			      
			      studentCounts.add(count);
			      System.out.println(hobby + ": " + count);
			  }
			  
		}//end compareHobbies()
		
}//end class AppDriver
