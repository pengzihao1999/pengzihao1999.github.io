hello_str = "hello hello helll"
print(len(hello_str))
# 如果小字符串在大字符串中不存在 会返回0
# 如果小字符串在大字符串中存在 会返回存在的次数
print(hello_str.count("hel"))
# 输出小字符串在大字符串出现的位置  如果不存在会报错
print(hello_str.index("lll"))

