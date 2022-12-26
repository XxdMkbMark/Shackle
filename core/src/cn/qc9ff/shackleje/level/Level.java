package cn.qc9ff.shackleje.level;

import cn.qc9ff.shackleje.level.map.Map;
import cn.qc9ff.shackleje.util.BlockType;
import cn.qc9ff.shackleje.util.Location;

public class Level {
    private Map map;
    private int prefix;

    private Location location;
    public Level(int prefix, int width, int height) {
        this.prefix = prefix;
        this.map = new Map(height, width);
        location = new Location(1, 1);
        this.map.getMap()[1][1] = BlockType.PLAYER_POINT;
    }

    public Map getLevel() {
        return map;
    }

    public int getPrefix() {
        return prefix;
    }

    public void move(int x, int y){
        if(map.getMap()[location.getX() + x][location.getY() + y] != BlockType.WALL){
            map.getMap()[location.getX()][location.getY()] = BlockType.ROAD;
            map.getMap()[location.getX() + x][location.getY() + y] = BlockType.PLAYER_POINT;
            location.setX(location.getX() + x);
            location.setY(location.getY() + y);
        }
    }
    @Override
    public String toString() {
        BlockType[][] tm = getLevel().map;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < tm.length; i++){
            for(int j = 0; j < tm[0].length; j++){
                if(tm[i][j] == BlockType.WALL){
                    builder.append("#");
                }else if(tm[i][j] == BlockType.PLAYER_POINT){
                    builder.append("P");
                }else{
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
