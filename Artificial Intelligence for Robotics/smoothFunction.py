# -*- coding: utf-8 -*-
"""
Created on Thu Jun 01 23:23:50 2017

@author: Administrator
"""

# -----------
# User Instructions
#
# Define a function smooth that takes a path as its input
# (with optional parameters for weight_data, weight_smooth,
# and tolerance) and returns a smooth path. The first and 
# last points should remain unchanged.
#
# Smoothing should be implemented by iteratively updating
# each entry in newpath until some desired level of accuracy
# is reached. The update should be done according to the
# gradient descent equations given in the instructor's note
# below (the equations given in the video are not quite 
# correct).
# -----------

from copy import deepcopy
import numpy
# thank you to EnTerr for posting this on our discussion forum
def printpaths(path,newpath):
    for old,new in zip(path,newpath):
        print '['+ ', '.join('%.3f'%x for x in old) + \
               '] -> ['+ ', '.join('%.3f'%x for x in new) +']'

# Don't modify path inside your function.
path=[[0, 0], 
      [1, 0],
      [2, 0],
      [3, 0],
      [4, 0],
      [5, 0],
      [6, 0],
      [6, 1],
      [6, 2],
      [6, 3],
      [5, 3],
      [4, 3],
      [3, 3],
      [2, 3],
      [1, 3],
      [0, 3],
      [0, 2],
      [0, 1]]

def smooth(path, weight_data = 0.1, weight_smooth = 0.1, tolerance = 0.000001):

#    # Make a deep copy of path into newpath
    newpath = deepcopy(path)
    
#    #######################
#    ### ENTER CODE HERE ###
#    #######################

    change = 0.00001
    while change >= 0.00001:
        change = 0.0
        for i in range(len(path)):
            for j in range(len(path[0])):
                old = newpath[i][j]
                newpath[i][j] += weight_data*(path[i][j] - newpath[i][j]) +  weight_smooth *(newpath[(i+1)%len(path)][j]+newpath[i-1][j] - 2*newpath[i][j])             
                change += abs (newpath[i][j] - old)
    return newpath        
printpaths(path,smooth(path))
