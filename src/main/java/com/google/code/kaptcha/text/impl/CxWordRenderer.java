package com.google.code.kaptcha.text.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.google.code.kaptcha.text.WordRenderer;
import com.google.code.kaptcha.util.Configurable;

/**
 * The default implementation of {@link WordRenderer}, creates an image with a
 * word rendered on it.
 */
public class CxWordRenderer extends Configurable implements WordRenderer {
	/**
	 * Renders a word to an image.
	 * 
	 * @param word
	 *            The word to be rendered.
	 * @param width
	 *            The width of the image to be created.
	 * @param height
	 *            The height of the image to be created.
	 * @return The BufferedImage created from the word.
	 */
	public BufferedImage renderWord(String word, int width, int height) {
		int fontSize = getConfig().getTextProducerFontSize();
		Font[] fonts = getConfig().getTextProducerFonts(fontSize);
		Color[] color = getConfig().getTextProducerFontColors();
		int charSpace = getConfig().getTextProducerCharSpace();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = null;

		g2D = image.createGraphics();

		FontRenderContext frc = g2D.getFontRenderContext();
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2D.setRenderingHints(hints);
		Random random = new Random();
		int startPosY = (height - fontSize) / 5 + fontSize;
		char[] wordChars = word.toCharArray();
		Font[] chosenFonts = new Font[wordChars.length];
		int[] charWidths = new int[wordChars.length];
		int startPosX = 0;
		for (int i = 0; i < wordChars.length; i++) {
			g2D.setColor(color[random.nextInt(color.length)]);
			chosenFonts[i] = fonts[random.nextInt(fonts.length)];
			char[] charToDraw = new char[] { wordChars[i] };
			GlyphVector gv = chosenFonts[i].createGlyphVector(frc, charToDraw);
			charWidths[i] = (int) gv.getVisualBounds().getWidth();
			if (i == 0) {
				startPosX = charWidths[i];
			}
			g2D.setFont(chosenFonts[i]);
			char[] charToDraw1 = new char[] { wordChars[i] };
			g2D.drawChars(charToDraw1, 0, charToDraw1.length, startPosX, startPosY);
			startPosX = startPosX + (int)charWidths[i]+ charSpace;
		}

		return image;
	}

}
