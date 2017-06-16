package cz.fit.dpo.mvcshooter.view.iconStates;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract interface IconState {

    
    public BufferedImage getCannonImage() throws IOException;
	public BufferedImage getEnemyImage1() throws IOException;
	public BufferedImage getEnemyImage2() throws IOException;
	public BufferedImage getMissileImage() throws IOException;
	public BufferedImage getCollisionImage() throws IOException;
}
