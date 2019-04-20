num_str = "0123456789"
# 截取2—5之间的字符串
print(num_str[2:6])
# 截取2—末尾的字符串
print(num_str[2:])
# 从字符串开始位置截取到5的位置
print(num_str[0:6])
# 截取完整的字符串
print(num_str[:])
# 从开始位置每隔一个字符开始切一个
print(num_str[::2])
# 从1每隔一个字符开始切一个
print(num_str[1::2])
# 截取从2开始到倒数第一个字符
print(num_str[2:-1])
# 截取倒数两个字符
print(num_str[-2:])
# 通过切片获取字符串的逆序
print(num_str[-1::-1])
