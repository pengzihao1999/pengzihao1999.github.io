name_list = ["peng", "wang", "li"]
# 1取值和取索引号
print(name_list[2])
print(name_list.index("wang"))
# 2修改
name_list[1] = "afsaf"
print(name_list)
# 3添加数据 插入数据
# append向列表的末尾增加数据
name_list.append("liu")
# insert可以向任意位置插入
name_list.insert(1, "first")
print(name_list)
# extend 可以把其他列表中的完整内容追加到末尾
extend_list = ["dada", "dad"]
name_list.extend(extend_list)
print(name_list)
# 4.删除
name_list.remove("li")
print(name_list)
name_list.pop()
print(name_list)  # 可以删除最后一个数据
name_list.pop(3)  # 可以指定要删除的索引
print(name_list)
# name_list.clear()
print(name_list)

# 4 统计
# 用del关键字从列表中删除指定的元素
#  本质上是从内存中删除的 在日常开发中，要从列表删除数据
#  建议使用列表提供的方法
del name_list[1]
print(name_list)
# len(length)可以统计列表中元素的个数
list_len = len(name_list)
print("列表中包含%d个元素" % list_len)
# count方法可以从机列表中给某一个数据出现的次数
count = name_list.count("aa")
print("aa出现了%d次" % count)
# remove如果列表中有多个数据，可以删除第一个
# 出现的数据


# 5 排序
num_list = [4, 6, 1, 6, 2]
name_list.sort(reverse=True)
num_list.sort(reverse=True)
print(num_list, name_list)

# 翻转
name_list.reverse()
num_list.reverse()
print(num_list, name_list)
# 使用迭代遍历
for name in name_list:
    print(name)
for num in num_list:
    print(num)


