package TileMap;

import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;

import game.GamePanel;

public class TileMap {
	
	//positition properies
	private double x,y;
	
	//bounds properties
	private int xMin,yMin;
	private int xMax,yMax;
	
	//smoove camera
	private double tween;
	
	//mapping
	private int [][] map;
	private int tileSize;
	private int	rows;
	private int columns;
	private int width;
	private int height;
	
	private BufferedImage tileset;
	private int tilesAcross;
	private Tile[][] tiles;
	
	//which start drawing properties
	private int rowOffset;
	private int columnOffset;
	private int rowsToDraw;
	private int columnsToDraw;
	
	//effects
	private boolean shaking;
	private int intensity;
	
	public TileMap(int tileSize) {
		this.tileSize = tileSize;
		rowsToDraw = GamePanel.height / tileSize + 2;
		columnsToDraw = GamePanel.width / tileSize + 2;
		tween = 0.07;
	}
	
	public void loadTiles(String source) {
		try {
			tileset = ImageIO.read(getClass().getResourceAsStream(source));
			tilesAcross = tileset.getWidth() / tileSize;
			//the size of table must be based of columns and rows in yours picture 
			tiles = new Tile[2][tilesAcross];
			
			BufferedImage subImage;
			for(int col = 0; col< tilesAcross; col++) {
				subImage = tileset.getSubimage(col*tileSize, 0, tileSize, tileSize);
				tiles[0][col] = new Tile(subImage);
				subImage = tileset.getSubimage(col*tileSize, tileSize, tileSize, tileSize);
				tiles[1][col] = new Tile(subImage);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String s) {
		try {
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			columns = Integer.parseInt(reader.readLine());
			rows = Integer.parseInt(reader.readLine());
			map = new int [rows][columns];
			width = columns*tileSize;
			height = columns*tileSize;
			
			String delims = "\\s+";
			for(int row = 0; row < rows; row++) {
				String line = reader.readLine();
				String [] tokens = line.split(delims);
				for(int col = 0; col< columns; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e){
			
		}
	}
	
	public void setPosition(double _x, double _y) {
		this.x = (x - _x)*tween;
		this.y = (y - _y)*tween;
		fixBounds();
		columnOffset= (int)-x/tileSize;
		rowOffset = (int) -y/tileSize;
	}
	
	public void fixBounds() {
		if(x < xMin)
			x = xMin;
		if(y < yMin)
			y = yMin;
		if(x > xMax)
			x = xMax;
		if(y > yMax)
			y = yMax;
	}
	
	public int getTileSize() {return this.tileSize;}
	public int getX() {return (int)this.x;}
	public int getY() {return (int)this.x;}
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getRows() { return rows; }
	public int getColumns() { return columns; }
	
	public BufferedImage getTileImage(int _row, int _column) {
		int rowNcol = map[_row][_column];
		int r = rowNcol / tilesAcross;
		int c = rowNcol & tilesAcross;
		return tiles[r][c].getImage();
	}
	
	public void update() {
		if(shaking) {
			x += Math.random()*intensity - (intensity/2);
			y += Math.random()*intensity - (intensity/2);
		}
	}
	
	public void draw(Graphics2D _graphic) {
		int conditionLoopRow = rowOffset+ rowsToDraw;
		int conditionLoopColumn = columnOffset+ columnsToDraw;
		for(int row = rowOffset; row < conditionLoopRow; row++) {
			if(row > rows)
				break;
			for(int col = columnOffset; col < conditionLoopColumn; col++) {
				if(row > columns)
					break;
				if(map[row][col] == 0)
					continue;
				
				int rowNColumn = map[row][col];
				int _r = rowNColumn / tilesAcross;
				int _c = rowNColumn & tilesAcross;
				
				_graphic.drawImage(tiles[_r][_c].getImage(),(int)x+col*tileSize,(int)y+row*tileSize,null);
			}
		}
	}
	
}
