import matplotlib as plt
import numpy as np

from mpl_toolkits.mplot3d import Axes3D
def load_and_write(filename):
    data = np.loadtxt(filename)

    ax = plt.figure().add_subplot(111, projection = '3d')


