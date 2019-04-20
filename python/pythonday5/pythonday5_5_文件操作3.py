# 1.打开文件
file_read = open("wenjian")
file_writer = open("copy", "w")

# 2.读 写
text = file_read.read()
file_writer.write(text)
# 3.关闭
file_read.close()
file_writer.close()
