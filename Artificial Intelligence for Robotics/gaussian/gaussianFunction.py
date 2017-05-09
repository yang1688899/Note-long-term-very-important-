# -*- coding: utf-8 -*-
"""
Created on Tue May 09 22:04:19 2017

@author: Administrator
"""

from math import *
def gaussian(mu,sigma2,x):
    return ( 1/sqrt(2*pi*sigma2) ) * exp( -0.5 * (x-mu)**2/sigma2 )

print gaussian(10, 4, 8)