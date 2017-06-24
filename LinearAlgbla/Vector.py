# -*- coding: utf-8 -*-
"""
Created on Sat Jun 17 19:46:39 2017

@author: yang
"""
from math import sqrt
from math import acos
from math import pi

class Vector(object):
    
    tolerance = 1e-10
    
    def __init__(self, coordinates):
        try:
            if not coordinates:
                raise ValueError
            self.coordinates = tuple(coordinates)
            self.dimension = len(coordinates)

        except ValueError:
            raise ValueError('The coordinates must be nonempty')

        except TypeError:
            raise TypeError('The coordinates must be an iterable')


    def __str__(self):
        return 'Vector: {}'.format(self.coordinates)


    def __eq__(self, v):
        return self.coordinates == v.coordinates
    
    def __add__(self,other):
        new_coordinates = [x+y for x,y in zip(self.coordinates,other.coordinates)]
        return Vector(new_coordinates)
            
    def __sub__(self,other):
        new_coordinates = [x-y for x,y in zip(self.coordinates,other.coordinates)]
        return Vector(new_coordinates)
    
    def __mul__(self,scaler):
        new_coordinates = [i*scaler for i in self.coordinates]
        return Vector(new_coordinates)  
    
    def magnitude(self):
        coordinates_squared = [ i**2 for i in self.coordinates]
        return sqrt(sum(coordinates_squared))
    
    def normalize(self):
        try:
            magnitude = self.magnitude()
            return self*(1/magnitude)
        except ZeroDivisionError:
            raise Exception('Cannot Normalize the zero vector!')
            
    def dot_product(self,other):
        coordinates_mul = [x*y for x,y in zip(self.coordinates,other.coordinates)]
        return sum(coordinates_mul)
    
    def angle_with(self,other,is_degrees=False):
        try:
            degrees_per_radian = 180./pi
            angle_in_radians = acos( round(self.normalize().dot_product(other.normalize()), 10) )
            if is_degrees:
                return degrees_per_radian * angle_in_radians
            else:
                return angle_in_radians
        except Exception as e:
            if str(e) == 'Cannot Normalize the zero vector!':
                raise Exception('Cannot compute a angle with zero vector!')
            else:
                raise e
    def is_zero(self):
        return (self.magnitude()<self.tolerance)
        
            
    def is_parallel(self,other):
        return (self.is_zero() or other.is_zero() or self.angle_with(other)==0 or self.angle_with(other)==pi)
        
    def is_orthogonal(self,other):
        if abs(self.dot_product(other)) < self.tolerance:
            return True
        else:
            return False
    #projection 
    def component_parallel_to(self,base):
        unit_base = base.normalize()
        return unit_base * self.dot_product(unit_base)
    
    def component_orthogonal_to(self,base):
        projection = self.component_parallel_to(base)
        return self-projection
    
    #cross product, only for 3d vector
    def cross_product(self,other):
        x1,y1,z1 = self.coordinates
        x2,y2,z2 = other.coordinates
        
        product_coordinates = [y1*z2 - y2*z1, -(x1*z2 - x2*z1), x1*y2 - x2*y1]
        return Vector(product_coordinates)
    

v = Vector((8.462,7.893,-8.187));
w = Vector((6.984,-5.975,4.778))
print (v.cross_product(w))

v = Vector((-8.987,-9.838,5.031))
w = Vector((-4.268,-1.861,-8.866))
p = v.cross_product(w)
print (p)
print (p.magnitude())

v = Vector((1.5,9.547,3.691))
w = Vector((-6.007,0.124,5.772))
p = v.cross_product(w)
print (p.magnitude()/2.0)