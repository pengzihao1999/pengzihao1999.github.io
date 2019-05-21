import numpy as np
# 把两个国家的数据方法一起来研究分析，同时保留国家的信息（每条数据的国家来源）

#加载数据
us_file_path = r"D:\PYTHONWORKSPACE\youtube_video_data\youtube_video_data\GB_video_data_numbers.csv"
uk_file_path = r"D:\PYTHONWORKSPACE\youtube_video_data\youtube_video_data\US_video_data_numbers.csv"

US_Data = np.loadtxt(us_file_path,delimiter=',',dtype='int')
UK_Data = np.loadtxt(uk_file_path,delimiter=',',dtype='int')
# 到后面追加国家的信息

# 1生成标志国家信息的矩阵
UK_bj = np.ones((UK_Data.shape[0],1)).astype(int)# 把默认的科学计数发转化为Int类型
US_bj = np.zeros((US_Data.shape[0],1)).astype(int)

# 水平拼接到数组上
UK_Data = np.hstack((UK_Data,UK_bj))
US_Data = np.hstack((US_Data,US_bj))

# 垂直拼接到一起
final_Data  = np.vstack((UK_Data,US_Data))

print(final_Data)
