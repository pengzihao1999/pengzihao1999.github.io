# for循环如果遍历完成了 就会执行else后面的代码
# 如果在for循环里面进行break后就不会执行else代码

for num in [1, 2, 3]:
    if num == 2:
        break
    print(num)
else:
    # 如果循环体内部使用break退出循环 就不会执行
    # else里面的代码
    print("会执行的")

print("循环结束")
# 在学员列表中搜索指定的姓名
find_name = "KKK"
students_list = [
    {"name": "a"},
    {"name": "b"}
]
for student_dic in students_list:
    print(student_dic)
    if student_dic["name"] == find_name:
        print("找到了%s" % find_name)
        # 如果已经找到，应该直接退出循环，而不遍历
        # 后续的元素
        break
else:
    print("没有找到%s啊" % find_name)

print("循环结束")
