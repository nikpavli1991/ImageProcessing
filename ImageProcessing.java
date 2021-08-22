/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce325.project;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Diktyas
 */
public class ImageProcessing {
    
    public static void main(String[] args) {
        try {
        PPMImage paparas = new PPMImage(new File("lena.ppm"));
        
        paparas.rotateClockwise();
        paparas.toFile(new File ("nikos.ppm"));
        
        PPMImageStacker nikos = new PPMImageStacker(new File ("C:\\Users\\Diktyas\\Documents\\NetBeansProjects\\ce325\\stacking_images\\stacking_images\\WFC3UVIS"));
        nikos.stack();
        nikos.getStackedImage().toFile(new File ("nikosss.ppm"));
        }
        catch(FileNotFoundException ex) {
        
        }
    }
}