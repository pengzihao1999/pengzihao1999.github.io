try:
    num = int(input("输入一个整数"))

    result = 8 / num
    print(result)
except ValueError:
    print("请输入正确的整数")
except Exception as result:
    print("未知错误 %s" % result)
else:  #  没有异常才会执行的代码
    print("尝试成功")
finally:
    print("最后都可以执行")
