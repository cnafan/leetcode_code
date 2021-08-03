Arrays.fill(res, -1); # 填充数组 ，初始化

Arrays.deepToString() # 可填充二维数组

Deque<Integer> list = new LinkedList<>();
list.addFirst()
list.addLast()

list.stream().mapToInt(Integer::intValue).toArray(); // list转数组  

通过 Arrays.asList(strArray) 方式,将数组转换List后，不能对List增删，只能查改，否则抛异常。  

Arrays.stream(nums).boxed().collect(Collectors.toList());// 数组转list
