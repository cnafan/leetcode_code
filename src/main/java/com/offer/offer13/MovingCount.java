package com.offer.offer13;

/**
 * 此题使用dfs更优的原因是不需要回溯，
 */
public class MovingCount {

    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        return dfs(m, n, k, 0, 0, used);
//        return dfs(0,0,used,k);
    }

    int dfs(int m, int n, int k, int i, int j, boolean[][] used) {
        if (!cal(i, j, k) || i >= m || j >= n || used[i][j]) {
            return 0;
        }
        used[i][j] = true;
        return 1 + dfs(m, n, k, i + 1, j, used) + dfs(m, n, k, i, j + 1, used);

    }

    boolean cal(int i, int j, int k) {
        int sum = i % 10 + i / 10 + j % 10 + j / 10;
        return k >= sum;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(3, 2, 17));
    }

    public int dfs(int i , int j, boolean[][] isVisited , int k ){
        //不符合条件返回0
        if(i > isVisited.length-1 || j> isVisited[0].length-1 || (i%10 + i/10 +j%10 + j/10) > k){
            return 0;
        }
        //已经浏览过了，返回0
        if(isVisited[i][j]){
            return 0;
        }
        //标记为已浏览
        isVisited[i][j] = true;
        //由于是从（0，0）开始，只要向下和想右递归求解即可，所以此题可扩展为从任一个点出发，皆可
        return dfs(i+1,j,isVisited,k) + dfs(i,j+1,isVisited,k)+1;


    }
}
