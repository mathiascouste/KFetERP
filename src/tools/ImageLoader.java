package tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

public final class ImageLoader {
    private static Map<String, ImageLoader> staticMap = new HashMap<String, ImageLoader>();
    private Map<String, String> pathingMap;
    private Map<String, Image> imageMap;

    public static ImageLoader newImageLoader(String name) {
        ImageLoader iL = new ImageLoader();
        staticMap.put(name, iL);
        return iL;
    }

    public static ImageLoader getImageLoader(String name) {
        return staticMap.get(name);
    }

    public static void deleteImageLoader(String name) {
        staticMap.remove(name);
    }

    private ImageLoader() {
        this.pathingMap = new HashMap<String, String>();
        this.imageMap = new HashMap<String, Image>();
    }

    public void addPath(String name, String path) {
        this.pathingMap.put(name, path);
    }

    public void loadImages() {
        for (Iterator<String> i = this.pathingMap.keySet().iterator(); i
                .hasNext();) {
            String imgName = i.next();
            this.imageMap.put(imgName, loadImage(this.pathingMap.get(imgName)));
        }
    }

    private Image loadImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            img = null;
        }
        return img;
    }

    public Image getImage(String imgName) {
        return this.imageMap.get(imgName);
    }
}