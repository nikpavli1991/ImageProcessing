/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce325.project;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diktyas
 */
public class PPMImageStacker {
    //pedia klasis
    List <PPMImage> listppm = new ArrayList<>();
    PPMImage stackedImage = new PPMImage();
    int width,height,colourdepth;
    //constructor kai dimiourgia listas
    public PPMImageStacker(java.io.File dir) throws FileNotFoundException {
        
        
       
        if (dir.isDirectory() == false) {
            System.out.println("ERROR  <" +  dir + "> is not a directory!");
        }
        String result[] = dir.list();
        File result2[] = dir.listFiles(); // gia apofygi directories me length mikrotero tou 4
        for (int i=0; i<result.length; i++) {
            if (!(result2[i].isDirectory())) {
                if ((result[i].substring(result[i].length()-4,result[i].length()).compareTo(".ppm") == 0)) {
                    listppm.add(new PPMImage(result2[i]));      
                }
            }
        }   
    } 
       
    //efarmozei stacking
    public void stack() {
        
        int listSize = listppm.size();
        int avgRed,avgGreen,avgBlue;
        int pixelRed[][] = new int [listppm.get(0).getHeight()] [listppm.get(0).getWidth()];
        int pixelGreen[][] = new int [listppm.get(0).getHeight()] [listppm.get(0).getWidth()];
        int pixelBlue[][] = new int [listppm.get(0).getHeight()] [listppm.get(0).getWidth()];
        
        width = listppm.get(0).getWidth();
        height = listppm.get(0).getHeight();
        Iterator<PPMImage> it = listppm.iterator();
        while(it.hasNext()) {
            PPMImage counter = it.next();
            
            colourdepth = counter.imageColordepth;
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    pixelRed[i][j] = pixelRed[i][j] + counter.image[i][j].getRed();
                    pixelGreen[i][j] = pixelGreen[i][j] + counter.image[i][j].getGreen();
                    pixelBlue[i][j] = pixelBlue[i][j] + counter.image[i][j].getBlue();  
              }
            }
        }
        
        stackedImage.imageWidth =width;
        stackedImage.imageHeight=height;
        stackedImage.imageColordepth=colourdepth;
        stackedImage.image = new RGBPixel[height][width];    
                         
        for(int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                avgRed = pixelRed[i][j] / listSize;
                avgGreen = pixelGreen[i][j] / listSize;
                avgBlue = pixelBlue[i][j] / listSize; 
                stackedImage.image[i][j] = new RGBPixel((short)avgRed,(short)avgGreen,(short)avgBlue);
            }
        }
    }
    
    //return stacked image
    public PPMImage getStackedImage() {
        
       return stackedImage;  
    }   
    
}
