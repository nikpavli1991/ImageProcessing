/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce325.project;

/**
 *
 * @author Diktyas
 */
public class RGBPixel {
    //pedia klasis
    private short pixelRed;
    private short pixelGreen;
    private short pixelBlue;
    private int pixelValue;
        
    //dimiourgia pixel
    public RGBPixel(short red,short green, short blue) {
      
      pixelRed = red;
      pixelGreen = green;
      pixelBlue = blue;
        
      pixelValue = pixelValue + red ;
      pixelValue = pixelValue << 8;
      pixelValue = pixelValue + green ;
      pixelValue = pixelValue << 8;
      pixelValue = pixelValue + blue;
              
    }
    
    //copy constructor
    public RGBPixel(RGBPixel pixel) {
        
      pixelRed = pixel.getRed();
      pixelGreen = pixel.getGreen();
      pixelBlue = pixel.getBlue();
        
      pixelValue = pixelValue + pixelRed ;
      pixelValue = pixelValue << 8;
      pixelValue = pixelValue + pixelGreen ;
      pixelValue = pixelValue << 8;
      pixelValue = pixelValue + pixelBlue;
      
    }
    
    //dimiourgia rgbpixel apo yuvpixel
   /* public RGBPixel(YUVPixel pixel) {
        
    } */
    
    //epistrofi timis kokkinou xrwmatos
    public short getRed() {
        return pixelRed;
    }
    
    //epistrofi timis prasinou xrwmatos
    public short getGreen() {
        return pixelGreen;
    }
    
    //epistrofi timis ble xrwmatos
    public short getBlue() {
        return pixelBlue;
    }
    
    //thetw timi kokkinou xrwmatos
    public void setRed(short red) {
        int mask = 0x0000FFFF;
        
        pixelRed = red;
        
        pixelValue = pixelValue & mask ;
        
        int redShift = red ; 
        
        redShift = redShift << 16;
        
        pixelValue = pixelValue + redShift;
        
    }
    
    //thetw timi prasinou xrwmatos
    public void setGreen(short green) {
        int mask = 0x00FF00FF;
        
        pixelGreen = green;
        
        pixelValue = pixelValue & mask ;
       
        green = (short)(green << 8);
        pixelValue = pixelValue + green;
                
    }
    
    //thetw timi ble xrwmatos
    public void setBlue(short blue) {
        int mask = 0x00FFFF00;
        
        pixelBlue = blue;
        
        pixelValue = pixelValue & mask ;
        
        pixelValue = pixelValue + blue ;
    }
    
    //epistrofi pixel
    public int getPixel() {
        return pixelValue;
    }
}
