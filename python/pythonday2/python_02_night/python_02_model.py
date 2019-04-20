# max(item) min(item)在字典中只能比较key
t_str = "sf g gre gash"
print(max(t_str))
t_list = [5, 634, 726, 5, 24, 12]
print(max(t_list))
# 字典不能比较大小 不能切片
# 字符串列表元组可以使用* + 运算符是新生成一个变量
# 而调用函数是在变量上直接进行操作
print([1, 2]*5)
print((1, 2)*5)
print("hello" + "python")
print((1, 2) + (3, 4))
print([1, 2] + [3, 4])
#  append和extend方法区别
#  append是添加一个元素进去
#  extend是直接增加元素
num_list = [1, 2, 3, 4, 5]
num_list.append([6, 7, 8])
print(num_list)
num_list.extend([9, 10, 11])
print(num_list)
print(3 in num_list)
print(6 not in num_list)
# in not in针对字典操作时是针对key

