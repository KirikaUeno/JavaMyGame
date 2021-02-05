package com.mapObjects;

import com.image.ImageFactory;
import com.image.Images;

public class Stone extends StaticCreatures{
    public Stone(double baseX, double baseY) {
        super(ImageFactory.createImage(Images.STONE),baseX, baseY, 100, 100);
    }
}
