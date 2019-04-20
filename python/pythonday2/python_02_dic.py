# 字典是一个无序的数据集合
# 建议在定义字典时每一行定义只占用一行代码
xiaoming_dict = {"name": "小明",
                 "age": 18,
                 "gender": True,
                 "height": 175,
                 "weight": 72.5
                 }
print(xiaoming_dict)

# 1 取值
print(xiaoming_dict["name"])  # 在中括号中输入key就可以了

# 2 增加/修改
# 如果key不存在 会新增键值对
# 如果key存在，会修改已经存在的键值对
xiaoming_dict["name"] = "xiaowang"

# 3 删除
xiaoming_dict.pop("name")

print(xiaoming_dict)

#  1统计键值对的数量
print(len(xiaoming_dict))

#  2 合并字典 如果合并的字典包含原字典的键 会进行覆盖操作
temp_dict = {"age": 20,
             "weight": 45}
xiaoming_dict.update(temp_dict)

# 3 清空操作
temp_dict.clear()
