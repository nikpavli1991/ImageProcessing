package ce325.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diktyas
 */
public class RGBImage implements Image{
    //pedia klasis
    protected int imageWidth;
    protected int imageHeight;
    protected int imageColordepth;
    protected RGBPixel[][] image;
    
    //default kataskevastis
    public RGBImage() {
        
    }
    
    //kataskevastis eikonas
    public RGBImage(int width, int height, int colordepth) {
        imageWidth = width;
        imageHeight = height;
        imageColordepth = colordepth;
        image = new RGBPixel[imageHeight][imageWidth];
        
        //gemisma pinaka image dimiourgia mavris eikonas
        for (int i=0; i< height; i++) {
            for (int j=0; j< width; j++ ) {
                image [i][j] = new RGBPixel((short)0,(short)0,(short)0);
            }
        }
    }
    
    //copy constructor
    public RGBImage(RGBImage copyImg) {
        imageWidth = copyImg.imageWidth;
        imageHeight = copyImg.imageHeight;
        imageColordepth = copyImg.imageColordepth; 
        image = copyImg.getImage();
    }
    
    // return image
    public RGBPixel[][] getImage(){
        return image;
    }
    
    public int getWidth() {
        return imageWidth;
    }
    
    public int getHeight() {
        return imageHeight;
    }
    
    // metatropi kathe pixel se gri xrwma
    public void greyscale() {
        
        for(int i=0; i<imageHeight; i++) {
            for (int j=0; j<imageWidth; j++) {
                image[i][j].setRed((short) (0.3 * image[i][j].getRed()+ 0.59 * image[i][j].getGreen() + 0.11 * image[i][j].getBlue()));
                image[i][j].setGreen(image[i][j].getRed());
                image[i][j].setBlue(image[i][j].getRed());
            }
        } 
    }
    
    //diplasiasmos eikonas xrisimopoiwntas enan temporary pinaka ws endiameso
    public void doublesize() {
        
        RGBPixel tmpArray[][] = new RGBPixel[imageHeight][imageWidth];
        tmpArray = image;
        imageHeight = 2 * imageHeight;
        imageWidth = 2 * imageWidth;
        image = new RGBPixel[imageHeight][imageWidth];
        
        for (int i=0; i<imageHeight/2; i++) {
            for (int j=0; j<imageWidth/2; j++) {
                image[2*i][2*j] = tmpArray[i][j];
                image[2*i+1][2*j] = tmpArray[i][j];
                image[2*i][2*j+1] = tmpArray[i][j];
                image[2*i+1][2*j+1] = tmpArray[i][j];
            }
        }
    }
    
    //upodiplasiasmos eikonas xrisimopoiwntas enan temporary pinaka ws endiameso
    public void halfsize() {
        
        RGBPixel tmpArray[][] = new RGBPixel[imageHeight][imageWidth];
        tmpArray = image;
        imageHeight = imageHeight / 2;
        imageWidth = imageWidth / 2;
        image = new RGBPixel[imageHeight][imageWidth];
        short red,green,blue;
        
        for (int i=0; i<imageHeight; i++) {
            for (int j=0; j<imageWidth; j++ ) {
                red =(short)((tmpArray[2*i][2*j].getRed() + tmpArray[2*i+1][2*j].getRed() + tmpArray[2*i][2*j+1].getRed() + tmpArray[2*i+1][2*j+1].getRed())/4);
                green =(short)((tmpArray[2*i][2*j].getGreen()+ tmpArray[2*i+1][2*j].getGreen()+ tmpArray[2*i][2*j+1].getGreen()+ tmpArray[2*i+1][2*j+1].getGreen())/4);
                blue = (short)((tmpArray[2*i][2*j].getBlue()+ tmpArray[2*i+1][2*j].getBlue()+ tmpArray[2*i][2*j+1].getBlue()+ tmpArray[2*i+1][2*j+1].getBlue())/4);
                image [i][j] = new RGBPixel(red, green, blue);
            }
        }
    }
        
    //strofi kata 90 moires deksia xrisimopoiwntas enan temporary pinaka ws endiameso
    public void rotateClockwise(){
            
        RGBPixel tmpArray[][] = new RGBPixel[imageHeight][imageWidth];
        tmpArray = image;
        int tmp = imageHeight;
        imageHeight = imageWidth;
        imageWidth = tmp;
        image = new RGBPixel[imageHeight][imageWidth];
        
        for (int i=imageHeight; i>0; i--) {
            for (int j=0; j<imageWidth; j++) {
                image[imageHeight-i][j] = tmpArray[imageWidth-j-1][imageHeight-i];
            }
        }
            
    }
    
    //metatropi eikonas apo YUV SE RGB
   /* public RGBImage(YUVImage YUVImg) {
        
    }
    */
}
