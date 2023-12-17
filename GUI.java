import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    private ArrayList<Picture> pictures;
    private JLabel imageLabel;	//the image 
    private JLabel thisHobby;	//name of the image
    int numImages;				//how many images in total
    private int currentIndex;	//index of the current image being shown.


    public GUI(ArrayList<Picture> pictures) {

    	this.pictures = pictures;
    	numImages = pictures.size();

        // Set up the image panel
        JPanel imagePanel = new JPanel();
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pictures.get(0).getImageFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel);
        getContentPane().add(imagePanel, BorderLayout.CENTER); //add the imagePanel to the center of content pane.

        
        // Set up the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);
        
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(this);
        buttonPanel.add(prevButton);
        
        thisHobby = new JLabel(pictures.get(0).getName());
        thisHobby.setForeground(Color.CYAN);        
        buttonPanel.add(thisHobby);              
        
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        buttonPanel.add(nextButton);
        
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);  //add the buttonPanel to the bottom of content pane.
        
        
        // Set the initial image
        currentIndex = 0;

        // Set the window size and show it
        setSize(750, 750);
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setVisible(true);
   
    }//end constructor GUI
    
	/**
     * This method will be called when the user pressed the Previous or Next button.
     */
    public void actionPerformed(ActionEvent e) {
        // Update the current index based on the button press
        
        if (e.getActionCommand().equals("Next")) {
            currentIndex = (currentIndex + 1) % numImages;
        } else {
            currentIndex = (currentIndex - 1 + numImages) % numImages;
        }

        // Load the new image and set it in the image panel
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(pictures.get(currentIndex).getImageFilename()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        imageLabel.setIcon(new ImageIcon(image));	//update the image
        thisHobby.setText(pictures.get(currentIndex).getName());//update the image text
    }
}//end class HobbyGUI