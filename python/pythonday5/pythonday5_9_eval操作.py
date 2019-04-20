"""
eval函数将字符串当成有效的表达式来求值并返回计算结果
在开发时不要使用eval来直接转换Input输入的结果，会产生
安全问题
"""

input_str = input("请输入算术题：")

print(eval(input_str))
