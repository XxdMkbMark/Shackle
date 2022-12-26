package cn.qc9ff.shackleje.level.map;

import cn.qc9ff.shackleje.util.BlockType;

import java.util.Random;

public class Map {

    private int width;
    private int height;
    public BlockType[][] map;// 存放迷宫的数组
    private int r;
    private int c;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.r = 2 * this.width + 1;
        this.c = 2 * this.height + 1;
        this.map = new BlockType[r][c];
        MapManager.Init(width, height, r, c, map);
    }

    public BlockType[][] getMap() {
        return map;
    }
}
