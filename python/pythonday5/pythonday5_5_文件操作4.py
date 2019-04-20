# 1.打开文件
file_read = open("wenjian")
file_writer = open("copy2", "w")

# 2.读 写
while True:
    text = file_read.readline()
    if not text:
        break
    file_writer.write(text)
# 3.关闭
file_read.close()
file_writer.close()
