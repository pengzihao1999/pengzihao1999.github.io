import numpy as np
# 在一列中把含有nan的值 改为本列的均值
def fill_ndarray(t1):
    # 步骤 1拿到所有列进行遍历
    for i in range(np.shape(t1)[1]):
        # 2 对每一列进行判断是否有nan
        temp_col = t1[:,i]
        #对每一列进行判断
        if np.count_nonzero(temp_col!=temp_col)!=0:
            #这一列存在nan 拿到不为nan的值 并求平均值赋给nan
            temp_not_nan = (temp_col[temp_col==temp_col])
            temp_col[np.isnan(temp_col)]= temp_not_nan.mean()

    return t1
if __name__ == '__main__':
    x = np.arange(1,25).reshape(4,6).astype("float")
    x[[0,2,3],[2,4,1]] = np.nan
    print(x)
    print("#"*100)
    print(fill_ndarray(x))