package cn.qc9ff.shackleje.libgdx.loader;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.io.File;

public class MapLoader {
    public static TiledMap tileMap;
    public static final TmxMapLoader tileMapLoader = new TmxMapLoader();
    public static TiledMap loadMap(int id){
        String path = "tile_map" + File.separator + id + ".tmx";
        return tileMapLoader.load(path);
    }
}
