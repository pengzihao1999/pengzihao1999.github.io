"""
如果文件非常大，可以使用readliine方法来降低对内存的占用

"""
file = open("wenjian")

while True:
    test = file.readline()

    # 判断是否读取到内容
    if not test:
        break
    print(test)

file.close()
