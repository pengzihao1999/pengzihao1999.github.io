#  1.判断空白字符
#  可以判断空格和其他字符等
space_str = " \t\n"
print(space_str.isspace())

#  2.判断字符串中是否只包含数字
#  都不能判断小数
num_str = "1"
print(num_str.isdecimal())  # 只能判断普通的数字
print(num_str.isdigit())   # 可以判断Uicode的数组
print(num_str.isnumeric())  # 可以判断中文数字

hello_str = "hello world"
#  字符串的查找和替换
# 1 判断是否以指定的字符串开始结束
print(hello_str.startswith("hello"))
print(hello_str.endswith("RLD"))
# 2 查找指定的字符串在大字符串中的索引
#  find在字符串不存在时会返回—1
#  index在字符串不存在时会报错
print(hello_str.find("wo"))
# 3替换字符串
# replace方法完成之后会返回一个新的字符串
# 注意 不会修改原有字符串的内容
print(hello_str.replace("wo", "haha"))
print(hello_str)

#  文本对齐
