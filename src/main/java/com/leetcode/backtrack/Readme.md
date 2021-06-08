##### 适用场景
- 组合问题：N个数里面按一定规则找出k个数的集合  
  - 39 组合总和
  - 40 组合总和2
- 排列问题：N个数按一定规则全排列，有几种排列方式
  - 46 全排列 
  - 47 全排列2 
- 切割问题：一个字符串按一定规则有几种切割方式
- 子集问题：一个N个数的集合里有多少符合条件的子集
 - 棋盘问题：N皇后，解数独等等

##### 回溯考虑的问题
- 分支如何产生；
- 题目需要的解在哪里？是在叶子结点、还是在非叶子结点、还是在从跟结点到叶子结点的路径？
- 哪些搜索会产生不需要的解的？例如：产生重复是什么原因，如果在浅层就知道这个分支不能产生需要的结果，应该提前剪枝，剪枝的条件是什么，代码怎么写？


##### 常用技巧
- 偏移量数组：如果是回溯二维矩阵每个点的四个方向可以先定义方向，然后遍历
```java
int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
for (int k = 0; k < directions.length; k++){
```

##### 代码模板
```java
/**
 * 无返回值
  */
void backtrace(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int begin, int len) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < len; i++) {
            tmp.add(candidates[i]);
            backtrace(candidates, target - candidates[i], res, tmp, i, len);
            tmp.remove(tmp.size() - 1);
        }

    }
    
    
```
```java
/**
 * 有返回值
 */
 boolean backtrace(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        // 访问
        visited[i][j] = true;
        
        boolean flag = backtrace(board, word, index + 1, visited, newi, newj);

        // 撤回
        visited[i][j] = false;
        return result;

    }
```
