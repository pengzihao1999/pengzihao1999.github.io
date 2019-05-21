import numpy as np

us_file_path = r"D:\PYTHONWORKSPACE\youtube_video_data\youtube_video_data\GB_video_data_numbers.csv"
uk_file_path = r"D:\PYTHONWORKSPACE\youtube_video_data\youtube_video_data\US_video_data_numbers.csv"
# delimiter参数是把csv文件进行逗号分隔,dtype是显示数据的样式，unpack为True为转置数组
t1 = np.loadtxt(us_file_path,delimiter=",",dtype="int")
t2 = np.loadtxt(us_file_path,delimiter=",",dtype="int",unpack=True)
print(t1)
print(t2)

