import java.util.ArrayList;
public class Students implements Comparable<Students>
{
	
String name;
ArrayList<String> hobbies;

    public Students(String name, ArrayList<String> hobbies) 
    {
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getName() 
    {
        return name;
    }

    public ArrayList<String> getHobbies() 
    {
        return hobbies;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setHobbies(ArrayList<String> hobbies) 
    {
        this.hobbies = hobbies;
    }

	public String toString() {
		return name + ": " + hobbies;
	}

	public int compareTo(Students other) 
	{
		return this.name.compareTo(other.getName());
	}

	public static void hasHobby(ArrayList<Students> students, ArrayList<String> myHobbies) {
	    for (String hobby : myHobbies) {
	        int count = 0;
	        for (Students student : students) {
	            if (student.getHobbies().contains(hobby)) {
	                count++;
	            }
	        }
	        System.out.println(hobby + ": " + count);
	    }
	}
}