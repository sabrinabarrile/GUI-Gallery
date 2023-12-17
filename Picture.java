public class Picture 
{
    private String name;
    private String imageFilename;

    public Picture(String name, String imageFilename) 
    {
        this.name = name;
        this.imageFilename = imageFilename;
    }

    public String getName() 
    {
      return name;
    }
    
    public String getImageFilename() 
    {
      return imageFilename;
    }
}//end Picture