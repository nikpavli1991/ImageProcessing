/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce325.project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Diktyas
 */
public class PPMImage extends RGBImage{

    //default kataskevastis
    public PPMImage() {
        
    }
            
    //constructor mazi me periorismous
    public PPMImage(java.io.File file) {
       
        
        try{
            Scanner sc = new Scanner(file);
            
            if(sc.next().compareTo("P3") != 0 || (file.getPath().substring(file.getPath().length()-4, file.getPath().length())).compareTo(".ppm") != 0){
                System.out.println("ERROR: file " + file + " is not of PPM type!");
                super.imageWidth = 0;
                super.imageHeight = 0;
                super.imageColordepth = 255;
                super.image = new RGBPixel[0][0];
                
            } 
            
            else {
            
                super.imageWidth = Integer.parseInt(sc.next());
                super.imageHeight = Integer.parseInt(sc.next());
                super.imageColordepth = Integer.parseInt(sc.next());

                super.image = new RGBPixel[super.imageHeight][super.imageWidth];

                for (int i=0; i< super.imageHeight; i++) {
                    for (int j=0; j< super.imageWidth; j++ ) {
                        super.image [i][j] = new RGBPixel(Short.parseShort(sc.next()), Short.parseShort(sc.next()), Short.parseShort(sc.next()));
                    }
                }
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
    }
    
    //epistrefei ta stoixeia tou ppm file enwmena se ena string
    public String toString(){
        
        String ppmStr = "P3 " + imageWidth + " " + imageHeight + " " + imageColordepth + " ";
        
        for (int i=0; i<imageHeight; i++) {
            for (int j=0; j<imageWidth; j++) {
                ppmStr = ppmStr + "|" +  image[i][j].getRed() + " " + image[i][j].getGreen() + " " + image[i][j].getBlue() + "|" + " "; 
            }
            ppmStr = ppmStr + "\n";
        }
        
        return ppmStr;
        
    }
    
    //eggrafi mias eikonas ppm mesa se ena file me tin morfi pou exoun ta dwsmena ppm arxeia
    public void toFile(java.io.File file) {
        
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("P3");
            printWriter.print (imageWidth + " ");
            printWriter.println (imageHeight);
            printWriter.println(imageColordepth);
            for (int i=0; i<imageHeight; i++) {
                for (int j=0; j<imageWidth; j++) {
                    printWriter.print(image[i][j].getRed() + " " + image[i][j].getGreen() + " " + image[i][j].getBlue() + " "); 
                }
                printWriter.println("");
            }
            printWriter.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
