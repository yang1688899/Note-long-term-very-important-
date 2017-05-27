# -*- coding: utf-8 -*-
"""
Created on Sun May 21 19:32:53 2017

@author: Administrator
"""

# ----------
# User Instructions:
# 
# Create a function compute_value which returns
# a grid of values. The value of a cell is the minimum
# number of moves required to get from the cell to the goal. 
#
# If a cell is a wall or it is impossible to reach the goal from a cell,
# assign that cell a value of 99.
# ----------

grid = [[0, 1, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0],
        [0, 1, 0, 0, 0, 0],
        [0, 0, 0, 0, 1, 0]]
goal = [len(grid)-1, len(grid[0])-1]
cost = 1 # the cost associated with moving from a cell to an adjacent one

delta = [[-1, 0 ], # go up
         [ 0, -1], # go left
         [ 1, 0 ], # go down
         [ 0, 1 ]] # go right

delta_name = ['^', '<', 'v', '>']

def is_out(grid,x,y):
    if x<0 or x>=len(grid):
        return True
    elif y<0 or y>=len(grid[0]):
        return True
    else:
        return False

def search(grid,goal,cost):
    
    value = [ [99 for i in grid[0]] for j in grid ]
    policy = [ [" " for i in grid[0]] for j in grid ]
    check_map = [ [0 for i in grid[0]] for j in grid ]
    
    x = goal[0]
    y = goal[1]
    v = 0
    
    value[x][y] = v
    policy[x][y] = "*"
    open = [[v,x,y]]
    
    while len(open) != 0:
        open.sort(reverse=True)
        next = open.pop()
        check_map[x][y] = 1
        v = next[0]
        x = next[1]
        y = next[2]
        
        for i in range(len(delta)):
            v2 = v + cost
            x2 = x - delta[i][0]
            y2 = y - delta[i][1]
            
            if not is_out(grid,x2,y2) and check_map[x2][y2] == 0 and grid[x2][y2] == 0:
                value[x2][y2] = v2
                open.append([v2,x2,y2])
                policy[x2][y2] = delta_name[i]
    return policy 

policy = compute_value(grid,goal,cost)
for i in policy:
    print i
    