- 我的经验是把定义区间成为左闭右闭区间，左右边界是无差别的，弄成左闭右开，反而增加了思考的复杂程度；
- 明确 int = left + ( right - left ) / 2 这里除以 2 是下取整；
- 明确 while(left <= right) 和 while(left < right) 这两种写法其实在思路上有本质差别， while(left <= right) 在循环体内部直接查找元素，而 while(left < right) 在循环体内部一直在排除元素，第 2 种思路在解决复杂问题的时候，可以使得问题变得简单；
- 始终在思考下一轮搜索区间是什么，把它作为注释写到代码里面，就能帮助我们搞清楚边界是不是能取到，等于、+1 、-1 之类的细节；

```
    // 找出
 public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
    // 排除
     public int binarySearchIndex(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
```
