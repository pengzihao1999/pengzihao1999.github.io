"""
元组与列表相似，不同之处在于元组的元素不能修改
1.用做函数的参数和返回值
2.格式化输出后面的%()实际上是个元组
3.可以shi列表和元组进行转换
"""
info_tuple = ("zhangsan", 18, 1.75)
# 拿到元组值
print(info_tuple[0])
# 定义空元组
empty_tuple=()
# 定义只包含一个元素的元组

single_tuple = (5,)
print(type(single_tuple))


# 1取值和取索引
print(info_tuple[0])
print(info_tuple.index(18))
print(info_tuple.count("张三"))

# 2遍历元组
for info in info_tuple:
    print(info)
# 进行元组列表转化 list(元组) tuple(列表)