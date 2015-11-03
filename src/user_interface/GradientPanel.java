import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class GradientPanel extends JPanel{
	/**
	 * @author William Escobar
	 */
	private static final long serialVersionUID = 1L;
	private boolean gradientsUsed;
	private Color[] gradientColors;
	private float[] positions;
	private float horizontalEnd;
	private float verticalEnd;
	private boolean horizontalAlignment;
	private boolean slantProvided;
	
	public GradientPanel(LayoutManager layoutManager, Color[] gradientColors, boolean horizontalAlignment){
		super(layoutManager);
		gradientsUsed = true;
		this.gradientColors = gradientColors;
		this.positions = new float[gradientColors.length];
		float positionInterval = (float)1.0/(gradientColors.length-1);
		for(float gradientPosition = 0f, position = 0; position < this.positions.length-1; gradientPosition+=positionInterval, position++){
			this.positions[(int)position] = gradientPosition;
		}
		this.positions[gradientColors.length-1] = 1f;
		this.horizontalAlignment = horizontalAlignment;
	}
	
	public GradientPanel(LayoutManager layoutManager, Color[] gradientColors, float[] positions, boolean horizontalAlignment){
		super(layoutManager);
		gradientsUsed = true;
		this.gradientColors = gradientColors;
		this.positions = positions;
		this.horizontalAlignment = horizontalAlignment;
	}
	
	public GradientPanel(LayoutManager layoutManager, Color[] gradientColors, float horizontalEnd, float verticalEnd){
		super(layoutManager);
		gradientsUsed = true;
		this.gradientColors = gradientColors;
		this.positions = new float[gradientColors.length];
		float positionInterval = (float)1.0/(gradientColors.length-1);
		for(float gradientPosition = 0f, position = 0; position < this.positions.length-1; gradientPosition+=positionInterval, position++){
			this.positions[(int)position] = gradientPosition;
		}
		this.positions[gradientColors.length-1] = 1f;
		this.horizontalEnd = horizontalEnd;
		this.verticalEnd = verticalEnd;
	}
	
	public GradientPanel(LayoutManager layoutManager, Color[] gradientColors, float[] positions, float horizontalEnd, float verticalEnd){
		super(layoutManager);
		gradientsUsed = true;
		slantProvided = true;
		this.gradientColors = gradientColors;
		this.positions = positions;
		this.horizontalEnd = horizontalEnd;
		this.verticalEnd = verticalEnd;
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(gradientsUsed){
			Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        Point2D start = new Point2D.Float(0f,0f);
	        float height = getHeight();
	        float width = getWidth();
	        if(!slantProvided){
				if(horizontalAlignment){
					horizontalEnd = width;
					verticalEnd = 0f;
				}else{
					horizontalEnd = 0f;
					verticalEnd = height; 
				}
	        }else{
	        	horizontalEnd *= width;
	        	verticalEnd *= height;
	        }
	        Point2D end = new Point2D.Float(horizontalEnd, verticalEnd);
	        LinearGradientPaint gp = new LinearGradientPaint(start,end,positions, gradientColors);
	        g2d.setPaint(gp);
	        g2d.fillRect(0, 0, getWidth(), getHeight());
		}
	}
}
