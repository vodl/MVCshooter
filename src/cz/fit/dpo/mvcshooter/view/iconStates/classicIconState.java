package cz.fit.dpo.mvcshooter.view.iconStates;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class classicIconState implements IconState {

	@Override
	public BufferedImage getCannonImage() throws IOException {
		return ImageIO.read(getClass().getResourceAsStream("/images/cannon.png"));
	}

	@Override
	public BufferedImage getEnemyImage1() throws IOException {
		return ImageIO.read(getClass().getResourceAsStream("/images/enemy1.png"));
	}

	@Override
	public BufferedImage getEnemyImage2() throws IOException {
		return ImageIO.read(getClass().getResourceAsStream("/images/enemy2.png"));
	}

	@Override
	public BufferedImage getMissileImage() throws IOException {
		return ImageIO.read(getClass().getResourceAsStream("/images/missile.png"));
	}

	@Override
	public BufferedImage getCollisionImage() throws IOException {
		return ImageIO.read(getClass().getResourceAsStream("/images/collision.png"));
	}

}
