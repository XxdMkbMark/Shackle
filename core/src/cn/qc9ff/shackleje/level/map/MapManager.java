package cn.qc9ff.shackleje.level.map;

import cn.qc9ff.shackleje.util.BlockType;

import java.util.Random;

public class MapManager {
    public static BlockType[][] Init(int width, int height, int r, int c, BlockType[][] map) {
        for (int i = 0; i < r; i++) // 将所有格子都设为墙
            for (int j = 0; j < c; j++)
                map[i][j] = BlockType.WALL;// 0 为墙 1为路
        // 中间格子放为1
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                map[2 * i + 1][2 * j + 1] = BlockType.ROAD;// 0 为墙 1为路
        // 普里姆算法
        rdPrime(width, height, r, c, map);
        return map;
    }

    public static void rdPrime(int width, int height, int r, int c, BlockType[][] map) {
        // ok存放已访问队列，not存放没有访问队列
        int[] ok, not;
        int sum = width * height;
        int count = 0;// 记录访问过点的数量
        ok = new int[sum];
        not = new int[sum];
        // width上各方向的偏移 height各方向的偏移 0左 1右 3上 2下
        int[] offR = {-1, 1, 0, 0};
        int[] offC = {0, 0, 1, -1};

        // 四个方向的偏移 左右上下
        int[] offS = {-1, 1, width, -width}; // 向上向下移动都是变化一行
        // 初始化 ok中0代表未访问,not中0代表未访问
        for (int i = 0; i < sum; i++) {
            ok[i] =0;
            not[i] = 0;
        }
        // 起点
        Random rd = new Random();
        ok[0] = rd.nextInt(sum);// 起始点
        int pos = ok[0];
        // 第一个点存入
        not[pos] = 1;
        while (count < sum) {
            // 取出现在的点
            int x = pos % width;
            int y = pos / width;// 该点的坐标
            int offpos = -1;
            int w = 0;
            // 四个方向都尝试一遍 直到挖通为止
            while (++w < 5) {
                // 随机访问最近的点
                int point = rd.nextInt(4); // 0-3
                int repos;
                int move_x, move_y;
                // 计算出移动方位
                repos = pos + offS[point];// 移动后的下标
                move_x = x + offR[point];// 移动后的方位
                move_y = y + offC[point];
                if (move_y >= 0 && move_x >= 0 && move_x < width && move_y < height && repos >= 0 && repos < sum
                        && not[repos] != 1) {
                    not[repos] = 1;// 把该点标记为已访问
                    ok[++count] = repos;// ++count代表第几个已经访问的点,repos代表该点的下标
                    pos = repos;// 把该点作为起点
                    offpos = point;
                    // 相邻的格子中间的位置放1
                    map[2 * x + 1 + offR[point]][2 * y + 1 + offC[point]] = BlockType.ROAD;
                    break;
                } else {
                    if (count == sum - 1)
                        return;
                }
            }
            if (offpos < 0) {// 周边没有找到能走的路了 从走过的路里重新找个起点
                pos = ok[rd.nextInt(count + 1)];
            }
        }
    }
}
