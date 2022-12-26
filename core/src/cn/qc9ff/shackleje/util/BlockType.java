package cn.qc9ff.shackleje.util;

public enum BlockType {
    WALL('◼', '#'),
    ROAD(' ', ' '),
    START_POINT('▣', '$'),
    DESTINATION('◈', '&'),
    PLAYER_POINT('P', 'P');
    private Character UTF;
    private Character ASCII;

    BlockType(Character UTF, Character ASCII) {
        this.UTF = UTF;
        this.ASCII = ASCII;
    }

    public Character getUTF() {
        return UTF;
    }

    public Character getASCII() {
        return ASCII;
    }
}
