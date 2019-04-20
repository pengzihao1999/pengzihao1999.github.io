def demo1(num, num_list):

    num += num
    num_list += num_list
    print(num)
    print(num_list)
    print("函数执行完毕")


gl_num = 10
gl_num_list = [1, 2, 3]
demo1(gl_num, gl_num_list)
print(gl_num)
print(gl_num_list)
print("主程序执行完毕")
