/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageUtils {
    
    public static final String FLOWER_64PX = "/images/64px_flower.png";
    public static final String DEF_GHOST = "/images/1.jpg";
    public static final int VLTK_WIDTH = 120;
    public static final int VLTK_HEIGHT = 140;
    
    public static <T> Image createImage(String path, Class<T> tClass) {
        URL url = tClass.getResource(path);
        ImageIcon imageIcon = new ImageIcon(url);
        return imageIcon.getImage();
    }
    
    public static <T> Image createImage(String path, Class<T> tClass, Dimension dim) {
        return createImage(path, tClass).getScaledInstance(dim.width, dim.height, Image.SCALE_SMOOTH);
    }
    
    public static <T> ImageIcon createImageIcon(String path, Class<T> tClass, Dimension dim) {
        return new ImageIcon(createImage(path, tClass, dim));
    }
    
    
}
